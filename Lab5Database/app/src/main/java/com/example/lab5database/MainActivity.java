package com.example.lab5database;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		((Button)findViewById(R.id.insert)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Result.class);
				i.putExtra("action", "insert");
				startActivity(i);
			}
		});
		((Button)findViewById(R.id.select)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Result.class);
				i.putExtra("action", "select");
				startActivity(i);
			}
		});
		((Button)findViewById(R.id.selectall)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Result.class);
				i.putExtra("action", "selectall");
				startActivity(i);
			}
		});
		((Button)findViewById(R.id.update)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Result.class);
				i.putExtra("action", "update");
				startActivity(i);
			}
		});
		((Button)findViewById(R.id.delete)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Result.class);
				i.putExtra("action", "delete");
				startActivity(i);
			}
		});
	}
}
