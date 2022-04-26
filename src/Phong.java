package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Phong {
    private int maP;
    private int loaiP;
    private float giaP;
    private boolean trangThai;

    KiemTraType kt = new KiemTraType();
     static ArrayList<Phong> dsP = new ArrayList<>();

    public static ArrayList<Phong> getDsP() {
        return dsP;
    }

    public Phong() {
    }

    public Phong(int maP, int loaiP, float giaP, boolean trangThai) {
        this.maP = maP;
        this.loaiP = loaiP;
        this.giaP = giaP;
        this.trangThai = trangThai;
    }

    public int getMaP() {
        return maP;
    }

    public void setMaP(int maP) {
        this.maP = maP;
    }

    public int getLoaiP() {
        return loaiP;
    }

    public void setLoaiP(int loaiP) {
        this.loaiP = loaiP;
    }

    public float getGiaP() {
        return giaP;
    }

    public void setGiaP(float giaP) {
        this.giaP = giaP;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void phong(){
        System.out.println("Bảng thông tin phòng");
        System.out.println("1. Thường - 1000 ");
        System.out.println("2. VIP1 - 1500");
        System.out.println("3. VIP2 - 2000");
        System.out.println("4. VIP3 - 2500");
    }
    public String hienPhong(int loaiP){
        switch (loaiP){
            case 1:
                setGiaP(1000);
                return "Thường";

            case 2:
                setGiaP(1500);
                return "VIP1";

            case 3:
                setGiaP(2000);
                return "VIP2";

            case 4:
                setGiaP(2500);
                return "VIP3";

        }
        return null;
    }

    public void nhap(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("Mã phòng: ");
            String maPS = input.nextLine();
            if(kt.isInt(maPS)){
                this.maP = Integer.parseInt(maPS);
                break;
            }
        }
        System.out.print("Chọn loại phòng: ");
        phong();
        this.loaiP = Integer.parseInt(input.nextLine());
        System.out.println("Bạn đã chọn loại phòng "+hienPhong(this.loaiP));
        while (true){
            System.out.print("Trạng thái: ");
            String trangtS = input.nextLine();
            if(kt.isBoolean(trangtS)){
                this.trangThai = Boolean.parseBoolean(trangtS);
                break;
            }
        }
    }

}
