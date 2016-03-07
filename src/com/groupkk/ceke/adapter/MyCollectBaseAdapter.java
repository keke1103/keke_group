package com.groupkk.ceke.adapter;

import java.util.ArrayList;

import com.groupkk.ceke.R;
import com.groupkk.ceke.util.MyCollectData;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCollectBaseAdapter extends BaseAdapter {
	ArrayList<MyCollectData> list;
	Context context;
	LayoutInflater inflater;

	public MyCollectBaseAdapter() {
		// TODO Auto-generated constructor stub
	}

	public MyCollectBaseAdapter(ArrayList<MyCollectData> list, Context context) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.my_collect_layout_main, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) convertView.findViewById(R.id.my_collect_image);
			holder.textView1 = (TextView) convertView.findViewById(R.id.my_collect_text1);
			holder.textView2 = (TextView) convertView.findViewById(R.id.my_collect_text2);
			holder.textView3 = (TextView) convertView.findViewById(R.id.my_collect_text3);
			holder.textView4 = (TextView) convertView.findViewById(R.id.my_collect_text4);
			holder.textView5 = (TextView) convertView.findViewById(R.id.my_collect_text5);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		MyCollectData data = list.get(position);
		holder.imageView.setImageResource(data.getImageID());
		holder.textView1.setText(data.getName());
		holder.textView2.setText("已报名" + data.getApplyNumber() + "人\t\t" + data.getCompanyName());
		holder.textView3.setText(data.getYueqi());
		holder.textView4.setText(data.getGrade());
		holder.textView5.setText("" + data.getApplyTime());
		if (data.getApplyTime() <= 3) {
			holder.textView5.setTextColor(context.getResources().getColor(R.color.main_orange));
		} else {
			holder.textView5.setTextColor(context.getResources().getColor(R.color.main_text_gray));
		}
		return convertView;
	}

	class ViewHolder {
		ImageView imageView;
		TextView textView1;
		TextView textView2;
		TextView textView3;
		TextView textView4;
		TextView textView5;
	}
}
