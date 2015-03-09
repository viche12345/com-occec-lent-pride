package com.occec.lent.pride.constants;

import com.occec.lent.pride.R;

public enum DeadlySin {

	ENVY(R.color.color_envy, R.drawable.main_icon_envy, R.string.envy, R.string.devo_envy_title,
			R.string.devo_envy_subtitle, R.string.devo_envy_summary, R.array.envySymptoms,
			R.string.devo_envy_pride_summary, R.string.devo_envy_bible_verse,
			R.string.devo_envy_reflect, R.array.envyAskGod, R.array.envyPractice,
			R.array.envyPracticeDetail, R.string.devo_envy_kids, R.string.devo_envy_kids_prayer),
	VAINGLORY(R.color.color_vainglory, R.drawable.main_icon_vainglory, R.string.vainglory, R.string.devo_vainglory_title,
			R.string.devo_vainglory_subtitle, R.string.devo_vainglory_summary,
			R.array.vainglorySymptoms, R.string.devo_vainglory_pride_summary,
			R.string.devo_vainglory_bible_verse, R.string.devo_vainglory_reflect,
			R.array.vaingloryAskGod, R.array.vaingloryPractice, R.array.vaingloryPracticeDetail, R.string.devo_vainglory_kids, R.string.devo_vainglory_kids_prayer),
	SLOTH(R.color.color_sloth, R.drawable.main_icon_sloth, R.string.sloth,
			R.string.devo_sloth_title, R.string.devo_sloth_subtitle, R.string.devo_sloth_summary,
			R.array.slothSymptoms, R.string.devo_sloth_pride_summary,
			R.string.devo_sloth_bible_verse, R.string.devo_sloth_reflect, R.array.slothAskGod,
			R.array.slothPractice, R.array.slothPracticeDetail, R.string.devo_sloth_kids, R.string.devo_sloth_kids_prayer),
	AVARICE(R.color.color_avarice, R.drawable.main_icon_avarice, R.string.avarice, R.string.devo_avarice_title,
			R.string.devo_avarice_subtitle, R.string.devo_avarice_summary, R.array.avariceSymptoms,
			R.string.devo_avarice_pride_summary, R.string.devo_avarice_bible_verse,
			R.string.devo_avarice_reflect, R.array.avariceAskGod, R.array.avaricePractice,
			R.array.avaricePracticeDetail, R.string.devo_avarice_kids, R.string.devo_avarice_kids_prayer),
	ANGER(R.color.color_anger, R.drawable.main_icon_anger,
			R.string.anger, R.string.devo_anger_title, R.string.devo_anger_subtitle,
			R.string.devo_anger_summary, R.array.angerSymptoms, R.string.devo_anger_pride_summary,
			R.string.devo_anger_bible_verse, R.string.devo_anger_reflect, R.array.angerAskGod,
			R.array.angerPractice, R.array.angerPracticeDetail, R.string.devo_anger_kids, R.string.devo_anger_kids_prayer),
	GLUTTONY(R.color.color_gluttony, R.drawable.main_icon_gluttony, R.string.gluttony, R.string.devo_gluttony_title,
			R.string.devo_gluttony_subtitle, R.string.devo_gluttony_summary,
			R.array.gluttonySymptoms, R.string.devo_gluttony_pride_summary,
			R.string.devo_gluttony_bible_verse, R.string.devo_gluttony_reflect,
			R.array.gluttonyAskGod, R.array.gluttonyPractice, R.array.gluttonyPracticeDetail, R.string.devo_gluttony_kids, R.string.devo_gluttony_kids_prayer),
	LUST(R.color.color_lust, R.drawable.main_icon_lust, R.string.lust, R.string.devo_lust_title,
			R.string.devo_lust_subtitle, R.string.devo_lust_summary, R.array.lustSymptoms,
			R.string.devo_lust_pride_summary, R.string.devo_lust_bible_verse,
			R.string.devo_lust_reflect, R.array.lustAskGod, R.array.lustPractice,
			R.array.lustPracticeDetail, R.string.devo_lust_kids, R.string.devo_lust_kids_prayer);

	private int colorId;
	private int iconResId;
	private int nameStringId;
	private int titleStringId;
	private int subtitleStringId;
	private int summaryStringId;
	private int symptomsArrayId;
	private int prideSummaryId;
	private int bibleVerseId;
	private int reflectId;
	private int askGodArrayId;
	private int practiceArrayId;
	private int practiceDetailArrayId;
	private int kidsSummaryStringId;
	private int kidsPrayerStringId;

	DeadlySin(int colorId, int iconResId, int nameStringId, int titleStringId,
			  int subtitleStringId, int summaryStringId, int symptomsArrayId, int prideSummaryId,
			  int bibleVerseId, int reflectId, int askGodArrayId, int practiceArrayId,
			  int practiceDetailArrayId, int kidsSummaryStringId, int kidsPrayerStringId) {
		this.colorId = colorId;
		this.iconResId = iconResId;
		this.nameStringId = nameStringId;
		this.titleStringId = titleStringId;
		this.subtitleStringId = subtitleStringId;
		this.summaryStringId = summaryStringId;
		this.symptomsArrayId = symptomsArrayId;
		this.prideSummaryId = prideSummaryId;
		this.bibleVerseId = bibleVerseId;
		this.reflectId = reflectId;
		this.askGodArrayId = askGodArrayId;
		this.practiceArrayId = practiceArrayId;
		this.practiceDetailArrayId = practiceDetailArrayId;
		this.kidsSummaryStringId = kidsSummaryStringId;
		this.kidsPrayerStringId = kidsPrayerStringId;
	}

	public int getColorId() {
		return colorId;
	}

	public int getIconResId() {
		return iconResId;
	}

	public int getNameStringId() {
		return nameStringId;
	}

	public int getTitleStringId() {
		return titleStringId;
	}

	public int getSubtitleStringId() {
		return subtitleStringId;
	}

	public int getSummaryStringId() {
		return summaryStringId;
	}

	public int getSymptomsArrayId() {
		return symptomsArrayId;
	}

	public int getPrideSummaryId() {
		return prideSummaryId;
	}

	public int getBibleVerseId() {
		return bibleVerseId;
	}

	public int getReflectId() {
		return reflectId;
	}

	public int getAskGodArrayId() {
		return askGodArrayId;
	}

	public int getPracticeArrayId() {
		return practiceArrayId;
	}

	public int getPracticeDetailArrayId() {
		return practiceDetailArrayId;
	}

	public int getKidsSummaryStringId() {
		return kidsSummaryStringId;
	}

	public int getKidsPrayerStringId() {
		return kidsPrayerStringId;
	}
}
