<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>KHO HANG HOA</title>
	<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h2>TRANG CHỦ</h2>
	<aside>
		<a href="customer?action=khoHang" class="active">Trang chủ</a>
		<a href="userInfo.jsp">Tài khoản</a>
		
		<c:if test="${khachHang != null && khachHang.laAdmin}">
			<a href="hanghoa?action=inventory">Quản lý Kho Hàng</a>
			<a href="customer?action=danhSach">Quản lý Người Dùng</a>
		</c:if>
		<c:if test="${khachHang != null && !khachHang.laAdmin}">
			<a href="invoice?action=payment">Thanh toán</a>
			<a href="lichSu?action=xemLichSu">Lịch sử mua hàng</a>
		</c:if>
		
		<a href="customer?action=dangXuat">Đăng xuất</a>
	</aside>
	<main>
		<div class="section-header">
            <h2 class="section-title">Hàng hóa</h2>
            <span class="goods-count">Hiển thị ${danhSachHangHoa.size()} kết quả</span> 
        </div>
		
		<div class="goods-grid">
    		<c:forEach items="${danhSachHangHoa}" var="dto">
        		<div class="goods-card">
            		<div class="goods-thumbnail" style="background-size: cover; background-position: center;"></div> 
            			<div class="goods-info">
						    <h3 class="goods-title">${dto.ten}</h3>
						    <span class="goods-producer">${dto.nsxuat}</span>
						    
						    <span class="goods-price"><fmt:formatNumber value="${dto.donGia}" pattern="#,###" /> VNĐ</span>
							<span class="goods-amount">Còn hàng: ${dto.soLuong}</span>
						    <form action="invoice" method="POST" class="cart-action-row">
						        <input type="hidden" name="action" value="themVaoGio">
						        <input type="hidden" name="maSo" value="${dto.maSo}">
						        
						        <button type="submit" class="btn-add-cart" onclick="return checkHangTon(this, ${dto.soLuong})">Thêm vào giỏ</button>
								<input type="number" name="soLuong" value="1" min="1" max="${dto.soLuong}" class="quantity-input" title="Chọn số lượng">
						    </form>
						</div>
        		</div>
    		</c:forEach>
		</div>

    	<c:if test="${empty danhSachHangHoa}">
    	        <p style="color: #333; text-align: center; width: 100%;">Không tìm thấy hàng hóa nào.</p>
    	</c:if>
	</main>
</body>
<script>
		function checkHangTon(buttonElement, tonKho) {
			var form = buttonElement.closest('form');
			
			var inputSoLuong = form.querySelector('input[name="soLuong"]');
			var soLuongDat = parseInt(inputSoLuong.value);
			
			if (isNaN(soLuongDat) || soLuongDat <= 0) {
				alert("Vui lòng nhập số lượng hợp lệ!");
				return false; // Trả về false sẽ chặn form không cho submit
			}
			
			if (soLuongDat > tonKho) {
				alert("Rất tiếc! Số lượng bạn chọn (" + soLuongDat + ") vượt quá số lượng tồn kho hiện tại (" + tonKho + ").");
				return false; // Chặn form không cho submit gửi về server
			}
			
			// Hợp lệ thì cho phép form chạy qua Servlet
			return true;
		}
	</script>
</body>
</html>
</html>