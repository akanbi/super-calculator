package com.supercalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void calculate(View view) {
		String number1 = getValueFromEditText(R.id.activity_main_number1);
		String number2 = getValueFromEditText(R.id.activity_main_number2);
		if (validateFields(number1, number2)) {
			int result = Integer.parseInt(number1) + Integer.parseInt(number2);
			Intent intent = new Intent(this, ResultActivity.class);
			intent.putExtra(ResultActivity.NUMBER1, number1);
			intent.putExtra(ResultActivity.NUMBER2, number2);
			intent.putExtra(ResultActivity.RESULT, Integer.valueOf(result).toString());
			startActivity(intent);
		}
	}
	
	private boolean validateFields(String fieldValue1, String fieldValue2) {
		if (fieldValue1.equals("") || fieldValue2.equals("")) {
			new AlertDialog.Builder(this).setMessage("Por favor, preencha os dois campos.").setNegativeButton("Ok", this).show();
			return false;
		} else {
			return true;
		}
	}
	
	private String getValueFromEditText(int id) {
		EditText editText = (EditText) findViewById(id);
		return editText.getText().toString();
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
	}
}
