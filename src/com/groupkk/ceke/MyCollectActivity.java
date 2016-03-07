package com.groupkk.ceke;

import java.util.ArrayList;

import com.groupkk.ceke.adapter.MyCollectBaseAdapter;
import com.groupkk.ceke.util.MyCollectData;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class MyCollectActivity extends Activity {
	ListView listView;
	ArrayList<MyCollectData> list;
	MyCollectBaseAdapter myCollectBaseAdapter;

	View back;
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
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_collect_main);
		back = findViewById(R.id.title_back);
		back.setOnClickListener(click);
		listView = (ListView) findViewById(R.id.my_collect_listview);
		getData();
		myCollectBaseAdapter = new MyCollectBaseAdapter(list, this);
		listView.setAdapter(myCollectBaseAdapter);
	}

	public void getData() {
		list = new ArrayList<MyCollectData>();
		for (int i = 0; i < 5; i++) {
			MyCollectData data = new MyCollectData();
			data.setImageID(R.drawable.ic_launcher);
			data.setName("二胡十段兴趣班");
			data.setCompanyName("渝中汉昌");
			data.setApplyNumber(i + 12);
			data.setYueqi("乐器");
			data.setGrade("小学");
			data.setApplyTime(i + 1);
			list.add(data);
		}
	}
}
