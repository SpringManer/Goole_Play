package com.itheima.gooleplay74.fragment;

import java.util.ArrayList;
import java.util.Random;

import com.itheima.gooleplay74.http.protocol.HotProtocal;
import com.itheima.gooleplay74.utils.DrawableUtils;
import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.FlowLayout;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class HotFragment extends BaseFragment {

	private ArrayList<String> data;

	@Override
	public ResultState onLoad() {

		data = new HotProtocal().getData(0);

		return checkData(data);
	}

	@Override
	public View onCreateSuccessView() {
		
		ScrollView scrollView = new ScrollView(UIUtils.getContext());

		FlowLayout flowLayout = new FlowLayout(UIUtils.getContext());
		int pading = UIUtils.dip2px(10);
		flowLayout.setPadding(pading, pading, pading, pading);
		flowLayout.setHorizontalSpacing(UIUtils.dip2px(6));
		flowLayout.setVerticalSpacing(UIUtils.dip2px(8));
		
		scrollView.addView(flowLayout);

		for (int i = 0; i < data.size(); i++) {

			TextView textView = new TextView(UIUtils.getContext());
			final String appName = data.get(i);
			textView.setText(appName);
			textView.setTextColor(Color.WHITE);
			textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
			textView.setPadding(pading, pading, pading, pading);
			textView.setGravity(Gravity.CENTER);

			// 随机设置背景颜色

			// 随机颜色 30 -- 230
			Random random = new Random();
			int r = 30 + random.nextInt(200);
			int g = random.nextInt(200) + 30;
			int b = random.nextInt(200) + 30;

			int color = 0xffcecece;

			StateListDrawable select = DrawableUtils.getSelect(color,
					Color.rgb(r, g, b), UIUtils.dip2px(6));

			textView.setBackgroundDrawable(select);

			textView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					Toast.makeText(UIUtils.getContext(), appName, 0).show();

				}
			});

			flowLayout.addView(textView);

		}

		return scrollView;
	}
}
