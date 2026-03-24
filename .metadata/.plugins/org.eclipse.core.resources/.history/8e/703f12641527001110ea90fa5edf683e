<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>QUẢN LÝ KHO HÀNG (ADMIN)</title>
	<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h2>HỆ THỐNG QUẢN TRỊ ADMIN</h2>
	<aside>
		<a href="customer?action=khoHang">Trang chủ</a>
		<a href="userInfo.jsp">Tài khoản</a>
		<c:if test="${khachHang.laAdmin}">
			<a href="hanghoa?action=inventory" class="active">Quản lý Kho Hàng</a>
		</c:if>
		<a href="customer?action=dangXuat">Đăng xuất</a>
	</aside>
	
	<main>
		<div class="inventory-header">
            <h2 class="section-title">Danh sách sản phẩm trong kho</h2>
            <button class="btn-add-new" id="btnOpenAddModal">+ Thêm Sản Phẩm Mới</button>
        </div>

        <c:if test="${not empty successMsg}"><div class="msg-alert msg-success">${successMsg}</div></c:if>
        <c:if test="${not empty errorMsg}"><div class="msg-alert msg-error">${errorMsg}</div></c:if>

		<table class="cart-table">
            <thead>
                <tr>
                    <th>Mã Số</th>
                    <th>Tên Sản Phẩm</th>
                    <th>Nhà Sản Xuất</th>
                    <th style="text-align: right;">Đơn Giá</th>
                    <th style="text-align: right;">Tồn Kho</th>
                    <th style="text-align: center;">Thao Tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${danhSach}" var="sp">
                    <tr>
                        <td><strong>${sp.maSo}</strong></td>
                        <td>${sp.ten}</td>
                        <td>${sp.nsxuat}</td>
                        <td style="text-align: right;"><fmt:formatNumber value="${sp.donGia}" pattern="#,###"/> VNĐ</td>
                        <td style="text-align: right;">${sp.soLuong}</td>
                        <td style="text-align: center; display: flex; justify-content: center; gap: 5px;">
                            <button type="button" class="btn-edit" 
                                onclick="openEditModal('${sp.maSo}', '${sp.ten}', '${sp.nsxuat}', '${sp.donGia}', '${sp.soLuong}')">Sửa</button>
                            
                            <form action="hanghoa" method="POST" style="margin: 0;">
                                <input type="hidden" name="action" value="xoa">
                                <input type="hidden" name="maSo" value="${sp.maSo}">
                                <button type="submit" class="btn-delete" onclick="return confirm('Xác nhận xóa sản phẩm này?');">Xóa</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="addModal" class="modal" style="display: none;">
            <div class="modal-content">
                <span class="close-btn" onclick="document.getElementById('addModal').style.display='none'">&times;</span>
                <h3>Thêm Hàng Hóa Mới</h3>
                <form action="hanghoa" method="POST">
                    <input type="hidden" name="action" value="them">
                    <label>Mã Sản Phẩm:</label>
                    <input type="text" name="maSo" required>
                    <label>Tên Sản Phẩm:</label>
                    <input type="text" name="ten" required>
                    <label>Nhà Sản Xuất:</label>
                    <input type="text" name="nsxuat" required>
                    <label>Đơn Giá:</label>
                    <input type="number" name="donGia" step="0.1" required>
                    <label>Số Lượng Tồn:</label>
                    <input type="number" name="soLuong" required>
                    <button type="submit" style="margin-top: 20px;">Lưu Sản Phẩm</button>
                </form>
            </div>
        </div>

        <div id="editModal" class="modal" style="display: none;">
            <div class="modal-content">
                <span class="close-btn" onclick="document.getElementById('editModal').style.display='none'">&times;</span>
                <h3>Cập Nhật Hàng Hóa</h3>
                <form action="hanghoa" method="POST">
                    <input type="hidden" name="action" value="sua">
                    <label>Mã Sản Phẩm (Không thể sửa):</label>
                    <input type="text" name="maSo" id="editMaSo" readonly style="background: #f1f1f1;">
                    <label>Tên Sản Phẩm:</label>
                    <input type="text" name="ten" id="editTen" required>
                    <label>Nhà Sản Xuất:</label>
                    <input type="text" name="nsxuat" id="editNsx" required>
                    <label>Đơn Giá:</label>
                    <input type="number" name="donGia" id="editGia" step="0.1" required>
                    <label>Số Lượng Tồn:</label>
                    <input type="number" name="soLuong" id="editSoLuong" required>
                    <button type="submit" style="background: #f39c12; margin-top: 20px;">Cập Nhật</button>
                </form>
            </div>
        </div>
	</main>

    <script>
        // Mở modal Thêm mới
        document.getElementById('btnOpenAddModal').addEventListener('click', function() {
            document.getElementById('addModal').style.display = 'block';
        });

        // Hàm được gọi khi bấm nút Sửa trên bảng
        function openEditModal(maSo, ten, nsxuat, donGia, soLuong) {
            document.getElementById('editMaSo').value = maSo;
            document.getElementById('editTen').value = ten;
            document.getElementById('editNsx').value = nsxuat;
            document.getElementById('editGia').value = donGia;
            document.getElementById('editSoLuong').value = soLuong;
            document.getElementById('editModal').style.display = 'block';
        }

        // Đóng khi click ra ngoài vùng nền mờ
        window.addEventListener('click', function(e) {
            if (e.target == document.getElementById('addModal')) document.getElementById('addModal').style.display = 'none';
            if (e.target == document.getElementById('editModal')) document.getElementById('editModal').style.display = 'none';
        });
    </script>
</body>
</html>