<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculation Service</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
    <h3>CONG - TRU - NHAN - CHIA</h3>
    <form action="CalcWebClient">
        <label>a: </label> <input type="number" step="any" name="a" placeholder="${a}" required>
        <label>b: </label> <input type="number" step="any" name="b" placeholder="${b}" required>
        <label> = ${ketQua}</label><br/><br/>
        <button type="submit" name="phepToan" value="cong">+</button>
        <button type="submit" name="phepToan" value="tru">-</button>
        <button type="submit" name="phepToan" value="nhan">*</button>
        <button type="submit" name="phepToan" value="chia">/</button>
    </form>
    
    <h3>GIAI THUA - LUY THUA - GIAI PHUONG TRINH BAC 2</h3>
    <h4>Tinh giai thua: n!</h4>
    <form action="CalcWebClient">
        <label>n: </label> <input type="number" name="a" placeholder="${aGT}" required>
        <button type="submit" name="phepToan" value="giaithua">=</button>
        <p>Ket qua: ${ketQuaGiaiThua}</p>
    </form>
    
    <h4>Tinh luy thua: a^n</h4>
    <form action="CalcWebClient">
        <label>a: </label> <input type="number" step="any" name="a" placeholder="${aLT}" required>
        <label>mu n: </label> <input type="number" name="n" placeholder="${nLT}" required>
        <button type="submit" name="phepToan" value="luythua">=</button>
        <p>Ket qua: ${ketQuaLuyThua}</p>
    </form>
    
    <h4>Giai phuong trinh bac 2: ax^2 + bx + c = 0</h4>
    <form action="CalcWebClient">
        <label>a: </label> <input type="number" step="any" name="a" placeholder="${aPTB2}" required>
        <label>b: </label> <input type="number" step="any" name="b" placeholder="${bPTB2}" required>
        <label>c: </label> <input type="number" step="any" name="c" placeholder="${cPTB2}" required>
        <button type="submit" name="phepToan" value="gpt2">=</button>
        <p>Ket qua: ${ketQuaGPT2}</p>
    </form>
</body>
</html>