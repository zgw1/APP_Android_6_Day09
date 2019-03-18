package com.example.zhang.app_android_6_day09.v;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhang.app_android_6_day09.Data.Bean;
import com.example.zhang.app_android_6_day09.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyView> {
    private List<Bean.DataBean> data = new ArrayList<>();
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Bean.DataBean> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View inflate = inflater.inflate(R.layout.item, viewGroup, false);

        return new MyView(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView myView, int i) {

        Uri uri = Uri.parse(data.get(i).getPic());
        Glide.with(context).load(uri).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(myView.iv);
        myView.tv.setText(data.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyView extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public MyView(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);

        }
    }

}
