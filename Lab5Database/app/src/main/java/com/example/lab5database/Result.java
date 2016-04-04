package com.example.lab5database;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends Activity {
	EditText regno, name, age;
	Button action;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		regno = (EditText) findViewById(R.id.regno);
		name = (EditText) findViewById(R.id.name);
		age = (EditText) findViewById(R.id.age);
		action = (Button) findViewById(R.id.action);

		String action = getIntent().getExtras().getString("action");
		final DatabaseHandler db = new DatabaseHandler(this);
		if (action.equals("insert")) {
			this.action.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if (regno.length() == 0)
						regno.setError("this field is required!");
					else {
						db.insert(Integer.parseInt(regno.getText().toString()),
								name.getText().toString(),
								Integer.parseInt(age.getText().toString()));
						Toast.makeText(getApplicationContext(),
								"Successfully inserted!", Toast.LENGTH_LONG)
								.show();
					}
				}
			});
		} else if (action.equals("select")) {
			name.setVisibility(View.GONE);
			age.setVisibility(View.GONE);
			this.action.setText("select");

			this.action.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if (regno.length() == 0)
						regno.setError("Enter a registration no!");
					else {
						String[] data = db.select(Integer.parseInt(regno
								.getText().toString()));
						TextView result = new TextView(Result.this);
						if (data.length < 3)
							Toast.makeText(getApplicationContext(),
									"does not exist!", Toast.LENGTH_SHORT)
									.show();
						else
							result.setText("REGISTRATION NUMBER : " + data[0]
									+ "\nNAME : " + data[1] + "\nAGE : "
									+ data[2]);
						result.setGravity(Gravity.CENTER);
						LinearLayout res = (LinearLayout) findViewById(R.id.result);
						res.addView(result);
					}
				}
			});
		} else if (action.equals("selectall")) {
			regno.setVisibility(View.GONE);
			name.setVisibility(View.GONE);
			age.setVisibility(View.GONE);
			this.action.setVisibility(View.GONE);

			LinearLayout res = (LinearLayout) findViewById(R.id.result);
			List<String[]> dataSet = db.selectAll();
			for (int i = 0; i < dataSet.size(); i++) {
				TextView result = new TextView(Result.this);
				String[] data = dataSet.get(i);
				result.setText("REGISTRATION NUMBER : " + data[0] + "\nNAME : "
						+ data[1] + "\nAGE : " + data[2]);
				result.setGravity(Gravity.CENTER);
				res.addView(result);
			}
		} else if (action.equals("update")) {
			this.action.setText("update");
			this.action.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if (regno.length() == 0)
						regno.setError("Enter a registration no!");
					else {
						db.update(new String[] { regno.getText().toString(),
								name.getText().toString(),
								age.getText().toString() });
						Toast.makeText(getApplicationContext(),
								"Successfully updated!", Toast.LENGTH_LONG)
								.show();
					}
				}
			});
		} else if (action.equals("delete")) {
			name.setVisibility(View.GONE);
			age.setVisibility(View.GONE);
			this.action.setText("delete");
			
			this.action.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (regno.length() == 0)
						regno.setError("Enter a registration no!");
					else {
						db.delete(Integer.parseInt(regno.getText().toString()));
						Toast.makeText(getApplicationContext(),
								"Successfully deleted!", Toast.LENGTH_LONG)
								.show();
					}
				}
			});						
		}
	}
}
