package com.example.appbanvemaybay;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class BookingFragment extends Fragment {

    Button buttonSearch;
    ArrayList<ChuyenBayModel> chuyenBayModelArrayList;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        buttonSearch=view.findViewById(R.id.btnSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),DanhSachChuyenBayActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.item_search,menu);
        MenuItem item=menu.findItem(R.id.itemSearch);
        SearchView searchView= (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchDatabase(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchDatabase(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void searchDatabase(String query) {
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Danh Sách Chuyến Bay").whereEqualTo("diemDen",query.toUpperCase()).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        chuyenBayModelArrayList.clear();
                        for (DocumentSnapshot documentSnapshot:task.getResult()){
                            ChuyenBayModel model=new ChuyenBayModel(documentSnapshot.getString("id"),
                                    documentSnapshot.getString("diemDen"),documentSnapshot.getString("diemDi"),
                                    documentSnapshot.getString("firstTime"),documentSnapshot.getString("endTime"),
                                    documentSnapshot.getString("ngay"),documentSnapshot.getString("price"));
                            chuyenBayModelArrayList.add(model);
                        }
//                        adapter=new ChuyenBayModel(getActivity(),chuyenBayModelArrayList);
//                        recyclerView.setAdapter(adapter);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Lỗi:"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.itemSettings){
            Toast.makeText(getActivity(), "Settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}