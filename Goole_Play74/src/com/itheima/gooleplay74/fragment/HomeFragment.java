package com.itheima.gooleplay74.fragment;

import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;

import android.view.View;
import android.widget.TextView;

public class HomeFragment extends BaseFragment {


	@Override
	public ResultState onLoad() {
		// TODO Auto-generated method stub
		return ResultState.STATE_SUCCESS;
	}

	@Override
	public View onCreateSuccessView() {
		TextView view = new TextView(UIUtils.getContext());
		view.setText(getClass().getSimpleName());
		return view;
	}

}
