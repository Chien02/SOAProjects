package qlnh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuanLyNganHang {
	public static final Map<String, TaiKhoanNganHang> danhSachTaiKhoan = new HashMap<String, TaiKhoanNganHang>();
	
	static {
		danhSachTaiKhoan.put("0000", new TaiKhoanNganHang("0000", "Nguyen Van A", 1000, "0000", true));
		danhSachTaiKhoan.put("1111", new TaiKhoanNganHang("1111", "Nguyen Van B", 2000, "1111", false));
		danhSachTaiKhoan.put("2222", new TaiKhoanNganHang("2222", "Nguyen Van C", 3000, "2222", false));
		danhSachTaiKhoan.put("3333", new TaiKhoanNganHang("3333", "Nguyen Van D", 4000, "3333", false));
	}
	
	public boolean themTaiKhoan(TaiKhoanNganHang taiKhoan) {
		if (!danhSachTaiKhoan.containsKey(taiKhoan.getSoTaiKhoan())) {
			danhSachTaiKhoan.put(taiKhoan.getSoTaiKhoan(), taiKhoan);
			return true;
		}
		return false;
	}
	
	public List<TaiKhoanNganHang> hienThiTatCa() {
		return new ArrayList<>(danhSachTaiKhoan.values());
	}
	
	public TaiKhoanNganHang timTaiKhoanTheoSo(String soTK) {
		if (!danhSachTaiKhoan.containsKey(soTK)) return null;
		return danhSachTaiKhoan.get(soTK);
	}
	
}
