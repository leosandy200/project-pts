package com.example.ptsganjil11rpl2leosandy15.Adapter;

import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptsganjil11rpl2leosandy15.Model.SportModel;
import com.example.ptsganjil11rpl2leosandy15.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.mahasiswaviewholder> {

    private ArrayList<SportModel> modelArrayList;
    private Callback callback;

    public interface Callback{
        void onClick(int position);
    }

    public MahasiswaAdapter(ArrayList<SportModel> modelArrayList, Callback callback) {
        this.modelArrayList = modelArrayList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public MahasiswaAdapter.mahasiswaviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recyleview, parent, false);
        return new mahasiswaviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.mahasiswaviewholder holder, int position) {

        holder.nama.setText(modelArrayList.get(position).getNama());
        holder.deskripsi.setText(modelArrayList.get(position).getDiskripsi());
        Picasso.get()
                .load(modelArrayList.get(position).getImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return (modelArrayList != null) ? modelArrayList.size() : 0;


    }

    public class mahasiswaviewholder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView nama;
        private TextView deskripsi;
        private CardView cardView;

        public mahasiswaviewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_list);
            nama = itemView.findViewById(R.id.list_nama);
            deskripsi = itemView.findViewById(R.id.list_diskripsi);
            cardView = itemView.findViewById(R.id.cardviewItemList);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getLayoutPosition());
                }
            });
        }
    }
}
