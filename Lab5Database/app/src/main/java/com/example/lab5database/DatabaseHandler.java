package com.example.lab5database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	public DatabaseHandler(Context context) {
		super(context, "students", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + "student" + "(regno INTEGER," 
				+ "name TEXT,"
				+ "age INTEGER" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + "student");

		onCreate(db);
	}

	void insert(int regno,String name,int age) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("regno", regno); 
		values.put("name", name);
		values.put("age", age);

		db.insert("student", null, values);
		db.close();
	}

	String[] select(int regno) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query("student", new String[] { "regno",
				"name", "age" }, "regno=?",
				new String[] { regno+"" }, null, null, null, null);
		if (cursor != null && cursor.moveToFirst()) {
			return new String[]{cursor.getInt(0)+"",cursor.getString(1),cursor.getInt(2)+""};
		}
		return new String[]{"error"};
	}
	
	public List<String[]> selectAll() {
		List<String[]> students = new ArrayList<String[]>();
		String selectQuery = "SELECT  * FROM student";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				students.add(new String[]{cursor.getInt(0)+"",cursor.getString(1),cursor.getInt(2)+""});
			} while (cursor.moveToNext());
		}

		return students;
	}

	public int update(String[] student) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("name", student[1]);
		values.put("age", student[2]);

		return db.update("student", values, " regno= ?",
				new String[] { student[0]+"" });
	}

	public void delete(int regno) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete("student", "regno = ?",
				new String[] { regno+"" });
		db.close();
	}

}
