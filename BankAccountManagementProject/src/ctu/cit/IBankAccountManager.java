package ctu.cit;

public interface IBankAccountManager {
    void themTaiKhoan(BankAccount account);
    void themDanhSachTaiKhoan(java.util.List<BankAccount> newAccounts);
    java.util.List<BankAccount> layDanhSachTaiKhoan();
    BankAccount timTaiKhoan(String soTaiKhoan);
    boolean khoaTaiKhoan(String soTaiKhoan);
    boolean moKhoaTaiKhoan(String soTaiKhoan);
    boolean napTien(String soTaiKhoan, double soTien);
    boolean rutTien(String soTaiKhoan, double soTien);
    boolean chuyenTien(String soTaiKhoanNguon, String soTaiKhoanDich, double soTien);
}
