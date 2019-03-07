package com.dinh.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dinh.app.R;
import com.dinh.app.model.SanPham;

public class ShowImgActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_img);

        img = findViewById(R.id.showImg);
        Log.d("AAAA","AAAAVVS");
        Intent intent = getIntent();
        SanPham sanPham = (SanPham) intent.getSerializableExtra("sp");
        Glide.with(ShowImgActivity.this).load(sanPham.getHinhSP()).into(img);
    }

}
