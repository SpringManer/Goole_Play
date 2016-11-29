package com.itheima.gooleplay74.fragment;

import java.util.ArrayList;
import java.util.Random;

import com.itheima.gooleplay74.http.protocol.RecommendProtocal;
import com.itheima.gooleplay74.utils.UIUtils;
import com.itheima.gooleplay74.view.LoadingPage.ResultState;
import com.itheima.gooleplay74.view.fly.StellarMap;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class RecommendFragment extends BaseFragment {

	private ArrayList<String> data;

	@Override
	public ResultState onLoad() {

		RecommendProtocal recommendProtocal = new RecommendProtocal();
		data = recommendProtocal.getData(0);
		return checkData(data);
	}

	@Override
	public View onCreateSuccessView() {

		StellarMap stellarMap = new StellarMap(UIUtils.getContext());

		stellarMap.setAdapter(new RecommendAdaptor());

		stellarMap.setRegularity(6, 9);

		stellarMap.setGroup(0, true);

		int dip2px = UIUtils.dip2px(10);
		stellarMap.setInnerPadding(dip2px, dip2px, dip2px, dip2px);

		return stellarMap;
	}

	public class RecommendAdaptor implements StellarMap.Adapter {

		@Override
		public int getGroupCount() {
			return 2;
		}

		@Override
		public int getCount(int group) {
			// 精准数量(将余数添加个最后一个组)

			int count = data.size() / getGroupCount();
			if (group == getGroupCount() - 1) {
				count += data.size() % getGroupCount();

			}
			return count;
		}

		@Override
		public View getView(int group, int position, View convertView) {

			position += group * (getCount(group - 1));

			final String appName = data.get(position);

			TextView textView = new TextView(UIUtils.getContext());

			textView.setText(appName);

			Random random = new Random();
			int size = 16 + random.nextInt(10);
			// 随机大小 16-- 26
			textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);

			// 随机颜色 30 -- 230
			int r = 30 + random.nextInt(200);
			int g = random.nextInt(200) + 30;
			int b = random.nextInt(200) + 30;
			textView.setTextColor(Color.rgb(r, g, b));

			textView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					// 显示名称
					Toast.makeText(UIUtils.getContext(), appName, 0).show();

				}
			});

			return textView;
		}

		@Override
		public int getNextGroupOnZoom(int group, boolean isZoomIn) {

			if (isZoomIn) {
				// 加载上一页（往下滑）

				if (group > 0) {
					group--;
				} else {
					group = getGroupCount() - 1;
				}

			} else {
				// 加载下一页（往上滑）
				if (group < getGroupCount() - 1) {
					group++;
				} else {
					group = 0;
				}

			}
			return group;
		}
	}

}
