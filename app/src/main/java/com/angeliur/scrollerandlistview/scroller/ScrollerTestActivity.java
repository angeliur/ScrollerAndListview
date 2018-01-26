package com.angeliur.scrollerandlistview.scroller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.angeliur.scrollerandlistview.R;
import com.angeliur.scrollerandlistview.listview.ListviewTestActivity;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class ScrollerTestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller_test);
    }

    public void btnDragView(View view){
        startActivity(new Intent(this, DragViewTestActivity.class));
    }

    public void btnDragViewGroup(View view){
        startActivity(new Intent(this, DragViewGroupTestActivity.class));
    }
}
