package com.example.lenovo.jinritoutiao.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lenovo.jinritoutiao.bean.BeanF;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private SQLiteopenHelper helper;
	private SQLiteDatabase db;


	public Dao(Context context){
    	
    	   helper = new SQLiteopenHelper(context);
    	   db = helper.getWritableDatabase(); 
    	
    }
	   public void add(List<> list){
		   
		   ContentValues values = new ContentValues();
		   
		      for (int i = 0; i <list.size(); i++) {
               //,title text,authorname text,category text,date text
				  BeanF.ResultBean.DataBean bean = list.get(i);
				  values.put("title",bean.getTitle());
		    	  values.put("authorname",bean.getAuthor_name());

                  values.put("date",bean.getDate());
				  db.insert("user",null, values);
		    	  
		    	  
			} 
		  
	   }
	public List<> findquery(){

		List<BeanF.ResultBean.DataBean> list= new ArrayList<BeanF.ResultBean.DataBean>();
		  Cursor cursor = db.query("user", null, null, null, null, null, null);    
		  while(cursor.moveToNext()){

			  BeanF.ResultBean.DataBean bean1 = new BeanF.ResultBean.DataBean();

              int id = cursor.getInt(cursor.getColumnIndex("id"));
             cursor.getString(cursor.getColumnIndex("title"));
			  String title = cursor.getString(cursor.getColumnIndex("title"));
			  String authorname = cursor.getString(cursor.getColumnIndex("authorname"));
              String date = cursor.getString(cursor.getColumnIndex("date"));
              bean1.setTitle(title);
              bean1.setAuthor_name(authorname);

              bean1.setDate(date);
             list.add(bean1);
			     
		  }    
		
		return list;
	}
	    public boolean delete(int id){
	    	   
	    	   int delete = db.delete("user","id=?",new String[]{String.valueOf(id)});
	    	   if (delete>0) {
				  return true;
			}
	    	    return false;
	    }
	
	
}
