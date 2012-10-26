package com.geekyouup.android.ustopwatch.fragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.geekyouup.android.ustopwatch.R;
import com.geekyouup.android.ustopwatch.UltimateStopwatchActivity;

public class LapTimesActivity extends SherlockFragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laptimes_layout);
		if(UltimateStopwatchActivity.IS_HONEYCOMB_OR_ABOVE)
		{
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		setTitle(getString(R.string.laptimes));

	}
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.laptimes_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.menu_reset) {
			LapTimeRecorder.getInstance().reset(this);
			
			LapTimesFragment ltf = (LapTimesFragment) getSupportFragmentManager().findFragmentById(R.id.laptimes_fragment_from_layout);
			if(ltf != null) ltf.reset();
		}else if(item.getItemId() == android.R.id.home){
            // app icon in action bar clicked; go home
            finish();
	    }
			
		return true;
	}                    */
	
}