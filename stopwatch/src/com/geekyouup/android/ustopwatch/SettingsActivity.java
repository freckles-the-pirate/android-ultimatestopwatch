package com.geekyouup.android.ustopwatch;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import com.actionbarsherlock.app.SherlockActivity;

public class SettingsActivity extends SherlockActivity {

    private CompoundButton mSwitchSoundTicking;
    private CompoundButton mSwitchEndlessAlarm;
    private CompoundButton mSwitchVibrate;
    private static boolean isTicking=false;
    private static boolean isEndlessAlarm = false;
    private static boolean isVibrate = false;
    private static final String KEY_TICKING = "key_ticking_on";
    private static final String KEY_ENDLESS_ALARM = "key_endless_alarm_on";
    private static final String KEY_VIBRATE = "key_vibrate_on";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        final Context context = this;
        mSwitchSoundTicking = (CompoundButton) findViewById(R.id.settings_seconds_sound);
        mSwitchSoundTicking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isTicking=b;
            }
        });

        mSwitchEndlessAlarm = (CompoundButton) findViewById(R.id.settings_endless_alert);
        mSwitchEndlessAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isEndlessAlarm=b;
            }
        });

        mSwitchVibrate = (CompoundButton) findViewById(R.id.settings_vibrate);
        mSwitchVibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isVibrate=b;
            }
        });

        mSwitchEndlessAlarm.setChecked(isEndlessAlarm);
        mSwitchSoundTicking.setChecked(isTicking);
        mSwitchVibrate.setChecked(isVibrate);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences(UltimateStopwatchActivity.PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putBoolean(KEY_TICKING,isTicking);
        editor.putBoolean(KEY_ENDLESS_ALARM, isEndlessAlarm);
        editor.putBoolean(KEY_VIBRATE,isVibrate);
        editor.commit();
    }

    public static void loadSettings(SharedPreferences prefs)
    {
        isTicking = prefs.getBoolean(KEY_TICKING,false);
        isEndlessAlarm = prefs.getBoolean(KEY_ENDLESS_ALARM,false);
        isVibrate = prefs.getBoolean(KEY_VIBRATE,false);
    }

    public static boolean isTicking() {
        return isTicking;
    }

    public static boolean isEndlessAlarm() {
        return isEndlessAlarm;
    }

    public static boolean isVibrate() {
        return isVibrate;
    }
}