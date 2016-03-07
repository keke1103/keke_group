package com.groupkk.ceke;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PersonalInformationActivity extends Activity {
	RelativeLayout relativeLayout;
	AlertDialog alertDialog;
	Builder builder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_information_main);
		relativeLayout = (RelativeLayout) findViewById(R.id.personal_information_relativelayout);
		relativeLayout.setOnClickListener(clickListener);
		builder = new AlertDialog.Builder(this);
		alertDialog = builder.create();
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			getDialog();
		}
	};

	public void getDialog() {
		LinearLayout linearLayout = new LinearLayout(this); // 定义的线性布局
		LayoutParams layoutParams = new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT); // 定义控件的宽、高
		linearLayout.setLayoutParams(layoutParams);
		linearLayout.setOrientation(1);

		TextView textView = new TextView(this);
		textView.setText("拍照");
		textView.setLayoutParams(layoutParams);
		textView.setGravity(Gravity.CENTER);
		linearLayout.addView(textView);

		TextView textView1 = new TextView(this);
		textView1.setText("从相册选择");
		textView1.setLayoutParams(layoutParams);
		textView1.setGravity(Gravity.CENTER);
		linearLayout.addView(textView1);

		View view = new View(this);

		TextView textView2 = new TextView(this);
		textView2.setText("取消");
		textView2.setLayoutParams(layoutParams);
		textView2.setGravity(Gravity.CENTER);
		linearLayout.addView(textView2);

		alertDialog.setView(linearLayout);
		alertDialog.show();
	}
}
