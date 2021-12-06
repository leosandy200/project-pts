package com.example.ptsganjil11rpl2leosandy15.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.ptsganjil11rpl2leosandy15.Adapter.MahasiswaAdapter;
import com.example.ptsganjil11rpl2leosandy15.Model.SportModel;
import com.example.ptsganjil11rpl2leosandy15.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private ArrayList<SportModel> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyleview);

        getDataApi();

    }
    public void getDataApi() {
        AndroidNetworking.get("https://www.thesportsdb.com/api/v1/json/1/all_sports.php")
            .addPathParameter("pageNumber", "0")
            .addQueryParameter("limit", "3")
            .addHeaders("token", "1234")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        modelArrayList = new ArrayList<>();

                        try {
                            JSONArray jsonArray = response.getJSONArray("sports");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String nama = jsonObject.getString("strSport");
                                String diskripsi = jsonObject.getString("strSportDescription");
                                String image = jsonObject.getString("strSportThumb");

                                modelArrayList.add(new SportModel(image,nama, diskripsi));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        mahasiswaAdapter = new MahasiswaAdapter(modelArrayList, new MahasiswaAdapter.Callback() {
                            @Override
                            public void onClick(int position) {
                                Toast.makeText(MainActivity.this, "ini recyclerview " + modelArrayList.get(position), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                                intent.putExtra("image", modelArrayList.get(position).getImage());
                                intent.putExtra("name", modelArrayList.get(position).getNama());
                                intent.putExtra("description", modelArrayList.get(position).getDiskripsi());
                                startActivity(intent);
                            }
                        });
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        recyclerView.setAdapter(mahasiswaAdapter);
                        recyclerView.setLayoutManager(layoutManager);
                    }


                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}