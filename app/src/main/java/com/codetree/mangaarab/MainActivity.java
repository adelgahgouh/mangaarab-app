package com.codetree.mangaarab;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    GridView gv;
    DrawerLayout drawerLayout;
    //TextView toolbartitle;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    adaptermanga_module customadapter;
ArrayList<manga_module> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gv);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        toolbar.setTitle("المانجا العربية");

        setSupportActionBar(toolbar);
        // toolbartitle.setText("الرابعة متوسط");

        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this
        );
        list();
       /* toolbar.setNavigationOnClickListener (new View.OnClickListener () {
            @SuppressLint("WrongConstant")
            @Override public void onClick(View view) {
                if (drawerLayout.isDrawerOpen (Gravity.END)) {
                    drawerLayout.closeDrawer (Gravity.END);
                } else {
                    drawerLayout.openDrawer (Gravity.END);
                }
            }
        });
*/
    }
    void list(){
        arrayList=new ArrayList<>();
        manga_module manga_module=
                new manga_module(1,
                        "adel","adel eng"
                        ,"story","complete"
                        ,"http://manga.ae/images/manga/1one-piece.jpg");
        manga_module manga_module2=
                new manga_module(2,
                        "ون بيس","One piece"
                        ,getResources().getString(R.string.story),"مستمر"
                        ,"https://images-na.ssl-images-amazon.com/images/I/61su5A50q0L._SX331_BO1,204,203,200_.jpg");
        arrayList.add(manga_module);
        arrayList.add(manga_module2);
        customadapter=new adaptermanga_module(getApplicationContext(),arrayList);
        gv.setAdapter(customadapter);
    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onNavigationItemSelected( MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.latest: {
                Toast.makeText(getApplicationContext(), "latest Selected", Toast.LENGTH_SHORT).show();
                if (drawerLayout.isDrawerOpen (Gravity.START)) {
                    drawerLayout.closeDrawer (Gravity.START);
                } else {
                    drawerLayout.openDrawer (Gravity.START);
                }
                startActivity(new Intent(getApplicationContext(), manga_activity.class));
                break;
            }


            case R.id.about: {

                Toast.makeText(getApplicationContext(), "About us Selected", Toast.LENGTH_SHORT).show();
                if (drawerLayout.isDrawerOpen (Gravity.START)) {
                    drawerLayout.closeDrawer (Gravity.START);
                } else {
                    drawerLayout.openDrawer (Gravity.START);
                }
                break;
            }

            case R.id.mainmenu:{
                 Toast.makeText(getApplicationContext(), "Main Selected", Toast.LENGTH_SHORT).show();
                if (drawerLayout.isDrawerOpen (Gravity.START)) {
                    drawerLayout.closeDrawer (Gravity.START);
                } else {
                    drawerLayout.openDrawer (Gravity.START);
                }
                break;}
            default:
                break;
        }


        return true;
    }
}
