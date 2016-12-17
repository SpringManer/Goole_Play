package com.itheima.gooleplay74.fragment;

import java.util.ArrayList;

import com.itheima.gooleplay74.adapter.MyBaseAdapter;
import com.itheima.gooleplay74.domain.AppInfo;
import com.itheima.gooleplay74.holder.AppHolder;
import com.itheima.gooleplay74.holder.BaseHolder;
import com.itheima.gooleplay74.http.protocol.AppProtocal;
import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;
import com.itheima.gooleplay74.view.MyListView;

import android.view.View;
import android.widget.TextView;

public class AppFragment extends BaseFragment {

	ArrayList<AppInfo> data;

	@Override
	public View onCreateSuccessView() {
		MyListView myListView = new MyListView(UIUtils.getContext());

		myListView.setAdapter(new AppAdaptor(data));
		
		return myListView;
	}

	@Override
	public ResultState onLoad() {
		// 加载网络
		AppProtocal appProtoca = new AppProtocal();

		data = appProtoca.getData(0);

		return checkData(data);

	}

	public class AppAdaptor extends MyBaseAdapter<AppInfo> {

		protected AppAdaptor(ArrayList<AppInfo> arraylist) {
			super(arraylist);
		}

		@Override
		public BaseHolder<AppInfo> getHolder(int position) {

			return new AppHolder();
		}

		@Override
		public ArrayList<AppInfo> onLoadMore() {

			AppProtocal appProtoca = new AppProtocal();

			ArrayList<AppInfo> moreData = (ArrayList<AppInfo>) appProtoca
					.getData(data.size());

			return moreData;
		}

		@Override
		public boolean isHaveMore() {
			return true;
		}

	}

}
