package com.itheima.gooleplay74.view;

/**
 * 自定义loadingPage工具类
 * 
 * 软件的各种状态：
 * 
 * 根据当前状态来显示不同页面的自定义控件
 * 
 * - 未加载 - 加载中 - 加载失败 - 数据为空 - 加载成功
 * 
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.itheima.gooleplay74.R;
import com.itheima.gooleplay74.utils.UIUtils;

public abstract class LoadingPage extends FrameLayout {

	private static final int STATE_LOAD_UNDO = 1;// 未加载
	private static final int STATE_LOAD_LOADING = 2;// 正在加载
	private static final int STATE_LOAD_ERROR = 3;// 加载失败
	private static final int STATE_LOAD_EMPTY = 4;// 数据为空
	private static final int STATE_LOAD_SUCCESS = 5;// 加载成功

	private int mCurrentState = 1;// 加载成功

	private View mLoadingPage;
	private View mErrorPage;
	private View mEmptyPage;
	private View mSuccessView;

	public LoadingPage(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}

	public LoadingPage(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public LoadingPage(Context context) {
		super(context);
		initView();
	}

	private void initView() {

		// 判断当前状态，设置不同的布局

		if (mLoadingPage == null) {

			mLoadingPage = UIUtils.inflate(R.layout.frag_loading);
			addView(mLoadingPage);

		}

		if (mErrorPage == null) {
			mErrorPage = UIUtils.inflate(R.layout.frag_load_error);
			addView(mErrorPage);
		}

		if (mEmptyPage == null) {
			mEmptyPage = UIUtils.inflate(R.layout.frag_empty);
			addView(mEmptyPage);
		}

		showRightLayout();

	}

	private void showRightLayout() {
		// // judgement
		// if (mCurrentState == STATE_LOAD_UNDO
		// || mCurrentState == STATE_LOAD_LOADING) {
		// mLoadingPage.setVisibility(View.VISIBLE);
		//
		// } else {
		//
		// mLoadingPage.setVisibility(View.INVISIBLE);
		// }

		mLoadingPage
				.setVisibility((mCurrentState == STATE_LOAD_UNDO || mCurrentState == STATE_LOAD_LOADING) ? View.VISIBLE
						: View.INVISIBLE);

		mErrorPage
				.setVisibility((mCurrentState == STATE_LOAD_ERROR) ? View.VISIBLE
						: View.INVISIBLE);
		mEmptyPage
				.setVisibility((mCurrentState == STATE_LOAD_EMPTY) ? View.VISIBLE
						: View.INVISIBLE);

		if (mCurrentState == STATE_LOAD_SUCCESS || mSuccessView == null) {

			mSuccessView = onCreatSuccessView();
			if (mSuccessView != null) {
				addView(mSuccessView);
			}
		}

		if (mSuccessView != null) {

			mSuccessView
					.setVisibility((mCurrentState == STATE_LOAD_SUCCESS) ? View.VISIBLE
							: View.INVISIBLE);

		}

	}

	public abstract View onCreatSuccessView();
}
