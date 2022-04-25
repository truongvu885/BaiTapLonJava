package src;

public class KhachHang extends Nguoi {
    private long cccd;
    private String thanhVien;
    private String ngayThueGan;

    public KhachHang() {

    }

    public KhachHang(long ma, String ten, String diaChi, String ngaySinh, long SDT, String gioiTinh, long cccd, String thanhVien, String ngayThueGan) {
        super(ma, ten, diaChi, ngaySinh, SDT, gioiTinh);
        this.cccd = cccd;
        this.thanhVien = thanhVien;
        this.ngayThueGan = ngayThueGan;
    }

    public long getCccd() {
        return cccd;
    }

    public void setCccd(long cccd) {
        this.cccd = cccd;
    }

    public String getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(String thanhVien) {
        this.thanhVien = thanhVien;
    }

    public String getNgayThueGan() {
        return ngayThueGan;
    }

    public void setNgayThueGan(String ngayThueGan) {
        this.ngayThueGan = ngayThueGan;
    }

}
