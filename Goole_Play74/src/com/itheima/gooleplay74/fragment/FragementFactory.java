package com.itheima.gooleplay74.fragment;

import java.util.HashMap;

import android.support.v4.app.Fragment;

public class FragementFactory {

	private static HashMap<Integer, BaseFragment> mFragmentMap;

	public static Fragment createFragment(int pos) {

		mFragmentMap = new HashMap<Integer, BaseFragment>();
		BaseFragment fragment = mFragmentMap.get(pos);

		if (fragment == null) {

			switch (pos) {
			case 0:
				fragment = new HomeFragment();

				break;
			case 1:
				fragment = new AppFragment();
				break;
			case 2:
				fragment = new GameFragment();
				break;
			case 3:
				fragment = new SubjectFragment();
				break;
			case 4:
				fragment = new RecommendFragment();
				break;
			case 5:
				fragment = new CategoryFragment();
				break;
			case 6:
				fragment = new HotFragment();
				break;

			}

			mFragmentMap.put(pos, fragment);
		}

		return fragment;

	}

}
