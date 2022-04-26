package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Phong implements Serializable{
    private String maP;
    private String loaiP;
    private float giaP;
    private String trangThai;
    KiemTraType kt = new KiemTraType();
    static ArrayList<Phong> dsP = new ArrayList<>();

    public static ArrayList<Phong> getDsP() {
        return dsP;
    }
    public String getMaP() {
        return maP;
    }

    public void setMaP(String maP) {
        this.maP = maP;
    }

    public String getLoaiP() {
        return loaiP;
    }

    public void setLoaiP(String loaiP) {
        this.loaiP = loaiP;
    }

    public float getGiaP() {
        return giaP;
    }

    public void setGiaP(float giaP) {
        this.giaP = giaP;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Phong() {
    }

    public Phong(String maP, String loaiP, float giaP, String trangThai) {
        this.maP = maP;
        this.loaiP = loaiP;
        this.giaP = giaP;
        this.trangThai = trangThai;
    }

    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("Mã phòng: ");
        this.maP = input.nextLine();
        System.out.print("Loại phòng: ");
        this.loaiP = input.nextLine();
        System.out.print("Giá phòng: ");
        this.giaP = input.nextFloat();
        input.nextLine();
        System.out.print("Trạng thái: ");
        this.trangThai = input.nextLine();

    }

    public void hienLb(){
        System.out.printf("%5s|%15s|%15s|%10s|","Mã","Loại phòng","Giá phòng","Trạng thái");
        System.out.print("\n");
    }
    public void hienDt(){
        System.out.printf("%5s|",this.maP);
        System.out.printf("%15s|",this.loaiP);
        System.out.printf("%15.2f|",this.giaP);
        System.out.printf("%10s|",this.trangThai);
        System.out.print("\n");
    }
    public void nhapDSphong(){
        int sl;
        while(true){
            System.out.printf("\nSố lượng phòng muốn nhập: ");
            sl= new Scanner(System.in).nextInt();
            for (int i = 0; i < sl; i++) {
                Phong p = new Phong();
                p.nhap();
                dsP.add(p);
            }
        }
    }
    public void hienDSphong(){
        hienLb();
        for(Phong phong: dsP)
            phong.hienDt();
    }
    public void hienMaP(){
        System.out.println("----------");
        System.out.print("--("+getMaP()+")--\n");
        System.out.println("----------");
    }
    public void ghiFile(){
        try {
            FileOutputStream fos = new FileOutputStream("D:/dsPhong.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsP);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void docFile(){
        try {
            FileInputStream fis = new FileInputStream("D:/dsPhong.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dsP = (ArrayList<Phong>) ois.readObject();
            hienLb();
            for (Phong p: dsP) {
                p.hienDt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void suaP(){

    }
    public void xoaP(){

    }
    public void timkiemP(){

    }
    public void sapxepP(){

    }
}
