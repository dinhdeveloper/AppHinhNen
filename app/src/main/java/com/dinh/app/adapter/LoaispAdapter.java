package com.dinh.app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinh.app.R;
import com.dinh.app.model.LoaiSanPham;

import java.util.ArrayList;

public class LoaispAdapter extends RecyclerView.Adapter<LoaispAdapter.ViewHolder> {

    Context context;
    ArrayList<LoaiSanPham> loaiSanPhamList;

    public LoaispAdapter(Context context, ArrayList<LoaiSanPham> loaiSanPhamList) {
        this.context = context;
        this.loaiSanPhamList = loaiSanPhamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        @SuppressLint("ResourceType") View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.menu.activity_main_drawer,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtTenLSP.setText(loaiSanPhamList.get(i).getTenLSP());
    }

    @Override
    public int getItemCount() {
        return loaiSanPhamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenLSP;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenLSP = itemView.findViewById(R.id.nav_3d);
        }
    }
}
