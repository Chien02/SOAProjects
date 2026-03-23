package qlnh;

public class GiaoDichRequest {
	private String maPin;
	private String soTaiKhoan;
	private String chuTaiKhoan;
	private String soTaiKhoanNhan;
	private double soTien;
	private boolean laAdmin;
	
	public String getChuTaiKhoan() {
		return chuTaiKhoan;
	}
	public void setChuTaiKhoan(String chuTaiKhoan) {
		this.chuTaiKhoan = chuTaiKhoan;
	}
	public boolean isLaAdmin() {
		return laAdmin;
	}
	public void setLaAdmin(boolean laAdmin) {
		this.laAdmin = laAdmin;
	}
	public String getMaPin() {
		return maPin;
	}
	public void setMaPin(String maPin) {
		this.maPin = maPin;
	}
	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}
	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}
	public String getSoTaiKhoanNhan() {
		return soTaiKhoanNhan;
	}
	public void setSoTaiKhoanNhan(String soTaiKhoanNhan) {
		this.soTaiKhoanNhan = soTaiKhoanNhan;
	}
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}
}
