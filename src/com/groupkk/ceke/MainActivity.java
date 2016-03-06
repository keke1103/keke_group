package com.groupkk.ceke;

import java.util.ArrayList;

import com.groupkk.ceke.adapter.MainFragmentAdapter;
import com.groupkk.ceke.fragment.CricleFragment;
import com.groupkk.ceke.fragment.MainPagerFragment;
import com.groupkk.ceke.fragment.PersonalCenterFragment;
import com.groupkk.ceke.fragment.TypePagerFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

@SuppressLint("ResourceAsColor")
public class MainActivity extends FragmentActivity {

	RadioGroup bottomGroup;
	/**
	 * 0:首页 1：分类 2：圈子 3：我
	 */
	RadioButton[] bottomRadio;

	FragmentManager mFragmentManager;

	ViewPager mViewPager;
	MainFragmentAdapter pagerAdapter;
	ArrayList<Fragment> fragments;

	MainPagerFragment mainPagerFragment;
	TypePagerFragment typePagerFragment;
	CricleFragment mCricleFragment;
	PersonalCenterFragment personalCenterFragment;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mFragmentManager = getSupportFragmentManager();
		initView();
	}

	@SuppressWarnings("deprecation")
	private void initView() {
		bottomGroup = (RadioGroup) findViewById(R.id.bottom_group);
		bottomGroup.setOnCheckedChangeListener(bottomChange);
		mViewPager = (ViewPager) findViewById(R.id.layou_main);
		bottomRadio = new RadioButton[4];
		bottomRadio[0] = (RadioButton) findViewById(R.id.radio_main);
		bottomRadio[1] = (RadioButton) findViewById(R.id.radio_type);
		bottomRadio[2] = (RadioButton) findViewById(R.id.radio_friend);
		bottomRadio[3] = (RadioButton) findViewById(R.id.radio_me);

		mainPagerFragment = new MainPagerFragment();
		typePagerFragment = new TypePagerFragment();
		mCricleFragment = new CricleFragment();
		personalCenterFragment = new PersonalCenterFragment();
		fragments = new ArrayList<Fragment>();
		fragments.add(mainPagerFragment);
		fragments.add(typePagerFragment);
		fragments.add(mCricleFragment);
		fragments.add(personalCenterFragment);
		pagerAdapter = new MainFragmentAdapter(mFragmentManager, fragments);
		mViewPager.setAdapter(pagerAdapter);
		mViewPager.setOnPageChangeListener(pageChange);
		initRadiaoBut();
	}

	OnCheckedChangeListener bottomChange = new OnCheckedChangeListener() {

		public void onCheckedChanged(RadioGroup group, int checkedId) {
			initRadiaoBut();
		}
	};

	@SuppressWarnings("deprecation")
	private void initRadiaoBut() {
		for (int i = 0; i < bottomRadio.length; i++) {
			if (bottomRadio[i].isChecked()) {
				mViewPager.setCurrentItem(i);
				bottomRadio[i].setTextColor(getResources().getColor(R.color.main_orange));
			} else {
				bottomRadio[i].setTextColor(getResources().getColor(R.color.other_text_gray));
			}
		}
	}

	private OnPageChangeListener pageChange = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			bottomRadio[arg0].setChecked(true);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

}
