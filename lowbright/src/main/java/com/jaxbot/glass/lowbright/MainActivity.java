package com.jaxbot.glass.lowbright;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.res.Resources;
import android.speech.RecognizerIntent;
import android.util.Log;

import java.util.ArrayList;

import android.provider.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();

		ArrayList<String> voiceResults = getIntent().getExtras()
			.getStringArrayList(RecognizerIntent.EXTRA_RESULTS);

		Log.d("Got:", voiceResults.get(0));

		int brightness = 50;
		int mode = 1;

		if (voiceResults.get(0).equals("on")) {
			mode = 0;
			brightness = 0;
		}

		Settings.System.putInt(getContentResolver(), "screen_brightness_mode", mode);
		Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);

		finish();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}

