package com.angeliur.scrollerandlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.angeliur.scrollerandlistview.listview.ListviewTestActivity;
import com.angeliur.scrollerandlistview.scroller.ScrollerTestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openListviewTest(View view){
        startActivity(new Intent(this, ListviewTestActivity.class));
    }

    public void openScrollerTest(View view){
        startActivity(new Intent(this, ScrollerTestActivity.class));
    }
}
