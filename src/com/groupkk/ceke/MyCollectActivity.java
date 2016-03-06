package com.groupkk.ceke;

import java.util.ArrayList;

import com.groupkk.ceke.adapter.MyCollectBaseAdapter;
import com.groupkk.ceke.util.MyCollectData;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MyCollectActivity extends Activity {
	ListView listView;
	ArrayList<MyCollectData> list;
	MyCollectBaseAdapter myCollectBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_collect_main);
		listView = (ListView) findViewById(R.id.my_collect_listview);
		getData();
		myCollectBaseAdapter = new MyCollectBaseAdapter(list, this);
		listView.setAdapter(myCollectBaseAdapter);
	}

	public void getData() {
		list = new ArrayList<MyCollectData>();
		for (int i = 0; i < 3; i++) {
			MyCollectData data = new MyCollectData();
			data.setImageID(R.drawable.ic_launcher);
			data.setName("二胡十段兴趣班");
			data.setApplyNumber("已报1人  渝中汉昌");
			data.setYueqi("乐器");
			data.setGrade("小学");
			data.setApplyTime("余1天");
			list.add(data);
		}
	}
}
