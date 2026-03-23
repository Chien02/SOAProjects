package ctu.cit.client;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ctu.cit.BankAccount;
import ctu.cit.BankAccountManagerService;

/**
 * Servlet implementation class BankAccountWebClient
 */
@WebServlet("/BankAccountWebClient")
public class BankAccountWebClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    // Khoi tao service. Trong ung dung thuc te, ban co the dung Dependency Injection.
    private BankAccountManagerService service = new BankAccountManagerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankAccountWebClient() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Phuong thuc nay chiu trach nhiem hien thi du lieu ra trang web.
		
		// 1. Lay danh sach tat ca tai khoan
		List<BankAccount> accounts = service.layDanhSachTaiKhoan();
		
		// 2. Tim tai khoan co so du lon nhat
		Optional<BankAccount> maxAccount = accounts.stream()
				.max(Comparator.comparing(BankAccount::getSoDu));
		
		// 3. Tinh tong so du
		double totalBalance = accounts.stream()
				.mapToDouble(BankAccount::getSoDu)
				.sum();
		
		// 4. Dat du lieu vao request de JSP co the su dung
		request.setAttribute("accounts", accounts);
		request.setAttribute("maxAccount", maxAccount.orElse(null));
		request.setAttribute("totalBalance", totalBalance);
		
		// 5. Chuyen tiep request den file JSP de render giao dien HTML
		request.getRequestDispatcher("/bank.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Phuong thuc nay xu ly cac hanh dong tu form ma nguoi dung gui len.
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if (action == null) {
			doGet(request, response);
			return;
		}
		
		String message = null;
		boolean success = false;

		try {
			switch (action) {
				case "add":
					success = themTaiKhoan(request);
					message = success ? "Them tai khoan thanh cong." : "Loi: So tai khoan da ton tai hoac du lieu khong hop le.";
					break;
				case "deposit":
					success = napTien(request);
					message = success ? "Nap tien thanh cong." : "Loi: Khong tim thay tai khoan, so tien khong hop le, hoac tai khoan da bi khoa.";
					break;
				case "withdraw":
					success = rutTien(request);
					message = success ? "Rut tien thanh cong." : "Loi: Khong tim thay tai khoan, so du khong du, hoac tai khoan da bi khoa.";
					break;
				case "transfer":
					success = chuyenTien(request);
					message = success ? "Chuyen tien thanh cong." : "Loi: Chuyen tien that bai. Vui long kiem tra lai thong tin.";
					break;
				case "lock":
					success = khoaTaiKhoan(request);
					message = success ? "Khoa tai khoan thanh cong." : "Loi: Khong tim thay tai khoan.";
					break;
				case "unlock":
					success = moKhoaTaiKhoan(request);
					message = success ? "Mo khoa tai khoan thanh cong." : "Loi: Khong tim thay tai khoan.";
					break;
			}
			request.getSession().setAttribute("message", message);
		} catch (Exception e) {
			// Dat mot thong bao loi chung
			request.getSession().setAttribute("message", "Loi: Du lieu nhap vao khong hop le.");
			e.printStackTrace();
		}
		
		// Chuyen huong ve trang chinh de hien thi du lieu da cap nhat (Post-Redirect-Get pattern)
		response.sendRedirect(request.getContextPath() + "/BankAccountWebClient");
	}

	private boolean themTaiKhoan(HttpServletRequest request) {
		String soTaiKhoan = request.getParameter("soTaiKhoan");
		String tenChuTaiKhoan = request.getParameter("tenChuTaiKhoan");
		double soDu = Double.parseDouble(request.getParameter("soDu"));
		
		BankAccount newAccount = new BankAccount(soTaiKhoan, tenChuTaiKhoan, soDu, true);
		return service.themTaiKhoan(newAccount) != null;
	}

	private boolean napTien(HttpServletRequest request) {
		String soTaiKhoan = request.getParameter("soTaiKhoan");
		double amount = Double.parseDouble(request.getParameter("amount"));
		return service.napTien(soTaiKhoan, amount) != null;
	}

	private boolean rutTien(HttpServletRequest request) {
		String soTaiKhoan = request.getParameter("soTaiKhoan");
		double amount = Double.parseDouble(request.getParameter("amount"));
		return service.rutTien(soTaiKhoan, amount) != null;
	}

	private boolean chuyenTien(HttpServletRequest request) {
		String fromAccount = request.getParameter("fromAccount");
		String toAccount = request.getParameter("toAccount");
		double amount = Double.parseDouble(request.getParameter("amount"));
		return service.chuyenTien(fromAccount, toAccount, amount);
	}

	private boolean khoaTaiKhoan(HttpServletRequest request) {
		String soTaiKhoan = request.getParameter("soTaiKhoan");
		return service.khoaTaiKhoan(soTaiKhoan) != null;
	}
	
	private boolean moKhoaTaiKhoan(HttpServletRequest request) {
		String soTaiKhoan = request.getParameter("soTaiKhoan");
		return service.moKhoaTaiKhoan(soTaiKhoan) != null;
	}
}
