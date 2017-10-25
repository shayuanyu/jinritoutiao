package com.example.lenovo.jinritoutiao.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.lenovo.jinritoutiao.R;
import com.example.lenovo.jinritoutiao.activity.ContentActivity;
import com.example.lenovo.jinritoutiao.activity.Dao;
import com.example.lenovo.jinritoutiao.adapter.MFadapter;
import com.example.lenovo.jinritoutiao.bean.BeanF;
import com.example.lenovo.jinritoutiao.utis.StreamTools;
import com.google.gson.Gson;
import com.limxing.xlistview.view.XListView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Fragment1 extends Fragment implements XListView.IXListViewListener{
    private XListView xlist;
    private boolean flag;
    private List<BeanF.ResultBean.DataBean> list;
    private MFadapter adapter;
    private String title;
   private Dao dao;
  //  private List<BeanF.ResultBean.DataBean> findquery;

    public static Fragment1 newInstance(String tag){
        Bundle bundle=new Bundle();
        bundle.putString("title",tag);
        Fragment1 fragment1=new Fragment1();
        fragment1.setArguments(bundle);
        return fragment1;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        Bundle b = getArguments();
        title = b.getString("title");
        initView(view);
        xlist.setPullLoadEnable(true);
        xlist.setXListViewListener(this);
        dao = new Dao(getActivity());
//        findquery = dao.findquery();
        xlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             //   BeanF.ResultBean.DataBean bean = (BeanF.ResultBean.DataBean) adapter.getItem(position-1);
//                Toast.makeText(getContext(),"weizhi"+position,Toast.LENGTH_SHORT).show();
              BeanF.ResultBean.DataBean dataBean = list.get(position-1);
                Intent intent=new Intent(getActivity(), ContentActivity.class);
                intent.putExtra("url", dataBean.getUrl());
                getActivity().startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getdata();
    }

    private void getdata() {
       geturl("http://v.juhe.cn/toutiao/index?type="+title+"&key=54e3d5f4ee64f51bef570ce8505d37b5");

    }

    private void geturl(String s) {
        new AsyncTask<String, Void, String>() {

            private List<BeanF.ResultBean.DataBean> findquery;

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s==null){
                    return;
                }else{
                    Gson gson = new Gson();
                    BeanF beanf = gson.fromJson(s, BeanF.class);
                    list = beanf.getResult().getData();
                    dao.add(list);

                    findquery = dao.findquery();
                    if (adapter==null){
                        adapter = new MFadapter(getActivity(), list);
                        xlist.setAdapter(adapter);
               }else {
                       adapter.loadMore(list,flag);
                 }



                }

            }

            @Override
            protected String doInBackground(String... params) {
                try {
                      String param = params[0];
                      URL url = new URL(param);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    int code = connection.getResponseCode();
                    if (code==200){
                        InputStream inputStream = connection.getInputStream();
                        String s= StreamTools.readFromNetWork(inputStream);
                        return s;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute(s);
    }

    private void initView(View view) {
        xlist = (XListView) view.findViewById(R.id.xlist);
    }

    @Override
    public void onRefresh() {
        flag = false;
        getdata();
        xlist.stopRefresh(true);
    }

    @Override
    public void onLoadMore() {
        flag=true;
        getdata();
        xlist.stopLoadMore();
    }
}