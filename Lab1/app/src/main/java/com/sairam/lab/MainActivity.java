package com.sairam.lab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
EditText username,password;
Button login;
TextView heading;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Drawable d=new ColorDrawable(0xff2196f3);
		this.getActionBar().setBackgroundDrawable(d);
		
		username=(EditText)findViewById(R.id.user);
		password=(EditText)findViewById(R.id.password);
		login=(Button)findViewById(R.id.login);
		heading=(TextView)findViewById(R.id.heading);
		
		//to use custom font like I do in the following 2 lines 
		//download ttf file from internet and put it under assets folder.
		//create assets folder as a direct child of your project, before copying.
		Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/Open Sans.ttf");
		heading.setTypeface(customFont);		
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(username.getText().toString().equals("student") && password.getText().toString().equals("cse")) {
					Intent i = new Intent(getApplicationContext(),Gui.class);
					startActivity(i);
					finish();
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
