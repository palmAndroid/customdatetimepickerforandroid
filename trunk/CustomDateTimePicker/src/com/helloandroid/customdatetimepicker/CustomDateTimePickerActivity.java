package com.helloandroid.customdatetimepicker;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;

import com.helloandroid.customdatetimepicker.bo.DayMonthYear;
import com.helloandroid.customdatetimepicker.bo.HourMinute;
import com.helloandroid.customdatetimepicker.utils.CustomDateTimePickerHelper;
import com.helloandroid.datepickergallery.R;

public class CustomDateTimePickerActivity extends Activity {

	CustomDateTimePickerHelper CustomDateGallery;
	DayMonthYear galleryHolderDayMonthYear;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		CustomDateTimePickerHelper customDateTimePickerHelper = new CustomDateTimePickerHelper(getApplicationContext());

		// year month date holder object
		// you could also use seperate Gallery objects if you like
		galleryHolderDayMonthYear = new DayMonthYear();
		galleryHolderDayMonthYear.mDay = (Gallery) findViewById(R.id.GalleryDay);
		galleryHolderDayMonthYear.mMonth = (Gallery) findViewById(R.id.GalleryMonth);
		galleryHolderDayMonthYear.mYear = (Gallery) findViewById(R.id.GalleryYear);
		galleryHolderDayMonthYear = customDateTimePickerHelper.getYearMonthDay(galleryHolderDayMonthYear, R.layout.galleryitem, R.id.datepickergallery_textView, 1);

		// hour minute
		HourMinute galleryHolderHourMinute = new HourMinute();
		galleryHolderHourMinute.mHour = (Gallery) findViewById(R.id.GalleryHour);
		galleryHolderHourMinute.mMinute = (Gallery) findViewById(R.id.GalleryMinute);
		galleryHolderHourMinute = customDateTimePickerHelper.getHourMinute(galleryHolderHourMinute, R.layout.galleryitem, R.id.datepickergallery_textView);

		// you can use any Gallery related built in method
		galleryHolderDayMonthYear.mMonth.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				Log.d("DatepickerTest", (String) galleryHolderDayMonthYear.mMonth.getItemAtPosition(arg2));
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});

		galleryHolderDayMonthYear.mDay.getSelectedItemPosition();

		/**
		 * Helper method for getting date in a String
		 */
		Log.d("Hour and minute: ", customDateTimePickerHelper.getHourMinute(galleryHolderHourMinute));

		
		/**
		 * Helper method for gettin hour and minute in String
		 */
		Log.d("Year month day: ", customDateTimePickerHelper.getYearMonthDay(galleryHolderDayMonthYear));

	}
}