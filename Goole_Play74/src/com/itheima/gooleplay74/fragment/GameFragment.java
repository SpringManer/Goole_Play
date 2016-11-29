package com.itheima.gooleplay74.fragment;

import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;

import android.view.View;
import android.widget.TextView;

public class GameFragment extends BaseFragment {

	@Override
	public ResultState onLoad() {
		return ResultState.STATE_SUCCESS;
	}

	@Override
	public View onCreateSuccessView() {

		TextView textView = new TextView(UIUtils.getContext());
		textView.setText("GameFragment");

		return textView;
	}

}
