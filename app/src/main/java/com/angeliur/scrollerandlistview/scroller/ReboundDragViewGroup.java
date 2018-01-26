package com.angeliur.scrollerandlistview.scroller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

//学习blog: http://blog.csdn.net/lmj623565791/article/details/46858663

public class ReboundDragViewGroup extends LinearLayout {
    private int lastX;
    private int lastY;
    private int offsetX;
    private int offsetY;
    private Scroller scroller;
    private View menuView;
    private View mainView;
    private ViewDragHelper viewDragHelper;
    private int mMenuWidth;


    public ReboundDragViewGroup(Context context) {
        super(context);
        initView(context);
    }

    public ReboundDragViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ReboundDragViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        viewDragHelper = ViewDragHelper.create(this, 1.0f, callback);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将触摸事件传递给ViewDragHelper,此操作必不可少
        viewDragHelper.processTouchEvent(event);
        return true;
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        // 何时开始检测触摸事件
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }

        // 触摸到View后回调
        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);
        }

        // 当拖拽状态改变，比如idle，dragging
        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);
        }

        // 当位置改变的时候调用,常用与滑动时更改scale等
        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);
        }

        // 处理水平滑动
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return 0;
        }

        // 处理垂直滑动
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return top;
        }

        //TextView全部加上clickable=true,或者子view中有button，意思就是子View可以消耗事件，会发现本来可以拖动的View不动了
        //主要是因为，如果子View不消耗事件，那么整个手势（DOWN-MOVE*-UP）都是直接进入onTouchEvent，在onTouchEvent的DOWN的时候就确定了captureView。如果消耗事件，那么就会先走onInterceptTouchEvent方法，判断是否可以捕获，而在判断的过程中会去判断另外两个回调的方法：getViewHorizontalDragRange和getViewVerticalDragRange，只有这两个方法返回大于0的值才能正常的捕获。
        //如果只需要一个方向的滑动，只需要重写其中一个方法就可以了
        @Override
        public int getViewHorizontalDragRange(View child) {
            return getMeasuredWidth() - child.getMeasuredWidth();
        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return getMeasuredHeight() - child.getMeasuredHeight();
        }

        // 拖动结束后调用
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            viewDragHelper.smoothSlideViewTo(releasedChild,0,0);
            ViewCompat.postInvalidateOnAnimation(ReboundDragViewGroup.this);
        }
    };

    @Override
    public void computeScroll() {
        if (viewDragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
}
