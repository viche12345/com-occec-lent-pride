package com.occec.lent.pride.fragments;

import com.occec.lent.pride.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_splash, container, false);
		animateStuff(v);
		v.findViewById(R.id.continueButton).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.container, new MainMenuFragment());
				transaction.addToBackStack(null);
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				transaction.commit();
			}
		});
		ImageView icon = (ImageView) v.findViewById(R.id.imageViewPrideIcon);
		icon.setImageResource(R.drawable.main_icon_intro);
		return v;
	}

	protected void animateStuff(View v) {
		Animation logoEnterAnim = AnimationUtils.loadAnimation(getActivity(),
				R.anim.splash_logo_enter);
		Animation fadeInEnter = new AlphaAnimation(0, 1);
		fadeInEnter.setDuration(1000);
		fadeInEnter.setStartOffset(300);
		View logo = v.findViewById(R.id.linearLayoutPrideLogo);
		View subtitle1 = v.findViewById(R.id.textViewSubtitle1);
		View subtitle2 = v.findViewById(R.id.textViewSubtitle2);
		View continueButton = v.findViewById(R.id.continueButton);
		if (logo != null)
			logo.startAnimation(logoEnterAnim);
		if (subtitle1 != null)
			subtitle1.startAnimation(fadeInEnter);
		if (subtitle2 != null)
			subtitle2.startAnimation(fadeInEnter);
		if (continueButton != null)
			continueButton.startAnimation(fadeInEnter);
	}
}
