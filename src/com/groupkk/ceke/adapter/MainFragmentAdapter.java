package com.groupkk.ceke.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainFragmentAdapter extends FragmentPagerAdapter {

	public MainFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	/**
	 * 
	 * @param fm
	 *            not null
	 * @param fragments
	 *            not null
	 */
	public MainFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {

		super(fm);
		this.fragments = fragments;
	}

	List<Fragment> fragments;

	public Fragment getItem(int arg0) {

		return fragments.get(arg0);
	}

	public int getCount() {

		return fragments.size();
	}

}
