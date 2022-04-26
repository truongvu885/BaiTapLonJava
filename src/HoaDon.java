package src;

import java.util.ArrayList;
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
    public ArrayList<NhanVien> getDsnv(){
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        for (Nguoi nguoi:dsng) {
            if(nguoi.getType().equalsIgnoreCase("NhanVien")){
                NhanVien nv = (NhanVien) nguoi;
                dsnv.add(nv);
            }
        }
        return dsnv;
    }
    public ArrayList<KhachHang> getDsKh(){
        ArrayList<KhachHang> dskh = new ArrayList<>();
        for (Nguoi nguoi:dsng) {
            if(nguoi.getType().equalsIgnoreCase("KhachHang")){
                KhachHang nv = (KhachHang) nguoi;
                dskh.add(nv);
            }
        }
        return dskh;
    }
    public void hienManv(){
        for (NhanVien nv:getDsnv()) {
            nv.hienMaNV();
        }
    }
    public void hienMaKh(){
        for (KhachHang kh:getDsKh()) {
            kh.hienMaKh();
        }
    }
    public void hienMaP(){
        for (Phong p:dsP) {
            p.hienMaP();
        }
    }
    public void hienMaDv(){
        for (DichVu dv:dsdv) {
            dv.hienMaDv();
        }
    }
    public float getGiaPhong(){
        for (Phong p:dsP) {
            if(p.getMaP().equalsIgnoreCase(this.maP))
            {
                return p.getGiaP();
            }
        }
        return 0;
    }
    public float getGiaDv(){
        for (DichVu dv:dsdv) {
            if(dv.getMaLoaiDV()==this.maDv){
                return dv.getGiaDV();
            }
        }
        return 0;
    }
    public float GiamGia(){
        for (KhachHang kh:getDsKh()) {
            switch (kh.getThanhVien()){
                case 0:
                    return 0;
                case 1:
                    return 0.1f;
                case 2:
                    return 0.2f;
                case 3:
                    return 0.3f;
                case 4:
                    return 0.4f;
                case 5:
                    return 0.5f;
            }
        }
        return 0;
    }

    public HoaDon(long maHD, long maNV, long maKH, String maP, int maDv, String ngayThue, String ngayTra,double tongTien) {
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
        tongTien = (getGiaPhong()+getGiaDv())*GiamGia();
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

    public boolean KtraNV(long ma){
        for (NhanVien nv: getDsnv()) {
            if(nv.getMa()==ma){
                return true;
            }
        }
        return false;
    }
    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.println("Mã hóa đơn: ");
        this.maHD = Integer.parseInt(input.nextLine());
        while(true){
            System.out.println("Mã nhân viên: ");
            hienManv();
            String manvS = input.nextLine();
            if(kt.isLong(manvS)){
                this.maNV = Long.parseLong(manvS);
                if(KtraNV(this.maNV)){
                    break;
                }
            }
        }
        System.out.println("Mã khách hàng: ");
        hienMaKh();
        this.maKH = Long.parseLong(input.nextLine());
        System.out.println("Mã phòng: ");
        hienMaP();
        this.maP = input.nextLine();
        System.out.println("Dịch vụ: ");
        hienMaDv();
        this.maDv = Integer.parseInt(input.nextLine());
        System.out.println("Ngày thuê: ");
        this.ngayThue = input.nextLine();
        System.out.println("Ngày trả: ");
        this.ngayTra = input.nextLine();
    }
    public String hienTenNv(long maNvien){
        for (NhanVien nv: getDsnv()) {
            if(nv.getMa()==maNvien){
                return nv.getTen();
            }
        }
        return null;
    }
    public String hienTenKh(long maKhang){
        for (KhachHang kh: getDsKh()) {
            if(kh.getMa()==maKhang){
                return kh.getTen();
            }
        }
        return null;
    }
    public String hienLoaiP(String maPh){
        for (Phong p: dsP) {
            if(p.getMaP().equalsIgnoreCase(maPh)){
                return p.getLoaiP();
            }
        }
        return null;
    }
    public String hienTenDv(int maDvu){
        for (DichVu dv: dsdv) {
            if(dv.getMaLoaiDV()==maDvu){
                return dv.getTenDV();
            }
        }
        return null;
    }

    public void hienLb(){
        System.out.printf("%5s|%20s|%20s|%15s|%15s|%10s|%10s|%10s|","Mã HD","Tên NV","Tên KH","Loại P","Dịch vụ","Ngày thuê","Ngày trả","Tổng tiền");
        System.out.println();
    }
    public void hienDt(){
        System.out.printf("%5d|",this.maHD);
        System.out.printf("%20s|",hienTenNv(this.maNV));
        System.out.printf("%20s|",hienTenKh(this.maKH));
        System.out.printf("%15s|",hienLoaiP(this.maP));
        System.out.printf("%15s|",hienTenDv(this.maDv));
        System.out.printf("%10s|",this.ngayThue);
        System.out.printf("%10s|",this.ngayTra);
        System.out.printf("%10.2f|",tongTien);
        System.out.println();
    }
    public void nhapDsHoaDon(){
        while (true){
            HoaDon hd = new HoaDon();
            hd.nhap();
            dsHd.add(hd);
            System.out.println("Bạn có muốn tiếp tục không? \n Có-1 \t\t Không-0");
            int chon = new Scanner(System.in).nextInt();
            if(chon==0){
                break;
            }
        }
    }
    public void hienDsHD(){
        hienLb();
        for (HoaDon hd:dsHd) {
            hd.hienDt();
        }
    }
}
