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

public class MyPostsAdapter extends BaseAdapter {
	List<Map<String, String>> list;
	Context context;
	LayoutInflater inflater;

	public MyPostsAdapter() {
		// TODO Auto-generated constructor stub
	}

	public MyPostsAdapter(Context context, List<Map<String, String>> list) {
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
			convertView = inflater.inflate(R.layout.list_posts_view, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.text_list_post_title);
			holder.time = (TextView) convertView.findViewById(R.id.text_list_post_time);
			holder.thumbsUp = (TextView) convertView.findViewById(R.id.text_list_post_thumbs_up);
			holder.comment = (TextView) convertView.findViewById(R.id.text_list_post_comment);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.title.setText(list.get(position).get("title"));
		holder.time.setText(list.get(position).get("time"));
		holder.thumbsUp.setText(list.get(position).get("thumbsUp"));
		holder.comment.setText(list.get(position).get("comment"));
		return convertView;
	}

	class ViewHolder {
		TextView title;
		TextView time;
		TextView thumbsUp;
		TextView comment;
	}
}
