package com.jash.lesson1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SlidingPaneLayout drawer;
    private NavigationView menu;
    private ActionBarDrawerToggle toggle;
    private ViewPager pager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = (SlidingPaneLayout) findViewById(R.id.drawer);
        menu = (NavigationView) findViewById(R.id.menu);
        menu.setNavigationItemSelectedListener(this);
        //显示Home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //三条横线的MEnu
//        toggle = new ActionBarDrawerToggle(this, drawer, 0, 0);
//        toggle.syncState();
//        //由DrawerLayout控制Toggle
//        drawer.setDrawerListener(toggle);
        pager = (ViewPager) findViewById(R.id.pager);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(String.format("第%02d页", i));
        }
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(), list));
        tab = (TabLayout) findViewById(R.id.tab);
        tab.setupWithViewPager(pager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toggle控制DrawerLayout
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_1:
                Toast.makeText(this, "第一项点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_4:
                ActivityCompat.finishAffinity(this);
                break;
        }
//        drawer.closeDrawer(GravityCompat.START);
        drawer.closePane();
        return true;
    }
}
