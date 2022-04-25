package src;

public class Phong {
    private String maP;
    private String loaiP;
    private float giaP;
    private Boolean trangThai;

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

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Phong() {
    }

    public Phong(String maP, String loaiP, float giaP, Boolean trangThai) {
        this.maP = maP;
        this.loaiP = loaiP;
        this.giaP = giaP;
        this.trangThai = trangThai;
    }
    public void nhap(){

    }
}
