package fit.example.login8.filter;

import com.alibaba.fastjson.JSONObject;
import fit.example.login8.utils.JWTUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebFilter("/8/*")
public class JWTFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setCharacterEncoding("UTF-8");
        String uri = req.getRequestURI();
        if (uri.endsWith("login")) {
            filterChain.doFilter(req, resp);
        } else {
            String authorization = req.getHeader("Authorization");
            if (Objects.isNull(authorization)) {
                Map<String, Object> res = new HashMap<>();
                res.put("message", "请先登录");
                res.put("code", 401);
                PrintWriter out = resp.getWriter();
                out.println(JSONObject.toJSONString(res));
            } else {
                // 校验token
                String token = authorization.split(" ")[1];
                try {
                    JWTUtils.verifyToken(token);
                    filterChain.doFilter(req, resp);
                } catch (Exception e) {
                    Map<String, Object> res = new HashMap<>();
                    res.put("message", "用户校验失败，请重新登录");
                    res.put("code", 401);
                    PrintWriter out = resp.getWriter();
                    out.println(JSONObject.toJSONString(res));
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
