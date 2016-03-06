package com.groupkk.ceke.fragment;

import com.groupkk.ceke.MyApplyRecordActivity;
import com.groupkk.ceke.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * 个人中心的Fragment
 * 
 * @author Administrator
 *
 */
public class PersonalCenterFragment extends Fragment {

	View mView;
	ImageView userIcon;
	View loginBtn;
	TextView userName;
	TextView userPhone;
	TextView subscribe_num;
	TextView acceptance_succeed_num;
	TextView posted_num;
	View apply_record;
	View posts;
	View collect;
	private OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.personal_center_apply_record_layout:
				Intent intent = new Intent(getActivity(), MyApplyRecordActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}

		}
	};

	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LinearLayout linearLayout = new LinearLayout(getActivity());
		LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		linearLayout.setLayoutParams(layoutParams);
		mView = inflater.inflate(R.layout.fragment_personal_layout, linearLayout, true);
		findView();
		initView();
		return mView;
	}

	private void findView() {
		userIcon = (ImageView) mView.findViewById(R.id.personal_center_default_user);
		loginBtn = mView.findViewById(R.id.user_login);
		userName = (TextView) mView.findViewById(R.id.user_name);
		userPhone = (TextView) mView.findViewById(R.id.user_phone);
		subscribe_num = (TextView) mView.findViewById(R.id.personal_center_subscribe_num);
		acceptance_succeed_num = (TextView) mView.findViewById(R.id.personal_center_acceptance_succeed_num);
		posted_num = (TextView) mView.findViewById(R.id.personal_center_posted_num);
		apply_record = mView.findViewById(R.id.personal_center_apply_record_layout);
		posts = mView.findViewById(R.id.personal_center_posts_layout);
		collect = mView.findViewById(R.id.personal_center_collect_layout);
	}

	private void initView() {
		apply_record.setOnClickListener(click);

	}

}
