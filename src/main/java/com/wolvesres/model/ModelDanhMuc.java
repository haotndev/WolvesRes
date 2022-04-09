package com.wolvesres.model;

import com.wolvesres.dao.DonViTinhDAO;
import com.wolvesres.swing.table.EventAction;
import com.wolvesres.swing.table.ModelAction;
import java.util.ArrayList;
import java.util.List;

public class ModelDanhMuc {

    private String maDanhMuc;
    private String tenDanhMuc;
    private boolean matHang;

    public boolean isMatHang() {
        return matHang;
    }

    public void setMatHang(boolean matHang) {
        this.matHang = matHang;
    }

    @Override
    public String toString() {
        return this.getTenDanhMuc();
    }

    public ModelDanhMuc() {
    }

    public ModelDanhMuc(String maDanhMuc, String tenDanhMuc, boolean matHang) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.matHang = matHang;
    }

    /**
     * @return the maDanhMuc
     */
    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    /**
     * @param maDanhMuc the maDanhMuc to set
     */
    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    /**
     * @return the tenDanhMuc
     */
    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    /**
     * @param tenDanhMuc the tenDanhMuc to set
     */
    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    DonViTinhDAO donViTinhDAO = new DonViTinhDAO();

//    //
//    public String TenDVT(int ma) {
//        String TenDVT = "";
//        for (ModelDonViTinh dvt : donViTinhDAO.selectAll()) {
//            if (ma == dvt.getMaDVT()) {
//                TenDVT = dvt.getTenDVT();
//            }
//        }
//        return TenDVT;
//    }
    public String getTenLoaiHang() {
    return isMatHang()?"Mặt hàng":" Món ăn";
    }

    public int ChuyenMaDVT(String Ten) {
        int ma = 0;
        for (ModelDonViTinh dv : donViTinhDAO.selectAll()) {
            if (Ten.equals(dv.getTenDVT())) {
                ma = dv.getMaDVT();
            }
        }
        return ma;
    }

    public Object[] toRowTable(EventAction event) {
        return new Object[]{getMaDanhMuc(), getTenDanhMuc(), isMatHang() ? "Mặt hàng" : "Món ăn", new ModelAction(this, event)};
    }

}