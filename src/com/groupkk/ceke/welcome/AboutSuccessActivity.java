package com.groupkk.ceke.welcome;

import com.groupkk.ceke.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutSuccessActivity extends Activity {
	View titleLayout;
	TextView title;
	View toReturn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_success);
		intiView();
	}

	private void intiView() {
		titleLayout = findViewById(R.id.about_success_include);
		title = (TextView) titleLayout.findViewById(R.id.title_text);
		toReturn = findViewById(R.id.title_back);
		toReturn.setVisibility(View.VISIBLE);
		title.setText(getString(R.string.about_success));
	}
}
