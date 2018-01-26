package com.angeliur.scrollerandlistview.scroller;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class DragView4 extends View {
    private int lastX;
    private int lastY;
    private int offsetX;
    private int offsetY;

    public DragView4(Context context) {
        super(context);
        initView();
    }

    public DragView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        //给自定义view设置背景色
        setBackgroundColor(Color.GRAY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                offsetX = x - lastX;
                offsetY = y - lastY;
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
        }
        return true;
    }
}
