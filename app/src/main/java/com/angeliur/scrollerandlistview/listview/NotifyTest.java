package com.angeliur.scrollerandlistview.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.angeliur.scrollerandlistview.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/26 0026.
 */

public class NotifyTest extends Activity{
    private ListView mListView;
    private ArrayList<String> mData;
    private NotifyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify);
        mData = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            mData.add("" + i);
        }
        mListView = (ListView) findViewById(R.id.listView);
        adapter = new NotifyAdapter(this, mData);
        mListView.setAdapter(adapter);
    }

    public void btnAdd(View view){
        mData.add("new");
        adapter.notifyDataSetChanged();
        mListView.setSelection(mData.size() - 1);
    }
}
