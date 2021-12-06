package com.example.ptsganjil11rpl2leosandy15.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptsganjil11rpl2leosandy15.Activity.DetailActivityRealm;
import com.example.ptsganjil11rpl2leosandy15.Model.MahasiswaModel;
import com.example.ptsganjil11rpl2leosandy15.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MahasiswaAdapterRealm extends RecyclerView.Adapter<MahasiswaAdapterRealm.MyViewHolder>{
    List<MahasiswaModel> listDataModel;

    public MahasiswaAdapterRealm(List<MahasiswaModel> mahasiswaModels) {
        this.listDataModel = mahasiswaModels;
    }

    @NonNull
    @Override
    public MahasiswaAdapterRealm.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recyleview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapterRealm.MyViewHolder holder, int position) {

        holder.nama.setText(listDataModel.get(position).getNama());
        holder.deskripsi.setText(listDataModel.get(position).getDiskripsi());
        Picasso.get()
                .load(listDataModel.get(position).getImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return (listDataModel != null) ? listDataModel.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView nama;
        private TextView deskripsi;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            imageView = itemView.findViewById(R.id.img_list);
            nama = itemView.findViewById(R.id.list_nama);
            deskripsi = itemView.findViewById(R.id.list_diskripsi);
            cardView = itemView.findViewById(R.id.cardviewItemList);
        }
    }

}