package receiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.pastel.mylocker.ActivityLock;

public class lockScreenReeiver extends BroadcastReceiver  {
	 public static boolean wasScreenOn = true;

	@Override
	public void onReceive(Context context, Intent intent) {

	    if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
        	        	wasScreenOn=false;
        	        	Intent intent11 = new Intent(context,ActivityLock.class);
        	        	intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	        	//context.startActivity(intent11);
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
        	Log.d("BROAD_CAST","SCREEN_ON");
        	wasScreenOn=true;
        	Intent intent11 = new Intent(context,ActivityLock.class);
        	intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	context.startActivity(intent11);
        }
       else if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
        	Intent intent11 = new Intent(context,ActivityLock.class);
        	intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           context.startActivity(intent11);
       }
    }
}
