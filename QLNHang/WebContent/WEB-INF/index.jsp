<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quan Ly Ngan Hang</title>
    <link href="style.css" rel="stylesheet"/>
</head>
<body>
    <h1>DANG NHAP</h1>
    
    <p class="error-msg">${thongBaoLoi}</p>
    
    <form action="QLNHangWebClient?action=dangnhap" method="POST" class="formDangNhap">
        <label>So tai khoan:</label>
        <input type="text" name="soTK" required>
        
        <label>Ma PIN:</label>
        <input type="password" name="maPin" required>
        
        <button type="submit">Dang nhap</button>
    </form>
</body>
</html>