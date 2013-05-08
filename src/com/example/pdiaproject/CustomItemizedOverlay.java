package com.example.pdiaproject;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class CustomItemizedOverlay extends ItemizedOverlay <OverlayItem>{

	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private Context context;
	
	public CustomItemizedOverlay( Context context, Drawable defaultMarker )
	{
		super( boundCenterBottom( defaultMarker ) );
		this.context = context;
	}
	
	public void addOverlay( OverlayItem overlay )
	{
		this.mOverlays.add(overlay);
		populate();
	}
	
	@Override
	protected OverlayItem createItem( int i ){
		return this.mOverlays.get(i);				
	}
	
	@Override
	public int size(){
		return this.mOverlays.size();
	}
	
	protected boolean onTap( int index )
	{
		OverlayItem item = this.mOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}
}
