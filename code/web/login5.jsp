<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Carl
  Date: 2023/11/10
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>第五周</title>
    <script src="<%=request.getContextPath() + "/js/jquery-3.7.1.js"%>"></script>
    <script src="<%=request.getContextPath() + "/js/md5.js"%>"></script>
    <style>
        html {
            background-color: #B5DEF2;
        }

        .wrapper {
            margin: 140px auto;
            width: 884px;
        }

        .loginBox {
            background-color: #F0F4F6;
            /*上divcolor*/
            border: 1px solid #BfD6E1;
            border-radius: 5px;
            color: #444;
            font: 14px 'Microsoft YaHei', '微软雅黑';
            margin: 0 auto;
            width: 388px
        }

        .loginBox .loginBoxCenter {
            border-bottom: 1px solid #DDE0E8;
            padding: 24px;
        }

        .loginBox .loginBoxCenter p {
            margin-bottom: 10px
        }

        .loginBox .loginBoxButtons {
            /*background-color: #F0F4F6;*/
            /*下divcolor*/
            border-top: 0px solid #FFF;
            border-bottom-left-radius: 5px;
            border-bottom-right-radius: 5px;
            line-height: 28px;
            overflow: hidden;
            padding: 20px 24px;
            vertical-align: center;
            filter: alpha(Opacity=80);
            -moz-opacity: 0.5;
            opacity: 0.5;
            text-align: center;
        }

        .loginBox .loginInput {
            border: 1px solid #D2D9dC;
            border-radius: 2px;
            color: #444;
            font: 12px 'Microsoft YaHei', '微软雅黑';
            padding: 8px 14px;
            margin-bottom: 8px;
            width: 310px;
        }

        .loginBox .loginInput:FOCUS {
            border: 1px solid #B7D4EA;
            box-shadow: 0 0 8px #B7D4EA;
        }

        .loginBox .loginBtn {
            background-image: -moz-linear-gradient(to bottom, blue, #85CFEE);
            border: 1px solid #98CCE7;
            border-radius: 20px;
            box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px, rgba(0, 0, 0, 0.1) 0 1px 1px;
            color: #444;
            /*登录*/
            cursor: pointer;
            font: bold 13px Arial;
            padding: 10px 50px;
        }

        .loginBox .loginBtn:HOVER {
            background-image: -moz-linear-gradient(to top, blue, #85CFEE);
        }

        .loginBox a.forgetLink {
            color: #ABABAB;
            cursor: pointer;
            float: right;
            font: 11px/20px Arial;
            text-decoration: none;
            vertical-align: middle;
            /*忘记密码*/
        }

        .loginBox a.forgetLink:HOVER {
            color: #000000;
            text-decoration: none;
            /*忘记密码*/
        }

        .verifyBox {
            display: flex;
            align-items: center;
            column-gap: 10px;
        }

        .verifyInput #verify {
            width: 200px;
        }

        #vcImg {
            width: 100px;
            height: 60px;
            border: 1px solid black;
            cursor: pointer;
        }

        .loginBottomBox {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }

        .loginBottomBox p {
            margin: 0;
        }

        .message {
            font-weight: bold;
            color: red;
        }
    </style>
</head>
<body>
<%
    Object message = request.getAttribute("message");
%>
<div class="wrapper">
    <form id="loginForm" action="<%=request.getContextPath()%>/5/login" method="post" onsubmit="return submitForm()">
        <div class="loginBox">
            <div class="loginBoxCenter">
                <p><label>用户名：</label></p>
                <!--autofocus 规定当页面加载时按钮应当自动地获得焦点。 -->
                <!-- placeholder提供可描述输入字段预期值的提示信息-->
                <p><input type="text" id="text" name="username" class="loginInput" autofocus="autofocus" required="required"
                          autocomplete="off" placeholder="请输入用户名" value=""/></p>
                <!-- required 规定必需在提交之前填写输入字段-->
                <p><label>密码：</label></p>
                <p><input type="password" id="password" name="password" class="loginInput" required="required"
                          placeholder="请输入密码" value=""/></p>
                <div class="verifyBox">
                    <div class="verifyInput">
                        <p><label>验证码：</label></p>
                        <p><input type="text" id="verify" name="verify" class="loginInput" required="required"
                                  placeholder="请输入验证码" value=""/></p>
                    </div>
                    <img id="vcImg"
                         onclick="refreshVc()"
                         src="<%=request.getContextPath() + "/5/login"%>"
                         alt="verifyCode"/>
                </div>
                <div class="loginBottomBox">
                    <p><a class="forgetLink" href="#">忘记密码?</a></p>
                    <p style="display: <%=Objects.nonNull(message) ? "inline-block" : "none"%>;" class="message">
                        <%=Objects.nonNull(message) ? message.toString() : ""%>
                    </p>
                </div>
            </div>
            <div class="loginBoxButtons">
                <button class="loginBtn">登录</button>
            </div>
        </div>
    </form>
</div>
</body>
<script>
    let vcImg = document.querySelector("#vcImg");
    let loginForm = document.querySelector("#loginForm");
    let password = document.querySelector("#password");

    function refreshVc() {
        let time = new Date().getTime();
        vcImg.src =  "/5/login?time=" + time;
    }

    function submitForm() {
        // 对密码进行md5加密
        password.value = md5(password.value);
    }
</script>
</html>
