package com.example.myfirstapp2;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class CustomizeTopology extends Activity implements OnItemSelectedListener{
	
	private Spinner spinner1;
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp2.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.activity_customize_topology);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
    public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
    	//parent.getItemAtPosition(pos).toString();
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    
	public void addListenerOnSpinnerItemSelection(){
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setOnItemSelectedListener(this);
	}
	
	public void customizeReady(View view) {
	    Intent intent = new Intent(this, CustomizeReady.class);
	    spinner1 = (Spinner) findViewById(R.id.spinner1);
	    String message = spinner1.getSelectedItem().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);
	}
	
	public void goHome(View view){
		Intent goBack = new Intent(CustomizeTopology.this,MainActivity.class);
		goBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(goBack);	
	}

    
}
