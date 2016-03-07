package com.groupkk.ceke;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ClassDetailActivity extends Activity {
	View back;
	TextView title;
	View share;
	TextView companyNameView;
	/**
	 * 预约 显示数字
	 */
	TextView orderView;
	RatingBar ratingBar;
	CheckBox collectView;
	TextView classNameView;
	TextView classAdressView;
	TextView classTimeView;
	ImageView classImageView;
	TextView classDetails;
	View joinBtn;

	Intent mIntent;
	private OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_back_class:
				finish();
				break;
			case R.id.company_title:
				mIntent.setClass(getApplicationContext(), CompanyDetailActivity.class);
				startActivity(mIntent);
				break;
			case R.id.join_class:
				mIntent.setClass(getApplicationContext(), MusicClassActivity.class);
				startActivity(mIntent);
				break;
			default:
				break;
			}

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_class_detail);
		mIntent = getIntent();
		findView();
		back.setOnClickListener(click);
		companyNameView.setOnClickListener(click);
		joinBtn.setOnClickListener(click);
	}

	private void findView() {
		back = findViewById(R.id.title_back_class);
		title = (TextView) findViewById(R.id.title_class_detail);
		share = findViewById(R.id.title_share);
		title.setText(mIntent.getStringExtra("className"));

		companyNameView = (TextView) findViewById(R.id.company_title);
		orderView = (TextView) findViewById(R.id.order_text);
		ratingBar = (RatingBar) findViewById(R.id.jigou_ratingBar_c);
		collectView = (CheckBox) findViewById(R.id.class_is_collect);

		classNameView = (TextView) findViewById(R.id.class_events_title);
		classAdressView = (TextView) findViewById(R.id.class_events_adress);
		classTimeView = (TextView) findViewById(R.id.class_events_time);
		classImageView = (ImageView) findViewById(R.id.class_image);
		classDetails = (TextView) findViewById(R.id.class_detail);
		joinBtn = findViewById(R.id.join_class);
	}

}
