package com.example.ptsganjil11rpl2leosandy15.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ptsganjil11rpl2leosandy15.Adapter.MahasiswaAdapterRealm;
import com.example.ptsganjil11rpl2leosandy15.Model.MahasiswaModel;
import com.example.ptsganjil11rpl2leosandy15.R;
import com.example.ptsganjil11rpl2leosandy15.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MahasiswaActivity extends AppCompatActivity {

    Realm realm;
    RealmHelper realmHelper;
    RecyclerView recyclerView;
    MahasiswaAdapterRealm mahasiswaAdapterRealm;
    List<MahasiswaModel> mahasiswaModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Setup Realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        realmHelper = new RealmHelper(realm);
        mahasiswaModels = new ArrayList<>();

        mahasiswaModels = realmHelper.getAllMahasiswa();

        show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mahasiswaAdapterRealm.notifyDataSetChanged();
        show();
    }

    public void show(){
        mahasiswaAdapterRealm = new MahasiswaAdapterRealm(mahasiswaModels);
        recyclerView.setAdapter(mahasiswaAdapterRealm);
    }
}

