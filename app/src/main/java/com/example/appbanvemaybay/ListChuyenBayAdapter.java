package com.example.appbanvemaybay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListChuyenBayAdapter extends RecyclerView.Adapter<ListChuyenBayAdapter.MyViewHolder> {
    Context context;
    ArrayList<ChuyenBayModel> chuyenBayModelArrayList;

    public ListChuyenBayAdapter(Context context, ArrayList<ChuyenBayModel> chuyenBayModelArrayList) {
        this.context = context;
        this.chuyenBayModelArrayList = chuyenBayModelArrayList;
    }

    @NonNull
    @Override
    public ListChuyenBayAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chuyen_bay_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListChuyenBayAdapter.MyViewHolder holder, int position) {
        ChuyenBayModel chuyenBayModel= chuyenBayModelArrayList.get(position);
        holder.tvFirstTime.setText(chuyenBayModel.firstTime);
        holder.tvEndTime.setText(chuyenBayModel.endTime);
        holder.tvGia.setText(chuyenBayModel.price);
        holder.tvDiemDi.setText(chuyenBayModel.DiemDi);
        holder.tvDiemDen.setText(chuyenBayModel.DiemDen);
        holder.tvNgay.setText(chuyenBayModel.Ngay);
    }

    @Override
    public int getItemCount() {
        return chuyenBayModelArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvFirstTime,tvEndTime,tvDiemDen,tvDiemDi,tvGia,tvNgay;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstTime=itemView.findViewById(R.id.tvRcvTimeDiemDi);
            tvEndTime=itemView.findViewById(R.id.tvRcvTimeDiemDen);
            tvDiemDen=itemView.findViewById(R.id.tvRcvDiemDen);
            tvDiemDi=itemView.findViewById(R.id.tvRcvDiemDi);
            tvGia=itemView.findViewById(R.id.tvRcvGia);
            tvNgay=itemView.findViewById(R.id.tvRcvNgay);
        }
    }
}
