package com.occec.lent.pride.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.occec.lent.pride.R;

public class MainMenuFragment extends SplashFragment {

	private final int mIconIds[] = { R.id.iconMainIntro, R.id.iconMainEnvy, R.id.iconMainVainglory,
			R.id.iconMainSloth, R.id.iconMainAvarice, R.id.iconMainAnger, R.id.iconMainGluttony,
			R.id.iconMainLust };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		animateStuff(rootView);
		return rootView;
	}

	@Override
	public void onResume() {
		super.onResume();
		for (int i = 0; i < mIconIds.length; i++) {
			View icon = getView().findViewById(mIconIds[i]);
			Animation anim = AnimationUtils.loadAnimation(getActivity(),
					R.anim.main_icon_spin_enter);
			long offset = anim.getStartOffset() + i * 30;
			anim.setStartOffset(offset);
			icon.startAnimation(anim);
		}
	}
}
