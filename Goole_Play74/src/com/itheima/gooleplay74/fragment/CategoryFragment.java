package com.itheima.gooleplay74.fragment;

import java.util.ArrayList;

import com.itheima.gooleplay74.adapter.MyBaseAdapter;
import com.itheima.gooleplay74.domain.CategoryInfo;
import com.itheima.gooleplay74.holder.BaseHolder;
import com.itheima.gooleplay74.holder.CategoryHolder;
import com.itheima.gooleplay74.holder.TitleHolder;
import com.itheima.gooleplay74.http.protocol.CategoryProtical;
import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;
import com.itheima.gooleplay74.view.MyListView;

import android.view.View;
import android.view.View.OnClickListener;

public class CategoryFragment extends BaseFragment  {
	
	private ArrayList<CategoryInfo> data;

	@Override
	public View onCreateSuccessView() {
		MyListView view = new MyListView(UIUtils.getContext());
		view.setAdapter(new CategoryAdapter(data));
		return view;
	}

	@Override
	public ResultState onLoad() {
		CategoryProtical protocol = new CategoryProtical();
		data = protocol.getData(0);
		return checkData(data);
	}

	class CategoryAdapter extends MyBaseAdapter<CategoryInfo> {

		public CategoryAdapter(ArrayList<CategoryInfo> data) {
			super(data);
		}

		@Override
		public int getViewTypeCount() {
			return super.getViewTypeCount() + 1;// 在原来基础上增加一种标题类型
		}

		@Override
		public int getInnerType(int position) {
			// 判断是标题类型还是普通分类类型
			CategoryInfo info = data.get(position);

			if (info.isTitle) {
				// 返回标题类型
				return super.getInnerType(position) + 1;// 原来类型基础上加1; 注意:
														// 将TYPE_NORMAL修改为1;
			} else {
				// 返回普通类型
				return super.getInnerType(position);
			}
		}

		@Override
		public BaseHolder<CategoryInfo> getHolder(int position) {
			// 判断是标题类型还是普通分类类型, 来返回不同的holder
			CategoryInfo info = data.get(position);

			if (info.isTitle) {
				return new TitleHolder();
			} else {
				return new CategoryHolder();
			}
		}

		@Override
		public boolean isHaveMore() {
			return false;// 没有更多数据, 需要隐藏加载更多的布局
		}

		@Override
		public ArrayList<CategoryInfo> onLoadMore() {
			return null;
		}

	}


//	private ArrayList<CategoryInfo> data;
//
//	@Override
//	public ResultState onLoad() {
//
//		CategoryProtical categoryProtical = new CategoryProtical();
//
//		data = categoryProtical.getData(0);
//
//		// 空指针鉴定
//		System.out.println(data.size());
//
//		return checkData(data);
//	}
//
//	@Override
//	public View onCreateSuccessView() {
//
//		MyListView myListView = new MyListView(UIUtils.getContext());
//		categoryAdaptor categoryAdaptor = new categoryAdaptor(data);
//		myListView.setAdapter(categoryAdaptor);
//		return myListView;
//	}
//
//	class categoryAdaptor extends MyBaseAdapter<CategoryInfo> {
//
//		public categoryAdaptor(ArrayList<CategoryInfo> arraylist) {
//			super(arraylist);
//		}
//
//		@Override
//		public BaseHolder<CategoryInfo> getHolder(int position) {
//
//			// 判断是标题类型还是普通分类类型, 来返回不同的holder
//			CategoryInfo info = data.get(position);
//
//			if (info.isTitle) {
//				return new TitleHolder();
//			} else {
//				return new CategoryHolder();
//			}
//
//		}
//
//		@Override
//		public int getViewTypeCount() {
//			return super.getViewTypeCount() + 1;
//		}
//
//		@Override
//		public int getInnerType(int position) {
//
//			CategoryInfo categoryInfo = data.get(position);
//
//			if (categoryInfo.isTitle) {
//
//				return super.getInnerType(position) + 1;
//			} else {
//
//				return super.getInnerType(position);
//			}
//		}
//
//		@Override
//		public ArrayList<CategoryInfo> onLoadMore() {
//			return null;
//		}
//
//		@Override
//		public boolean isHaveMore() {
//			return false;
//		}
//
//	}


}
