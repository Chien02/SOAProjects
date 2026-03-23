package ctu.cit.client;

import ctu.cit.BankAccount;
import ctu.cit.BankAccountManagerService;

import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class BankAccountClient {

    // Khoi tao service va scanner de tai su dung trong toan bo chuong trinh
    private static final BankAccountManagerService service = new BankAccountManagerService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        themTaiKhoan();
                        break;
                    case 2:
                        napTien();
                        break;
                    case 3:
                        rutTien();
                        break;
                    case 4:
                        chuyenTien();
                        break;
                    case 5:
                        khoaTaiKhoan();
                        break;
                    case 6:
                        hienThiDanhSach();
                        break;
                    case 7:
                        timTaiKhoanLonNhat();
                        break;
                    case 8:
                        tinhTongSoDu();
                        break;
                    case 0:
                        System.out.println("Da thoat chuong trinh.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai.");
                }
                if (choice != 0) {
                    System.out.println("\nNhan Enter de tiep tuc...");
                    scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap mot so.");
                choice = -1; // Dat lai de vong lap tiep tuc
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n======================");
        System.out.println("MENU QUAN LY TAI KHOAN");
        System.out.println("======================");
        System.out.println("1. Them tai khoan moi");
        System.out.println("2. Nap tien vao tai khoan");
        System.out.println("3. Rut tien tu tai khoan");
        System.out.println("4. Chuyen tien giua cac tai khoan");
        System.out.println("5. Khoa tai khoan");
        System.out.println("6. Hien thi danh sach tai khoan");
        System.out.println("7. Tim tai khoan co so du lon nhat");
        System.out.println("8. Tinh tong so du cua tat ca tai khoan");
        System.out.println("0. Thoat");
        System.out.println("======================");
        System.out.print("Vui long chon mot lua chon: ");
    }

    private static void themTaiKhoan() {
        System.out.print("Nhap so tai khoan: ");
        String soTaiKhoan = scanner.nextLine();
        System.out.print("Nhap ten chu tai khoan: ");
        String tenChuTaiKhoan = scanner.nextLine();
        System.out.print("Nhap so du ban dau: ");
        double soDu = Double.parseDouble(scanner.nextLine());

        BankAccount newAccount = new BankAccount(soTaiKhoan, tenChuTaiKhoan, soDu, true);
        BankAccount createdAccount = service.themTaiKhoan(newAccount);

        if (createdAccount != null) {
            System.out.println("Them tai khoan thanh cong.");
        } else {
            System.out.println("Loi: So tai khoan da ton tai hoac du lieu khong hop le.");
        }
    }

    private static void napTien() {
        System.out.print("Nhap so tai khoan can nap tien: ");
        String soTaiKhoan = scanner.nextLine();
        System.out.print("Nhap so tien can nap: ");
        double soTien = Double.parseDouble(scanner.nextLine());

        BankAccount updatedAccount = service.napTien(soTaiKhoan, soTien);
        if (updatedAccount != null) {
            System.out.println("Nap tien thanh cong.");
            System.out.println("So du moi: " + String.format("%,.2f VND", updatedAccount.getSoDu()));
        } else {
            System.out.println("Loi: Khong tim thay tai khoan, so tien khong hop le, hoac tai khoan da bi khoa.");
        }
    }

    private static void rutTien() {
        System.out.print("Nhap so tai khoan can rut tien: ");
        String soTaiKhoan = scanner.nextLine();
        System.out.print("Nhap so tien can rut: ");
        double soTien = Double.parseDouble(scanner.nextLine());

        BankAccount updatedAccount = service.rutTien(soTaiKhoan, soTien);
        if (updatedAccount != null) {
            System.out.println("Rut tien thanh cong.");
            System.out.println("So du con lai: " + String.format("%,.2f VND", updatedAccount.getSoDu()));
        } else {
            System.out.println("Loi: Khong tim thay tai khoan, so du khong du, hoac tai khoan da bi khoa.");
        }
    }

    private static void chuyenTien() {
        System.out.print("Nhap so tai khoan nguon: ");
        String soTaiKhoanNguon = scanner.nextLine();
        System.out.print("Nhap so tai khoan dich: ");
        String soTaiKhoanDich = scanner.nextLine();
        System.out.print("Nhap so tien can chuyen: ");
        double soTien = Double.parseDouble(scanner.nextLine());

        if (service.chuyenTien(soTaiKhoanNguon, soTaiKhoanDich, soTien)) {
            System.out.println("Chuyen tien thanh cong.");
        } else {
            System.out.println("Loi: Chuyen tien that bai. Vui long kiem tra lai thong tin tai khoan, so du, va trang thai.");
        }
    }

    private static void khoaTaiKhoan() {
        System.out.print("Nhap so tai khoan can khoa: ");
        String soTaiKhoan = scanner.nextLine();

        BankAccount updatedAccount = service.khoaTaiKhoan(soTaiKhoan);
        if (updatedAccount != null) {
            System.out.println("Khoa tai khoan thanh cong.");
        } else {
            System.out.println("Loi: Khong tim thay tai khoan.");
        }
    }

    private static void hienThiDanhSach() {
        List<BankAccount> accounts = service.layDanhSachTaiKhoan();
        
        if (accounts.isEmpty()) {
            System.out.println("Khong co tai khoan nao trong he thong.");
            return;
        }

        System.out.println("\n--- DANH SACH TAI KHOAN ---");
        for (BankAccount account : accounts) {
            account.hienThiThongTinTaiKhoan();
            System.out.println("--------------------");
        }
    }

    private static void timTaiKhoanLonNhat() {
        List<BankAccount> accounts = service.layDanhSachTaiKhoan();
        if (accounts.isEmpty()) {
            System.out.println("Khong co tai khoan nao de tim kiem.");
            return;
        }

        accounts.stream()
                .max(Comparator.comparing(BankAccount::getSoDu))
                .ifPresent(maxAccount -> {
                    System.out.println("Tai khoan co so du lon nhat la:");
                    maxAccount.hienThiThongTinTaiKhoan();
                });
    }

    private static void tinhTongSoDu() {
        List<BankAccount> accounts = service.layDanhSachTaiKhoan();
        double totalBalance = accounts.stream().mapToDouble(BankAccount::getSoDu).sum();
        System.out.printf("Tong so du cua tat ca tai khoan la: %,.2f VND%n", totalBalance);
    }
}