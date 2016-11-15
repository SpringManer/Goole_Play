package com.itheima.gooleplay74.fragment;

import java.util.ArrayList;

import android.os.SystemClock;
import android.view.View;
import android.widget.ListView;

import com.itheima.gooleplay74.adapter.MyBaseAdapter;
import com.itheima.gooleplay74.holder.BaseHolder;
import com.itheima.gooleplay74.holder.HomeHolder;
import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;

public class HomeFragment<E> extends BaseFragment {

	private ArrayList<String> arrayList;
	private ArrayList<String> mMoreData;

	@Override
	public View onCreateSuccessView() {

		ListView listView = new ListView(UIUtils.getContext());

		listView.setAdapter(new SimpleTestAdaptor(arrayList));

		return listView;
	}

	@Override
	public ResultState onLoad() {

		arrayList = new ArrayList<String>();

		mMoreData = new ArrayList<String>();

		for (int i = 0; i < 30; i++) {

			arrayList.add("测试数据" + i);

			mMoreData.add("更多测试数据" + i);

		}

		return ResultState.STATE_SUCCESS;

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
			return true;
		}

		@Override
		public ArrayList onLoadMore() {
			
			
			


				mMoreData = new ArrayList<String>();

				for (int i = 0; i < 15; i++) {


					mMoreData.add("更多测试数据" + i);

				}
				
				SystemClock.sleep(2000);


			return mMoreData;
		}

	}

}
