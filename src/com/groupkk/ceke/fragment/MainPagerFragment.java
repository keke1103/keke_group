package com.groupkk.ceke.fragment;

import com.groupkk.ceke.R;
import com.groupkk.ceke.view.MainItemView;
import com.groupkk.ceke.view.MainItemView.ClassData;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainPagerFragment extends Fragment {

	View mView;
	/**
	 * 广告视图
	 */
	View title_advertisement;
	/**
	 * 地理位置按钮
	 */
	TextView left_text_view;
	/**
	 * 搜索编辑框
	 */
	EditText search_edit;
	/**
	 * 搜索图标
	 */
	View search_icon;
	/**
	 * 用户提示点
	 */
	View user_hint;

	LinearLayout class_main_layout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		LinearLayout mLa = new LinearLayout(getActivity());
		mLa.setLayoutParams(new LayoutParams(-1, -1));
		mView = inflater.inflate(R.layout.fragment_mainpager, mLa);
		initView();

		return mView;
	}

	private void initView() {
		title_advertisement = mView.findViewById(R.id.title_advertisement);
		left_text_view = (TextView) mView.findViewById(R.id.left_text_view);
		search_edit = (EditText) mView.findViewById(R.id.search_edit);
		search_icon = mView.findViewById(R.id.search_icon_);
		user_hint = mView.findViewById(R.id.user_hint);
		class_main_layout = (LinearLayout) mView.findViewById(R.id.class_main_layout);

		
		class_main_layout.addView(setClassTypeAndData());
		class_main_layout.addView(setClassTypeAndData());
		class_main_layout.addView(setClassTypeAndData());
		
	}

	
	private View setClassTypeAndData(){
		
		MainItemView itemView = new MainItemView(getActivity());
		ClassData mData = new ClassData(null, getString(R.string.erhu), 2, getString(R.string.company), "乐器", "小学", 5);
		ClassData[] datas = new ClassData[4];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = mData;
		}
		itemView.setClassData(datas);
		return itemView.getContentView();
		
	}
}
