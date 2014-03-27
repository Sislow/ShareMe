package otis.AdvAnd.shareme;


import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

	// RSA Key
	//9E:5F:97:2E:93:FE:FC:82:12:A9:34:9C:82:4F:D5:83

	//fList<User> Users = new UserData().getUser();
	
	
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
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch(item.getItemId()) {
	    case R.id.menu_item1:
	        Intent accountInfo = new Intent(this, SharedPref.class);
	        this.startActivity(accountInfo);
	        break;
	    case R.id.menu_item2:
	    	Intent settings = new Intent(this, CheckUser.class);
	        this.startActivity(settings);
	        break;
	    default:
	        return super.onOptionsItemSelected(item);
	    }

	    return true;
	}
	View.OnClickListener handle = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			Intent pref = new Intent(MainActivity.this, CheckUser.class);
			startActivity(pref);

		}
		
	};
	
	
		
		
		
	
	
}
