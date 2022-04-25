package src;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int chon;
        KiemTraType kt = new KiemTraType();
        DsNguoi ds = new DsNguoi();
     do {
         menuChinh();
         while(true){
             System.out.print("Bạn chọn: ");
             String chonS = new Scanner(System.in).nextLine();
             if(kt.isInt(chonS)){
                 chon = Integer.parseInt(chonS);
                 break;
             }
         }
         switch (chon){
             case 1:
                 int chonnv;
                 do {
                     menuNhanvien();
                     while (true){
                         System.out.println("Bạn chọn: ");
                         String chonnvS = new Scanner(System.in).nextLine();
                         if(kt.isInt(chonnvS)){
                             chonnv = Integer.parseInt(chonnvS);
                             break;
                         }
                     }
                     switch (chonnv){
                         case 1:
                             ds.nhap("NhanVien");
                             break;
                     }
                 }while (chonnv!=0);
                 break;
             case 2:
                 int chonkh;
                 do {
                     menuKhachHang();
                     while (true){
                         System.out.println("Bạn chọn: ");
                         String chonnvS = new Scanner(System.in).nextLine();
                         if(kt.isInt(chonnvS)){
                             chonnv = Integer.parseInt(chonnvS);
                             break;
                         }
                     }
                     switch (chonnv){
                         case 1:
                             ds.nhap("KhachHang");
                             break;
                     }
                 }while (chonnv!=0);
                 break;


         }
     }while (chon!=0);
    }

    private static void menuKhachHang() {
        System.out.println("\n\t-----QUẢN LÝ KHÁCH HÀNG------");
        System.out.println("1. Thêm khách hàng");
        System.out.println("2. Sửa thông tin khách hàng");
        System.out.println("3. Xóa khách hàng");
    }

    public static void menuChinh(){

        System.out.println("\n\t-----QUẢN LÝ KHÁCH SẠN------");
        System.out.println("1. Nhân viên");
        System.out.println("2. Khách hàng");
        System.out.println("3. Phòng quản lý");
        System.out.println("4. Phòng");
        System.out.println("5. Dịch vụ");
        System.out.println("6. Hóa đơn");
    }
    public static void menuNhanvien()  {
        System.out.println("\n\t-----QUẢN LÝ NHÂN VIÊN------");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Sửa thông tin nhân viên");
        System.out.println("3. Xóa nhân viên");
    }

}
