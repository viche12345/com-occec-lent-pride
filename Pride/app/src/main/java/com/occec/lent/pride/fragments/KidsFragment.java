package com.occec.lent.pride.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.occec.lent.pride.R;
import com.occec.lent.pride.constants.DeadlySin;

/**
 * Created by Vincent on 2/28/2015.
 */
public class KidsFragment extends Fragment {

	private DeadlySin sin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sin = (DeadlySin) getArguments().getSerializable("deadlysin");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_devo_kids, container, false);
		v.findViewById(R.id.devoHeaderLayout).setBackgroundResource(sin.getColorId());

		TextView kidsSummary = (TextView) v.findViewById(R.id.textViewKidsSummary);
		kidsSummary.setText(sin.getKidsSummaryStringId());

		TextView kidsPrayer = (TextView) v.findViewById(R.id.textViewKidsPrayer);
		kidsPrayer.setText(sin.getKidsPrayerStringId());
		return v;
	}
}
