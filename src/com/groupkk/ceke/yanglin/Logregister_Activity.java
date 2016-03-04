package com.groupkk.ceke.yanglin;

import com.groupkk.ceke.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Logregister_Activity extends Activity {
	ImageView iv_back;
	Button register, login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_login);
		iv_back = (ImageView) findViewById(R.id.iv_back);
		register = (Button) findViewById(R.id.tv_fast_register);
		login = (Button) findViewById(R.id.tv_login);
		iv_back.setOnClickListener(listener);
		register.setOnClickListener(listener);
		login.setOnClickListener(listener);
	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.iv_back:

				break;

			case R.id.tv_fast_register:

				break;
			case R.id.tv_login:

				break;
			}
		}
	};
}
