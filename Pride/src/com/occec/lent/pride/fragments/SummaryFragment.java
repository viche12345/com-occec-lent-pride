package com.occec.lent.pride.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.occec.lent.pride.R;
import com.occec.lent.pride.constants.DeadlySin;

public class SummaryFragment extends Fragment {

	private DeadlySin sin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sin = (DeadlySin) getArguments().getSerializable("deadlysin");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.fragment_devo_summary, container, false);
		populateHeader(v);
		if (savedInstanceState == null)
			animateStuff(v);

		ImageView icon2 = (ImageView) v.findViewById(R.id.imageViewDevoIconDuplicate);
		icon2.setImageResource(sin.getIconResId());

		TextView summary = (TextView) v.findViewById(R.id.textViewSummary);
		summary.setText(sin.getSummaryStringId());

		LinearLayout symptoms = (LinearLayout) v.findViewById(R.id.linearLayoutSymptoms);
		populateSymptoms(inflater, symptoms);

		return v;
	}

	private void populateHeader(View v) {
		v.findViewById(R.id.devoHeaderLayout).setBackgroundResource(sin.getColorId());
		ImageView icon = (ImageView) v.findViewById(R.id.imageViewDevoIcon);
		icon.setImageResource(sin.getIconResId());

		TextView sinName = (TextView) v.findViewById(R.id.textViewName);
		sinName.setText(sin.getNameStringId());

		TextView title = (TextView) v.findViewById(R.id.textViewDevoTitle);
		title.setText(sin.getTitleStringId());

		TextView subtitle = (TextView) v.findViewById(R.id.textViewDevoSubtitle);
		subtitle.setText(sin.getSubtitleStringId());
	}

	private void populateSymptoms(LayoutInflater inflater, LinearLayout ll) {
		for (String s : getResources().getStringArray(sin.getSymptomsArrayId())) {
			View v = inflater.inflate(R.layout.delegate_main, ll, false);
			TextView msg = (TextView) v.findViewById(R.id.textViewBulletMsg);
			msg.setText(s);
			ll.addView(v);
		}
	}

	private void animateStuff(View v) {
		final View headerLayout = v.findViewById(R.id.devoHeaderLayout);
		final View scrollView = v.findViewById(R.id.devoScrollView);
		final View landscapeContainer = v.findViewById(R.id.linearLayoutSummaryContainer);

		// Set views to invisible
		v.findViewById(R.id.devoHeaderLayout).setVisibility(View.INVISIBLE);
		if (scrollView != null)
			scrollView.setVisibility(View.INVISIBLE);
		if (landscapeContainer != null)
			landscapeContainer.setVisibility(View.INVISIBLE);

		float startX = getArguments().getFloat("xCoord", 0);
		float startY = getArguments().getFloat("yCoord", 0);
		float endX = v.findViewById(R.id.imageViewDevoIcon).getX();
		float endY = v.findViewById(R.id.imageViewDevoIcon).getY();
		TranslateAnimation anim = new TranslateAnimation(Animation.ABSOLUTE, startX,
				Animation.ABSOLUTE, endX, Animation.ABSOLUTE, startY, Animation.ABSOLUTE, endY);
		anim.setDuration(350);
		anim.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				Animation fadeIn = AnimationUtils.loadAnimation(getActivity(),
						android.R.anim.fade_in);
				headerLayout.setVisibility(View.VISIBLE);
				if (scrollView != null)
					scrollView.setVisibility(View.VISIBLE);
				if (landscapeContainer != null)
					landscapeContainer.setVisibility(View.VISIBLE);
				headerLayout.startAnimation(fadeIn);
				if (scrollView != null)
					scrollView.startAnimation(fadeIn);
				if (landscapeContainer != null)
					landscapeContainer.startAnimation(fadeIn);
			}
		});
		v.findViewById(R.id.imageViewDevoIconDuplicate).startAnimation(anim);
	}
}
