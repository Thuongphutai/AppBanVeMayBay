package com.example.appbanvemaybay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder>{

    private List<SanPham> sanPhamList;
    public SanPhamAdapter(List<SanPham> sanPhamList){
        this.sanPhamList = sanPhamList;
    }
    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham, parent, false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        if(sanPham == null){
            return;
        }
        holder.mimgSP.setImageResource(sanPham.getImage());
        holder.mTenSP.setText(sanPham.getTenSP());
        holder.mTenQuocGia.setText(sanPham.getQuocGia());
        holder.mGiaTien.setText(sanPham.getGiaSP());
    }

    @Override
    public int getItemCount() {
        if (sanPhamList != null){
            return sanPhamList.size();
        }
        return 0;
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder {
        private ImageView mimgSP;
        private TextView mTenSP, mTenQuocGia, mGiaTien;
        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            mimgSP = itemView.findViewById(R.id.imgSP);
            mTenSP = itemView.findViewById(R.id.TenSP);
            mTenQuocGia = itemView.findViewById(R.id.TenQuocGia);
            mGiaTien = itemView.findViewById(R.id.GiaTien);
        }
    }
}
