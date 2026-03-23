<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quan Ly Tai Khoan Ngan Hang</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f7f6; color: #333; }
    h1, h2 { color: #0056b3; }
    table { width: 100%; border-collapse: collapse; margin-bottom: 20px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
    th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
    th { background-color: #007bff; color: white; }
    tr:nth-child(even) { background-color: #f9f9f9; }
    tr:hover { background-color: #f1f1f1; }
    .container { display: flex; flex-wrap: wrap; gap: 40px; }
    .actions, .summary { flex: 1; min-width: 300px; }
    form { margin-bottom: 20px; padding: 20px; border: 1px solid #ccc; border-radius: 8px; background-color: #fff; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
    form h2 { margin-top: 0; border-bottom: 2px solid #007bff; padding-bottom: 10px; }
    label { display: block; margin-bottom: 5px; font-weight: bold; }
    input[type=text], input[type=number] { width: calc(100% - 20px); padding: 10px; margin-bottom: 15px; border-radius: 4px; border: 1px solid #ccc; }
    button { background-color: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
    button:hover { background-color: #0056b3; }
    .lock-btn { background-color: #dc3545; }
    .lock-btn:hover { background-color: #c82333; }
    .unlock-btn { background-color: #28a745; }
    .unlock-btn:hover { background-color: #218838; }
    .message { padding: 15px; margin-bottom: 20px; border-radius: 4px; color: #fff; background-color: #28a745; }
    .message.error { background-color: #dc3545; }
</style>
</head>
<body>

    <h1>Trang Quan Ly Tai Khoan Ngan Hang</h1>

    <%-- Hien thi thong bao tu session (neu co) --%>
    <c:if test="${not empty sessionScope.message}">
        <div class="message <c:if test='${sessionScope.message.startsWith("Loi")}'>error</c:if>">
            ${sessionScope.message}
        </div>
        <c:remove var="message" scope="session" />
    </c:if>

    <h2>Danh Sach Tai Khoan</h2>
    <table>
        <thead>
            <tr>
                <th>So Tai Khoan</th>
                <th>Ten Chu Tai Khoan</th>
                <th>So Du</th>
                <th>Trang Thai</th>
                <th>Hanh Dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="acc" items="${accounts}">
                <tr>
                    <td>${acc.soTaiKhoan}</td>
                    <td>${acc.tenChuTaiKhoan}</td>
                    <td><fmt:formatNumber value="${acc.soDu}" type="currency" currencySymbol="" maxFractionDigits="0"/> VND</td>
                    <td>
                        <c:if test="${acc.trangThai}">
                            <span style="color: green; font-weight: bold;">Hoat Dong</span>
                        </c:if>
                        <c:if test="${not acc.trangThai}">
                            <span style="color: red; font-weight: bold;">Da Khoa</span>
                        </c:if>
                    </td>
                    <td>
                        <form action="BankAccountWebClient" method="post" style="display:inline;">
                             <input type="hidden" name="soTaiKhoan" value="${acc.soTaiKhoan}">
                             <c:if test="${acc.trangThai}">
                                 <input type="hidden" name="action" value="lock">
                                 <button type="submit" class="lock-btn">Khoa</button>
                             </c:if>
                             <c:if test="${not acc.trangThai}">
                                 <input type="hidden" name="action" value="unlock">
                                 <button type="submit" class="unlock-btn">Mo Khoa</button>
                             </c:if>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="container">
        <div class="summary">
            <form>
                <h2>Thong Tin Tong Hop</h2>
                <p><strong>Tong so du tat ca tai khoan:</strong> 
                    <fmt:formatNumber value="${totalBalance}" type="currency" currencySymbol="" maxFractionDigits="0"/> VND
                </p>
                <c:if test="${not empty maxAccount}">
                    <p><strong>Tai khoan co so du lon nhat:</strong></p>
                    <ul>
                        <li>So TK: ${maxAccount.soTaiKhoan}</li>
                        <li>Chu TK: ${maxAccount.tenChuTaiKhoan}</li>
                        <li>So Du: <fmt:formatNumber value="${maxAccount.soDu}" type="currency" currencySymbol="" maxFractionDigits="0"/> VND</li>
                    </ul>
                </c:if>
                 <c:if test="${empty maxAccount}">
                    <p>Khong co tai khoan nao trong he thong.</p>
                </c:if>
            </form>
        </div>

        <div class="actions">
            <form action="BankAccountWebClient" method="post">
                <h2>Them Tai Khoan Moi</h2>
                <input type="hidden" name="action" value="add">
                <label for="soTaiKhoanAdd">So Tai Khoan:</label>
                <input type="text" id="soTaiKhoanAdd" name="soTaiKhoan" required>
                <label for="tenChuTaiKhoan">Ten Chu Tai Khoan:</label>
                <input type="text" id="tenChuTaiKhoan" name="tenChuTaiKhoan" required>
                <label for="soDu">So Du Ban Dau:</label>
                <input type="number" id="soDu" name="soDu" step="1000" min="0" required>
                <button type="submit">Them Tai Khoan</button>
            </form>
            
            <form action="BankAccountWebClient" method="post">
                <h2>Nap Tien / Rut Tien</h2>
                <label for="soTaiKhoanDeposit">So Tai Khoan:</label>
                <input type="text" id="soTaiKhoanDeposit" name="soTaiKhoan" required>
                <label for="amountDeposit">So Tien:</label>
                <input type="number" id="amountDeposit" name="amount" step="1000" min="1" required>
                <button type="submit" name="action" value="deposit">Nap Tien</button>
                <button type="submit" name="action" value="withdraw" class="lock-btn">Rut Tien</button>
            </form>

            <form action="BankAccountWebClient" method="post">
                <h2>Chuyen Tien</h2>
                <input type="hidden" name="action" value="transfer">
                <label for="fromAccount">Tu Tai Khoan:</label>
                <input type="text" id="fromAccount" name="fromAccount" required>
                <label for="toAccount">Den Tai Khoan:</label>
                <input type="text" id="toAccount" name="toAccount" required>
                <label for="amountTransfer">So Tien Chuyen:</label>
                <input type="number" id="amountTransfer" name="amount" step="1000" min="1" required>
                <button type="submit">Chuyen Tien</button>
            </form>
        </div>
    </div>

</body>
</html>