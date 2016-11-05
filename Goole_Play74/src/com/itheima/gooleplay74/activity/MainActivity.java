package com.itheima.gooleplay74.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.itheima.gooleplay74.R;
import com.itheima.gooleplay74.fragment.BaseFragment;
import com.itheima.gooleplay74.fragment.FragementFactory;
import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.PagerTab;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		PagerTab mPagerTab = (PagerTab) findViewById(R.id.pager_tab);
		ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);

		MyAdapter mAdapter = new MyAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);

		mPagerTab.setViewPager(mViewPager);// 将指针和viewpager绑定在一起

	}

	class MyAdapter extends FragmentPagerAdapter {

		private String[] mTabNames;

		public MyAdapter(FragmentManager fm) {
			super(fm);
			mTabNames = UIUtils.getStringArray(R.array.tab_names);// 加载页面标题数组
		}

		// 返回页签标题
		@Override
		public CharSequence getPageTitle(int position) {
			return mTabNames[position];
		}

		// 返回当前页面位置的fragment对象
		@Override
		public Fragment getItem(int position) {
			
			//调用FragmentFactory工厂生产类
			 Fragment fragment = FragementFactory.createFragment(position);
			return fragment;
		}

		// fragment数量
		@Override
		public int getCount() {
			return mTabNames.length;
		}
	}
}