package com.itheima.gooleplay74.fragment;

import java.util.ArrayList;

import com.itheima.gooleplay74.http.protocol.HotProtocal;
import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.FlowLayout;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;

import android.view.View;
import android.widget.TextView;

public class HotFragment extends BaseFragment {

	private ArrayList<String> data;

	@Override
	public ResultState onLoad() {

		data = new HotProtocal().getData(0);

		return checkData(data);
	}

	@Override
	public View onCreateSuccessView() {

		FlowLayout flowLayout = new FlowLayout(UIUtils.getContext());

		for (int i = 0; i < data.size(); i++) {

			TextView textView = new TextView(UIUtils.getContext());

			textView.setText(data.get(i));

			flowLayout.addView(textView);

		}

		return flowLayout;
	}

}
