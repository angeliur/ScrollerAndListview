package com.angeliur.scrollerandlistview.scroller;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Scroller;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class DragView5 extends View {
    private int lastX;
    private int lastY;
    private int offsetX;
    private int offsetY;
    private Scroller scroller;

    public DragView5(Context context) {
        super(context);
        initView(context);
    }

    public DragView5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DragView5(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        //给自定义view设置背景色
        setBackgroundColor(Color.BLACK);
        //初始化Scroller
        scroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        // 判断Scroller是否执行完毕
        if (scroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(scroller.getCurrX(),scroller.getCurrY());
            // 通过重绘来不断调用computeScroll
            invalidate();
        }

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
            case MotionEvent.ACTION_UP:
                // 手指离开时，执行滑动过程
                View viewGroup = (View) getParent();
                scroller.startScroll(viewGroup.getScrollX(),viewGroup.getScrollY(),-viewGroup.getScrollX(),-viewGroup.getScrollY());
                invalidate();
                break;
        }
        return true;
    }
}
