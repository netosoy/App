package com.example.myfirstapp2;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SelectElementActivity extends Activity {
	
	public final static String BUTTON_ID = "com.example.myfirstapp2.MESSAGE";

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	    setContentView(R.layout.activity_select_element);
	    
	    Button CnlButton = (Button) findViewById(R.id.element1_btn);
	    Button MVButton = (Button) findViewById(R.id.element2_btn);
	    Button LVButton = (Button) findViewById(R.id.element_btn3);
	    Button TrnButton = (Button) findViewById(R.id.element_btn4);
	    
	    LVButton.setOnClickListener(new View.OnClickListener(){
	    	public void onClick(View v){
	    		Intent nextIntent = new Intent(SelectElementActivity.this, SelectTopology.class);
	    		startActivity(nextIntent.putExtra(BUTTON_ID, 1));
	    		}
	    	});
	    
	    TrnButton.setOnClickListener(new View.OnClickListener(){
	    	public void onClick(View v){
	    		Intent nextIntent = new Intent(SelectElementActivity.this, SelectTopology.class);
	    		startActivity(nextIntent.putExtra(BUTTON_ID, 2));
	    		}
	    	});
	    
	    MVButton.setOnClickListener(new View.OnClickListener(){
	    	public void onClick(View v){
	    		Intent nextIntent = new Intent(SelectElementActivity.this, SelectTopology.class);
	    		startActivity(nextIntent.putExtra(BUTTON_ID, 3));
	    		}
	    	});
	    
	    CnlButton.setOnClickListener(new View.OnClickListener(){
	    	public void onClick(View v){
	    		Intent nextIntent = new Intent(SelectElementActivity.this, SelectTopology.class);
	    		startActivity(nextIntent.putExtra(BUTTON_ID, 4));
	    		}
	    	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_elemet, menu);
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
	
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_display_message,
					container, false);
			return rootView;
		}
	}
}
