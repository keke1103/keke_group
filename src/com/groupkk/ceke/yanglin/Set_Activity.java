package com.groupkk.ceke.yanglin;

import com.groupkk.ceke.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Set_Activity extends Activity {
	ImageView iv_back;
	Button exit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set);
		iv_back = (ImageView) findViewById(R.id.iv_back);
		exit = (Button) findViewById(R.id.btn_exitaccount);
		iv_back.setOnClickListener(listener);
		exit.setOnClickListener(listener);
	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.iv_back:

				break;

			case R.id.btn_exitaccount:

				break;
			}
		}
	};
}
