package com.angeliur.scrollerandlistview.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.angeliur.scrollerandlistview.R;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class ListviewTestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_test);
    }

    public void btnViewHolder(View view) {
        startActivity(new Intent(this, NotifyTest.class));
    }

    public void btnChatItem(View view) {
        startActivity(new Intent(this, ChatItemListViewTest.class));
    }

    public void btnScrollHideListView(View view) {
        startActivity(new Intent(this, ScrollHideListViewTest.class));
    }

    public void btnFlexible(View view) {
        startActivity(new Intent(this, FlexibleListViewTest.class));
    }

    public void btnFocus(View view) {
        startActivity(new Intent(this, FocusListViewTest.class));
    }
}
