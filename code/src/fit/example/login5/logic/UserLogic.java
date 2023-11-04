package fit.example.login5.logic;

import fit.example.login5.dao.UserDAO;
import fit.example.login5.model.UserBean;

import java.util.List;


// 业务逻辑层
public class UserLogic {

    // 获取全部用户信息
    public List<UserBean> getUsers() {
        List<UserBean> result;
        try {
            UserDAO userDAO = new UserDAO();
            result = userDAO.getUsers();
        } catch (Exception e) {
            e.getMessage();
            result = null;
        }
        return result;
    }
}
