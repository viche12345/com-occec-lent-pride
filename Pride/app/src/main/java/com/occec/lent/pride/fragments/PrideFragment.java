package com.occec.lent.pride.fragments;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.occec.lent.pride.R;
import com.occec.lent.pride.constants.DeadlySin;

public class PrideFragment extends Fragment {

	private DeadlySin sin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sin = (DeadlySin) getArguments().getSerializable("deadlysin");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_devo_pride, container, false);
		v.findViewById(R.id.devoHeaderLayout).setBackgroundResource(sin.getColorId());

		TextView prideSummary = (TextView) v.findViewById(R.id.textViewPrideSummary);
		prideSummary.setText(sin.getPrideSummaryId());

		TextView bibleVerse = (TextView) v.findViewById(R.id.textViewVerse);
		bibleVerse.setText(sin.getBibleVerseId());

		TextView reflect = (TextView) v.findViewById(R.id.textViewReflectSummary);
		reflect.setText(sin.getReflectId());
		return v;
	}

	@Override
	public void onPause() {
		super.onPause();
		EditText et = (EditText) getView().findViewById(R.id.editTextNotes);
		String notes = et.getText().toString();
		SharedPreferences sharedPrefs = getActivity().getSharedPreferences("notes", 0);
		Editor editor = sharedPrefs.edit();
		editor.putString(sin.name(), notes);
		editor.apply();
	}

	@Override
	public void onResume() {
		super.onResume();
		EditText et = (EditText) getView().findViewById(R.id.editTextNotes);
		SharedPreferences sharedPrefs = getActivity().getSharedPreferences("notes", 0);
		String notes = sharedPrefs.getString(sin.name(), null);
		if (notes != null && et != null) {
			et.setText(notes);
		}
	}
}
