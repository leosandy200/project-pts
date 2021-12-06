package com.example.ptsganjil11rpl2leosandy15.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptsganjil11rpl2leosandy15.Model.MahasiswaModel;
import com.example.ptsganjil11rpl2leosandy15.R;
import com.example.ptsganjil11rpl2leosandy15.RealmHelper;
import com.squareup.picasso.Picasso;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Bundle bundle;
    private TextView tvName, tvDeskripsi;
    private ImageView imageView;
    Button btn_simpan;
    private String name, deskripsi, image;

    Realm realm;
    RealmHelper realmHelper;
    MahasiswaModel mahasiswaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.namalist);
        tvDeskripsi = findViewById(R.id.diskripsilist);
        imageView = findViewById(R.id.imgView);
        btn_simpan = findViewById(R.id.buttonsimpan);

        bundle = getIntent().getExtras();
        if (bundle != null){
            name = bundle.getString("name");
            deskripsi = bundle.getString("description");
            image = bundle.getString("image");
        }

        tvName.setText(name);
        tvDeskripsi.setText(deskripsi);
        Picasso.get().load(image).into(imageView);

        //Set up Realm
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);


        btn_simpan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btn_simpan){

            bundle = getIntent().getExtras();
            if (bundle != null){
                name = bundle.getString("name");
                deskripsi = bundle.getString("description");
                image = bundle.getString("image");
            }


            MahasiswaModel mahasiswaModel=new MahasiswaModel();
            mahasiswaModel.setNama(name);
            mahasiswaModel.setDiskripsi(deskripsi);
            mahasiswaModel.setImage(image);

            realmHelper = new RealmHelper(realm);
            realmHelper.save(mahasiswaModel);
        }
    }
}