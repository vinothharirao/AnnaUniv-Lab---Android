package com.example.lab7multithreading;
/** 
 * Created by Vinoth Harirao on 28/10/2015 
 */
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
LinearLayout timers;
Button add;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		add = (Button)findViewById(R.id.add);
		timers = (LinearLayout)findViewById(R.id.timers);
		
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				createTimer();
			}
		});
	}
	public void createTimer() {
		TextView t = new TextView(getApplicationContext());
		t.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
		t.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
		t.setTextColor(0xff2196f3);
		t.setTextSize(19);
		t.setPadding(10, 10, 0, 10);
		t.setBackground(getResources().getDrawable(R.drawable.patch));
        t.setGravity(Gravity.CENTER);
		timers.addView(t);
		startTimer(t);
	}
	
	public void startTimer(final TextView mTextField) {
		new CountDownTimer(30000, 1000) {

		     public void onTick(long millisUntilFinished) {
		         mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
		     }

		     public void onFinish() {
		         mTextField.setText("done!");
		     }
		  }.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
