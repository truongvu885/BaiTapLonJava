package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DichVu implements Serializable {
    private int maLoaiDV;
    private String tenDV;
    private float giaDV;

    static ArrayList<DichVu> dsdv = new ArrayList<>();

    public static ArrayList<DichVu> getDsdv() {
        return dsdv;
    }

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

    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Mã dịch vụ: ");
        this.maLoaiDV = Integer.parseInt(input.nextLine());
        System.out.print("Tên dịch vụ: ");
        this.tenDV = input.nextLine();
        System.out.print("Giá dịch vụ: ");
        this.giaDV = Float.parseFloat(input.nextLine());
    }

    public void hienLb() {
        System.out.printf("%5s|%15s|%10s|", "Mã dv", "Tên dv", "Giá");
        System.out.println();
    }

    public void hienDt() {
        System.out.printf("%5d|", this.maLoaiDV);
        System.out.printf("%15s|", this.tenDV);
        System.out.printf("%10.2f|", this.giaDV);
        System.out.print("\n");
    }

    public void nhapDsDv() {
        System.out.print("Nhập số lượng dịch vụ muốn thêm: ");
        int soluong = new Scanner(System.in).nextInt();
        for (int i = 0; i < soluong; i++) {
            System.out.println("----------------");
            DichVu dv = new DichVu();
            dv.nhap();
            dsdv.add(dv);
        }
    }

    public void hienDsDv() {
        hienLb();
        for (DichVu dichVu : dsdv) {
            dichVu.hienDt();
        }
    }

    public void hienMaDv() {
        System.out.print("(" + getMaLoaiDV() + ")\t");
    }

    public void ghiFile() {
        try {
            FileOutputStream fos = new FileOutputStream("D:/dsDvu.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsdv);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void docFile() {
        try {
            FileInputStream fis = new FileInputStream("D:/dsDvu.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dsdv = (ArrayList<DichVu>) ois.readObject();
            for (DichVu dv : dsdv) {
                dv.hienDsDv();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
