package invoice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hanghoa.ChiTietDTO;

public class HoaDonDTO implements Serializable{
	private String maSo;
	private String maKhachHang;
	private String tieuDe;
	private Date date;
	private List<ChiTietDTO> danhSachChiTiet = new ArrayList<ChiTietDTO>();
	public HoaDonDTO(String maSo, String maKhachHang, String tieuDe, Date date) {
		super();
		this.maSo = maSo;
		this.maKhachHang = maKhachHang;
		this.tieuDe = tieuDe;
		this.date = date;
	}
	public HoaDonDTO() {
		super();
	}
	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<ChiTietDTO> getDanhSachChiTiet() {
		return danhSachChiTiet;
	}
	public void setDanhSachChiTiet(List<ChiTietDTO> danhSachChiTiet) {
		this.danhSachChiTiet = danhSachChiTiet;
	}
	
}
