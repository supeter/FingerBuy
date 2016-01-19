package com.idvances.fingerbuy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Food extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static int lrtmp = 0;
    private android.widget.SimpleAdapter fadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //====================================================================================
        ScrollView foodSV = (ScrollView)findViewById(R.id.foodScroll);
        foodSV.setFocusable(false);

        String[] strAry = new String[] { "bread", "bread2", "bread4", "bread5" };
        //image
        int[] imgAry = new int[] { R.drawable.food_pd1_img, R.drawable.food_pd2_img,
                R.drawable.food_pd3_img, R.drawable.food_pd4_img };

        List list = new ArrayList();
        for (int i = 0; i < strAry.length; i++) {
            Map map = new HashMap();
            map.put("image", imgAry[i]);
            map.put("text", strAry[i]);
            list.add(map);
        }
        fadapter= addNewPost(list);
        // Main-----
        // ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_checked, strAry);
        ListView listView = (ListView) findViewById(R.id.foodListView);
        listView.setAdapter(fadapter);
        setListViewHeightBasedOnChildren(listView);
        //====================================================================================

    }
    private android.widget.SimpleAdapter addNewPost(List list){
        if(lrtmp == 0){
            // 參數1：context - 上下文對象
            // 參數2：data - 設置到listView的數據集合
            // 參數3：resource - 放在listView中每一行的Acivity 資源檔
            // 參數4：from - 指定每一行的數據鍵（和to裡面的d對應）
            // 參數5：to - 指定每一行應用到哪個數據上
            fadapter = new android.widget.SimpleAdapter(this, list,
                    R.layout.list_left, new String[] { "image", "text" },
                    new int[] { R.id.listview_content_img,
                            R.id.listview_content_text });
            Log.e("lrtmp == 0","left");
            lrtmp = (lrtmp +1) % 2;
            return fadapter;
        }else if(lrtmp == 1 ) {
            fadapter = new android.widget.SimpleAdapter(this, list,
                    R.layout.list_right, new String[] { "image", "text" },
                    new int[] { R.id.listview_content_img,
                            R.id.listview_content_text });
            Log.e("lrtmp == 1","right");
            lrtmp = (lrtmp +1) % 2;
            return fadapter;
        }
        Toast.makeText(this,"adapter ERROR",Toast.LENGTH_LONG).show();
        return fadapter;
    }
    private void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.foodNvg) {
            // Handle the camera action
        } else if (id == R.id.clothNvg) {

        } else if (id == R.id.liveNvg) {

        } else if (id == R.id.transmitNvg) {

        } else if (id == R.id.edcationNvg) {

        } else if (id == R.id.etertainmentNvg) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
