package com.sairam.lab;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;

public class Gui extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Drawable d=new ColorDrawable(0xff2196f3);
		this.getActionBar().setBackgroundDrawable(d);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gui);
	}	

}
