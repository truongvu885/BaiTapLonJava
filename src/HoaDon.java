package src;

import java.util.ArrayList;
import java.util.Scanner;

public class HoaDon {
    private long maHD;
    private long maNV;
    private long maKH;
    private int maP;
    private int maDv;
    private String ngayThue;
    private String ngayTra;
    private double tongTien;

    public HoaDon() {

    }
    ArrayList<Nguoi> dsng = DsNguoi.getDsNg();
    ArrayList<Phong> dsP = Phong.getDsP();
    ArrayList<DichVu> dsdv = DichVu.getDsdv();
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
    public float getGiaPhong(){
        for (Phong p:dsP) {
            if(p.getMaP()==this.maP)
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

    public HoaDon(long maHD, long maNV, long maKH, int maP, int maDv, String ngayThue, String ngayTra,double tongTien) {
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

    public int getMaP() {
        return maP;
    }

    public void setMaP(int maP) {
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
    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.println("Mã hóa đơn: ");
        this.maHD = Integer.parseInt(input.nextLine());
        System.out.println("Mã nhân viên: ");
        hienManv();
        this.maNV = Long.parseLong(input.nextLine());
        System.out.println("Mã khách hàng: ");
        hienMaKh();
        this.maKH = Long.parseLong(input.nextLine());
        System.out.println("Mã phòng: ");
        System.out.println("Dịch vụ: ");
        System.out.println("Ngày thuê: ");
        this.ngayThue = input.nextLine();
        System.out.println("Ngày trả: ");
        this.ngayTra = input.nextLine();
    }

}
