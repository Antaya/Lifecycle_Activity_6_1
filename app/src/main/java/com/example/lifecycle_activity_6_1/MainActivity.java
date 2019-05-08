package com.example.lifecycle_activity_6_1;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    public static final String KEY = "key";
    public static final long TIME_TO_EXIT = 2000;
    long lastPress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.text_result);
        Log.d("Lifecycle", "onCreate" + " Bundle равен: " + savedInstanceState);
        resultText.append("\n" + "onCreate" + " Bundle равен: " + savedInstanceState);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY, true);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) return;
        boolean value = savedInstanceState.getBoolean(KEY, false);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart");
        resultText.append("\n" + "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume");
        resultText.append("\n" + "onResume");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "onPause");
        resultText.append("\n" + "onPause");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop");
        resultText.append("\n" + "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy");
        resultText.append("\n" + "onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "onRestart");
        resultText.append("\n" + "onRestart");

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d("Lifecycle", "onPostCreate");
        resultText.append("\n" + "onPostCreate");


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("Lifecycle", "onPostResume");
        resultText.append("\n" + "onPostResume");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                Log.d("Lifecycle", "onKeyDown");
                resultText.append("\n" + "onKeyDown");
                onBackPressed();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                Log.d("Lifecycle", "onKeyDown");
                resultText.append("\n" + "onKeyDown");
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Log.d("Lifecycle", "onKeyDown");
                resultText.append("\n" + "onKeyDown");
                event.startTracking();
                return true;

        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Log.d("Lifecycle", "onKeyLongPress");
            resultText.append("\n" + "onKeyLongPress" + "VOLUME_UP");
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Log.d("Lifecycle", "onKeyLongPress");
            resultText.append("\n" + "onKeyLongPress" + "VOLUME_DOWN");
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        long now = System.currentTimeMillis();
        if (now - lastPress > TIME_TO_EXIT) {
            Toast.makeText(this, "для выхода нажми еще раз", Toast.LENGTH_SHORT).show();
            lastPress = now;
            Log.d("Lifecycle", "onBackPressed");
            resultText.append("\n" + "onBackPressed");


        } else {
            super.onBackPressed();
        }


    }
}
