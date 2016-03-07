package com.groupkk.ceke;

import java.util.ArrayList;

import com.groupkk.ceke.adapter.CircleClassifyBaseAdapter;
import com.groupkk.ceke.fragment.CircleClassifyData;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class CircleClassifyActivity extends Activity {
	ListView listView;
	ArrayList<CircleClassifyData> list;
	CircleClassifyBaseAdapter circleClassifyBaseAdapter;
	View back;
	View ball;
	private OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_back:
				finish();
				break;
			case R.id.fab:
				Toast.makeText(getApplicationContext(), "insert", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.circle_classify_main);
		findView();
		initView();
		getData();
		circleClassifyBaseAdapter = new CircleClassifyBaseAdapter(list, this);
		listView.setAdapter(circleClassifyBaseAdapter);

	}

	private void findView() {
		back = findViewById(R.id.title_back);
		ball = findViewById(R.id.fab);

		listView = (ListView) findViewById(R.id.circle_classify_list);
	}

	private void initView() {
		back.setOnClickListener(click);
		ball.setOnClickListener(click);
	}

	public void getData() {
		list = new ArrayList<CircleClassifyData>();
		for (int i = 0; i < 4; i++) {
			CircleClassifyData circleClassifyData = new CircleClassifyData();
			circleClassifyData.setCircle_classify_creation_name("sadads" + i);
			circleClassifyData.setCircle_classify_cultrue("sdf" + i);
			circleClassifyData.setCircle_classify_last_time("456" + i);
			circleClassifyData.setCircle_classify_name("feng" + i);
			circleClassifyData.setCircle_classify_number("2465" + i);
			list.add(circleClassifyData);
		}
	}
}
