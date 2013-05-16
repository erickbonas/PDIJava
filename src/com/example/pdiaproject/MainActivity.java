package com.example.pdiaproject;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;



public class MainActivity extends Activity
{
	@Override
	public void onCreate( Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Bitmap map = getGoogleMapThumbnail(-23.564798,-46.735067);
		// Assign the bitmap to an ImageView in this layout
		ImageView view = (ImageView) findViewById(R.id.map_id);
		view.setImageBitmap(map);
		
	}
	
	public static Bitmap getGoogleMapThumbnail(double lati, double longi){
	    String URL = "http://maps.google.com/maps/api/staticmap?center=" +lati + "," + longi + "&zoom=15&size=640x640&sensor=false&scale=2";
	    Bitmap bmp = null;
	    HttpClient httpclient = new DefaultHttpClient();   
	    HttpGet request = new HttpGet(URL); 

	    InputStream in = null;
	    try {
	        in = httpclient.execute(request).getEntity().getContent();
	        bmp = BitmapFactory.decodeStream(in);
	        in.close();
	    } catch (IllegalStateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (ClientProtocolException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	    return bmp;
	}
}

