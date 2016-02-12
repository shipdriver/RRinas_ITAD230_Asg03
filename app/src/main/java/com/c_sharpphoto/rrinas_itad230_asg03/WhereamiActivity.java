package com.c_sharpphoto.rrinas_itad230_asg03;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class WhereamiActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whereami);
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

    public void onSetLatLongClick(View view) {
        EditText latEditText = (EditText) findViewById(R.id.latit);
        String latitudeEntered = latEditText.getText().toString();
        float latErrorChk = Float.parseFloat(latitudeEntered);
        if (latErrorChk > 90 || latErrorChk < -90){
            latitudeEntered="0";}

        EditText longEditText = (EditText) findViewById(R.id.longi);
        String longitudeEntered = longEditText.getText().toString();
        float longErrorChk = Float.parseFloat(latitudeEntered);
        if (longErrorChk > 180 || latErrorChk < -180){
            latitudeEntered="0";}

        String geoLocation = "geo:"+latitudeEntered+","+longitudeEntered;

        Uri geoLoc = Uri.parse(geoLocation);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLoc);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int x = 2;
    }


}
