package com.example.ptsganjil11rpl2leosandy15;

import android.util.Log;

import com.example.ptsganjil11rpl2leosandy15.Model.MahasiswaModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    // untuk menyimpan data
    public void save(final MahasiswaModel mahasiswaModel){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(MahasiswaModel.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    mahasiswaModel.setId(nextId);

                    realm.copyToRealm(mahasiswaModel);

                }
                else{
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }

    // untuk memanggil semua data
    public List<MahasiswaModel> getAllMahasiswa(){
        RealmResults<MahasiswaModel> results = realm.where(MahasiswaModel.class).findAll();
        return results;
    }


    // untuk menghapus data
    public void delete(Integer id){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<MahasiswaModel> model = realm.where(MahasiswaModel.class).equalTo("id", id).findAll();
                model.deleteFromRealm(0);
            }
        });
    }

}
