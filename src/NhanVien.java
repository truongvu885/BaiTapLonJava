package src;

import java.util.Scanner;

public class NhanVien extends Nguoi{
    private String ngayVaoLam;
    private final float luongCB =1150;
    private float phuCap;
    private float hsl;
    private String chucVu;
    private int maPB;

    public NhanVien() {

    }

    public NhanVien(long ma, String ten, String diaChi, String ngaySinh, long SDT, String gioiTinh, String ngayVaoLam, float phuCap, float hsl, String chucVu, int maPB) {
        super(ma, ten, diaChi, ngaySinh, SDT, gioiTinh);
        this.ngayVaoLam = ngayVaoLam;
        this.phuCap = phuCap;
        this.hsl = hsl;
        this.chucVu = chucVu;
        this.maPB = maPB;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public float getLuongCB() {
        return luongCB;
    }

    public float getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(float phuCap) {
        this.phuCap = phuCap;
    }

    public float getHsl() {
        return hsl;
    }

    public void setHsl(float hsl) {
        this.hsl = hsl;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getMaPB() {
        return maPB;
    }

    public void setMaPB(int maPB) {
        this.maPB = maPB;
    }

    public boolean isFloat(String s){
        try {
            Float.parseFloat(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public void nhap(){
        super.nhap();
        Scanner input = new Scanner(System.in);
        System.out.print("Ngày vào làm: ");
        this.ngayVaoLam = input.nextLine();
        System.out.print("Chức vụ: ");
        this.chucVu = input.nextLine();
        System.out.print("Phòng ban: ");
        this.maPB = Integer.parseInt(input.nextLine());
        while (true){
            System.out.print("Hệ số lương: ");
            String hslS = input.nextLine();
            if(isLong(hslS)){
                this.hsl = Float.parseFloat(hslS);
                break;
            }
        }
        while (true){
            System.out.print("Phụ cấp: ");
            String pcS = input.nextLine();
            if(isLong(pcS)){
                this.hsl = Float.parseFloat(pcS);
                break;
            }
        }
    }
    @Override
    public void hienLb(){
        System.out.printf("%5s|%30s|%15s|%10s|%50s|%12s|%15s|%8s|%10s|%8s|%8s|","Mã","Họ và tên","Ngày sinh","Giới tính","Địa chỉ","Số ĐT",
                "Ngày vào làm","Hệ số lương","Chức vụ","Phòng ban","Phụ cấp");
        System.out.print("\n");
    }
    @Override
    public void hienDt(){
        super.hienDt();
        System.out.printf("%15s|",this.ngayVaoLam);
        System.out.printf("%8f|",this.hsl);
        System.out.printf("%10s|",this.chucVu);
        System.out.printf("%8d|",this.maPB);
        System.out.printf("%8f|",this.phuCap);
    }
    @Override
    public void hien(){
        this.hienLb();
        this.hienDt();
    }
}
