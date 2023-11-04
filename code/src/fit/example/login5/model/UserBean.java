package fit.example.login5.model;

/**
 * <td align='center'>
 *                 <%=userBean.getUserId()%>
 *             </td>
 *             <td align='center'>
 *                 <%=userBean.getUserName()%>
 *             </td>
 *             <td align='center'>
 *                 <%=userBean.getUserPhone()%>
 *             </td>
 *             <td align='center'>
 *                 <%=userBean.getUserPwd()%>
 *             </td>
 *             <td align='center'>
 *                 <%=userBean.getUserCard()%>
 *             </td>
 *             <td align='center'>
 *                 <%=userBean.getUserStatus()%>
 *             </td>
 *             <td align='center'>
 *                 <%=userBean.getUserType()%>
 *             </td>
 */
public class UserBean {
    private Integer userId;
    private String userName;
    private String userPhone;
    private String userPwd;
    private String userCard;
    private String userStatus;
    private Integer userType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userCard='" + userCard + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userType=" + userType +
                '}';
    }
}
