package qlnh;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TaiKhoanNganHang {
	private String soTaiKhoan;
	private String chuTaiKhoan;
	private double soDu;
	private String maPin;
	private boolean laAdmin;
	
	public TaiKhoanNganHang() {
	}

	public TaiKhoanNganHang(String soTaiKhoan, String chuTaiKhoan, double soDu, String maPin, boolean laAdmin) {
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.chuTaiKhoan = chuTaiKhoan;
		this.soDu = soDu;
		this.maPin = maPin;
		this.laAdmin = laAdmin;
	}

	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public String getChuTaiKhoan() {
		return chuTaiKhoan;
	}

	public void setChuTaiKhoan(String chuTaiKhoan) {
		this.chuTaiKhoan = chuTaiKhoan;
	}

	public double getSoDu() {
		return soDu;
	}

	public void setSoDu(double soDu) {
		this.soDu = soDu;
	}

	public String getMaPin() {
		return maPin;
	}

	public void setMaPin(String maPin) {
		this.maPin = maPin;
	}
	
	public boolean isLaAdmin() {
	    return laAdmin;
	}

	public void setLaAdmin(boolean laAdmin) {
	    this.laAdmin = laAdmin;
	}
	
	// Phuong thuc chinh	
	public boolean kiemTraMaPin(String pinNhap) {
		return this.maPin.equals(pinNhap);
	}
	
	public boolean napTien(double soTien, String pinNhap) {
		if (!kiemTraMaPin(pinNhap) || soTien < 0) return false;
		this.soDu += soTien;
		return true;
	}
	
	public boolean rutTien(double soTien, String pinNhap) {
		if (!kiemTraMaPin(pinNhap) || soTien < 0 || soTien > this.soDu) return false;
		this.soDu -= soTien;
		return true;
	}
	
	public boolean chuyenTien(TaiKhoanNganHang tkKhac, double soTien, String pinNhap) {
		if (!kiemTraMaPin(pinNhap) || soTien > this.soDu) return false;
		tkKhac.setSoDu(tkKhac.getSoDu() + soTien);
		this.soDu -= soTien;
		return true;
	}
	
	public TaiKhoanNganHang hienThiThongTin() {
		return new TaiKhoanNganHang(this.soTaiKhoan, this.chuTaiKhoan, this.soDu, this.maPin, this.laAdmin);
	}
}
