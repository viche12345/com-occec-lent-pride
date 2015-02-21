package com.occec.lent.pride;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.occec.lent.pride.constants.DeadlySin;
import com.occec.lent.pride.fragments.MainMenuFragment;
import com.occec.lent.pride.fragments.MainPagerFragment;
import com.occec.lent.pride.fragments.SplashFragment;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			if (getResources().getConfiguration().smallestScreenWidthDp < 600) {
				getSupportFragmentManager().beginTransaction()
						.add(R.id.container, new SplashFragment()).commit();
			} else {
				getSupportFragmentManager().beginTransaction()
						.add(R.id.container, new MainMenuFragment()).commit();
			}
		}
	}

	public void onClickIntro(View v) {
		Intent i = new Intent();
		i.setClass(getApplicationContext(), IntroActivity.class);
		startActivity(i);
	}

	public void onClickIcon(View v, DeadlySin sin) {
		MainPagerFragment frag = new MainPagerFragment();
		Bundle args = new Bundle();
		args.putSerializable("deadlysin", sin);
		int[] location = new int[2];
		v.getLocationOnScreen(location);
		args.putFloat("xCoord", location[0]);
		args.putFloat("yCoord", location[1]);
		frag.setArguments(args);

		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.container, frag);
		transaction.addToBackStack(null);
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		transaction.commit();
	}

	public void envyClick(View v) {
		onClickIcon(v, DeadlySin.ENVY);
	}

	public void vaingloryClick(View v) {
		onClickIcon(v, DeadlySin.VAINGLORY);
	}

	public void slothClick(View v) {
		onClickIcon(v, DeadlySin.SLOTH);
	}

	public void avariceClick(View v) {
		onClickIcon(v, DeadlySin.AVARICE);
	}

	public void angerClick(View v) {
		onClickIcon(v, DeadlySin.ANGER);
	}

	public void gluttonyClick(View v) {
		onClickIcon(v, DeadlySin.GLUTTONY);
	}

	public void lustClick(View v) {
		onClickIcon(v, DeadlySin.LUST);
	}

}
