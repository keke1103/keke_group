package com.groupkk.ceke;

import java.util.ArrayList;

import com.groupkk.ceke.adapter.MyApplyRecordBaseAdapter;
import com.groupkk.ceke.util.MyApplyRecordData;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class MusicClassActivity extends Activity {
	View back;
	TextView title;
	View time_text;
	CheckBox timeBox;

	ListView classesView;
	ArrayList<MyApplyRecordData> list;
	MyApplyRecordBaseAdapter myApplyRecordBaseAdapter;

	private OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_back:
				finish();
				break;
			case R.id.time_check_text:
				timeBox.setChecked(!timeBox.isChecked());
				break;

			default:
				break;
			}

		}
	};

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_class);
		findView();
		init();
	}

	private void init() {
		back.setOnClickListener(click);
		time_text.setOnClickListener(click);
		getData();
		myApplyRecordBaseAdapter = new MyApplyRecordBaseAdapter(list, this);
		classesView.setAdapter(myApplyRecordBaseAdapter);

	}

	private void findView() {
		back = findViewById(R.id.title_back);
		title = (TextView) findViewById(R.id.title_text);
		title.setText("音乐类课程列表");
		time_text = findViewById(R.id.time_check_text);
		timeBox = (CheckBox) findViewById(R.id.time_box);
		classesView = (ListView) findViewById(R.id.list_mucis_class_interest);
	}

	public void getData() {
		list = new ArrayList<MyApplyRecordData>();
		for (int i = 0; i < 5; i++) {
			MyApplyRecordData data = new MyApplyRecordData();
			data.setName("上课一二");

			data.setImageID(R.drawable.ic_launcher);
			data.setChairTime("223天");
			data.setChairName("大大中国顾客");
			data.setResidueDay(i);
			list.add(data);
		}
	}
}
