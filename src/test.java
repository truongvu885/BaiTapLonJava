package src;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        KiemTraType kt = new KiemTraType();
        int chon;
        DsNguoi ds = new DsNguoi();
        PhongQuanLy pql = new PhongQuanLy();
        Phong p = new Phong();
        DichVu dv = new DichVu();
        HoaDon hd = new HoaDon();

        do {
            menuChinh();
            while (true) {
                System.out.print("Bạn chọn: ");
                String chonS = new Scanner(System.in).nextLine();
                if (kt.isInt(chonS)) {
                    chon = Integer.parseInt(chonS);
                    break;
                }
            }
            switch (chon) {
                case 1:
                    int chonpql;
                    do {
                        menuPhongQuanLy();
                        while (true) {
                            System.out.print("Chọn: ");
                            String chonPqlS = new Scanner(System.in).nextLine();
                            if (kt.isInt(chonPqlS)) {
                                chonpql = Integer.parseInt(chonPqlS);
                                break;
                            }
                        }
                        switch (chonpql) {
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
                    } while (chonpql != 0);
                    break;
                case 2:
                    int chonp;
                    do {
                        menuPhong();
                        while (true) {
                            System.out.print("Chọn: ");
                            String chonPhS = new Scanner(System.in).nextLine();
                            if (kt.isInt(chonPhS)) {
                                chonp = Integer.parseInt(chonPhS);
                                break;
                            }
                        }
                        switch (chonp) {
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
                    } while (chonp != 0);
                    break;
                case 3:
                    int chonDv;
                    do {
                        menuDichvu();
                        System.out.print("Chọn: ");
                        chonDv = new Scanner(System.in).nextInt();
                        switch (chonDv) {
                            case 1 -> dv.nhapDsDv();
                            case 2 -> dv.hienDsDv();
                            case 3 -> dv.ghiFile();
                            case 4 -> dv.docFile();
                        }
                    } while (chonDv != 0);
                    break;
                case 4:
                    if (KiemTra()) {
                        int chonHd;
                        do {
                            menuHoaDon();
                            System.out.print("Chọn: ");
                            chonHd = new Scanner(System.in).nextInt();
                            switch (chonHd) {
                                case 1:
                                    hd.nhapDsHoaDon();
                                    break;
                                case 2:
                                    hd.hienDsHD();
                                    break;
                            }
                        } while (chonHd != 0);
                        break;
                    } else
                        System.out.println("Bạn cần nhập Phòng quản lý, Phòng, Dịch vụ, Nhân viên, Khách hàng trước");
                    break;
                case 5:
                    if (KiemTra()) {
                        int chonnv;
                        do {
                            menuNhanvien();
                            while (true) {
                                System.out.print("Chọn: ");
                                String chonnvS = new Scanner(System.in).nextLine();
                                if (kt.isInt(chonnvS)) {
                                    chonnv = Integer.parseInt(chonnvS);
                                    break;
                                }
                            }
                            switch (chonnv) {
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
                                    //ds.sapXepLuong();
                                    ds.sapXepTuoi("NhanVien");
                                    break;
                                case 7:
                                    ds.ghiFile();
                                    break;
                                case 8:
                                    NhanVien nv = new NhanVien();
                                    nv.hienLb();
                                    ds.docFile("NhanVien", null);
                                    break;
                            }
                        } while (chonnv != 0);
                        break;
                    } else System.out.println("Bạn cần nhập Phòng quản lý, Phòng, Dịch vụ trước");
                    break;
                case 6:
                    if (KiemTra()) {
                        int chonkh;
                        do {
                            menuKhachHang();
                            while (true) {
                                System.out.print("Chọn: ");
                                String chonkhS = new Scanner(System.in).nextLine();
                                if (kt.isInt(chonkhS)) {
                                    chonkh = Integer.parseInt(chonkhS);
                                    break;
                                }
                            }
                            switch (chonkh) {
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
                                    KhachHang kh = new KhachHang();
                                    kh.hienLb();
                                    ds.docFile(null, "KhachHang");
                                    break;
                            }
                        } while (chonkh != 0);
                        break;
                    } else System.out.println("Bạn cần nhập Phòng quản lý, Phòng, Dịch vụ trước");
                    break;
                case 7:
                    pql.docFile();
                    p.docFile();
                    dv.docFile();
                    NhanVien nv = new NhanVien();
                    nv.hienLb();
                    ds.docFile("NhanVien",null);
                    KhachHang kh = new KhachHang();
                    kh.hienLb();
                    ds.docFile(null,"KhachHang");
                    break;
            }
        } while (chon != 0);
    }

    public static void menuChinh() {
        System.out.println("\n\t-----QUẢN LÝ KHÁCH SẠN------");
        System.out.println("0. Thoát");
        System.out.println("1. Phòng quản lý");
        System.out.println("2. Phòng");
        System.out.println("3. Dịch vụ");
        System.out.println("4. Hóa đơn");
        System.out.println("5. Nhân viên");
        System.out.println("6. Khách hàng");
        System.out.println("7. Load data");
    }

    private static void menuKhachHang() {
        System.out.println("\n\t-----KHÁCH HÀNG------");
        System.out.println("0. Thoát");
        System.out.println("1. Thêm khách hàng");
        System.out.println("2. Sửa thông tin khách hàng");
        System.out.println("3. Xóa khách hàng");
        System.out.println("4. Xem thông tin khách hàng");
        System.out.println("5. Tìm kiếm thông tin khách hàng");
        System.out.println("6. Sắp xếp theo tên");
        System.out.println("7. Ghi file");
        System.out.println("8. Đọc file");
    }

    public static void menuNhanvien() {
        System.out.println("\n\t-----NHÂN VIÊN------");
        System.out.println("0. Thoát");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Sửa thông tin nhân viên");
        System.out.println("3. Xóa nhân viên");
        System.out.println("4. Xem thông tin nhân viên");
        System.out.println("5. Tìm kiếm thông tin nhân viên");
        System.out.println("6. Sắp xếp theo lương");
        System.out.println("7. Ghi file");
        System.out.println("8. Đọc file");
    }

    public static void menuDichvu() {
        System.out.println("\n\t-----Dịch vụ------");
        System.out.println("0. Thoát");
        System.out.println("1. Nhập ");
        System.out.println("2. Hiện");
        System.out.println("3. Ghi file");
        System.out.println("4. Đọc file");
    }

    public static void menuPhong() {
        System.out.println("\n\t-----Phòng-----");
        System.out.println("0. Thoát");
        System.out.println("1. Nhập danh sách");
        System.out.println("2. Hiện danh sách ");
        System.out.println("3. Ghi file");
        System.out.println("4. Đọc file");
        System.out.println("5. Sửa phòng theo mã");
        System.out.println("6. Xóa phòng theo mã ");
        System.out.println("7. Tìm phòng theo mã ");
        System.out.println("8. Sắp xếp phòng theo giá ");
    }

    public static void menuPhongQuanLy() {
        System.out.println("\n\t-----Phòng ban quản lý-----");
        System.out.println("0. Thoát");
        System.out.println("1. Nhập ");
        System.out.println("2. Hiện ");
        System.out.println("3. Ghi file");
        System.out.println("4. Đọc file");
    }

    public static void menuHoaDon() {
        System.out.println("\n\t-----Hóa đơn-----");
        System.out.println("0. Thoát");
        System.out.println("1. Nhập ");
        System.out.println("2. Hiện ");
        System.out.println("3. Ghi file");
        System.out.println("4. Đọc file");
    }

    public static boolean KiemTra() {
        ArrayList<Phong> dsP = Phong.getDsP();
        ArrayList<PhongQuanLy> dsPQL = PhongQuanLy.getDsPQl();
        ArrayList<DichVu> dsDv = DichVu.getDsdv();
        int dem1 = 0, dem2 = 0, dem3 = 0;
        for (Phong p : dsP) {
            dem1++;
        }
        for (PhongQuanLy ql : dsPQL) {
            dem2++;
        }
        for (DichVu dv : dsDv) {
            dem3++;
        }
        if (dem1 != 0 && dem2 != 0 && dem3 != 0) {
            return true;
        } else return false;
    }
}
