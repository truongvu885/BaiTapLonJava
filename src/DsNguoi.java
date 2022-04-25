package src;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DsNguoi {
    KiemTraType kt = new KiemTraType();
    static ArrayList<Nguoi> dsNg = new ArrayList<>();
    int soluong ;

    public static ArrayList<Nguoi> getDsNg() {
        return dsNg;
    }

    public boolean kiemTraMa(long makt){
            for (Nguoi nguoi:dsNg) {
                if(nguoi.getMa()==makt){
                    return true;
            }
                else return false;
        }
            return false;
    }
    public void hienMa(){
        for (Nguoi nguoi:dsNg) {
            System.out.print("--("+nguoi.getMa()+")--\t");
        }
    }

    public void nhap(String type) {
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
                    System.out.print("Không thêm mã đã tồn tại: ");
                    hienMa();
                    System.out.print("\n");
                    NhanVien nv = new NhanVien();
                    nv.nhap();
                    if(!kiemTraMa(nv.getMa())){
                        dsNg.add(nv);
                    }
                    else {
                        System.err.println("Không thêm được-Mã nhân viên vừa nhập đã tồn tại");
                        break;
                    }
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
                    System.out.print("Không thêm mã đã tồn tại");
                    hienMa();
                    KhachHang kh = new KhachHang();
                    kh.nhap();
                    if(!kiemTraMa(kh.getMa())){
                        dsNg.add(kh);
                    }
                    else {
                        System.err.println("Không thêm được-Mã vừa nhập đã tồn tại");
                        break;
                    }
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
                NhanVien nv = new NhanVien();
                nv.hienLb();
                for (Nguoi nguoi : dsNg) {
                    if(nguoi.getType().equalsIgnoreCase("NhanVien")){
                        nv = (NhanVien) nguoi;
                        nv.hienDt();
                    }
                }
                break;
            case "KhachHang":
                KhachHang kh = new KhachHang();
                kh.hienLb();
                for (Nguoi nguoi : dsNg) {
                    if(nguoi.getType().equalsIgnoreCase("KhachHang")){
                        kh = (KhachHang) nguoi;
                        kh.hienDt();
                    }
                }
                break;
        }
    }
    public void timKiemMa(){
        System.out.println("Mã cần tìm: ");
        long ma = new Scanner(System.in).nextLong();
        for (Nguoi nguoi:dsNg) {
            if(nguoi.getMa()==ma){
                if(nguoi.getType().equalsIgnoreCase("NhanVien")){
                    NhanVien nv = (NhanVien) nguoi;
                    nv.hien();
                }
                else if(nguoi.getType().equalsIgnoreCase("KhachHang")) {
                    KhachHang kh = (KhachHang) nguoi;
                    kh.hien();
                }
            }
            else {
                System.out.println("Không có mã cần tìm");
            }
        }
    }
    public void timKiemTen(){
        System.out.println("Tên cần tìm ");
        String ten = new Scanner(System.in).nextLine();
        for (Nguoi nguoi:dsNg) {
            if(nguoi.getTen().contains(ten)){
                if(nguoi.getType().equalsIgnoreCase("NhanVien")){
                    NhanVien nv = (NhanVien) nguoi;
                    nv.hien();
                }
                else if(nguoi.getType().equalsIgnoreCase("KhachHang")) {
                    KhachHang kh = (KhachHang) nguoi;
                    kh.hien();
                }
            }
            else {
                System.out.println("Không có tên cần tìm");
            }
        }
    }
    public void timKiemChucVu() {
        System.out.println("Chức vụ cần tìm: ");
        String chucVu = new Scanner(System.in).nextLine();
        for (Nguoi nguoi:dsNg) {
            NhanVien nv = (NhanVien) nguoi;
            if(nv.getChucVu().equalsIgnoreCase(chucVu)){
                nv.hien();
            }
            else {
                System.out.println("Không có chức vụ cần tìm");
            }
        }
    }
    public void timKiemThanhVien(){
        KhachHang kh = new KhachHang();
        int tv;
        System.out.println("Bạn muốn tìm khách hàng nào ");
        kh.KieuThanhVien();
        while(true){
            String tvS = new Scanner(System.in).nextLine();
            if(kt.isInt(tvS)){
                tv = Integer.parseInt(tvS);
                break;
            }
        }
        for (Nguoi nguoi:dsNg) {
             kh = (KhachHang) nguoi;
             if(kh.getThanhVien()==tv){
                 kh.hien();
             }
        }
    }

    public void xoa(){
        long maXoa;
        while (true)
        {
            System.out.print("Mã cần xóa: ");
            String maS = new Scanner(System.in).nextLine();
            if(kt.isLong(maS)){
                maXoa = Long.parseLong(maS);
                break;
            }
        }
        for (Nguoi nguoi:dsNg) {
            if(nguoi.getMa()==maXoa){
                dsNg.remove(nguoi);
            }
        }
    }

    public void sua(String type){
        switch (type){
            case "NhanVien":
                long maSua;
                int chon ;
                while(true)
                {
                    System.out.print("Nhập mã của nhân viên cần sửa");
                    String maSuaS = new Scanner(System.in).nextLine();
                    if(kt.isLong(maSuaS)){
                        maSua = Long.parseLong(maSuaS);
                        break;
                    }
                }

                for (Nguoi nguoi:dsNg) {
                    if(nguoi.getMa()==maSua){
                        do {
                            System.out.println("0. Thoát");
                            System.out.println("1. Sửa số điện thoại");
                           // System.out.println("2. Sửa địa chỉ");
                            System.out.print("Bạn chọn: ");
                            chon = new Scanner(System.in).nextInt();
                            switch (chon){
                                case 1:
                                    System.out.print("Nhập SDT mới: ");
                                    Long sdtSua = new Scanner(System.in).nextLong();
                                    nguoi.setSDT(sdtSua);
                                    break;
//                                case 2:
//                                    System.out.println("Nhập địa chỉ mới: ");
//                                    String diachiSua = new Scanner(System.in).nextLine();
//                                    nguoi.setDiaChi(diachiSua);
//                                    break;
                            }
                        }while (chon!=0);
                    }
                }
                break;
            case "KhachHang":
                KhachHang kh = new KhachHang();
                while(true)
                {
                    System.out.print("Nhập mã khách hàng cần sửa");
                    String maSuaS = new Scanner(System.in).nextLine();
                    if(kt.isLong(maSuaS)){
                        maSua = Long.parseLong(maSuaS);
                        break;
                    }
                }

                for (Nguoi nguoi:dsNg) {
                    if(nguoi.getMa()==maSua){
                        kh = (KhachHang) nguoi;
                        do {
                            System.out.println("0. Thoát");
                            System.out.println("1. Sửa quyền thành viên");
                            System.out.print("Bạn chọn: ");
                            chon = new Scanner(System.in).nextInt();
                            switch (chon){
                                case 1:

                                    while(true)
                                    {
                                        System.out.println("Nhập quyền thành viên mới: ");
                                        kh.KieuThanhVien();
                                        String thVienS = new Scanner(System.in).nextLine();
                                        if(kt.isInt(thVienS))
                                        {
                                            kh.setThanhVien(Integer.parseInt(thVienS));
                                            break;
                                        }
                                    }
                                    break;
                            }
                        }while (chon!=0);
                    }
                }
        }
    }

    public void sapXepTen(){
        Collections.sort(dsNg,NguoiSort.TEN);
        System.out.println("\n\tDanh sách sau khi sắp xếp");
        Nguoi ng = new Nguoi();
        ng.hienLb();
        for (Nguoi nguoi:dsNg) {
            nguoi.hienDt();
        }
    }
    public void sapXepTuoi(){
        Collections.sort(dsNg,NguoiSort.TUOI);
        System.out.println("\n\tDanh sách sau khi sắp xếp");
        Nguoi ng = new Nguoi();
        ng.hienLb();
        for (Nguoi nguoi:dsNg) {
            nguoi.hienDt();
        }
    }

    public void sapXepLuong(){
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        for (Nguoi nguoi:dsNg) {
            if(nguoi.getType().equalsIgnoreCase("NhanVien")){
                NhanVien nv = (NhanVien) nguoi;
                dsnv.add(nv);
            }
        }
        Collections.sort(dsnv, (o1, o2) -> Double.compare(o1.getLuong(), o2.getLuong()));
        hien("NhanVien");
    }

    void docFile(String type1,String type2){
        try {
            FileInputStream fis = new FileInputStream("D:/dsNguoi.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dsNg = (ArrayList<Nguoi>) ois.readObject();
            for (Nguoi nguoi: dsNg) {
                if(nguoi.getType().equalsIgnoreCase(type1)){
                    NhanVien nv = (NhanVien) nguoi;
                    nv.hien();
                }
                else if(nguoi.getType().equalsIgnoreCase(type2)){
                    KhachHang kh = (KhachHang) nguoi;
                    kh.hien();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    void ghiFile(){
        try {
            FileOutputStream fos = new FileOutputStream("D:/dsNguoi.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsNg);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class NguoiSort{
    public static final Comparator<Nguoi> TEN = (Nguoi o1, Nguoi o2) -> o1.getTen().compareTo(o2.getTen());
    public static final Comparator<NhanVien> LUONG = (NhanVien o1, NhanVien o2) -> Double.compare(o1.getLuong(),o2.getLuong());
    public static final Comparator<Nguoi> TUOI = (Nguoi o1, Nguoi o2) -> {
        try {
            return Integer.compare(o1.tinhTuoi(),o2.tinhTuoi());
        } catch (ParseException e) {
           return 0;
        }
    };
}

