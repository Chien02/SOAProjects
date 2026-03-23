package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import customer.KhachHangDTO;
import hanghoa.ChiTiet;

@WebServlet("/hanghoa")
public class HangHoaWebClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// Đảm bảo URL này khớp với project API Hàng Hóa của bạn
	private final String HANGHOA_URL = "http://localhost:8080/QuanLyHangHoa/rest/hangHoa";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// BẢO MẬT: Phải là Admin mới được vào trang này
		HttpSession session = request.getSession();
		KhachHangDTO user = (KhachHangDTO) session.getAttribute("khachHang");
		if (user == null || !user.isLaAdmin()) {
			response.sendRedirect("index.jsp");
			return;
		}

		String action = request.getParameter("action");
		if (action == null) action = "inventory";

		switch (action) {
			case "inventory":
				getInventory(request, response);
				break;
			case "them":
				themHangHoa(request, response);
				break;
			case "sua":
				suaHangHoa(request, response);
				break;
			case "xoa":
				xoaHangHoa(request, response);
				break;
			default:
				getInventory(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// 1. LẤY DANH SÁCH HÀNG HÓA
	private void getInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = ClientBuilder.newClient();
		try {
			WebTarget target = client.target(HANGHOA_URL).path("danhSach");
			Response apiResponse = target.request(MediaType.APPLICATION_JSON).get();
			if (apiResponse.getStatus() == 200) {
				List<ChiTiet> list = apiResponse.readEntity(new GenericType<List<ChiTiet>>() {});
				request.setAttribute("danhSach", list);
			}
			request.getRequestDispatcher("inventory.jsp").forward(request, response);
		} finally {
			client.close();
		}
	}

	// 2. THÊM HÀNG HÓA
	private void themHangHoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChiTiet sp = new ChiTiet();
		sp.setMaSo(request.getParameter("maSo"));
		sp.setTen(request.getParameter("ten"));
		sp.setNsxuat(request.getParameter("nsxuat"));
		sp.setDonGia(Double.parseDouble(request.getParameter("donGia")));
		sp.setSoLuong(Integer.parseInt(request.getParameter("soLuong")));

		Client client = ClientBuilder.newClient();
		try {
			Response apiResponse = client.target(HANGHOA_URL).path("themHangHoa")
					.request(MediaType.APPLICATION_JSON).post(Entity.json(sp));

			if (apiResponse.getStatus() == 200) {
				request.setAttribute("successMsg", "Thêm hàng hóa thành công!");
			} else {
				request.setAttribute("errorMsg", "Lỗi: " + apiResponse.readEntity(String.class));
			}
			getInventory(request, response); // Load lại danh sách
		} finally {
			client.close();
		}
	}

	// 3. SỬA HÀNG HÓA
	private void suaHangHoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChiTiet sp = new ChiTiet();
		sp.setMaSo(request.getParameter("maSo"));
		sp.setTen(request.getParameter("ten"));
		sp.setNsxuat(request.getParameter("nsxuat"));
		sp.setDonGia(Double.parseDouble(request.getParameter("donGia")));
		sp.setSoLuong(Integer.parseInt(request.getParameter("soLuong")));

		Client client = ClientBuilder.newClient();
		try {
			Response apiResponse = client.target(HANGHOA_URL).path("capNhatHangHoa")
					.request(MediaType.APPLICATION_JSON).post(Entity.json(sp));

			if (apiResponse.getStatus() == 200) {
				request.setAttribute("successMsg", "Cập nhật hàng hóa thành công!");
			} else {
				request.setAttribute("errorMsg", "Cập nhật thất bại!");
			}
			getInventory(request, response);
		} finally {
			client.close();
		}
	}

	// 4. XÓA HÀNG HÓA
	private void xoaHangHoa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChiTiet sp = new ChiTiet();
		sp.setMaSo(request.getParameter("maSo")); // Xóa chỉ cần Mã Số

		Client client = ClientBuilder.newClient();
		try {
			Response apiResponse = client.target(HANGHOA_URL).path("xoaHangHoa")
					.request(MediaType.APPLICATION_JSON).post(Entity.json(sp));

			if (apiResponse.getStatus() == 200) {
				request.setAttribute("successMsg", "Đã xóa hàng hóa!");
			} else {
				request.setAttribute("errorMsg", "Không thể xóa!");
			}
			getInventory(request, response);
		} finally {
			client.close();
		}
	}
}