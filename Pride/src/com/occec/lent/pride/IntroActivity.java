package com.occec.lent.pride;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class IntroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		TextView part1 = (TextView) findViewById(R.id.textViewPrefacePart1);
		part1.setText(parseFileFromAssets("preface_part1.txt"));
		TextView part2 = (TextView) findViewById(R.id.textViewPrefacePart2);
		part2.setText(parseFileFromAssets("preface_part2.txt"));
		TextView guidelines = (TextView) findViewById(R.id.textViewGuidelines);
		guidelines.setText(parseFileFromAssets("guidelines.txt"));
	}

	private Spanned parseFileFromAssets(String file) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open(file)));
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return Html.fromHtml(sb.toString());
	}
}
