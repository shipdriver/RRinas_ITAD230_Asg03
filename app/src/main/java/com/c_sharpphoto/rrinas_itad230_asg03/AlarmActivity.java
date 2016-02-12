package com.c_sharpphoto.rrinas_itad230_asg03;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onSetAlarmClick(View view) {
        EditText hourEditText = (EditText) findViewById(R.id.alarmhour);
        int hour = Integer.parseInt(hourEditText.getText().toString());

        EditText minuteEditText = (EditText) findViewById(R.id.alarmminute);
        int minute = Integer.parseInt(minuteEditText.getText().toString());

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Your alarm")
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minute);
//                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 0);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int x = 1;
    }

}
