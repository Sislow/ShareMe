package otis.AdvAnd.shareme;


import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

	// RSA Key
	//9E:5F:97:2E:93:FE:FC:82:12:A9:34:9C:82:4F:D5:83

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// if statement that checks for NFC being connected
		if (!NfcAdapter.getDefaultAdapter(this).isEnabled())
	    {
	        // directions on how to turn on NFC
			Toast.makeText(getApplicationContext(), "Please activate NFC and press Back to return to the application!", Toast.LENGTH_LONG).show();
	        // Openning NFC settings
			startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
	    }
		
	
		// Begins application from splash screen, will be taken to actual login after initial setup
		Button begin = (Button) findViewById(R.id.Login);
		begin.setOnClickListener(handle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	View.OnClickListener handle = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "Collecting Your information...", Toast.LENGTH_LONG).show();
			
			// pulls gmail account
			final AccountManager manager = AccountManager.get(MainActivity.this);
			final Account[] accounts = manager.getAccountsByType("com.google");
			final int size = accounts.length;
			String[] names = new String[size];
			for (int i = 0; i < size; i++) {
			  names[i] = accounts[i].name;
			}
			//Pulls phone number
			TelephonyManager tMgr = (TelephonyManager) MainActivity.this.getSystemService(Context.TELEPHONY_SERVICE);
			String mPhoneNumber = tMgr.getLine1Number();
			
			// print out to console to check
			System.out.println(names[0].toString());
			
			// Assign first account to string
			String username = names[0].toString();
			
			// Bundle information and passed to the class for checking by user
			Bundle B = new Bundle();
			B.putString("val1", username);
			B.putString("val2", mPhoneNumber);
			
			// Begin new activity and pass bundle
			Intent checkit = new Intent(getApplicationContext(), CheckUser.class);
			checkit.putExtras(B);
			startActivityForResult(checkit, 1);
		}
		
	};
	
	
		
		
		
	
	
}
