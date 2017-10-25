package com.example.lenovo.jinritoutiao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.jinritoutiao.R;
import com.example.lenovo.jinritoutiao.bean.Newsbean;

import java.util.List;

/**
 * Created by Lenovo on 2017/9/8.
 */

public class MNadapter extends BaseAdapter {
    private Context context;
    private List<Newsbean.DataBeanX.DataBean> lists;
    private final LayoutInflater inflater;
    public MNadapter(Context context, List<Newsbean.DataBeanX.DataBean> lists) {
        this.context = context;
        this.lists = lists;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 加载更多
     */
    public void loadMore(List<Newsbean.DataBeanX.DataBean> data, boolean flag){


        for (Newsbean.DataBeanX.DataBean dataBean: data) {

            //flag true 数据要添加到最前面  false要添加到最后面
            if(flag){
                data.add(dataBean);
            }else {
                //首先我把数据都添加到最前面
                data.add(0, dataBean);
            }


        }
        //刷新界面
        notifyDataSetChanged();

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
            convertView=inflater.inflate(R.layout.itemnews, null);
            holder=new ViewHolder();

            holder.tvName=(TextView) convertView.findViewById(R.id.t_news);
          //  holder.img = (ImageView)convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        //赋值
        holder.tvName.setText(lists.get(position).getContent());
        return convertView;
    }

    class ViewHolder{
        ImageView img;
        TextView tvName;
    }

}