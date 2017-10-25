package com.example.lenovo.jinritoutiao.activity;
/*
 *    author jiahongyin
 *    date 2017-07-28
 *  
 *   作用  创建数据库
 * */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteopenHelper extends SQLiteOpenHelper {

	public SQLiteopenHelper(Context context) {
		super(context,"info.db",null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
     		db.execSQL("create table user(id Integer primary key autoincrement,title text,authorname text,date text)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
