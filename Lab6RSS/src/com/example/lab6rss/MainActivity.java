package com.example.lab6rss;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	List headlines;
    List links;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy pol = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
		StrictMode.setThreadPolicy(pol);

		headlines = new ArrayList();
		links = new ArrayList();
		 
		try {
		    URL url = new URL("http://feeds.pcworld.com/pcworld/latestnews");
		 
		    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		    XmlPullParser xpp = factory.newPullParser();
		 
		    xpp.setInput(getInputStream(url), "UTF_8");
		
		    boolean insideItem = false;
		 
		    int eventType = xpp.getEventType();
		    while (eventType != XmlPullParser.END_DOCUMENT) {
		        if (eventType == XmlPullParser.START_TAG) {
		 
		            if (xpp.getName().equalsIgnoreCase("item")) {
		                insideItem = true;
		            } else if (xpp.getName().equalsIgnoreCase("title")) {
		                if (insideItem)
		                    headlines.add(xpp.nextText()); 
		            } else if (xpp.getName().equalsIgnoreCase("link")) {
		                if (insideItem)
		                    links.add(xpp.nextText()); 
		            }
		        }else if(eventType==XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")){
		            insideItem=false;
		        }
		 
		        eventType = xpp.next(); 
		    }
		} catch (MalformedURLException e) {
		    e.printStackTrace();
		} catch (XmlPullParserException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		 
		// Binding data
		ArrayAdapter adapter = new ArrayAdapter(this,
		        android.R.layout.simple_list_item_1, headlines);
		setListAdapter(adapter);
		
	}
	public InputStream getInputStream(URL url) {
		   try {
		       return url.openConnection().getInputStream();
		   } catch (IOException e) {
		       return null;
		     }
	}	
}
