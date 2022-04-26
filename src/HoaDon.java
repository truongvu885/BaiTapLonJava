package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HoaDon {
    private long maHD;
    private long maNV;
    private long maKH;
    private String maP;
    private int maDv;
    private String ngayThue;
    private String ngayTra;
    private double tongTien;

    public HoaDon() {

    }

    ArrayList<Nguoi> dsng = DsNguoi.getDsNg();
    ArrayList<Phong> dsP = Phong.getDsP();
    ArrayList<DichVu> dsdv = DichVu.getDsdv();
    ArrayList<HoaDon> dsHd = new ArrayList<>();
    KiemTraType kt = new KiemTraType();

    public ArrayList<NhanVien> getDsnv() {
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        for (Nguoi nguoi : dsng) {
            if (nguoi.getType().equalsIgnoreCase("NhanVien")) {
                NhanVien nv = (NhanVien) nguoi;
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public ArrayList<KhachHang> getDsKh() {
        ArrayList<KhachHang> dskh = new ArrayList<>();
        for (Nguoi nguoi : dsng) {
            if (nguoi.getType().equalsIgnoreCase("KhachHang")) {
                KhachHang nv = (KhachHang) nguoi;
                dskh.add(nv);
            }
        }
        return dskh;
    }

    public void hienManv() {
        System.out.print("\tMã NV hiện có: ");
        for (NhanVien nv : getDsnv()) {
            nv.hienMaNV();
        }
        System.out.println();
    }

    public void hienMaKh() {
        System.out.print("\tMã KH hiện có: ");
        for (KhachHang kh : getDsKh()) {
            kh.hienMaKh();
        }
        System.out.println();
    }

    public void hienMaP() {
        System.out.print("\tMã P hiện có: ");
        for (Phong p : dsP) {
            p.hienMaP();
        }
        System.out.println();
    }

    public void hienMaDv() {
        System.out.print("\tMã DV hiện có: ");
        for (DichVu dv : dsdv) {
            dv.hienMaDv();
        }
        System.out.println();
    }

    public float getGiaPhong() {
        for (Phong p : dsP) {
            if (p.getMaP().equalsIgnoreCase(this.maP)) {
                return p.getGiaP();
            }
        }
        return 0;
    }

    public float getGiaDv() {
        for (DichVu dv : dsdv) {
            if (dv.getMaLoaiDV() == this.maDv) {
                return dv.getGiaDV();
            }
        }
        return 0;
    }

    public float GiamGia() {
        for (KhachHang kh : getDsKh()) {
            if(kh.getMa()==this.maKH){
                switch (kh.getThanhVien()) {
                    case 0:
                        return 0;
                    case 1:
                        return 0.3f;
                    case 2:
                        return 0.5f;
                }
            }
        }
        return 0;
    }

    public HoaDon(long maHD, long maNV, long maKH, String maP, int maDv, String ngayThue, String ngayTra, double tongTien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.maP = maP;
        this.maDv = maDv;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.tongTien = tongTien;
    }

    public double getTongTien() {
        tongTien = (getGiaPhong() + getGiaDv())-(getGiaPhong() + getGiaDv())*GiamGia();
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public long getMaHD() {
        return maHD;
    }

    public void setMaHD(long maHD) {
        this.maHD = maHD;
    }

    public long getMaNV() {
        return maNV;
    }

    public void setMaNV(long maNV) {
        this.maNV = maNV;
    }

    public long getMaKH() {
        return maKH;
    }

    public void setMaKH(long maKH) {
        this.maKH = maKH;
    }

    public String getMaP() {
        return maP;
    }

    public void setMaP(String maP) {
        this.maP = maP;
    }

    public int getMaDv() {
        return maDv;
    }

    public void setMaDv(int maDv) {
        this.maDv = maDv;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public boolean KtraNV(long ma) {
        for (NhanVien nv : getDsnv()) {
            if (nv.getMa() == ma) {
                return true;
            }
        }
        return false;
    }

    public boolean KtraKh(long ma) {
        for (KhachHang kh : getDsKh()) {
            if (kh.getMa() == ma) {
                return true;
            }
        }
        return false;
    }

    public boolean KtraP(String ma) {
        for (Phong p : dsP) {
            if (p.getMaP().equalsIgnoreCase(ma)) {
                return true;
            }
        }
        return false;
    }

    public boolean KtraDv(int ma) {
        for (DichVu dv : dsdv) {
            if (dv.getMaLoaiDV() == ma) {
                return true;
            }
        }
        return false;
    }

    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.println("Mã hóa đơn: ");
        this.maHD = Integer.parseInt(input.nextLine());
        while (true) {
            System.out.println("Mã nhân viên: ");
            hienManv();
            String manvS = input.nextLine();
            if (kt.isLong(manvS)) {
                this.maNV = Long.parseLong(manvS);
                if (KtraNV(this.maNV)) {
                    break;
                }
            }
        }
        while (true) {
            System.out.println("Mã khách hàng: ");
            hienMaKh();
            String makhS = input.nextLine();
            if (kt.isLong(makhS)) {
                this.maKH = Long.parseLong(makhS);
                if (KtraKh(this.maKH)) {
                    break;
                }
            }
        }
        while (true) {
            System.out.println("Mã phòng: ");
            hienMaP();
            this.maP = input.nextLine();
            if (KtraP(this.maP)) {
                break;
            }
        }
        while (true) {
            System.out.println("Mã dịch vụ: ");
            hienMaDv();
            String madvS = input.nextLine();
            if (kt.isInt(madvS)) {
                this.maDv = Integer.parseInt(madvS);
                if (KtraDv(this.maDv)) {
                    break;
                }
            }
        }
        while (true){
            System.out.print("Ngày thuê : ");
            this.ngayThue = input.nextLine();
            if(kt.isDate(this.ngayThue)){
                break;
            }
        }
        while (true){
            System.out.print("Ngày trả: ");
            this.ngayTra = input.nextLine();
            if(kt.isDate(this.ngayTra)){
                break;
            }
        }
    }

    public String hienTenNv(long maNvien) {
        for (NhanVien nv : getDsnv()) {
            if (nv.getMa() == maNvien) {
                return nv.getTen();
            }
        }
        return null;
    }

    public String hienTenKh(long maKhang) {
        for (KhachHang kh : getDsKh()) {
            if (kh.getMa() == maKhang) {
                return kh.getTen();
            }
        }
        return null;
    }

    public String hienLoaiP(String maPh) {
        for (Phong p : dsP) {
            if (p.getMaP().equalsIgnoreCase(maPh)) {
                return p.getLoaiP();
            }
        }
        return null;
    }

    public String hienTenDv(int maDvu) {
        for (DichVu dv : dsdv) {
            if (dv.getMaLoaiDV() == maDvu) {
                return dv.getTenDV();
            }
        }
        return null;
    }

    public void hienLb() {
        System.out.println("\n\t------Danh sách hóa đơn-----");
        System.out.printf("%5s|%20s|%20s|%15s|%15s|%10s|%10s|%10s|", "Mã HD", "Tên NV", "Tên KH", "Loại P", "Dịch vụ", "Ngày thuê", "Ngày trả", "Tổng tiền");
        System.out.println();
    }

    public void hienDt() {
        System.out.printf("%5d|", this.maHD);
        System.out.printf("%20s|", hienTenNv(this.maNV));
        System.out.printf("%20s|", hienTenKh(this.maKH));
        System.out.printf("%15s|", hienLoaiP(this.maP));
        System.out.printf("%15s|", hienTenDv(this.maDv));
        System.out.printf("%10s|", this.ngayThue);
        System.out.printf("%10s|", this.ngayTra);
        System.out.printf("%10.2f|", getTongTien());
        System.out.println();
    }

    public void nhapDsHoaDon() {
        while (true) {
            HoaDon hd = new HoaDon();
            hd.nhap();
            dsHd.add(hd);
            System.out.println("Bạn có muốn tiếp tục không? \n Có-1 \t\t Không-0");
            int chon = new Scanner(System.in).nextInt();
            if (chon == 0) {
                break;
            }
        }
    }

    public void hienDsHD() {
        hienLb();
        for (HoaDon hd : dsHd) {
            hd.hienDt();
        }
    }
    public void SapXepTheoTongTien(){
        Collections.sort(dsHd, new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return Double.compare(o1.getTongTien(),o2.getTongTien());
            }
        });
    }
    public double timHoaDonMax(){
        double max = 0;
        for (HoaDon hd :dsHd) {
            if(hd.getTongTien()>max){
                max = hd.getTongTien();
            }
            else max = max;
        }
        return max;
    }
    public double timHoaDonMin(){
        double min = timHoaDonMax();
        for (HoaDon hd :dsHd) {
            if(hd.getTongTien()<min){
                min = hd.getTongTien();
            }
            else min = min;
        }
        return min;
    }
    public void hienMax(){
        hienLb();
        for (HoaDon hd:dsHd) {
            if(hd.getTongTien()==timHoaDonMax()){
                hd.hienDt();
            }
        }
    }
}
