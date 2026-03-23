package hanghoa;

import java.io.Serializable;

public class HangHoaDTO implements Serializable {
	private String hangHoaId;
	private String ten;
	private String donGia;
	private String nhaSanXuat;
	public HangHoaDTO(String hangHoaId, String ten, String donGia, String nhaSanXuat) {
		super();
		this.hangHoaId = hangHoaId;
		this.ten = ten;
		this.donGia = donGia;
		this.nhaSanXuat = nhaSanXuat;
	}
	public HangHoaDTO() {
		super();
	}
	public String getHangHoaId() {
		return hangHoaId;
	}
	public void setHangHoaId(String hangHoaId) {
		this.hangHoaId = hangHoaId;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDonGia() {
		return donGia;
	}
	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}
	public String getNhaSanXuat() {
		return nhaSanXuat;
	}
	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}
}
