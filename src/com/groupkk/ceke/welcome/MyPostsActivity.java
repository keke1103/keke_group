package com.groupkk.ceke.welcome;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.groupkk.ceke.R;
import com.groupkk.ceke.adapter.MyPostsAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MyPostsActivity extends Activity {
	ListView postsList;
	List<Map<String, String>> list;
	MyPostsAdapter myAdapter;
	View toReturn;
	View newPosts;
	View myTouch;
	RelativeLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_posts);
		list = new ArrayList<Map<String, String>>();
		findId();
		myTouch.setOnClickListener(clickListener);

		myAdapter = new MyPostsAdapter(getApplicationContext(), list);
		postsList.setAdapter(myAdapter);
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			switch (v.getId()) {
			case R.id.image_post_return:

				break;
			case R.id.image_posts_new:

				break;
			case R.id.view_touch:
				getData();
				postsList.setVisibility(View.VISIBLE);
				layout.setVisibility(View.GONE);
				break;

			default:
				break;
			}

		}
	};

	@SuppressLint("SimpleDateFormat")
	private void getData() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			Map<String, String> map = new HashMap<String, String>();

			map.put("title", "我是最好的高级UI设计师");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String time = format.format(new Date());
			map.put("time", time);

			map.put("thumbsUp", ((int) (Math.random() * 1000)) + "");
			map.put("comment", ((int) (Math.random() * 100)) + "");
			list.add(map);

			// Toast.makeText(getApplicationContext(), "123",
			// Toast.LENGTH_SHORT).show();
		}
	}

	private void findId() {
		// TODO Auto-generated method stub
		postsList = (ListView) findViewById(R.id.list_posts_list);
		toReturn = findViewById(R.id.image_post_return);
		newPosts = findViewById(R.id.image_posts_new);
		myTouch = findViewById(R.id.view_touch);
		layout = (RelativeLayout) findViewById(R.id.layout_posts_view);
	}
}
