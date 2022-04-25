package src;

import java.util.Date;
import java.util.Scanner;

public class Nguoi {
    private long ma;
    private String ten;
    private String diaChi;
    private String ngaySinh;
    private long sdt;
    private String gioiTinh;

    public Nguoi() {
    }

    public Nguoi(long ma, String ten, String diaChi, String ngaySinh, long SDT, String gioiTinh) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.sdt = SDT;
        this.gioiTinh = gioiTinh;
    }

    public long getMa() {
        return ma;
    }

    public void setMa(long ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public long getSDT() {
        return sdt;
    }

    public void setSDT(long SDT) {
        this.sdt = SDT;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public  boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public void nhap(){
        Scanner input = new Scanner(System.in);
        while (true)
        {
            System.out.print("Mã: ");
            String maS = input.nextLine();
            if(isLong(maS)){
                this.ma = Long.parseLong(maS);
                break;
            }
        }
        System.out.print("Tên: ");
        this.ten = input.nextLine();
        System.out.print("Ngày sinh(dd/mm/yyy): ");
        this.ngaySinh = input.nextLine();
        while(true)
        {
            System.out.print("Giới tính: ");
            this.gioiTinh = input.nextLine();
            if(this.gioiTinh.equalsIgnoreCase("Nam") || this.gioiTinh.equalsIgnoreCase("Nữ")){
                break;
            }
        }
        System.out.print("Địa chỉ: ");
        this.diaChi = input.nextLine();
        while (true)
        {
            System.out.print("Số điện thoại: ");
            String sdtS = input.nextLine();
            if(isLong(sdtS)){
                this.sdt = Long.parseLong(sdtS);
                break;
            }
        }
    }
    protected void hienLb(){
        System.out.printf("%5s|%30s|%15s|%10s|%50s|%12s|","Mã","Họ và tên","Ngày sinh","Giới tính","Địa chỉ","Số ĐT");
        System.out.print("\n");
    }
    protected void hienDt(){
        System.out.printf("%5d|",this.ma);
        System.out.printf("%30s|",this.ten);
        System.out.printf("%15s|",this.ngaySinh);
        System.out.printf("%10s|",this.gioiTinh);
        System.out.printf("%50s|",this.diaChi);
        System.out.printf("%12s|",this.sdt);
    }
    public void hien(){
        hienLb();
        hienDt();
    }
}
