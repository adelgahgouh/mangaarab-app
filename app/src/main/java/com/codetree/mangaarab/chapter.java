package com.codetree.mangaarab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class chapter extends AppCompatActivity {
ImageView imgchapter;
    String img1="http://manga.ae/images/manga/shingeki-no-kyojin.jpg"
            ,img2="http://manga.ae/images/manga/naruto.jpg";
    private GestureDetector gdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        imgchapter=findViewById(R.id.imgchapter);
        gdt = new GestureDetector(new GestureListener());
        imgchapter.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                gdt.onTouchEvent(event);
                return true;
            } });

    }
    private class GestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            if (e1.getX() - e2.getX() > 50 && Math.abs(velocityX) > 50)
            {
                Toast.makeText(getApplicationContext(), "You have swipped left side", Toast.LENGTH_SHORT).show();
                /* Code that you want to do on swiping left side*/
                Glide.with(getApplicationContext()).load(img1).into(imgchapter);

                return false;
            }
            else if (e2.getX() - e1.getX() > 50 && Math.abs(velocityX) > 50)
            {
                Toast.makeText(getApplicationContext(), "You have swipped right side", Toast.LENGTH_SHORT).show();
                /* Code that you want to do on swiping right side*/
                Glide.with(getApplicationContext()).load(img2).into(imgchapter);

                return false;
            }
            return false;
        }
    }
}
