import java.util.ArrayList;
import java.util.Scanner;
 
public class BaiTapTuan5 {
 
    // ---------- Class Sach (nam ngay trong file nay) ----------
    static class Sach {
        private String maSach;
        private String tenSach;
        private String tacGia;
        private int soLuong;
        private double donGia;
 
        public Sach(String maSach, String tenSach, String tacGia, int soLuong, double donGia) {
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.tacGia = tacGia;
            this.soLuong = soLuong;
            this.donGia = donGia;
        }
 
        public String getMaSach() {
            return maSach;
        }
 
        public String getTenSach() {
            return tenSach;
        }
 
        public String getTacGia() {
            return tacGia;
        }
 
        public int getSoLuong() {
            return soLuong;
        }
 
        public double getDonGia() {
            return donGia;
        }
 
        // Gia tri cua sach = so luong * don gia
        public double getThanhTien() {
            return soLuong * donGia;
        }
 
        public void hienThi() {
            System.out.printf("%-8s | %-25s | %-18s | %6d | %12.0f | %14.0f%n",
                    maSach, tenSach, tacGia, soLuong, donGia, getThanhTien());
        }
    }
 
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Sach> danhSach = new ArrayList<>();
 
    // ---------- Ham tien ich nhap du lieu an toan ----------
    static int nhapSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  -> Vui long nhap so nguyen hop le!");
            }
        }
    }
 
    static double nhapSoThuc(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  -> Vui long nhap so hop le!");
            }
        }
    }
 
    static boolean daTonTai(String ma) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(ma)) {
                return true;
            }
        }
        return false;
    }
 
    // ---------- Bai 1: Nhap n sach bang vong lap ----------
    static void nhapNSach() {
        int n;
        do {
            n = nhapSoNguyen("Nhap so luong sach can them (n > 0): ");
        } while (n <= 0);
 
        for (int i = 1; i <= n; i++) {
            System.out.println("--- Nhap sach thu " + i + " ---");
 
            String ma;
            while (true) {
                System.out.print("Ma sach: ");
                ma = sc.nextLine().trim();
                if (ma.isEmpty()) {
                    System.out.println("  -> Ma sach khong duoc de trong!");
                } else if (daTonTai(ma)) {
                    System.out.println("  -> Ma sach da ton tai, nhap ma khac!");
                } else {
                    break;
                }
            }
 
            System.out.print("Ten sach: ");
            String ten = sc.nextLine().trim();
            System.out.print("Tac gia: ");
            String tacGia = sc.nextLine().trim();
 
            int soLuong;
            do {
                soLuong = nhapSoNguyen("So luong: ");
                if (soLuong < 0) {
                    System.out.println("  -> So luong khong duoc am!");
                }
            } while (soLuong < 0);
 
            double donGia;
            do {
                donGia = nhapSoThuc("Don gia: ");
                if (donGia < 0) {
                    System.out.println("  -> Don gia khong duoc am!");
                }
            } while (donGia < 0);
 
            danhSach.add(new Sach(ma, ten, tacGia, soLuong, donGia));
        }
        System.out.println("Da them " + n + " sach thanh cong!");
    }
 
    // ---------- Hien thi danh sach ----------
    static void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Thu vien chua co sach nao!");
            return;
        }
        System.out.printf("%-8s | %-25s | %-18s | %6s | %12s | %14s%n",
                "Ma", "Ten sach", "Tac gia", "SL", "Don gia", "Thanh tien");
        System.out.println("-".repeat(100));
        for (Sach s : danhSach) {
            s.hienThi();
        }
    }
 
    // ---------- Bai 2: Tinh tong so luong va tong gia tri ----------
    static void tinhTong() {
        if (danhSach.isEmpty()) {
            System.out.println("Thu vien chua co sach nao!");
            return;
        }
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        for (Sach s : danhSach) {
            tongSoLuong += s.getSoLuong();
            tongGiaTri += s.getThanhTien();
        }
        System.out.println("Tong so dau sach : " + danhSach.size());
        System.out.println("Tong so luong    : " + tongSoLuong);
        System.out.printf("Tong gia tri     : %.0f%n", tongGiaTri);
    }
 
    // ---------- Bai 4: Tim sach theo ma ----------
    static void timTheoMa() {
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine().trim();
        boolean timThay = false;
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(ma)) {
                System.out.println("Da tim thay sach:");
                System.out.printf("%-8s | %-25s | %-18s | %6s | %12s | %14s%n",
                        "Ma", "Ten sach", "Tac gia", "SL", "Don gia", "Thanh tien");
                s.hienThi();
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay sach co ma: " + ma);
        }
    }
 
    // ---------- Bai 3: Menu lap den khi chon Thoat ----------
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n========== QUAN LY SACH THU VIEN ==========");
            System.out.println("1. Nhap n sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tinh tong so luong va tong gia tri");
            System.out.println("4. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.println("===========================================");
            chon = nhapSoNguyen("Chon chuc nang: ");
 
            switch (chon) {
                case 1:
                    nhapNSach();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    tinhTong();
                    break;
                case 4:
                    timTheoMa();
                    break;
                case 0:
                    System.out.println("Tam biet! Chuong trinh ket thuc.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        } while (chon != 0);
    }
}