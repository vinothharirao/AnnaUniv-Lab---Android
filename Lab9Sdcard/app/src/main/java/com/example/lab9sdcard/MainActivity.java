package com.example.lab9sdcard;
/**
 * Created by Vinoth Harirao on 29/10/2015
 */
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button save, discard;
	EditText name, content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		save = (Button) findViewById(R.id.save);
		discard = (Button) findViewById(R.id.cancel);
		name = (EditText) findViewById(R.id.filename);
		content = (EditText) findViewById(R.id.contents);
		
		discard.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				content.setText("");
			}
		});

		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (save.getText().toString().toLowerCase().equals("save")) {
					saveFile(name.getText().toString(), content.getText()
							.toString());
				} else {
					fetchFile(name.getText().toString());
				}
			}
		});

	}
	public void fetchFile(String name) {
		File sdCard = Environment.getExternalStorageDirectory();
		File dir = new File(sdCard.getAbsolutePath() + "/AndroidLab");
		dir.mkdirs();
		File file = new File(dir, name);

		try {
			DataInputStream din = new DataInputStream(new FileInputStream(file));
			String contents = "",temp;
			while((temp=din.readLine())!=null) {
				contents += temp+"\n";
			}
			this.content.setText(contents);
			this.content.setTextColor(0xff000000);
			this.content.setFocusable(true);
			this.content.setFocusableInTouchMode(true);
			this.content.setClickable(true);
			this.content.setGravity(Gravity.LEFT);
			save.setText("Save");
			
		}catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(getApplicationContext(), "File Not Found!",Toast.LENGTH_LONG).show();
			this.content.setText("File Not Found!");
			this.content.setTextColor(0xfff44336);
			this.content.setFocusable(true);
			this.content.setFocusableInTouchMode(true);
			this.content.setClickable(true);
			this.content.setGravity(Gravity.LEFT);
			this.save.setText("Save");
		}
	}

	public void saveFile(String name, String contents) {
		File sdCard = Environment.getExternalStorageDirectory();
		File dir = new File(sdCard.getAbsolutePath() + "/AndroidLab");
		dir.mkdirs();
		File file = new File(dir, name);

		try {
			FileOutputStream f = new FileOutputStream(file);
			f.write(contents.getBytes());
			Toast.makeText(getApplicationContext(), "File saved!",
					Toast.LENGTH_LONG).show();
			this.content
					.setText("Your File has been saved to sdcard successfully. \nTo view the contents you can either "
							+ "check manually under the directory /sdCard/AndroidLab/ \n"
							+ name + " or\n click edit below.");
			this.content.setGravity(Gravity.CENTER_HORIZONTAL);
			this.content.setTextColor(0xff00bcd4);
			this.content.setFocusable(false);
			this.content.setFocusableInTouchMode(false);
			this.content.setClickable(false);
			save.setText("Edit");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(getApplicationContext(), "save failed!",
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}

	}

}
