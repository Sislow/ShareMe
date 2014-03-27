package otis.AdvAnd.shareme;

import java.io.File;
import java.io.FileOutputStream;

import otis.AdvAnd.NFCController.NFCMain;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckUser extends Activity {

	
	String username;
	String name;
	String mPhone;
	TextView Number;
	TextView Email;
	EditText fillName;
	String filename = "ContactInfo";
	FileOutputStream outputStream;
	File file;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.check_main);
		
		file = new File(this.getFilesDir(), filename);
		System.out.println(this.getFilesDir().toString());
		
		Toast.makeText(CheckUser.this, "Collecting Your information...", Toast.LENGTH_LONG).show();
		
		
		fillName = (EditText) findViewById(R.id.Name);
		name = fillName.getText().toString();
		
		Number = (TextView) findViewById(R.id.Title);
		Email = (TextView) findViewById(R.id.phoneTitle);

		run();
		Button begin = (Button) findViewById(R.id.Login);
		begin.setOnClickListener(handle);
		
	}
	
	public void run(){
				
				// pulls gmail account
				final AccountManager manager = AccountManager.get(CheckUser.this);
				final Account[] accounts = manager.getAccountsByType("com.google");
				final int size = accounts.length;
				String[] names = new String[size];
				
				for (int i = 0; i < size; i++) {
				  names[i] = accounts[i].name;
				}
				
				//Pulls phone number
				TelephonyManager tMgr = (TelephonyManager) CheckUser.this.getSystemService(Context.TELEPHONY_SERVICE);
				mPhone = tMgr.getLine1Number();
				
				
				// print out to console to check
				System.out.println(names[0].toString());
				
				// Assign first account to string
				username = names[0].toString();
				
				Number.setText(mPhone);
				Email.setText(username);
	}
	
		View.OnClickListener handle = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			String string = name + "\n" + username + "\n" + mPhone;
			try {
				  outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
				  outputStream.write(string.getBytes());
				  outputStream.close();
				} catch (Exception e) {
				  e.printStackTrace();
				}
	
			
			
			if(file.exists()) {
				System.out.println("file.exists()");
				Intent share = new Intent(CheckUser.this, NFCMain.class);
				startActivity(share);
			}
			
			
		}

		
		
	};
}
