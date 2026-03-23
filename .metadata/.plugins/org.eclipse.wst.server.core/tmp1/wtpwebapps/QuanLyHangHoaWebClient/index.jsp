<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ĐĂNG NHẬP</title>
	<link rel="stylesheet" href="styles/login.css">
</head>
<body>
	<h2>ĐĂNG NHẬP</h2>
	<p style="color: red;">${errorMsg}</p>
	<p style="color: green;">${successMsg}</p>
	<form action="customer" method="POST">
		<label for="cccd">CCCD</label>
		<input type="text" name="cccd">
		
		<label for="password">Mật khẩu</label>
		<input type="password" name="password">
		
		<button type="submit" name="action" value="dangNhap">Đăng nhập</button>
		
		<p>Chưa có tài khoản. <a href="register.jsp">Đăng ký ngay</a></p>
	</form>
</body>
</html>