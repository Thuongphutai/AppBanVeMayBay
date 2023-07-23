package com.example.appbanvemaybay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DanhSachChuyenBayActivity extends AppCompatActivity {

    ImageButton btnBack;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    ArrayList<ChuyenBayModel> chuyenBayModelArrayList;
    ListChuyenBayAdapter listChuyenBayAdapter;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_chuyen_bay);
        btnBack=findViewById(R.id.btnBackDanhSachChuyenBay);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DanhSachChuyenBayActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Đang tải dữ liệu...");
        progressDialog.show();

        recyclerView=findViewById(R.id.rcvDanhSachChuyenBay);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db=FirebaseFirestore.getInstance();
        chuyenBayModelArrayList=new ArrayList<ChuyenBayModel>();
        listChuyenBayAdapter =new ListChuyenBayAdapter(DanhSachChuyenBayActivity.this,chuyenBayModelArrayList);

        recyclerView.setAdapter(listChuyenBayAdapter);

        EventChangeListener();
    }

    private void EventChangeListener() {
        db.collection("Danh Sách Chuyến Bay").orderBy("id", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null){
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                    Log.e("Firestore lỗi:",error.getMessage());
                }
                for (DocumentChange documentChange:value.getDocumentChanges()){
                    if (documentChange.getType()==DocumentChange.Type.ADDED){
                        chuyenBayModelArrayList.add(documentChange.getDocument().toObject(ChuyenBayModel.class));

                    }
                    listChuyenBayAdapter.notifyDataSetChanged();
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }
            }
        });
    }
}