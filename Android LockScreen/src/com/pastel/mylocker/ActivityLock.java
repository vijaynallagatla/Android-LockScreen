package com.pastel.mylocker;

import lib.gesture.SimpleGestureFilter;
import lib.gesture.SimpleGestureFilter.SimpleGestureListener;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.AnalogClock;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLock extends Activity implements SimpleGestureListener {

	  @SuppressWarnings("deprecation")
	 KeyguardManager.KeyguardLock k1;
	  @SuppressWarnings("unused")
	private SimpleGestureFilter detector;
	 TextView tv;
	 ImageView iv;
	 EditText edtPassword;
	 String passPattern="";
	 int count=0;
	 AnalogClock ac;
	
	 
	public void onCreate(Bundle savedInstanceState) {

    	   super.onCreate(savedInstanceState);
    	   //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_FULLSCREEN);

    	   setContentView(R.layout.activity_main);
    	  // this.setSystemUIEnabled(false);
    	   detector = new SimpleGestureFilter(this,this);
       	  /* if(getIntent()!=null&&getIntent().hasExtra("kill")&&getIntent().getExtras().getInt("kill")==1){
    	      // Toast.makeText(this, "" + "kill activityy", Toast.LENGTH_SHORT).show();
    	        	finish();
    	    	} */
       	   iv=(ImageView)findViewById(R.id.iv);
       	   edtPassword=(EditText)findViewById(R.id.edtPassword);
       	   iv.setImageResource(R.drawable.bg);
       	   tv=(TextView)findViewById(R.id.tv);
       	   ac=(AnalogClock)findViewById(R.id.analogClock1);
       	ac.setEnabled(true);
       	//ac.setPadding(300, 300, 300, 300);
       	ac.setScaleX(2);
       	ac.setScaleY(2);

        
      
        
        try{
        	  startService(new Intent(this,MyService.class));
        StateListener phoneStateListener = new StateListener();
        TelephonyManager telephonyManager =(TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        telephonyManager.listen(phoneStateListener,PhoneStateListener.LISTEN_CALL_STATE);
        }catch (Exception e) {
			// TODO: handle exception
		}
   }  
    @Override
    public boolean dispatchTouchEvent(MotionEvent me){
    	// Call onTouchEvent of SimpleGestureFilter class
         this.detector.onTouchEvent(me);
       return super.dispatchTouchEvent(me);
    }
    public void checkPattern(){
    	if(String.valueOf(passPattern).equals("1234")){
    		passPattern="";
    		finish();
    	}
    	else{
    		passPattern="";
    		edtPassword.setText(passPattern);
    		Toast.makeText(this,"Wrong Password",Toast.LENGTH_SHORT).show();
    	}
    }
    

    class StateListener extends PhoneStateListener{
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            super.onCallStateChanged(state, incomingNumber);
            switch(state){
                case TelephonyManager.CALL_STATE_RINGING:
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    System.out.println("call Activity off hook");
                	finish();
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    break;
            }
        }
    };
   
    @Override
    public void onBackPressed() {
        // Don't allow back to dismiss.
        return;
    }

    //only used in lockdown mode
    @Override
    protected void onPause() {
        super.onPause();

        // Don't hang around.
       // finish();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Don't hang around.
       // finish();
    }

   

    @Override
  public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {

    
       if((keyCode == KeyEvent.KEYCODE_HOME)){
    	  return true;
        }

	return super.onKeyDown(keyCode, event);

    }
    
    public void onUserLeaveHint(){
    	super.onUserLeaveHint();
    }

      public void onDestroy(){
       // k1.reenableKeyguard();

        super.onDestroy();
    }
    
   
    @Override
	 public void onSwipe(int direction) {
	  
	 
	  switch (direction) {
	 
	  case SimpleGestureFilter.SWIPE_RIGHT : //this.mRenderer.setRippleSize(96.0F);
	  											passPattern+="4";
	  											count++;
	                                            break;
	  case SimpleGestureFilter.SWIPE_LEFT :  
	  											passPattern+="3";
	  											count++;
	                                            break;
	  case SimpleGestureFilter.SWIPE_DOWN :		passPattern+="2";
	  											count++;
	                                            break;
	  case SimpleGestureFilter.SWIPE_UP :    
	  											passPattern+="1";
	  											count++;
	                                            break;
	  }
	  edtPassword.setText(passPattern);
	  if(count>=4){
		 
	   //Toast.makeText(this, String.valueOf(passPattern), Toast.LENGTH_SHORT).show();
	   count=0;
	   checkPattern();
	  }
    }
	 
	 @Override
	 public void onDoubleTap() {
	    Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
	 }
	
}