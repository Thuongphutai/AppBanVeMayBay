package com.example.appbanvemaybay;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private RecyclerView rcvSanPham;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        rcvSanPham = rootView.findViewById(R.id.rcv_SanPham);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rcvSanPham.setLayoutManager(gridLayoutManager);

        SanPhamAdapter adapter = new SanPhamAdapter(getListSanPham());
        rcvSanPham.setAdapter(adapter);
        return rootView;
    }

    private List<SanPham> getListSanPham() {
        List<SanPham> list = new ArrayList<>();
        list.add(new SanPham(R.drawable.linhbuuson, "Linh Buu Son", "Việt Nam", "1.000.000"));
        list.add(new SanPham(R.drawable.paris, "Paris", "France", "4.000.000"));
        list.add(new SanPham(R.drawable.newyork, "New York", "United States", "7.000.000"));
        list.add(new SanPham(R.drawable.singapore, "Singapore", "Singapore", "3.500.000"));
        return list;
    }
}