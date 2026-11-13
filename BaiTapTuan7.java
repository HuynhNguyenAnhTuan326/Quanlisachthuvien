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

class SachTuan8 {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;
 
    public SachTuan8() {
    }
 
    // Yeu cau 4: constructor day du tham so (goi setter de kiem tra hop le)
    public SachTuan8(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }
 
    // Yeu cau 2: getters
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
 
    // Yeu cau 2: setters
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
 
    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
 
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
 
    // Yeu cau 3: namXuatBan phai > 0 va khong lon hon nam hien tai
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = java.time.Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Loi: nam xuat ban " + namXuatBan + " khong hop le (phai tu 1 den " + currentYear + ").");
        }
    }
 
    // Yeu cau 3: soLuong khong am
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Loi: so luong " + soLuong + " khong hop le (khong duoc am).");
        }
    }
 
    public void hienThiThongTin() {
        System.out.println("Ma sach     : " + maSach);
        System.out.println("Tieu de     : " + tieuDe);
        System.out.println("Tac gia     : " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong    : " + soLuong);
        System.out.println("---------------------------------");
    }
}
 
class BaiTapTuan8 {
    public static void main(String[] args) {
        System.out.println("===== TUAN 8 =====");
 
        // Tao sach bang constructor day du tham so (du lieu hop le)
        SachTuan8 s1 = new SachTuan8("S001", "Lap trinh Java co ban", "Nguyen Van A", 2020, 10);
        System.out.println("=== Sach hop le ===");
        s1.hienThiThongTin();
 
        // Tao sach voi du lieu khong hop le: se bi tu choi boi setter
        System.out.println("=== Tao sach voi du lieu sai ===");
        SachTuan8 s2 = new SachTuan8("S002", "Cau truc du lieu", "Tran Thi B", 3000, -5);
        s2.hienThiThongTin();
 
        // Dung setter de sua du lieu
        System.out.println("=== Dung setter sua du lieu ===");
        s2.setNamXuatBan(2019);
        s2.setSoLuong(5);
        s2.setTieuDe("Cau truc du lieu va giai thuat");
        s2.hienThiThongTin();
 
        // Thu gan gia tri khong hop le cho sach s1
        System.out.println("=== Thu gan gia tri sai cho S001 ===");
        s1.setNamXuatBan(-1);
        s1.setSoLuong(-20);
        System.out.println("Sau khi thu, S001 van la: nam " + s1.getNamXuatBan() + ", so luong " + s1.getSoLuong());
 
        // Quan ly bang ArrayList (dung lai y tuong tuan 7)
        java.util.ArrayList<SachTuan8> danhSach = new java.util.ArrayList<>();
        danhSach.add(s1);
        danhSach.add(s2);
        System.out.println("=== Danh sach sach (" + danhSach.size() + " cuon) ===");
        for (SachTuan8 s : danhSach) {
            s.hienThiThongTin();
        }
    }
}