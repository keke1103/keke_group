package com.groupkk.ceke.adapter;

import java.util.ArrayList;

import com.groupkk.ceke.R;
import com.groupkk.ceke.util.MyApplyRecordData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyApplyRecordBaseAdapter extends BaseAdapter {
	ArrayList<MyApplyRecordData> list;
	Context context;
	LayoutInflater inflater;

	public MyApplyRecordBaseAdapter(ArrayList<MyApplyRecordData> list, Context context) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	public MyApplyRecordBaseAdapter() {
		// TODO Auto-generated constructor stub
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.my_apply_record_layout_main, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) convertView.findViewById(R.id.my_apply_record_layout_image);
			holder.textView1 = (TextView) convertView.findViewById(R.id.my_apply_record_layout_text1);
			holder.textView2 = (TextView) convertView.findViewById(R.id.my_apply_record_layout_text2);
			holder.textView3 = (TextView) convertView.findViewById(R.id.my_apply_record_layout_text3);
			holder.textView4 = (TextView) convertView.findViewById(R.id.my_apply_record_layout_text4);
			holder.textView5 = (TextView) convertView.findViewById(R.id.my_apply_record_layout_text5);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		MyApplyRecordData data = list.get(position);
		holder.imageView.setImageResource(data.getImageID());
		holder.textView1.setText(data.getName());
		holder.textView2.setText("" + data.getResidueDay());
		if (data.getResidueDay() > 3) {
			holder.textView2.setTextColor(context.getResources().getColor(R.color.main_text_gray));
		} else {
			holder.textView2.setTextColor(context.getResources().getColor(R.color.main_orange));
		}
		holder.textView3.setText(data.getChairName());
		holder.textView4.setText(data.getChairTime());
		if (data.getAccept()==1) {
			holder.textView5.setText("已受理");
			holder.textView5.setTextColor(context.getResources().getColor(R.color.auxiliary_green_));
		} else if(data.getAccept()==-1){
			holder.textView5.setText("未受理");
			holder.textView5.setTextColor(context.getResources().getColor(R.color.main_red));
		}else{
			holder.textView5.setText("");
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
