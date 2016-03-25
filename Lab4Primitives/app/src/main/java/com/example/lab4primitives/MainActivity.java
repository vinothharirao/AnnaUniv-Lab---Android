package com.example.lab4primitives;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
LinearLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ll=(LinearLayout)findViewById(R.id.ll);

        findViewById(R.id.line).setOnClickListener(this);
        findViewById(R.id.circle).setOnClickListener(this);
        findViewById(R.id.ellipse).setOnClickListener(this);
        findViewById(R.id.rectangle).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

    @Override
    public void onClick(View v) {
        ll.removeAllViews();
        ll.addView(new DrawPrimitive(getApplicationContext(), ((TextView)findViewById(v.getId())).getText().toString() ));
    }
}
