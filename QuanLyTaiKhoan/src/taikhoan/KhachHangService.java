package taikhoan;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import customer.KhachHangDTO;

@Path("/khachHang")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KhachHangService implements IKhachHang {
	private static KhachHangImpl khachHangImpl = new KhachHangImpl();

	@Override
	@POST
	@Path("/them")
	public Response themKhachHang(KhachHangDTO dto) {
		return khachHangImpl.themKhachHang(dto);
	}

	@Override
	@POST
	@Path("/capNhat")
	public Response capNhatKhachHang(KhachHangDTO dto) {
		// TODO Auto-generated method stub
		return khachHangImpl.capNhatKhachHang(dto);
	}

	@Override
	@GET
	@Path("/danhSach")
	public Response layDanhSachKH() {
		// TODO Auto-generated method stub
		return khachHangImpl.layDanhSachKH();
	}

	@Override
	@POST
	@Path("/dangNhap")
	public Response dangNhap(KhachHangDTO dto) {
		// TODO Auto-generated method stub
		return khachHangImpl.dangNhap(dto);
	}
	
	@POST
	@Path("/dangKyVip")
	public Response dangKyVip(KhachHangDTO dto) {
	    return khachHangImpl.dangKyVip(dto);
	}

	@Override
	@POST
	@Path("/capNhatVip")
	public Response capNhatVIP(KhachHangDTO dto) {
		return khachHangImpl.capNhatVIP(dto);
	}
}
