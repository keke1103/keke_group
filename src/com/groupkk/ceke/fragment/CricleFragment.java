package com.groupkk.ceke.fragment;

import java.util.ArrayList;

import com.groupkk.ceke.CircleClassifyActivity;
import com.groupkk.ceke.R;
import com.groupkk.ceke.adapter.CircleBaseAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;

/**
 * 圈子的Fragment
 * 
 * @author Administrator
 *
 */
public class CricleFragment extends Fragment {
	ListView cricleListView;
	CircleBaseAdapter circleBaseAdapter;
	ArrayList<CircleData> list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LinearLayout linearLayout = new LinearLayout(getActivity());
		LayoutParams layoutParams = new LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		linearLayout.setLayoutParams(layoutParams);
		View view = inflater.inflate(R.layout.fragment_circle_main, linearLayout, true);
		cricleListView = (ListView) view.findViewById(R.id.circle_list);
		getData();
		circleBaseAdapter = new CircleBaseAdapter(list, getActivity());
		cricleListView.setAdapter(circleBaseAdapter);
		cricleListView.setOnItemClickListener(clickListener);
		return view;
	}
	/**
	 * cricleListView的点击事件，跳转页面
	 */
	OnItemClickListener clickListener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(getActivity(),CircleClassifyActivity.class);
			startActivity(intent);
		}
	};

	public void getData() {
		list = new ArrayList<CircleData>();
		for (int i = 0; i < 4; i++) {
			CircleData data = new CircleData();
			data.setCircleName("第" + i + "的名字");
			data.setCircleCulture("文化");
			data.setPeopleNumber("42515" + i);
			list.add(data);
		}
	}
}
