package otis.AdvAnd.shareme;

import java.util.ArrayList;
import java.util.List;

import otis.AdvAnd.DAO.User;
import otis.AdvAnd.DAO.UserData;
import otis.AdvAnd.NFCController.NFCMain;
import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheckUser extends Activity {
	
	
	String name;
	String mPhone;
	TextView checkUser;
	TextView checkPhone;
	User user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.check_main);
		
		
		// Obtain Bundle from last Activity
		Bundle B = getIntent().getExtras();
		name = B.getString("val1");
		mPhone = B.getString("val2");
		
		
		if (!NfcAdapter.getDefaultAdapter(this).isEnabled())
	    {
	        Toast.makeText(getApplicationContext(), "Please activate NFC and press Back to return to the application!", Toast.LENGTH_LONG).show();
	        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
	    }
		
		
		checkUser = (TextView) findViewById(R.id.Title);
		// set title to gmail account
		checkUser.setText(name);
		
		checkPhone = (TextView) findViewById(R.id.phoneTitle);
		checkPhone.setText(mPhone);
		
		
		Button begin = (Button) findViewById(R.id.Login);
		begin.setOnClickListener(handle);
		
	}
	
		View.OnClickListener handle = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// Iterate through information (not set yet)
			
			
			
			
			
			
			
		}

		
		
	};
}
