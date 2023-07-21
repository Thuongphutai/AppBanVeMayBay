package com.example.appbanvemaybay;

public class SanPham {
    private int image;
    private String tenSP, QuocGia, GiaSP;

    public SanPham(int image, String tenSP, String quocGia, String giaSP) {
        this.image = image;
        this.tenSP = tenSP;
        QuocGia = quocGia;
        GiaSP = giaSP;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }

    public String getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(String giaSP) {
        GiaSP = giaSP;
    }
}
