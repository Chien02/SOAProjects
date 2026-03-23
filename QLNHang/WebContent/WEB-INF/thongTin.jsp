<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<header>
	<meta charset="UTF-8">
	<title>Quan Ly Ngan Hang</title>
	<link href="style.css" rel="stylesheet"/>
</header>
<body>
	<h1>Xin chao ${taiKhoan.chuTaiKhoan}</h1>
		<table class="masterTable">
			<thead>
				<tr>
					<th><h3>TUY CHON</h3></th>
					<th class="functionTHead"><h3>THONG TIN TAI KHOAN</h3></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td> <a href="QLNHangWebClient?action=thongtin">THONG TIN</a> </td>
					<td rowspan="8" class="merged-cell">
						<table class="functionTable">
							<thead>
								<th></th>
								<th></th>
							</thead>
							<tbody>
								<tr>
									<td><p>So tai khoan:</p></td>
									<td><p>${taiKhoan.soTaiKhoan}</p></td>
								</tr>
								<tr>
									<td><p>Chu tai khoan:</p></td>
									<td><p>${taiKhoan.chuTaiKhoan}</p></td>
								</tr>
								<tr>
									<td><p>So du:</p></td>
									<td><p>${taiKhoan.soDu}</p></td>
								</tr>
								<tr>
									<td><p>Quyen quan tri:</p></td>
									<td><p>${taiKhoan.laAdmin}</p></td>
								</tr>
							</tbody>
							
						</table>
					</td>
				</tr>
				<tr>
					<td> <a href="QLNHangWebClient?action=naptien">NAP TIEN</a> </td>
				</tr>
				<tr>
					<td> <a href="QLNHangWebClient?action=ruttien">RUT TIEN</a> </td>
				</tr>
				<tr>
					<td> <a href="QLNHangWebClient?action=chuyentien">CHUYEN TIEN</a> </td>
				</tr>
				<c:if test="${taiKhoan.laAdmin}">
					<tr>
						<td> <a href="QLNHangWebClient?action=danhsach">DANH SACH TAI KHOAN</a> </td>
					</tr>
					<tr>
						<td> <a href="QLNHangWebClient?action=themtaikhoan">THEM TAI KHOAN</a> </td>
					</tr>
					<tr>
						<td> <a href="QLNHangWebClient?action=timtaikhoan">TIM TAI KHOAN</a> </td>
					</tr>
				</c:if>
				<tr>
					<td> <a href="QLNHangWebClient?action=dangxuat">DANG XUAT</a> </td>
				</tr>
			</tbody>
		</table>
</body>
</html>