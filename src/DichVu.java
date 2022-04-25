package src;

import java.util.Scanner;

public class DichVu {
    private int maLoaiDV;
    private String tenDV;
    private float giaDV;

    public void setMaLoaiDV(int maLoaiDV) {
        this.maLoaiDV = maLoaiDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public void setGiaDV(float giaDV) {
        this.giaDV = giaDV;
    }

    public int getMaLoaiDV() {
        return maLoaiDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public float getGiaDV() {
        return giaDV;
    }
    public void setDichvu(){
        switch (this.maLoaiDV){
            case 1:
                setGiaDV(4000);
                setTenDV("Combo 5 ngày");
                break;
            case 2:
                setGiaDV(5000);
                setTenDV("Combo 7 ngày");
                break;
            case 3:
                setGiaDV(9000);
                setTenDV("Combo 15 ngày");
                break;
            case 4:
                setGiaDV(15000);
                setTenDV("Combo VIP");
                break;
        }
    }
    public void hienDichVu(){
        System.out.println("\tBảng dịch vụ");
        System.out.println("1. Combo5 - 4000");
        System.out.println("2. Combo7 - 5000");
        System.out.println("3. Combo15 - 9000");
        System.out.println("4. VIP - 15000");
    }

    public void nhap(){
        Scanner input = new Scanner(System.in);
        hienDichVu();
        System.out.print("Chọn dịch vụ: ");
        this.maLoaiDV = Integer.parseInt(input.nextLine());
        setDichvu();
    }
    public void hienLb(){
        System.out.printf("%5s|%15s|%10s","Mã dv","Tên dv","Giá"+"\n");
    }
    public void hienDt(){
        System.out.printf("%5d",this.maLoaiDV);
        System.out.printf("%15s",this.tenDV);
        System.out.printf("%10.2f",this.giaDV);
    }
}
