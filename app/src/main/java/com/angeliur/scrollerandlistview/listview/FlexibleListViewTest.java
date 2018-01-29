package com.angeliur.scrollerandlistview.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.angeliur.scrollerandlistview.R;

import java.util.ArrayList;


/**
 * Created by Administrator on 2018/1/26 0026.
 */

public class FlexibleListViewTest extends Activity{
    private FlexibleListView mListView;
    private String[] mData = new String[40];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flexible);
        for (int i = 0; i < mData.length; i++) {
            mData[i] = "" + i;
        }
        mListView = (FlexibleListView) findViewById(R.id.listview);
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mData));
    }

}
