import java.util.ArrayList;
 
// Yêu cầu 1: lớp Sach với các thuộc tính theo đề
class Sach {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;
 
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }
 
    public String getMaSach() {
        return maSach;
    }
 
    public String getTieuDe() {
        return tieuDe;
    }
 
    public String getTacGia() {
        return tacGia;
    }
 
    public int getNamXuatBan() {
        return namXuatBan;
    }
 
    public int getSoLuong() {
        return soLuong;
    }
 
    // Yêu cầu 2: in ra thông tin chi tiết của một cuốn sách
    public void hienThiThongTin() {
        System.out.println("Ma sach     : " + maSach);
        System.out.println("Tieu de     : " + tieuDe);
        System.out.println("Tac gia     : " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong    : " + soLuong);
        System.out.println("---------------------------------");
    }
}
 
// Yêu cầu 3 + 4: lớp chạy chương trình, quản lý danh sách bằng ArrayList
public class BaiTapTuan7 {
    public static void main(String[] args) {
        Sach s1 = new Sach("S001", "Lap trinh Java co ban", "Nguyen Van A", 2020, 10);
        System.out.println("=== Thong tin mot cuon sach ===");
        s1.hienThiThongTin();
 
        ArrayList<Sach> danhSach = new ArrayList<>();
        danhSach.add(s1);
        danhSach.add(new Sach("S002", "Cau truc du lieu va giai thuat", "Tran Thi B", 2019, 5));
        danhSach.add(new Sach("S003", "Lap trinh huong doi tuong", "Le Van C", 2021, 8));
        danhSach.add(new Sach("S004", "Co so du lieu", "Pham Thi D", 2018, 12));
 
        System.out.println("=== Danh sach sach (" + danhSach.size() + " cuon) ===");
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
 
        // Tìm sách theo mã
        String maCanTim = "S003";
        System.out.println("=== Tim sach co ma " + maCanTim + " ===");
        boolean timThay = false;
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maCanTim)) {
                s.hienThiThongTin();
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay sach.");
        }
 
        // Xóa sách theo mã
        String maCanXoa = "S002";
        danhSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maCanXoa));
        System.out.println("=== Sau khi xoa sach " + maCanXoa + " (" + danhSach.size() + " cuon) ===");
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
    }
}