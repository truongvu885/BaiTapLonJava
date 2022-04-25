package src;

import java.util.ArrayList;
import java.util.Scanner;

public class DsNguoi {
    KiemTraType kt = new KiemTraType();
    ArrayList<Nguoi> dsNg = new ArrayList<>();
    int soluong ;

    public void nhap(String type){
        switch (type){
            case "NhanVien":
                while (true){
                    System.out.print("Nhập số lượng nhân viên muốn thêm: ");
                    String soluongS = new Scanner(System.in).nextLine();
                    if(kt.isInt(soluongS)){
                        this.soluong = Integer.parseInt(soluongS);
                        break;
                    }
                }
                for (int i = 0; i < soluong; i++) {
                    NhanVien nv = new NhanVien();
                    nv.nhap();
                    dsNg.add(nv);
                }
                break;
            case "KhachHang":
                while (true){
                    System.out.print("Nhập số lượng khách hàng muốn thêm: ");
                    String soluongS = new Scanner(System.in).nextLine();
                    if(kt.isInt(soluongS)){
                        this.soluong = Integer.parseInt(soluongS);
                        break;
                    }
                }
                for (int i = 0; i < soluong; i++) {
                    KhachHang kh = new KhachHang();
                    kh.nhap();
                    dsNg.add(kh);
                }
                break;
        }
    }
    public void hien(String type){
        switch (type){
            case "nguoi":
                for (Nguoi nguoi:dsNg) {
                    nguoi.hien();
                }
                break;
            case "NhanVien":
                for (Nguoi nguoi : dsNg) {
                    if(nguoi.getType().equalsIgnoreCase("NhanVien")){
                        NhanVien nv = (NhanVien) nguoi;
                        nv.hien();
                    }
                }
                break;
            case "KhachHang":
                for (Nguoi nguoi : dsNg) {
                    if(nguoi.getType().equalsIgnoreCase("KhachHang")){
                        KhachHang kh = (KhachHang) nguoi;
                        kh.hien();
                    }
                }
                break;
        }
    }
}
