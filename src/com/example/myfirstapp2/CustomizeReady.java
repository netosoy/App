package com.example.myfirstapp2;


import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class CustomizeReady extends Activity {
	
	int[] ImagesDetails = new int[]{R.array.LVbox_details, R.array.trns_details, R.array.MVbox_details, R.array.canliz_details};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customize_ready);
		
		// Get the extra data for intent for recognize button pressed
		Bundle prevActivity = getIntent().getExtras();
		final int selected = prevActivity.getInt(SelectTopology.BUTTON_ID);
		final int index = prevActivity.getInt(SelectTopology.TOPOLOGY_ID);
		
		// Find Layout and configure parameters
		ImageButton lowDetailView = (ImageButton) findViewById(R.id.lowDetailView);
		
		// Get list for image resources
		TypedArray imgsResources = getResources().obtainTypedArray(ImagesDetails[selected-1]);
		
		// Set selected topology resource
		lowDetailView.setImageResource(imgsResources.getResourceId(index-1,-1));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.customize_ready, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void viewDetails(View view){
		Intent otherIntent = new Intent(this, ViewDetails.class);
		startActivity(otherIntent);		
	}
}
