package com.dinh.activity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.dinh.app.API.APIService;
import com.dinh.app.R;
import com.dinh.app.adapter.LoaispAdapter;
import com.dinh.app.adapter.ViewPagerAdapter;
import com.dinh.app.fragment.FragmentNewHome;
import com.dinh.app.fragment.FragmentRandomHome;
import com.dinh.app.fragment.FragmentRatingHome;
import com.dinh.app.fragment.FragmentStreamHome;
import com.dinh.app.model.LoaiSanPham;

import java.util.List;

import static com.dinh.app.R.id.action_search;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    //xu ly menu
    LoaispAdapter loaispAdapter;
    APIService apiServiceLSP;
    List<LoaiSanPham> loaiSanPhams;

    Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        //xu ly menu
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            MenuItem menuItem = findViewById(R.id.action_search);
            SearchView searchView = (SearchView) menuItem.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    //search
                    return false;
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportActionBar().setTitle("Home");
            //setSupportActionBar(toolbar);
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
            viewPagerAdapter.addFragment(new FragmentNewHome(),"NEW");
            viewPagerAdapter.addFragment(new FragmentRandomHome(),"RATING");
            viewPagerAdapter.addFragment(new FragmentRatingHome(),"RANDOM");
            viewPager.setAdapter(viewPagerAdapter);

        } else if (id == R.id.nav_all) {
                getSupportActionBar().setTitle("All");
              //  setSupportActionBar(toolbar);

            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
            viewPagerAdapter.addFragment(new FragmentNewHome(),"NEW");
            viewPagerAdapter.addFragment(new FragmentRandomHome(),"RATING");
            viewPagerAdapter.addFragment(new FragmentRatingHome(),"STREAM");
            viewPager.setAdapter(viewPagerAdapter);

        } else if (id == R.id.nav_3d) {
                getSupportActionBar().setTitle("3D");
                getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new FragmentNewHome());
              //  setSupportActionBar(toolbar);

        }
//        else if (id == R.id.nav_animal) {
//            getSupportActionBar().setTitle("Animals");
//           // setSupportActionBar(toolbar);
//
//        } else if (id == R.id.nav_girl) {
//            getSupportActionBar().setTitle("Hot Girl");
//            //setSupportActionBar(toolbar);
//
//        } else if (id == R.id.nav_car) {
//            getSupportActionBar().setTitle("Cars");
//            //setSupportActionBar(toolbar);
//
//        }else if (id == R.id.nav_other) {
//            getSupportActionBar().setTitle("Other");
//            //setSupportActionBar(toolbar);
//
//        } else if (id == R.id.nav_share) {
//            getSupportActionBar().setTitle("Share");
//            //setSupportActionBar(toolbar);
//
//        } else if (id == R.id.nav_send) {
//            getSupportActionBar().setTitle("Send");
//            //setSupportActionBar(toolbar);
//
//        } else if (id == R.id.nav_anime) {
//            getSupportActionBar().setTitle("Anime");
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentNewHome(),"NEW");
        viewPagerAdapter.addFragment(new FragmentRandomHome(),"RATING");
        viewPagerAdapter.addFragment(new FragmentRatingHome(),"RANDOM");
        viewPagerAdapter.addFragment(new FragmentStreamHome(),"STREAM");
        viewPager.setAdapter(viewPagerAdapter);
    }


    public void showIMG(View view) {
        Intent intent = new Intent(MainActivity.this, ShowImgActivity.class);
        startActivity(intent); // gửi lệnh đến android system để mở màn hình 2.
    }

    //action_search

}
