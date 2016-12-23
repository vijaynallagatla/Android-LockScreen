package com.pastel.mylocker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class SetPattern extends Activity implements OnItemSelectedListener {

	Spinner spnrNoPattern;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_pattern);
		spnrNoPattern=(Spinner)findViewById(R.id.spnrPattern);
		spnrNoPattern.setOnItemSelectedListener(this);
		
		List<String> categories = new ArrayList<String>();
		categories.add("1 Pattern");
		categories.add("2 Patterns");
		categories.add("3 Patterns");
		categories.add("4 Patterns");
		categories.add("5 Patterns");
		categories.add("6 Patterns");
		categories.add("7 Patterns");
		categories.add("8 Patterns");
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnrNoPattern.setAdapter(dataAdapter);
	}
	
	public void onItemSelected(AdapterView<?> parent,View view,int position,long id){
		
		Spinner spinner =(Spinner)parent;
		if(spinner.getId()==R.id.spnrPattern){
		String no_of_pattern=parent.getItemAtPosition(position).toString();
		if(position==2){
			Spinner sp1=new Spinner(this);
			
		}
		
		Toast.makeText(this, no_of_pattern, Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
