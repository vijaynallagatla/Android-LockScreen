package com.pastel.mylocker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

public class ActivitySettings extends Activity {
	Switch swtch;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_settings);
		
		try{
	        startService(new Intent(this,MyService.class));
	        
		}catch (Exception e) {
				// TODO: handle exception
			}
	}
	
		 @Override
	    public void onBackPressed() {
	        // Don't allow back to dismiss.
		 finish();
	        return;
	    }
		 
		 @Override
	public void onSaveInstanceState(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);
	}
		
		 @Override
	public void onRestoreInstanceState(Bundle savedInstanceState){
		super.onRestoreInstanceState(savedInstanceState);
	}

	public void startSetPattern(View view){
		Intent i=new Intent(this,SetPattern.class);
		startActivity(i);
	}
	
	public void setDefault(View view){
		swtch=(Switch)findViewById(R.id.switchSetDefault);
		if(swtch.isChecked()){
			swtch.setChecked(false);
		}else
		{
			swtch.setChecked(true);
		}
				
	}

	public void switchVibrate(View view){
		swtch=(Switch)findViewById(R.id.switchVibrate);
		if(swtch.isChecked()){
			swtch.setChecked(false);
		}else
		{
			swtch.setChecked(true);
		}
		
	}

	public void switchSound(View view){
		swtch=(Switch)findViewById(R.id.switchSound);
		if(swtch.isChecked()){
			swtch.setChecked(false);
		}else
		{
			swtch.setChecked(true);
		}
		
	}
}

