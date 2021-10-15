package com.codetree.mangaarab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adaptermanga_module extends BaseAdapter {

    private Context context;
    private ArrayList<manga_module> imageModelArrayList;


    public adaptermanga_module(Context context, ArrayList<manga_module> imageModelArrayList) {

        this.context = context;
        this.imageModelArrayList = imageModelArrayList;

    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return imageModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mangaitem, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.tvnamemodule);

            holder.iv = (ImageView) convertView.findViewById(R.id.imgmodule);

            convertView.setTag(holder);
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder) convertView.getTag();
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context.getApplicationContext(),manga_activity.class);
                i.putExtra("id",imageModelArrayList.get(position).getIdanime());
                i.putExtra("namear",imageModelArrayList.get(position).getNamear());
                i.putExtra("nameeng",imageModelArrayList.get(position).getNameeng());
                i.putExtra("story",imageModelArrayList.get(position).getStory());
                i.putExtra("imgsrc",imageModelArrayList.get(position).getImgsrc());
                i.putExtra("statue",imageModelArrayList.get(position).getStatue());
                context.startActivity(i);

            }
        });
        holder.tvname.setText(imageModelArrayList.get(position).getNameeng());
        Glide.with(context).load(imageModelArrayList.get(position).getImgsrc()).into(holder.iv);

        /*holder.tvname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context.getApplicationContext(),manga_activity.class);
                i.putExtra("id",imageModelArrayList.get(position).getIdanime());
                i.putExtra("namear",imageModelArrayList.get(position).getNamear());
                i.putExtra("nameeng",imageModelArrayList.get(position).getNameeng());
                i.putExtra("story",imageModelArrayList.get(position).getStory());
                i.putExtra("imgsrc",imageModelArrayList.get(position).getImgsrc());
                i.putExtra("statue",imageModelArrayList.get(position).getStatue());
                context.startActivity(i);
            }
        });*/
        return convertView;
    }

    private class ViewHolder {

        protected TextView tvname;
        private ImageView iv;

    }
}
