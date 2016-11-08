package com.itheima.gooleplay74.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;


public abstract class BaseFragment extends Fragment {

	private LoadingPage mLoadingPage;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 使用textview显示当前类的类名
		// TextView view = new TextView(UIUtils.getContext());
		// view.setText(getClass().getSimpleName());
		mLoadingPage = new LoadingPage(UIUtils.getContext()) {

		

			@Override
			public ResultState onLoad() {
				return BaseFragment.this.onLoad();
			}


			@Override
			public View onCreateSuccessView() {
				return BaseFragment.this.onCreateSuccessView();
			}

		};

		return mLoadingPage;
	}

	// 加载成功的布局, 必须由子类来实现
	public abstract View onCreateSuccessView();

	// 加载网络数据, 必须由子类来实现
	public abstract ResultState onLoad();

	// 开始加载数据
	public void loadData() {
//		if (mLoadingPage != null) {
			mLoadingPage.loadData();
//		}
	}

}
