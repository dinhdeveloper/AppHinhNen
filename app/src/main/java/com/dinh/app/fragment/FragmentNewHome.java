package com.dinh.app.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dinh.app.API.APIService;
import com.dinh.app.API.APIUntil;
import com.dinh.app.R;
import com.dinh.app.adapter.SanPhamAdapter;
import com.dinh.app.model.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNewHome extends Fragment {


    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;
    SanPhamAdapter sanPhamAdapter;
    List<SanPham> sanPhams;
    APIService apiServiceSP;
    List<String> strings;

    public FragmentNewHome() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_new, container, false);
        apiServiceSP = APIUntil.getServer();
        recyclerView = view.findViewById(R.id.recView);
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        apiServiceSP.APIServiceSP().enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                sanPhams =  response.body();
                sanPhamAdapter = new SanPhamAdapter(getContext(), sanPhams);
                recyclerView.setAdapter(sanPhamAdapter);
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Log.d("HIHI",t.toString());
            }
        });
        return view;
    }
}
