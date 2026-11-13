import java.util.Scanner;

public class BaiTapTuan4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== Nhap thong tin sach (nhu tuan 3) =====
        System.out.print("Nhap ma sach: ");
        String maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap don gia: ");
        double donGia = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        int soLuong = Integer.parseInt(sc.nextLine());

        // ===== BAI 1: Kiem tra du lieu hop le =====
        boolean hopLe = true;

        if (donGia <= 0) {
            System.out.println("Loi: Don gia phai lon hon 0");
            hopLe = false;
        }
        if (soLuong < 0) {
            System.out.println("Loi: So luong phai lon hon hoac bang 0");
            hopLe = false;
        }
        if (namXuatBan < 1900 || namXuatBan > 2026) {
            System.out.println("Loi: Nam xuat ban khong hop le (1900 - 2026)");
            hopLe = false;
        }

        if (!hopLe) {
            System.out.println("=> Sach KHONG hop le. Ket thuc chuong trinh.");
            sc.close();
            return; // dung chuong trinh tai day
        }
        System.out.println("=> Sach hop le.");

        // ===== BAI 2: Phan loai gia =====
        String loaiGia;
        if (donGia < 50000) {
            loaiGia = "Sach gia thap";
        } else if (donGia <= 100000) {
            loaiGia = "Sach gia trung binh";
        } else if (donGia <= 200000) {
            loaiGia = "Sach gia cao";
        } else {
            loaiGia = "Sach gia dac biet";
        }

        // ===== BAI 3: Phan loai ton kho =====
        String tonKho;
        if (soLuong == 0) {
            tonKho = "Het sach";
        } else if (soLuong <= 5) {
            tonKho = "Sap het";
        } else if (soLuong <= 20) {
            tonKho = "Con it";
        } else {
            tonKho = "Con nhieu";
        }

        // ===== BAI 4: Dung switch chon loai sach =====
        System.out.println();
        System.out.println("Chon loai sach:");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Nhap lua chon (1-4): ");
        int luaChon = Integer.parseInt(sc.nextLine());

        String loaiSach;
        switch (luaChon) {
            case 1:
                loaiSach = "Sach giao khoa";
                break;
            case 2:
                loaiSach = "Sach tham khao";
                break;
            case 3:
                loaiSach = "Sach chuyen nganh";
                break;
            case 4:
                loaiSach = "Sach khac";
                break;
            default:
                loaiSach = "Lua chon khong hop le";
        }

        // ===== Hien thi ket qua =====
        System.out.println();
        System.out.println("=== THONG TIN SACH ===");
        System.out.println("Ma sach      : " + maSach);
        System.out.println("Ten sach     : " + tenSach);
        System.out.println("Tac gia      : " + tacGia);
        System.out.println("Nam xuat ban : " + namXuatBan);
        System.out.printf("Don gia      : %,.0f VND%n", donGia);
        System.out.println("So luong     : " + soLuong);
        System.out.println("Muc gia      : " + loaiGia);
        System.out.println("Ton kho      : " + tonKho);
        System.out.println("Loai sach    : " + loaiSach);
        sc.close();
    }
}