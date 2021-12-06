package com.example.ptsganjil11rpl2leosandy15.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MahasiswaModel extends RealmObject {

    @PrimaryKey
    private int id;
    private String Image;
    private String Nama;
    private String Diskripsi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
