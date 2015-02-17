package com.occec.lent.pride.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.occec.lent.pride.R;
import com.occec.lent.pride.constants.DeadlySin;

public class MainPagerFragment extends Fragment {

	private DeadlySin sin;

	private MainPagerAdapter mPagerAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sin = (DeadlySin) getArguments().getSerializable("deadlysin");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_devo_container, container, false);
		v.findViewById(R.id.pager_title_strip).setBackgroundResource(sin.getColorId());
		ViewPager pager = (ViewPager) v.findViewById(R.id.pager);
		pager.setOffscreenPageLimit(5);
		mPagerAdapter = new MainPagerAdapter(getChildFragmentManager());
		pager.setAdapter(mPagerAdapter);
		return v;
	}

	private class MainPagerAdapter extends FragmentPagerAdapter {

		final int POSITION_SUMMARY_FRAGMENT = 0;
		final int POSITION_PRIDE_FRAGMENT = 1;
		final int POSITION_PRACTICE_FRAGMENT = 2;

		public MainPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment f = null;
			switch (position) {
			case POSITION_SUMMARY_FRAGMENT:
				f = new SummaryFragment();
				break;
			case POSITION_PRIDE_FRAGMENT:
				f = new PrideFragment();
				break;
			case POSITION_PRACTICE_FRAGMENT:
				f = new PracticeFragment();
				break;
			}

			// Pass arguments from main menu fragment along to next fragment
			f.setArguments(getArguments());
			return f;
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case POSITION_SUMMARY_FRAGMENT:
				return getString(R.string.summary);
			case POSITION_PRIDE_FRAGMENT:
				return getString(R.string.pride);
			case POSITION_PRACTICE_FRAGMENT:
				return getString(R.string.practice);
			}
			return null;
		}

	}
}
