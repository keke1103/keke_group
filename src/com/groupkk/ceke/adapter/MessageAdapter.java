package com.groupkk.ceke.adapter;

import java.util.List;
import java.util.Map;

import com.groupkk.ceke.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MessageAdapter extends BaseAdapter {
	Context context;
	LayoutInflater inflater;
	List<Map<String, String>> list;

	public MessageAdapter() {
		// TODO Auto-generated constructor stub
	}

	public MessageAdapter(Context context, List<Map<String, String>> list) {
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	public void setData(List<Map<String, String>> list) {
		this.list = list;
		this.notifyDataSetChanged();
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
			convertView = inflater.inflate(R.layout.list_view_message, null);
			holder = new ViewHolder();
			holder.Information = (TextView) convertView.findViewById(R.id.text_message_list_message);
			holder.time = (TextView) convertView.findViewById(R.id.text_message_list_time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.Information.setText(list.get(position).get("message"));
		holder.time.setText(list.get(position).get("time"));
		return convertView;
	}

	class ViewHolder {
		TextView Information;
		TextView time;
	}
}
