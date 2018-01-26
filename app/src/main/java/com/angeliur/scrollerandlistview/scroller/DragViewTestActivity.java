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

public class DragViewTestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_view);
    }

}
