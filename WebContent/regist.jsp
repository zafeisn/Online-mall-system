<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	pageContext.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link rel="stylesheet" href="style/common.css">
    <link rel="stylesheet" href="style/regStyle.css">
    <!--设置标签图标-->
    <link href="favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="style/footerStyle.css">
</head>
<body>


<!--注册头部-->
<div id="reg_header">
    <div class="reg_h_center">

            <img src="images/logo.png" alt="">
            <h3>欢迎注册</h3>

            <div class="reg_h_right">
                <span>已有账户</span><a href="login.html">请登录</a>
            </div>
    </div>
</div>

<div id="reg_main">
        <div class="main_left">
            <form id="reg_form" action="${contextPath }/UserServlet?action=registServlet" method="post">
                <div>
                    <label>用户名</label>
                    <input id="username" type="text" placeholder="请输入用户名..." name="username">
                </div>
                <div>
                    <label>密码</label>
                    <input id="password" type="text" placeholder="请输入密码.." name="password">
                </div>
                <div>
                    <label>确认密码</label>
                    <input id="repassword" type="text" placeholder="请再次输入密码...">
                </div>
                <div>
                    <label>电话</label>
                    <input id="phone" type="text" placeholder="请输入电话..." name="phone">
                </div>
                <div class="check_box">
                    <label>验证码</label>
                    <input id="code" type="text" placeholder="请输入验证码..." name="code">
                    <img src="/myWeb/CheckCodeServlet" onclick="change(this)">
                </div>
                <div class="submit_button">
                    <input type="button" value="立即注册" onclick="checkData(this)">
                </div>
            </form>
        </div>
        <div class="main_right">
             <img src="images/reg_right.png" alt="">
        </div>
</div>
<!--尾部-->
<%@ include file="/footer.jsp" %>

<script type="text/javascript">

	function change(obj){
		obj.src = "${contextPath}/CheckCodeServlet?time=" + new Date().getTime();
	}

	function checkData(obj){
		
		var username = document.getElementById("username");
		var password = document.getElementById("password");
		var repassword = document.getElementById("repassword");
		var phone = document.getElementById("phone");
		var code = document.getElementById("code");
		
		if(username.value == ""){
			alert("请输入用户名！");
			return;
		}
		if(password.value == ""){
			alert("请输入密码！");
			return;
		}
		if(repassword.value == ""){
			alert("请确认密码！");
			return;
		}
		if(password.value == repassword.value){
			var form = document.getElementById("reg_form");
			form.submit();
		}else{
			alert("两次输入的密码不一致，请重新输入！");
		}
		
		if(phone.value == ""){
			alert("请输入手机号！");
			return;
		}
		if(code.value == ""){
			alert("请输入验证码！");
			return;
		}
		
	}	
</script>

</body>
</html>


