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
                 int chonpql;
                 do {
                     menuPhongQuanLy();
                     PhongQuanLy pql = new PhongQuanLy();
                     while (true){
                         System.out.print("Bạn chọn: ");
                         String chonPqlS = new Scanner(System.in).nextLine();
                         if(kt.isInt(chonPqlS)){
                             chonpql = Integer.parseInt(chonPqlS);
                             break;
                         }
                     }
                     switch (chonpql){
                         case 1:
                             pql.nhapDS();
                             break;
                         case 2:
                             pql.hienDS();
                             break;
                         case 3:
                             pql.ghiFile();
                             break;
                         case 4:
                             pql.docFile();
                             break;
                     }
                 }while (chonpql!=0);
                 break;
             case 2:
                 int chonp;
                 do {
                     menuPhong();
                     Phong p = new Phong();
                     while (true){
                         System.out.print("Bạn chọn: ");
                         String chonPhS = new Scanner(System.in).nextLine();
                         if(kt.isInt(chonPhS)){
                             chonp = Integer.parseInt(chonPhS);
                             break;
                         }
                     }
                     switch (chonp){
                         case 1:
                             p.nhapDSphong();
                             break;
                         case 2:
                             p.hienDSphong();
                             break;
                         case 3:
                             p.ghiFile();
                             break;
                         case 4:
                             p.docFile();
                             break;
                         case 5:
                             p.suaP();
                             break;
                         case 6:
                             p.xoaP();
                             break;
                         case 7:
                             p.timkiemP();
                             break;
                         case 8:
                             p.sapxepP();
                             break;
                     }
                 }while (chonp!=0);
                 break;
             case 3:
                 DichVu dv = new DichVu();
                    dv.nhapDsDv();
                    dv.hien();
                 break;
             case 4:
                 HoaDon hd = new HoaDon();
                 hd.nhap();
                 break;
             case 5:
                 int chonnv;
                 do {
                     menuNhanvien();
                     while (true){
                         System.out.print("Bạn chọn: ");
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
                         case 2:
                             ds.sua("NhanVien");
                             break;
                         case 3:
                             ds.xoa();
                             break;
                         case 4:
                             ds.hien("NhanVien");
                             break;
                         case 5:
                             ds.timKiemMa();
                             break;
                         case 6:
                             ds.sapXepLuong();
                             break;
                         case 7:
                             ds.ghiFile();
                             break;
                         case 8:
                             ds.docFile("NhanVien",null);
                             break;
                     }
                 }while (chonnv!=0);
                 break;
             case 6:
                 int chonkh;
                 do {
                     menuKhachHang();
                     while (true){
                         System.out.print("Bạn chọn: ");
                         String chonkhS = new Scanner(System.in).nextLine();
                         if(kt.isInt(chonkhS)){
                             chonkh = Integer.parseInt(chonkhS);
                             break;
                         }
                     }
                     switch (chonkh){
                         case 1:
                             ds.nhap("KhachHang");
                             break;
                         case 2:
                             ds.sua("KhachHang");
                             break;
                         case 3:
                             ds.xoa();
                             break;
                         case 4:
                             ds.hien("KhachHang");
                             break;
                         case 5:
                             ds.timKiemMa();
                             break;
                         case 6:
                             ds.sapXepTen();
                             break;
                         case 7:
                             ds.ghiFile();
                             break;
                         case 8:
                             ds.docFile(null,"KhachHang");
                             break;
                     }
                 }while (chonkh!=0);
                 break;
         }
     }while (chon!=0);
    }
    public static void menuChinh(){

        System.out.println("\n\t-----QUẢN LÝ KHÁCH SẠN------");
        System.out.println("1. Phòng quản lý");
        System.out.println("2. Phòng");
        System.out.println("3. Dịch vụ");
        System.out.println("4. Hóa đơn");
        System.out.println("5. Nhân viên");
        System.out.println("6. Khách hàng");
    }
    private static void menuKhachHang() {
        System.out.println("\n\t-----KHÁCH HÀNG------");
        System.out.println("1. Thêm khách hàng");
        System.out.println("2. Sửa thông tin khách hàng");
        System.out.println("3. Xóa khách hàng");
        System.out.println("4. Xem thông tin khách hàng");
        System.out.println("5. Tìm kiếm thông tin khách hàng");
        System.out.println("6. Sắp xếp theo tên");
        System.out.println("7. Ghi file");
        System.out.println("8. Đọc file");
    }

    public static void menuNhanvien()  {
        System.out.println("\n\t-----NHÂN VIÊN------");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Sửa thông tin nhân viên");
        System.out.println("3. Xóa nhân viên");
        System.out.println("4. Xem thông tin nhân viên");
        System.out.println("5. Tìm kiếm thông tin nhân viên");
        System.out.println("6. Sắp xếp theo lương");
        System.out.println("7. Ghi file");
        System.out.println("8. Đọc file");
    }
    public static void menuDichvu(){
        System.out.println("-----Dịch vụ------");
        System.out.println("1. Nhập ");
        System.out.println("2. Xem");
        System.out.println("3. Ghi file");
        System.out.println("4. Đọc file");
    }
    public static void menuPhong(){
        System.out.println("-----Phòng-----");
        System.out.println("1. Nhập ds phòng ");
        System.out.println("2. Hiện ds phòng");
        System.out.println("3. Ghi file");
        System.out.println("4. Đọc file");
        System.out.println("5. Sửa phòng ");
        System.out.println("6. Xóa phòng ");
        System.out.println("7. Tìm phòng ");
        System.out.println("8. Sắp xếp phòng ");
    }
    public static void menuPhongQuanLy(){
        System.out.println("-----Phòng-----");
        System.out.println("1. Nhập ");
        System.out.println("2. Hiện ");
        System.out.println("3. Ghi file");
        System.out.println("4. Đọc file");
    }
}
