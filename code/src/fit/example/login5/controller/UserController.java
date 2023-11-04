package fit.example.login5.controller;

import fit.example.login5.logic.UserLogic;
import fit.example.login5.model.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = {"/user/list"})
public class UserController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 获取业务逻辑层
        UserLogic userLogic = new UserLogic();
        List<UserBean> userBeanList = userLogic.getUsers();
        // 将数据存储到request对象中
        request.setAttribute("userBeanList", userBeanList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
