package com.itheima.gooleplay74.fragment;

import java.util.ArrayList;

import android.view.View;

import com.itheima.gooleplay74.adapter.MyBaseAdapter;
import com.itheima.gooleplay74.domain.AppInfo;
import com.itheima.gooleplay74.holder.BaseHolder;
import com.itheima.gooleplay74.holder.HomeHolder;
import com.itheima.gooleplay74.http.protocol.HomeProtocal;
import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;
import com.itheima.gooleplay74.view.MyListView;

public class HomeFragment<E> extends BaseFragment {

	private HomeProtocal homeProtocal;
	ArrayList<AppInfo> data;

	@Override
	public View onCreateSuccessView() {

		MyListView listView = new MyListView(UIUtils.getContext());

		listView.setAdapter(new SimpleTestAdaptor(data));

		return listView;
	}

	@Override
	public ResultState onLoad() {

		homeProtocal = new HomeProtocal();

		data = (ArrayList<AppInfo>) homeProtocal.getData(0);
		if (data == null) {
			return ResultState.STATE_EMPTY;

		} else {
			return ResultState.STATE_SUCCESS;
		}

		// arrayList = new ArrayList<String>();
		//
		// mMoreData = new ArrayList<String>();
		//
		// for (int i = 0; i < 30; i++) {
		//
		// arrayList.add("测试数据" + i);
		//
		// mMoreData.add("更多测试数据" + i);
		//
		// }
		//
		// return ResultState.STATE_SUCCESS;

	}

	private class SimpleTestAdaptor extends MyBaseAdapter {

		SimpleTestAdaptor(ArrayList arrayList) {
			super(arrayList);
		}

		@Override
		public BaseHolder getHolder() {

			return new HomeHolder();
		}

		@Override
		public boolean isHaveMore() {
			return false;
		}

		@Override
		public ArrayList onLoadMore() {
			ArrayList mMoredata = (ArrayList) homeProtocal.getData(data.size());

			return mMoredata;
		}

	}

}
