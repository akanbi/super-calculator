package com.supercalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultActivity extends ActionBarActivity {

	public static final String NUMBER1 = "com.supercalculator.number1";
	public static final String NUMBER2 = "com.supercalculator.number2";
	public static final String RESULT = "com.supercalculator.result";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		TextView textView = (TextView) findViewById(R.id.activity_result_text);
		String number1 = getIntent().getStringExtra(NUMBER1);
		String number2 = getIntent().getStringExtra(NUMBER2);
		String result = getIntent().getStringExtra(RESULT);
		textView.setText("Resultado: " + number1 + " + " + number2 + " = " + result + ".");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
