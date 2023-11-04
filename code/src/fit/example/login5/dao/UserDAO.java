package fit.example.login5.dao;

import fit.example.login5.model.UserBean;
import fit.example.login5.utils.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 数据持久层/数据访问层
public class UserDAO {
    private Connection conn;

    public UserDAO() throws Exception {
        conn = DBConn.getConnection();
    }

    // 获取全部用户信息
    public List<UserBean> getUsers() throws Exception {
        List<UserBean> ret = new ArrayList<UserBean>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tb_user");
            while (rs.next()) {
                UserBean userBean = new UserBean();
                userBean.setUserId(rs.getInt("user_id"));
                userBean.setUserName(rs.getString("user_name"));
                userBean.setUserPhone(rs.getString("user_phone"));
                userBean.setUserPwd(rs.getString("login_pwd"));
                userBean.setUserCard(rs.getString("login_code"));
                userBean.setUserType(rs.getInt("user_type"));
                ret.add(userBean);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return ret;
    }
}
