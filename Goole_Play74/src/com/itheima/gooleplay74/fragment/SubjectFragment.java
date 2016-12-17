package com.itheima.gooleplay74.fragment;

import java.util.ArrayList;

import android.view.View;

import com.itheima.gooleplay74.adapter.MyBaseAdapter;
import com.itheima.gooleplay74.domain.SubjectInfo;
import com.itheima.gooleplay74.holder.BaseHolder;
import com.itheima.gooleplay74.holder.SubjectHolder;
import com.itheima.gooleplay74.http.protocol.SubjectProtocal;
import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;
import com.itheima.gooleplay74.view.MyListView;

public class SubjectFragment extends BaseFragment {

	ArrayList<SubjectInfo> data;

	@Override
	public ResultState onLoad() {
		// 请求网络
		SubjectProtocal subjectProtocal = new SubjectProtocal();

		data = subjectProtocal.getData(0);

		return checkData(data);
	}

	@Override
	public View onCreateSuccessView() {

		MyListView myListView = new MyListView(UIUtils.getContext());

		myListView.setAdapter(new SubjectAdaptor(data));

		return myListView;
	}

	public class SubjectAdaptor extends MyBaseAdapter<SubjectInfo> {

		protected SubjectAdaptor(ArrayList arraylist) {
			super(arraylist);
		}

		@Override
		public BaseHolder getHolder(int position) {
			return new SubjectHolder();
		}

		@Override
		public ArrayList onLoadMore() {
			return null;
		}
	}

}
