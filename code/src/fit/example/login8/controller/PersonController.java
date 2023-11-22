package fit.example.login8.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import fit.example.login8.utils.JWTUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/8/person-center")
public class PersonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String authorization = req.getHeader("Authorization");
        String token = authorization.split(" ")[1];
        DecodedJWT jwt = JWTUtils.verifyToken(token);
        // 将jwt信息返回
        String header = jwt.getHeader();
        String payload = jwt.getPayload();
        String signature = jwt.getSignature();
        HashMap<String, Object> res = new HashMap<>();
        res.put("header", header);
        res.put("payload", payload);
        res.put("signature", signature);
        res.put("code", 200);
        res.put("message", "成功");
        PrintWriter out = resp.getWriter();
        out.println(JSONObject.toJSONString(res));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
