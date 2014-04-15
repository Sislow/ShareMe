package otis.AdvAnd.shareme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button NFCSent = (Button) findViewById(R.id.sendInfo);
		NFCSent.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent action = new Intent(MainActivity.this, NfcSend.class);
				startActivity(action);
			}
		});

	}
}
