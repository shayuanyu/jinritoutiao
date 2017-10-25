package com.example.lenovo.jinritoutiao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.jinritoutiao.R;
import com.example.lenovo.jinritoutiao.bean.bean;

import java.util.List;

/**
 * Created by Lenovo on 2017/8/31.
 */

public class MyMdapter extends BaseAdapter{
    private Context context;
    private List<bean> lists;
    private final LayoutInflater inflater;
    public MyMdapter(Context context, List<bean> lists) {
        this.context = context;
        this.lists = lists;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
        //加载布局
        convertView=inflater.inflate( R.layout.cehua2, null);
        holder=new ViewHolder();

        holder.tvName=(TextView) convertView.findViewById(R.id.textView);
        holder.img = (ImageView)convertView.findViewById(R.id.imageView);

        convertView.setTag(holder);
    }else{
        holder=(ViewHolder) convertView.getTag();
    }
    //赋值
        holder.img.setImageResource(lists.get(position).getImg());
        holder.tvName.setText(lists.get(position).getName());
        return convertView;
}

class ViewHolder{
    ImageView img;
    TextView tvName;
}

}
