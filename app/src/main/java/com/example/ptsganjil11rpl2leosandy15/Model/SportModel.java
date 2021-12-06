package com.example.ptsganjil11rpl2leosandy15.Model;

public class SportModel {
   private String Image;
   private String Nama;
   private String Diskripsi;

    public SportModel(String image, String nama, String diskripsi) {
        Image = image;
        Nama = nama;
        Diskripsi = diskripsi;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getDiskripsi() {
        return Diskripsi;
    }

    public void setDiskripsi(String diskripsi) {
        Diskripsi = diskripsi;
    }
}
