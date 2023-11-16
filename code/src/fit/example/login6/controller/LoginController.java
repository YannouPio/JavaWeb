package fit.example.login6.controller;

import com.alibaba.fastjson.JSONObject;
import fit.example.login5.dao.UserDAO;
import fit.example.login5.model.UserBean;
import fit.example.login5.utils.ImageCodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/6/login")
public class LoginController extends HttpServlet {
    public static final Map<String, String> VERIFY_CODE_CACHE = new HashMap<>();
    public static final Map<String, String> LOGIN_CACHE = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> imageCode = ImageCodeUtils.genImageCode();
        String code = imageCode.get("code").toString();
        BufferedImage buffImg = (BufferedImage) imageCode.get("image");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Base64.Encoder encoder = Base64.getEncoder();
        ImageIO.setUseCache(false);
        ImageIO.write(buffImg, "png", os);
        UUID uuid = UUID.randomUUID();
        res.put("uuid", uuid.toString());
        res.put("image", encoder.encodeToString(os.toByteArray()));
        VERIFY_CODE_CACHE.put(uuid.toString(), code);
        PrintWriter out = resp.getWriter();
        out.write(JSONObject.toJSONString(res));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> resMap = new HashMap<>();
        resp.setCharacterEncoding("UTF-8");
        ServletInputStream is = req.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        StringBuilder inputStr = new StringBuilder();
        while ((len = is.read(buf)) != -1) {
            inputStr.append(new String(buf, 0, len));
        }
        JSONObject inputJson = JSONObject.parseObject(inputStr.toString());
        String username = inputJson.get("username").toString();
        String password = inputJson.get("password").toString();
        String verify = inputJson.get("verify").toString();
        String uuid = inputJson.get("uuid").toString();
        String vcCache = VERIFY_CODE_CACHE.get(uuid);
        // 获取用户信息
        UserBean user = null;
        try {
            UserDAO userDAO = new UserDAO();
            user = userDAO.getUserByUsername(username);
        } catch (Exception e) {
            resMap.put("message", "系统异常！");
            resMap.put("code", 500);
            throw new RuntimeException(e);
        }
        if (!verify.equals(vcCache)) {
            resMap.put("message", "验证码错误！");
            resMap.put("code", 500);
        } else if (Objects.isNull(user)) {
            resMap.put("message", "用户名错误！");
            resMap.put("code", 500);
        } else if (!user.getUserPwd().equals(password)) {
            resMap.put("message", "密码错误！");
            resMap.put("code", 500);
        } else {
            LOGIN_CACHE.put(uuid, username);
            resMap.put("message", "登录成功！");
            resMap.put("code", 200);
        }
        PrintWriter out = resp.getWriter();
        out.write(JSONObject.toJSONString(resMap));
    }
}
