package com.groupkk.ceke;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class CompanyDetailActivity extends Activity {
	View back;
	TextView title;
	ImageView logoView;
	TextView nameView;
	TextView telView;
	TextView adressView;
	TextView orderView; // 预约
	RatingBar ratingbar;
	LinearLayout mClassLayout;
	TextView companyIntroduction;// 公司介绍

	private OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_back:
				finish();
				break;

			default:
				break;
			}

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jigou_details);
		findView();
		init();
		back.setOnClickListener(click);
	}

	private void findView() {
		back = findViewById(R.id.title_back);
		back.setVisibility(View.VISIBLE);
		title = (TextView) findViewById(R.id.title_text);
		title.setText("机构详情");
		logoView = (ImageView) findViewById(R.id.ji_gou_logo);
		nameView = (TextView) findViewById(R.id.jiGouName);
		telView = (TextView) findViewById(R.id.jiGouTelPhone);
		adressView = (TextView) findViewById(R.id.jiGouAdress);
		orderView = (TextView) findViewById(R.id.jigou_order);
		ratingbar = (RatingBar) findViewById(R.id.jigou_ratingBar);
		mClassLayout = (LinearLayout) findViewById(R.id.jiGou_class_layout);
		companyIntroduction = (TextView) findViewById(R.id.company_introduction);
	}

	@SuppressLint("InflateParams")
	private void init() {
		View v = getLayoutInflater().inflate(R.layout.my_apply_record_layout_main, null);
		v.findViewById(R.id.my_apply_record_layout_text5).setVisibility(View.GONE);
		mClassLayout.addView(v);
		v = getLayoutInflater().inflate(R.layout.my_apply_record_layout_main, null);
		mClassLayout.addView(v);
		v.findViewById(R.id.my_apply_record_layout_text5).setVisibility(View.GONE);
	}
}
