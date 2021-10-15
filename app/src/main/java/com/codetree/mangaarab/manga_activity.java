package com.codetree.mangaarab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class manga_activity extends AppCompatActivity {
    TextView tvtitle,tvtiltear,tvstory,tvstatue;
    ImageView imgchapter;
    ListView lv;

   //Toolbar toolbar;
    String namear,nameeng,story,statue,imgsrc;
    int idanime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity_mangac);
     //   toolbar = (Toolbar) findViewById(R.id.toolbar);
       tvstory=findViewById(R.id.tvstory);
        tvtitle=findViewById(R.id.title);
        tvtiltear=findViewById(R.id.tvtitlear);
        tvstatue=findViewById(R.id.tvstatue);
        imgchapter=(ImageView)findViewById(R.id.imgmanga);
        lv=findViewById(R.id.listchapters);

      // setSupportActionBar(toolbar);

        namear=getIntent().getExtras().getString("namear");
        nameeng=getIntent().getExtras().getString("nameeng");
        story=getIntent().getExtras().getString("story");
        statue=getIntent().getExtras().getString("statue");
        imgsrc=getIntent().getExtras().getString("imgsrc");
        idanime=getIntent().getExtras().getInt("idanime");
        Toast.makeText(getApplicationContext(),imgsrc,Toast.LENGTH_SHORT).show();
        tvtitle.setText(nameeng);
        tvstory.setText(story);
lv.setNestedScrollingEnabled(true);
        tvtiltear.setText(namear);

        tvstatue.setText(statue);
        ArrayList<String> chapters=new ArrayList<>();
        chapters.add("الفصل 1");
        chapters.add("الفصل 1");
        chapters.add("الفصل 1");
        chapters.add("الفصل 1");
        chapters.add("الفصل 1");
        chapters.add("الفصل 1");
        chapters.add("الفصل 1");
        chapters.add("الفصل 1");
        Glide.with(manga_activity.this).load(imgsrc).into(imgchapter);
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.listchitem,chapters);
        lv.setAdapter(stringArrayAdapter);

    }
}
