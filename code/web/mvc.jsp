<%@ page import="java.util.List" %>
<%@ page import="fit.example.login5.model.UserBean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP+Javabean+Servlet</title>
</head>
<body>
<div>
    <table border=1 style="margin:0 auto;width:800px;font-size:24px;font-family: 微软雅黑 Light;">
        <tr>
            <td align="center" width="6%">序号</td>
            <td align="center" width="12%">登录账号</td>
            <td align="center" width="12%">登陆密码</td>
            <td align="center" width="12%">用户姓名</td>
            <td align="center" width="12%">手机号码</td>
            <td align="center" width="10%">类别</td>
            <td align="center" width="12%">状态</td>
        </tr>
        <%
            //循环显示数据
            List<UserBean> userBeanList = (List<UserBean>) request.getAttribute("userBeanList");
            for (int i = 0; i < userBeanList.size(); i++) {
                UserBean userBean = userBeanList.get(i);
        %>
        <tr>
            <td align='center'>
                <%=userBean.getUserId()%>
            </td>
            <td align='center'>
                <%=userBean.getUserCard()%>
            </td>
            <td align='center'>
                <%=userBean.getUserPwd()%>
            </td>
            <td align='center'>
                <%=userBean.getUserName()%>
            </td>
            <td align='center'>
                <%=userBean.getUserPhone()%>
            </td>
            <td align='center'>
                <%=userBean.getUserType()%>
            </td>
            <td align='center'>
                <%=userBean.getUserType()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>