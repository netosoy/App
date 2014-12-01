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

public class SelectTopology extends Activity {
	
	public final static String BUTTON_ID = "com.example.myfirstapp2.ELEMENT";
	public final static String TOPOLOGY_ID = "com.example.myfirstapp2.TOPOLOGY";
	
	int[] numberOfBtns = new int[]{5,2,4,5};
	int[] ImagesArrays = new int[]{R.array.LVboxes_imgs, R.array.trns_imgs, R.array.MVboxes_imgs, R.array.canliz_imgs};
	
	LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
			LinearLayout.LayoutParams.WRAP_CONTENT, 
			LinearLayout.LayoutParams.WRAP_CONTENT);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.activity_select_topology);
		
		// Get the extra data for intent for recognize button pressed
		Bundle prevActivity = getIntent().getExtras();
		final int selected = prevActivity.getInt(SelectElementActivity.BUTTON_ID);
		
		// Find Layout and configure parameters
		LinearLayout btnsLayout = (LinearLayout) findViewById(R.id.topologyBtnLayout);
		btnsLayout.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
		
		// Create array of buttons, and get list for image resources
		final ImageButton btns[] = new ImageButton[numberOfBtns[selected-1]];
		TypedArray imgsResources = getResources().obtainTypedArray(ImagesArrays[selected-1]);
		
		for(int i=0; i< btns.length; i++){
			
			final int Index = i;
			btns[Index] = new ImageButton(this);
			btns[Index].setLayoutParams(params);
			btns[Index].setImageResource(imgsResources.getResourceId(i,-1));
			btnsLayout.addView(btns[Index]);
			btns[Index].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(btns[Index].getId() == ((ImageButton) v).getId()){
					Intent nextActivity = new Intent(SelectTopology.this, CustomizeReady.class);
					nextActivity.putExtra(TOPOLOGY_ID,(Index+1)); 	//Indicator of pressed button
					nextActivity.putExtra(BUTTON_ID,selected);		//Indicator of topology
					startActivity(nextActivity);
					}
				}
			});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fisrt_element, menu);
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
	public void goBack(View view){
		finish();
	}
	
	public void customElemet(View view){
		Intent intent = new Intent(this, CustomizeTopology.class);
		startActivity(intent);
	}
}
