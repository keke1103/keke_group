package com.groupkk.ceke;

import java.util.ArrayList;

import com.groupkk.ceke.adapter.CircleClassifyBaseAdapter;
import com.groupkk.ceke.fragment.CircleClassifyData;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CircleClassifyActivity extends Activity {
	ListView listView;
	ArrayList<CircleClassifyData> list;
	CircleClassifyBaseAdapter circleClassifyBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.circle_classify_main);
		listView = (ListView) findViewById(R.id.circle_classify_list);
		getData();
		circleClassifyBaseAdapter = new CircleClassifyBaseAdapter(list, this);
		listView.setAdapter(circleClassifyBaseAdapter);

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
