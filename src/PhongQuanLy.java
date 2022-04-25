package src;

import java.util.ArrayList;
import java.util.Scanner;

public class PhongQuanLy {
    private int maPB;
    private String tenPB;
    private int soLuong;

    ArrayList<PhongQuanLy> dsPQl = new ArrayList<>();
    KiemTraType kt = new KiemTraType();

    public PhongQuanLy() {
    }

    public PhongQuanLy(int maPB, String tenPB, int soLuong) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.soLuong = soLuong;
    }

    public int getMaPB() {
        return maPB;
    }

    public void setMaPB(int maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void nhap(){
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.print("Mã PB: ");
            String maPBS = input.nextLine();
            if(kt.isInt(maPBS))
            {
                this.maPB = Integer.parseInt(maPBS);
                break;
            }
        }
        System.out.print("Tên PB: ");
        this.tenPB = input.nextLine();
        while(true){
            System.out.print("Số lượng tv: ");
            String slS = input.nextLine();
            if(kt.isInt(slS)){
                this.soLuong = Integer.parseInt(slS);
                break;
            }
        }
    }
    public void nhapDS(){
        int solp;
        while (true){
            System.out.println("Nhập số lượng phòng quản lý: ");
            String slpS = new Scanner(System.in).nextLine();

            if(kt.isInt(slpS)){
                solp = Integer.parseInt(slpS);
                break;
            }
        }
        for (int i = 0; i < solp; i++) {
            System.out.println("Thông tin phòng thứ "+(i+1));
            PhongQuanLy pql = new PhongQuanLy();
            pql.nhap();
            dsPQl.add(pql);
        }
    }
    public void hienDsMap(){
        for (PhongQuanLy p:dsPQl) {
            System.out.println(p.maPB+"\n");
        }
    }
}
