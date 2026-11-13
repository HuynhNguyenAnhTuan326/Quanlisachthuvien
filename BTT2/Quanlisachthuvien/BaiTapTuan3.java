import java.util.Scanner;

public class BaiTapTuan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // BÀI 1: Nhập thông tin sách
        System.out.print("Nhap ma sach: ");
        String maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = sc.nextInt();

        System.out.print("Nhap don gia: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        int soLuong = sc.nextInt();

        // BÀI 2: Thành tiền = đơn giá x số lượng
        double thanhTien = donGia * soLuong;

        // BÀI 3: Phí vận chuyển = 5% giá trị sách
        double phiVanChuyen = thanhTien * 0.05;

        // BÀI 4: Tổng tiền nhập = Thành tiền + Phí vận chuyển
        double tongTienNhap = thanhTien + phiVanChuyen;

        // Hiển thị lại thông tin
        System.out.println();
        System.out.println("=== THONG TIN SACH ===");
        System.out.println("Ma sach        : " + maSach);
        System.out.println("Ten sach       : " + tenSach);
        System.out.println("Tac gia        : " + tacGia);
        System.out.println("Nam xuat ban   : " + namXuatBan);
        System.out.printf("Don gia        : %,.0f VND%n", donGia);
        System.out.println("So luong       : " + soLuong);
        System.out.printf("Thanh tien     : %,.0f VND%n", thanhTien);
        System.out.printf("Phi van chuyen : %,.0f VND%n", phiVanChuyen);
        System.out.printf("Tong tien nhap : %,.0f VND%n", tongTienNhap);

        sc.close();
    }
}