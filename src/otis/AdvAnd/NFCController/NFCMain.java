package otis.AdvAnd.NFCController;

import java.io.File;

import org.apache.http.client.HttpClient;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentFilter;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class NFCMain extends Activity {

	NfcAdapter mNfcAdapter;
	TextView textView;
	PendingIntent mNfcPendingIntent;

	IntentFilter[] mNdefExchangeFilters;

	NdefMessage mNdefMessage;
	NdefMessage msgs[];
	NdefRecord msg;

	private FileUriCallback mFileUriCallback;


	// List of URIs to provide to Android Beam
	
	String transferFile = "ContactInfo";
   
    File requestFile = new File(this.getFilesDir(), transferFile);
    
    
    // Get a URI for the File and add it to the list of URIs
    
	/**
	 * Callback that Android Beam file transfer calls to get
	 * files to share
	 */
	private class FileUriCallback implements NfcAdapter.CreateBeamUrisCallback {

		public FileUriCallback() {

		}
		
		/**
		 * Create content URIs as needed to share with another device
		 */
		@Override
		public Uri[] createBeamUris(NfcEvent event) {
			// TODO Auto-generated method stub
			return null;
		}
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		

		// Android Beam file transfer is available, continue
		mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

		/*
		 * Instantiate a new FileUriCallback to handle requests for
		 * URIs
		 */
		mFileUriCallback = new FileUriCallback();

		// Set the dynamic callback for URI requests.
		mNfcAdapter.setBeamPushUrisCallback(mFileUriCallback,this);



	}
}
