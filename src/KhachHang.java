package src;

import java.util.Scanner;

public class KhachHang extends Nguoi {
    private long cccd;
    private int thanhVien;
    private String ngayThueGan;

    public KhachHang() {

    }

    public KhachHang(long ma, String ten, String diaChi, String ngaySinh, long SDT, String gioiTinh, long cccd, int thanhVien, String ngayThueGan) {
        super(ma, ten, diaChi, ngaySinh, SDT, gioiTinh);
        this.cccd = cccd;
        this.thanhVien = thanhVien;
        this.ngayThueGan = ngayThueGan;
    }

    public long getCccd() {
        return cccd;
    }

    public void setCccd(long cccd) {
        this.cccd = cccd;
    }

    public int getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(int thanhVien) {
        this.thanhVien = thanhVien;
    }

    public String getNgayThueGan() {
        return ngayThueGan;
    }

    public void setNgayThueGan(String ngayThueGan) {
        this.ngayThueGan = ngayThueGan;
    }

    public void KieuThanhVien(){
        System.out.print("\t\t");
        System.out.println("0. Thường");
        System.out.println("1. Thân thiết");
        System.out.println("2. VIP");
    }
    private String hienKieuThanhVien(int kieu){
        String kieuStr = null;
        switch (kieu){
            case 0:
                kieuStr = "Thường";
                break;
            case 1:
                kieuStr = "Thân thiết";
                break;
            case 2:
                kieuStr = "VIP";
                break;
        }
        return kieuStr;
    }
    @Override
    public void nhap() {
        super.nhap();
        Scanner input = new Scanner(System.in);
        KiemTraType kt = new KiemTraType();
        while(true)
        {
            System.out.print("Căn cước công dân: ");
            String cccdS = input.nextLine();
            if(kt.isLong(cccdS)){
                this.cccd = Long.parseLong(cccdS);
                break;
            }
        }
        while(true)
        {
            System.out.println("Thành viên: ");
            KieuThanhVien();
            String thVienS = input.nextLine();
            if(kt.isInt(thVienS))
            {
                this.thanhVien = Integer.parseInt(thVienS);
                break;
            }
        }

        System.out.println("Ngày thuê gần nhất: ");
        this.ngayThueGan = input.nextLine();
        super.setType("KhachHang");
    }
    public void hienLb(){
        System.out.printf("%5s|%20s|%15s|%10s|%20s|%12s|%15s|%10s|%15s|","Mã","Họ và tên","Ngày sinh","Giới tính","Địa chỉ","Số ĐT","CCCD","Thành viên","Ngày thuê gần");
        System.out.print("\n");
    }
    public void hienDt(){
        super.hienDt();
        System.out.printf("%15d|",this.cccd);
        System.out.printf("%10s|",hienKieuThanhVien(this.thanhVien));
        System.out.printf("%15s|",this.ngayThueGan);
        System.out.print("\n");
    }
    public void hien(){
        hienLb();
        hienDt();
    }

    public void hienMaKh() {
        System.out.println("----------");
        System.out.print("--("+getMa()+")--\n");
        System.out.println("----------");
    }
}
