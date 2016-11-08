package com.itheima.gooleplay74.fragment;

import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;

import android.view.View;
import android.widget.TextView;

public class AppFragment extends BaseFragment {

	

	@Override
	public ResultState onLoad() {
		// TODO Auto-generated method stub
		return ResultState.STATE_ERROR;
	}

	@Override
	public View onCreateSuccessView() {
		TextView textView = new TextView(UIUtils.getContext());
		
		textView.setText(getClass().getSimpleName());
		return null;
	}

}
