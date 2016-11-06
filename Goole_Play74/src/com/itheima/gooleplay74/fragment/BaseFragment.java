package com.itheima.gooleplay74.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage;

public abstract class BaseFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 使用textview显示当前类的类名
		// TextView view = new TextView(UIUtils.getContext());
		// view.setGravity(Gravity.CENTER);

		// view.setText(getClass().getSimpleName());

		LoadingPage mLoadingPage = new LoadingPage(UIUtils.getContext()) {

			@Override
			public View onCreatSuccessView() {
				return BaseFragment.this.onCreatSuccessView();
			}

		};

		return mLoadingPage;

	}

	public abstract View onCreatSuccessView();

}