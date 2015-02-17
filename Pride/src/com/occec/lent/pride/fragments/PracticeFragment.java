package com.occec.lent.pride.fragments;

import com.occec.lent.pride.R;
import com.occec.lent.pride.constants.DeadlySin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PracticeFragment extends Fragment {

	private DeadlySin sin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sin = (DeadlySin) getArguments().getSerializable("deadlysin");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_devo_practice, container, false);
		v.findViewById(R.id.devoHeaderLayout).setBackgroundResource(sin.getColorId());
		ImageView icon = (ImageView) v.findViewById(R.id.imageViewDevoIcon);
		icon.setImageResource(sin.getIconResId());

		TextView sinName = (TextView) v.findViewById(R.id.textViewName);
		sinName.setText(sin.getNameStringId());

		TextView bigSinName = (TextView) v.findViewById(R.id.textViewNameBig);
		bigSinName.setText(sin.getNameStringId());

		LinearLayout llAskGod = (LinearLayout) v.findViewById(R.id.linearLayoutAskGod);
		populateLinearLayouts(inflater, llAskGod, sin.getAskGodArrayId(), -1);

		LinearLayout llPractice = (LinearLayout) v.findViewById(R.id.linearLayoutPractice);
		populateLinearLayouts(inflater, llPractice, sin.getPracticeArrayId(),
				sin.getPracticeDetailArrayId());
		return v;
	}

	private void populateLinearLayouts(LayoutInflater inflater, LinearLayout ll, int msgArrayResId,
			int detailArrayResId) {
		String[] msgArray = getResources().getStringArray(msgArrayResId);
		String[] detailArray = detailArrayResId > 0 ? getResources().getStringArray(
				detailArrayResId) : null;
		for (int i = 0; i < msgArray.length; i++) {
			View v = inflater.inflate(R.layout.delegate_main, ll, false);
			TextView msg = (TextView) v.findViewById(R.id.textViewBulletMsg);
			msg.setText(msgArray[i]);

			if (detailArray != null && !detailArray[i].startsWith("#")) {
				TextView detail = (TextView) v.findViewById(R.id.textViewBulletDetail);
				detail.setText(detailArray[i]);
				detail.setVisibility(View.VISIBLE);
			}

			ll.addView(v);
		}
	}
}
