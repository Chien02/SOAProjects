<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GIỎ HÀNG CỦA BẠN</title>
	<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h2>QUẢN LÝ KHO HÀNG</h2>
	
	<aside>
		<a href="customer?action=khoHang">Trang chủ</a>
		<a href="userInfo.jsp">Tài khoản</a>
		
		<c:if test="${khachHang != null && khachHang.laAdmin}">
			<a href="hanghoa?action=inventory">Quản lý Kho Hàng</a>
			<a href="customer?action=danhSach">Quản lý Người Dùng</a>
		</c:if>
		<c:if test="${khachHang != null && !khachHang.laAdmin}">
			<a href="invoice?action=payment" class="active">Thanh toán</a>
			<a href="lichSu?action=xemLichSu">Lịch sử mua hàng</a>
		</c:if>
		
		<a href="customer?action=dangXuat">Đăng xuất</a>
	</aside>
	<main>
		<div class="section-header">
            <h2 class="section-title">Giỏ hàng & Thanh toán</h2>
        </div>
        
        <c:if test="${not empty successMsg}">
            <div class="msg-alert msg-success">${successMsg}</div>
        </c:if>
        <c:if test="${not empty errorMsg}">
            <div class="msg-alert msg-error">${errorMsg}</div>
        </c:if>

        <c:choose>
            <c:when test="${not empty gioHang && not empty gioHang.danhSachChiTiet}">
                
                <table class="cart-table">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên Sản Phẩm</th>
                            <th>Đơn Giá</th>
                            <th>Số Lượng</th>
                            <th>Thành Tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="tongTienToanDon" value="0" />
                        
                        <c:forEach items="${gioHang.danhSachChiTiet}" var="item" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td><strong>${item.ten}</strong></td>
                                <td><fmt:formatNumber value="${item.donGia}" pattern="#,###" /> VNĐ</td>
                                <td>${item.soLuong}</td>
                                
                                <c:set var="thanhTienMon" value="${item.donGia * item.soLuong}" />
                                <td style="color: #e74c3c; font-weight: bold;"><fmt:formatNumber value="${thanhTienMon}" pattern="#,###" /> VNĐ</td>
                                
                                <c:set var="tongTienToanDon" value="${tongTienToanDon + thanhTienMon}" />
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
					    <c:set var="tongTienThanhToan" value="${tongTienToanDon}" />
					    
					    <c:if test="${khachHang.vip}">
					        <c:set var="tienGiamGia" value="${tongTienToanDon * (khachHang.tiLeGiam/100)}" />
					        <c:set var="tongTienThanhToan" value="${tongTienToanDon - tienGiamGia}" />
					        
					        <tr>
					            <td colspan="4" style="text-align: right; font-size: 16px; padding: 15px 20px;">Tạm tính:</td>
					            <td style="font-size: 16px; font-weight: bold; padding: 15px 20px;">
					                <fmt:formatNumber value="${tongTienToanDon}" pattern="#,###" /> VNĐ
					            </td>
					        </tr>
					        
					        <tr>
					            <td colspan="4" style="text-align: right; font-size: 16px; color: #27ae60; padding: 10px 20px;">
					                 Ưu đãi VIP (Giảm ${khachHang.tiLeGiam}%):
					            </td>
					            <td style="font-size: 16px; font-weight: bold; color: #27ae60; padding: 10px 20px;">
					                - <fmt:formatNumber value="${tienGiamGia}" pattern="#,###" /> VNĐ
					            </td>
					        </tr>
					    </c:if>
					
					    <tr style="background-color: #fcf8e3;">
					        <td colspan="4" style="text-align: right; font-size: 18px; font-weight: bold; padding: 20px;">
					            TỔNG CỘNG THANH TOÁN:
					        </td>
					        <td style="font-size: 22px; font-weight: bold; color: #e74c3c; padding: 20px;">
					            <fmt:formatNumber value="${tongTienThanhToan}" pattern="#,###" /> VNĐ
					        </td>
					    </tr>
					</tfoot>
                </table>

                <div class="checkout-section">
                    <form action="invoice" method="POST">
                        <input type="hidden" name="action" value="thanhToan">
                        <button type="submit" class="btn-checkout">THANH TOÁN</button>
                    </form>
                </div>

            </c:when>
            
            <c:otherwise>
                <div class="empty-cart">
                    <p>Giỏ hàng của bạn hiện đang trống!</p>
                    <a href="customer?action=khoHang" style="color: #3498db; text-decoration: none; font-weight: bold; margin-top: 10px; display: inline-block;">
                        &larr; Quay lại kho hàng để mua sắm
                    </a>
                </div>
            </c:otherwise>
        </c:choose>

	</main>
</body>
</html>