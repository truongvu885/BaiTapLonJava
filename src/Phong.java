package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Phong implements Serializable {
    private String maP;
    private String loaiP;
    private float giaP;
    private String trangThai;
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

    public void nhap() {
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

    public void hienLb() {
        System.out.println("\n\t------Danh sách phòng-----");
        System.out.printf("%5s|%15s|%15s|%10s|", "Mã", "Loại phòng", "Giá phòng", "Trạng thái");
        System.out.print("\n");
    }

    public void hienDt() {
        System.out.printf("%5s|", this.maP);
        System.out.printf("%15s|", this.loaiP);
        System.out.printf("%15.2f|", this.giaP);
        System.out.printf("%10s|", this.trangThai);
        System.out.print("\n");
    }

    public void nhapDSphong() {
        int sl;
        while (true) {
            System.out.printf("\nSố lượng phòng muốn nhập: ");
            sl = new Scanner(System.in).nextInt();
            if (sl == 0) {
                break;
            }
            for (int i = 0; i < sl; i++) {
                Phong p = new Phong();
                p.nhap();
                dsP.add(p);
            }
        }
    }

    public void hienDSphong() {
        hienLb();
        for (Phong phong : dsP)
            phong.hienDt();
    }

    public void hienMaP() {
        System.out.print("(" + getMaP() + ")\t");
    }

    public void ghiFile() {
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

    public void docFile() {
        try {
            FileInputStream fis = new FileInputStream("D:/dsPhong.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dsP = (ArrayList<Phong>) ois.readObject();
            hienLb();
            for (Phong p : dsP) {
                p.hienDt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void suaP() {
        System.out.print("Mã phòng cần sửa: ");
        String ma = new Scanner(System.in).nextLine();
        for (Phong p:dsP) {
            if(p.getMaP().equalsIgnoreCase(ma)){
                System.out.println("Loại phòng mới: ");
                String lp = new Scanner(System.in).nextLine();
                p.setLoaiP(lp);
                /*int chonSua ;
                do {
                    menuSuaP();
                    System.out.print("Chọn: ");
                    chonSua = new Scanner(System.in).nextInt();
                    switch (chonSua){
                        case 1:
                            System.out.println("Loại phòng mới: ");
                            String lp = new Scanner(System.in).nextLine();
                            p.setLoaiP(lp);
                            break;
                        case 2:
                            System.out.println("Giá phòng mới: ");
                            float gp = new Scanner(System.in).nextFloat();
                            p.setGiaP(gp);
                            break;
                        case 3:
                            System.out.println("Trạng thái mới: ");
                            String tt = new Scanner(System.in).nextLine();
                            p.setTrangThai(tt);
                            break;
                    }
                }while (chonSua!=0);*/
            }
        }
    }

    /*public void menuSuaP(){
        System.out.println("\t---Sửa tt phòng---");
        System.out.println("0. Thoát");
        System.out.println("1. Sửa loại phòng");
        System.out.println("2. Sửa giá phòng");
        System.out.println("3. Sửa trạng thái");
    }*/

    public void xoaP() {
        System.out.print("Mã phòng cần xóa: ");
        String ma = new Scanner(System.in).nextLine();
        for (Phong p:dsP) {
            if(p.getMaP().equalsIgnoreCase(ma)){
                dsP.remove(p);
                System.out.println("Xóa thành công");
                p.hienDSphong();
            }
        }
    }

    public void timkiemP() {
        System.out.println("Mã cần tìm: ");
        String ma = new Scanner(System.in).nextLine();
        for (Phong p:dsP) {
            if(p.getMaP().equalsIgnoreCase(ma)){
                p.hienDSphong();
            }
        }
    }

    public void sapxepP() {
        Collections.sort(dsP, new Comparator<Phong>() {
            @Override
            public int compare(Phong o1, Phong o2) {
                return Float.compare(o1.getGiaP(),o2.getGiaP());
            }
        });
        System.out.println("Danh sách sau khi sắp xếp");
        hienDSphong();
    }
}
