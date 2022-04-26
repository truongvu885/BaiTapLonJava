package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PhongQuanLy {
    private int maPB;
    private String tenPB;
    private int soLuong;

    static ArrayList<PhongQuanLy> dsPQl = new ArrayList<>();
    KiemTraType kt = new KiemTraType();

    public static ArrayList<PhongQuanLy> getDsPQl() {
        return dsPQl;
    }

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
    public void hienLb(){
        System.out.printf("%5s|%15s|%5s|","MãPB","Tên PB","SL");
        System.out.print("\n");
    }
    public void hienDt(){
        System.out.printf("%5d|",getMaPB());
        System.out.printf("%15s|",getTenPB());
        System.out.printf("%5d|",getSoLuong());
        System.out.print("\n");
    }
    public void hien(){
        hienLb();
        for (PhongQuanLy ql : dsPQl) {
            ql.hienDt();
        }
    }
    public void hienMa(){
        System.out.print("--Mã PB:("+getMaPB()+")--");
    }

    public void ghiFile(){
        try {
            FileOutputStream fos = new FileOutputStream("D:/dsPQL.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsPQl);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void docFile(){
        try {
            FileInputStream fis = new FileInputStream("D:/dsPQL.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dsPQl = (ArrayList<PhongQuanLy>) ois.readObject();
            hienLb();
            for (PhongQuanLy ql: dsPQl) {
                ql.hienDt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
