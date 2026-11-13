import java.util.ArrayList;
import java.util.Scanner;
 
public class BaiTapTuan6 {
 
    static Scanner sc = new Scanner(System.in);
 
    // Bai 2: ArrayList<String> luu ma sach
    static ArrayList<String> dsMaSach = new ArrayList<>();
 
    // Bai 3 + 4: moi phan tu la 1 chuoi "ma;ten;tacGia;soLuong;donGia"
    static ArrayList<String> danhSachSach = new ArrayList<>();
 
    // ================= Ham tien ich (ke thua tu tuan 5) =================
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
 
    static int nhapSoLuong() {
        int sl;
        do {
            sl = nhapSoNguyen("So luong: ");
            if (sl < 0) {
                System.out.println("  -> So luong khong duoc am!");
            }
        } while (sl < 0);
        return sl;
    }
 
    static double nhapDonGia() {
        double dg;
        do {
            dg = nhapSoThuc("Don gia: ");
            if (dg < 0) {
                System.out.println("  -> Don gia khong duoc am!");
            }
        } while (dg < 0);
        return dg;
    }
 
    // Nhap chuoi, thay dau ';' bang ',' de khong lam hong dinh dang
    static String nhapChuoi(String thongBao) {
        System.out.print(thongBao);
        return sc.nextLine().trim().replace(";", ",");
    }
 
    // ================= BAI 1: Mang int[] soLuong =================
    static void bai1() {
        System.out.println("\n===== BAI 1: Mang so luong 5 cuon sach =====");
        int[] soLuong = new int[5];
 
        for (int i = 0; i < soLuong.length; i++) {
            do {
                soLuong[i] = nhapSoNguyen("Nhap so luong cuon sach thu " + (i + 1) + ": ");
                if (soLuong[i] < 0) {
                    System.out.println("  -> So luong khong duoc am!");
                }
            } while (soLuong[i] < 0);
        }
 
        // Hien thi, tinh tong, tim lon nhat
        int tong = 0;
        int max = soLuong[0];
        int viTriMax = 0;
        System.out.println("Danh sach so luong:");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.println("  Cuon " + (i + 1) + ": " + soLuong[i]);
            tong += soLuong[i];
            if (soLuong[i] > max) {
                max = soLuong[i];
                viTriMax = i;
            }
        }
        System.out.println("Tong so luong      : " + tong);
        System.out.println("So luong lon nhat  : " + max + " (cuon thu " + (viTriMax + 1) + ")");
    }
 
    // ================= BAI 2: ArrayList<String> ma sach =================
    static int timMa(String ma) {
        for (int i = 0; i < dsMaSach.size(); i++) {
            if (dsMaSach.get(i).equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }
 
    static void bai2() {
        int chon;
        do {
            System.out.println("\n===== BAI 2: Quan ly ma sach (ArrayList<String>) =====");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("0. Quay lai");
            chon = nhapSoNguyen("Chon: ");
 
            switch (chon) {
                case 1: {
                    String ma = nhapChuoi("Nhap ma sach: ");
                    if (ma.isEmpty()) {
                        System.out.println("Ma sach khong duoc de trong!");
                    } else if (timMa(ma) != -1) {
                        System.out.println("Ma sach da ton tai!");
                    } else {
                        dsMaSach.add(ma);
                        System.out.println("Da them ma sach: " + ma);
                    }
                    break;
                }
                case 2:
                    if (dsMaSach.isEmpty()) {
                        System.out.println("Danh sach ma sach dang trong!");
                    } else {
                        System.out.println("Co " + dsMaSach.size() + " ma sach:");
                        for (int i = 0; i < dsMaSach.size(); i++) {
                            System.out.println("  " + (i + 1) + ". " + dsMaSach.get(i));
                        }
                    }
                    break;
                case 3: {
                    String ma = nhapChuoi("Nhap ma can tim: ");
                    int vt = timMa(ma);
                    if (vt == -1) {
                        System.out.println("Khong tim thay ma: " + ma);
                    } else {
                        System.out.println("Tim thay ma '" + dsMaSach.get(vt) + "' o vi tri " + (vt + 1));
                    }
                    break;
                }
                case 4: {
                    String ma = nhapChuoi("Nhap ma can xoa: ");
                    int vt = timMa(ma);
                    if (vt == -1) {
                        System.out.println("Khong tim thay ma: " + ma);
                    } else {
                        dsMaSach.remove(vt);
                        System.out.println("Da xoa ma: " + ma);
                    }
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
 
    // ================= BAI 3 + 4: ArrayList<String> danhSachSach =================
    // Dinh dang moi phan tu: ma;ten;tacGia;soLuong;donGia
    static int timSach(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] t = danhSachSach.get(i).split(";");
            if (t[0].equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }
 
    static void inTieuDe() {
        System.out.printf("%-8s | %-25s | %-18s | %6s | %12s | %14s%n",
                "Ma", "Ten sach", "Tac gia", "SL", "Don gia", "Thanh tien");
        System.out.println("-".repeat(100));
    }
 
    static void inMotSach(String s) {
        String[] t = s.split(";");
        int sl = Integer.parseInt(t[3]);
        double dg = Double.parseDouble(t[4]);
        System.out.printf("%-8s | %-25s | %-18s | %6d | %12.0f | %14.0f%n",
                t[0], t[1], t[2], sl, dg, sl * dg);
    }
 
    // 1. Them sach
    static void themSach() {
        String ma;
        while (true) {
            ma = nhapChuoi("Ma sach: ");
            if (ma.isEmpty()) {
                System.out.println("  -> Ma sach khong duoc de trong!");
            } else if (timSach(ma) != -1) {
                System.out.println("  -> Ma sach da ton tai, nhap ma khac!");
            } else {
                break;
            }
        }
        String ten = nhapChuoi("Ten sach: ");
        String tacGia = nhapChuoi("Tac gia: ");
        int sl = nhapSoLuong();
        double dg = nhapDonGia();
 
        danhSachSach.add(ma + ";" + ten + ";" + tacGia + ";" + sl + ";" + (long) dg);
        System.out.println("Da them sach thanh cong!");
    }
 
    // 2. Hien thi sach
    static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Thu vien chua co sach nao!");
            return;
        }
        inTieuDe();
        for (String s : danhSachSach) {
            inMotSach(s);
        }
    }
 
    // 3. Tim sach (theo ma hoac ten chua tu khoa)
    static void timSachMenu() {
        String tuKhoa = nhapChuoi("Nhap ma hoac ten sach can tim: ").toLowerCase();
        boolean timThay = false;
        for (String s : danhSachSach) {
            String[] t = s.split(";");
            if (t[0].toLowerCase().equals(tuKhoa) || t[1].toLowerCase().contains(tuKhoa)) {
                if (!timThay) {
                    inTieuDe();
                }
                inMotSach(s);
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay sach phu hop!");
        }
    }
 
    // 4. Xoa sach
    static void xoaSach() {
        String ma = nhapChuoi("Nhap ma sach can xoa: ");
        int vt = timSach(ma);
        if (vt == -1) {
            System.out.println("Khong tim thay sach co ma: " + ma);
        } else {
            danhSachSach.remove(vt);
            System.out.println("Da xoa sach co ma: " + ma);
        }
    }
 
    // 5. Sua sach
    static void suaSach() {
        String ma = nhapChuoi("Nhap ma sach can sua: ");
        int vt = timSach(ma);
        if (vt == -1) {
            System.out.println("Khong tim thay sach co ma: " + ma);
            return;
        }
        System.out.println("Thong tin hien tai:");
        inTieuDe();
        inMotSach(danhSachSach.get(vt));
 
        System.out.println("Nhap thong tin moi (ma sach giu nguyen):");
        String maCu = danhSachSach.get(vt).split(";")[0];
        String ten = nhapChuoi("Ten sach: ");
        String tacGia = nhapChuoi("Tac gia: ");
        int sl = nhapSoLuong();
        double dg = nhapDonGia();
 
        danhSachSach.set(vt, maCu + ";" + ten + ";" + tacGia + ";" + sl + ";" + (long) dg);
        System.out.println("Da sua sach thanh cong!");
    }
 
    // 6. Tinh tong so luong
    static void tongSoLuong() {
        int tong = 0;
        for (String s : danhSachSach) {
            tong += Integer.parseInt(s.split(";")[3]);
        }
        System.out.println("Tong so luong sach: " + tong);
    }
 
    // 7. Tinh tong gia tri
    static void tongGiaTri() {
        double tong = 0;
        for (String s : danhSachSach) {
            String[] t = s.split(";");
            tong += Integer.parseInt(t[3]) * Double.parseDouble(t[4]);
        }
        System.out.printf("Tong gia tri sach: %.0f%n", tong);
    }
 
    // Bai 3 + 4: menu hoan chinh
    static void menuQuanLySach() {
        int chon;
        do {
            System.out.println("\n========== QUAN LY SACH THU VIEN ==========");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.println("===========================================");
            chon = nhapSoNguyen("Chon chuc nang: ");
 
            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
                    break;
                case 3:
                    timSachMenu();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    suaSach();
                    break;
                case 6:
                    tongSoLuong();
                    break;
                case 7:
                    tongGiaTri();
                    break;
                case 8:
                    System.out.println("Thoat menu quan ly sach.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        } while (chon != 8);
    }
 
    // ================= MAIN =================
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n############ BAI THUC HANH TUAN 6 ############");
            System.out.println("1. Bai 1: Mang so luong 5 cuon sach");
            System.out.println("2. Bai 2: ArrayList ma sach");
            System.out.println("3. Bai 3 + 4: Quan ly sach (menu hoan chinh)");
            System.out.println("0. Thoat chuong trinh");
            chon = nhapSoNguyen("Chon bai: ");
 
            switch (chon) {
                case 1:
                    bai1();
                    break;
                case 2:
                    bai2();
                    break;
                case 3:
                    menuQuanLySach();
                    break;
                case 0:
                    System.out.println("Tam biet! Chuong trinh ket thuc.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}