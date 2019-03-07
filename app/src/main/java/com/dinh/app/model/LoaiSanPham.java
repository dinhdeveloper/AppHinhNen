package com.dinh.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoaiSanPham {
    @SerializedName("maLSP")
    @Expose
    private Integer maLSP;
    @SerializedName("tenLSP")
    @Expose
    private String tenLSP;
    @SerializedName("hinhSLP")
    @Expose
    private Object hinhSLP;
    @SerializedName("SanPhams")
    @Expose
    private List<Object> sanPhams = null;

    public Integer getMaLSP() {
        return maLSP;
    }

    public void setMaLSP(Integer maLSP) {
        this.maLSP = maLSP;
    }

    public String getTenLSP() {
        return tenLSP;
    }

    public void setTenLSP(String tenLSP) {
        this.tenLSP = tenLSP;
    }

    public Object getHinhSLP() {
        return hinhSLP;
    }

    public void setHinhSLP(Object hinhSLP) {
        this.hinhSLP = hinhSLP;
    }

    public List<Object> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<Object> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
