package fit.example.login5.controller;

import fit.example.login5.utils.ImageCodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@WebServlet("/5/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> imageCode = ImageCodeUtils.genImageCode();
        String code = imageCode.get("code").toString();
        BufferedImage buffImg = (BufferedImage) imageCode.get("image");
        //登录成功创建一个Session对象，记录当前连接
        HttpSession session = req.getSession(true);
        session.setAttribute("randomCode", code);
        // 将上面图片输出到浏览器 ImageIO
        ImageIO.setUseCache(false);// 防止Tomcat缓存
        ImageIO.write(buffImg, "png", resp.getOutputStream()); //注意有些情况修改图片格式为png
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
