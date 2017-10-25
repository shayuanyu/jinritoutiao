package com.example.lenovo.jinritoutiao.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.jinritoutiao.R;
import com.example.lenovo.jinritoutiao.bean.BeanF;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.lenovo.jinritoutiao.R.id.chahao;
import static com.example.lenovo.jinritoutiao.R.id.textView;

/**
 * Created by Lenovo on 2017/9/7.
 */

public class MFadapter extends BaseAdapter {
     private List<BeanF.ResultBean.DataBean> list;
    private Context context;
    private static final int type_1=1;
   // private static final int type_2=2;
    private final DisplayImageOptions options;
    private int type;
    private TextView tv_no;
    private PopupWindow window;
    private ImageView iv_errorNo;

    public MFadapter(Context context,List<BeanF.ResultBean.DataBean> list) {
        this.list = list;
        this.context = context;
        options = new DisplayImageOptions.Builder()
                             .cacheInMemory(true)
                             .cacheOnDisk(true)
                             .showImageForEmptyUri(R.mipmap.ic_empty)
                             .showImageOnLoading(R.mipmap.loading)
                              .showImageOnFail(R.mipmap.ic_error)

                              .build();
    }
    /**
     * 加载更多
     */
    public void loadMore(List<BeanF.ResultBean.DataBean> list1, boolean flag){
            if(flag){
                list.add(list1.get(0));
                list.add(list1.get(1));
                list.add(list1.get(3));
            }else {
                list.add(0,list1.get(2));
                list.add(0,list1.get(4));
                list.add(0, list1.get(6));
            }
        //刷新界面
        notifyDataSetChanged();

    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
         return  type_1;


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        int anInt = context.getSharedPreferences("ALER", MODE_PRIVATE).getInt("font", 0);

        if (list.get(position).getThumbnail_pic_s02()!=null&&list.get(position).getThumbnail_pic_s03()!=null){
            convertView=View.inflate(context,R.layout.itemthree,null);
            ImageView image1= (ImageView) convertView.findViewById(R.id.imageview31);
            ImageView image2= (ImageView) convertView.findViewById(R.id.imageview32);
            ImageView image3= (ImageView) convertView.findViewById(R.id.imageview33);
            final ImageView chahao3= (ImageView) convertView.findViewById(chahao);
            TextView   tv1 = (TextView) convertView.findViewById(R.id.title3);
            TextView nick3= (TextView) convertView.findViewById(R.id.nick3);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),image1,options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),image2,options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s03(),image3,options);
            tv1.setText(list.get(position).getTitle());

            if (anInt == 0) {
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX, 15); //设置45PX
                notifyDataSetChanged();
            } else if (anInt == 1) {
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30); //设置45SP
                notifyDataSetChanged();
            } else if (anInt == 2) {
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 46); //设置45SP
                notifyDataSetChanged();
            } else if (anInt == 3) {
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 58);//设置45DIP
                notifyDataSetChanged();
            }
            //加载popuWindows布局
            View popView = View.inflate(context, R.layout.pop_item, null);
            //初始化
            window = new PopupWindow(popView,200,50);
            //设置点击pop外部关闭pop界面，两者缺一不可
            window.setBackgroundDrawable(new ColorDrawable());
            window.setOutsideTouchable(true);
            //查找pop布局控件
            tv_no = (TextView) popView.findViewById(R.id.tv_no);
            iv_errorNo = (ImageView) popView.findViewById(R.id.iv_errorNo);
            iv_errorNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    window.dismiss();
                }
            });
            nick3.setText(list.get(position).getAuthor_name()+"   "+list.get(position).getCategory()+"  "+list.get(position).getDate());
            chahao3.setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View v) {
                    window.showAsDropDown(chahao3);
//                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                    builder.setMessage("是否删除");
//                    builder.setNegativeButton("考虑考虑吧", null);
//                    builder.setPositiveButton("狠心删除", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            //    startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS))
//                            list.remove(position);
//                            notifyDataSetChanged();
//                        }
//                    });
//                    builder.create().show();

                }
            });
            tv_no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                    window.dismiss();
                }
            });
        }else if (list.get(position).getThumbnail_pic_s02()!=null&&list.get(position).getThumbnail_pic_s03()==null){
            convertView=View.inflate(context,R.layout.itemtwo,null);
            ImageView imageview21= (ImageView) convertView.findViewById(R.id.imageview21);
            ImageView imageview22= (ImageView) convertView.findViewById(R.id.imageview22);
            ImageView chahao= (ImageView) convertView.findViewById(R.id.chahao);
            TextView title2= (TextView) convertView.findViewById(R.id.title2);
            TextView nick2= (TextView) convertView.findViewById(R.id.nick2);

            if (anInt == 0) {
                title2.setTextSize(TypedValue.COMPLEX_UNIT_PX, 15); //设置45PX
                notifyDataSetChanged();
            } else if (anInt == 1) {
                title2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30); //设置45SP
                notifyDataSetChanged();
            } else if (anInt == 2) {
                title2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 46); //设置45SP
                notifyDataSetChanged();
            } else if (anInt == 3) {
                title2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 58);//设置45DIP
                notifyDataSetChanged();
            }
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),imageview21,options);
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),imageview22,options);
            title2.setText(list.get(position).getTitle());

              nick2.setText(list.get(position).getAuthor_name()+"   "+list.get(position).getCategory()+"  "+list.get(position).getDate());
            chahao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    builder.setMessage("是否删除");
                    builder.setNegativeButton("考虑考虑吧",null);
                    builder.setPositiveButton("狠心删除", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //    startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS))
                                list.remove(position);
                               notifyDataSetChanged();
                        }
                    });
                    builder.create().show();
                }
              });
        }else {
            convertView = View.inflate(context, R.layout.itemone, null);
            ImageView image1 = (ImageView) convertView.findViewById(R.id.image1);
            ImageView chahao1 = (ImageView) convertView.findViewById(R.id.chahao1);
            TextView tv = (TextView) convertView.findViewById(textView);
            TextView title1 = (TextView) convertView.findViewById(R.id.qw);

            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(), image1, options);
            tv.setText(list.get(position).getTitle());

            title1.setText(list.get(position).getAuthor_name() + "   " + list.get(position).getCategory() + "  " + list.get(position).getDate());
            chahao1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("是否删除");
                    builder.setNegativeButton("考虑考虑吧", null);
                    builder.setPositiveButton("狠心删除", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //    startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS))
                            list.remove(position);
                            notifyDataSetChanged();
                        }
                    });
                    builder.create().show();
                }
            });

            if (anInt == 0) {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, 15); //设置45PX
                notifyDataSetChanged();
            } else if (anInt == 1) {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30); //设置45SP
                notifyDataSetChanged();
            } else if (anInt == 2) {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 46); //设置45SP
                notifyDataSetChanged();
            } else if (anInt == 3) {
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 58);//设置45DIP
                notifyDataSetChanged();
            }
        }
        return convertView;
    }


}
