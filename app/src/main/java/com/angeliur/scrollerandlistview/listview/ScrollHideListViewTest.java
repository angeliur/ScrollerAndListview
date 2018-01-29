package com.angeliur.scrollerandlistview.listview;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.angeliur.scrollerandlistview.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/26 0026.
 */

public class ScrollHideListViewTest extends Activity{
    private Toolbar mToolbar;
    private ListView mListView;
    private String[] mStr = new String[20];
    private int mTouchSlop;
    private int mFirstY;
    private int mCurrentY;
    private int direction;
    private ObjectAnimator mAnimator;
    private boolean mShow = true;
    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int y = (int) event.getY();
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    mFirstY = y;
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = y;
                    if (mCurrentY - mFirstY > mTouchSlop){
                        direction = 0;
                    }else {
                        direction = 1;
                    }
                    if (direction == 0){
                        if (!mShow){
                            //显示toolbar
                            toolbarAnim(0);
                        }
                    }else if (direction == 1){
                        if (mShow){
                            //隐藏toolbar
                            toolbarAnim(1);
                        }
                    }
                    mShow = !mShow;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    };

    private void toolbarAnim(int flag) {
        if (mAnimator != null && mAnimator.isRunning()){
            mAnimator.cancel();
        }
        if (flag == 0){
            mAnimator = ObjectAnimator.ofFloat(mToolbar,"translationY",mToolbar.getTranslationY(),0);
        }else {
            mAnimator = ObjectAnimator.ofFloat(mToolbar,"translationY",mToolbar.getTranslationY(),-mToolbar.getHeight());
        }
        mAnimator.start();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_hide);
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        mListView = (ListView) findViewById(R.id.listview);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        for (int i = 0;i < mStr.length;i++){
            mStr[i] = "Item" + i;
        }
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.abc_action_bar_default_height_material)));
        mListView.addHeaderView(header);
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mStr));
        mListView.setOnTouchListener(mTouchListener);
    }

}
