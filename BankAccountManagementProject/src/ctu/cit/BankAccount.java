package ctu.cit;

public class BankAccount {
	private String soTaiKhoan;
	private String tenChuTaiKhoan;
	private double soDu;
	private boolean trangThai;
	
	// A no-arg constructor is often needed for JSON deserialization frameworks like Jackson
	public BankAccount() {}

	public BankAccount(String _soTaiKhoan, String _tenChuTaiKhoan, double _soDu, boolean _trangThai) {
		this.soTaiKhoan = _soTaiKhoan;
		this.tenChuTaiKhoan = _tenChuTaiKhoan;
		this.soDu = _soDu;
		this.trangThai = _trangThai;
	}
	
	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}
	
	public String getTenChuTaiKhoan() {
		return tenChuTaiKhoan;
	}
	
	public double getSoDu() {
		return soDu;
	}
	
	public boolean isTrangThai() {
		return trangThai;
	}
	
	public boolean napTien(double soTien) {
		// Account must be active and amount must be positive
		if (!this.trangThai || soTien <= 0) {
			return false;
		}
		this.soDu += soTien;
		return true;
	}
	
	public boolean rutTien(double soTien) {
		// Account must be active, amount positive, and balance sufficient
		if (!this.trangThai || soTien <= 0 || soTien > this.soDu) {
			return false;
		}
		this.soDu -= soTien;
		return true;
	}
	
	public boolean chuyenTien(BankAccount dich, double soTien) {
		if (dich == null || !this.trangThai || !dich.isTrangThai()) {
			return false; // Destination account cannot be null, and both accounts must be active
		}
		// Check if this account has enough money
		if (this.rutTien(soTien)) {
			// If withdrawal is successful, deposit into the destination account
			if (dich.napTien(soTien)) {
				return true;
			}
			// CRITICAL: If deposit fails, refund the money to the original account.
			this.napTien(soTien);
		}
		return false;
	}
	
	public boolean khoaTaiKhoan() {
		if (!this.trangThai) {
			return false; // Account is already locked
		}
		this.trangThai = false;
		return true;
	}

	public boolean moKhoaTaiKhoan() {
		if (this.trangThai) {
			return false; // Account is already active
		}
		this.trangThai = true;
		return true;
	}

	public boolean hienThiThongTinTaiKhoan() {
		System.out.println("So tai khoan: " + this.soTaiKhoan);
		System.out.println("Ten chu tai khoan: " + this.tenChuTaiKhoan);
		System.out.println("So du: " + this.soDu);
		System.out.println("Trang thai: " + (this.trangThai ? "Active" : "Locked"));
		return true;
	}
}
