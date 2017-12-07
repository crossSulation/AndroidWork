package com.alldiancan.models;

import android.media.Image;

/**
 * Created by laliu on 12/7/2017.
 * ??????
 */
public class RestoBasicInfo {
    private Image imginfo;
    private String contact;
    private String dialnumber;
    private String restoAddress;
    private int  ranks;

    public RestoBasicInfo(String contact, String dialnumber, Image imginfo, String restoAddress, int ranks) {
        this.contact = contact;
        this.dialnumber = dialnumber;
        this.imginfo = imginfo;
        this.restoAddress = restoAddress;
        this.ranks = ranks;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRestoAddress() {
        return restoAddress;
    }

    public void setRestoAddress(String restoAddress) {
        this.restoAddress = restoAddress;
    }

    public String getDialnumber() {
        return dialnumber;
    }

    public void setDialnumber(String dialnumber) {
        this.dialnumber = dialnumber;
    }

    public Image getImginfo() {
        return imginfo;
    }

    public void setImginfo(Image imginfo) {
        this.imginfo = imginfo;
    }

    public int getRanks() {
        return ranks;
    }

    public void setRanks(int ranks) {
        this.ranks = ranks;
    }
}
