package com.angeliur.scrollerandlistview.scroller;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class DragView1 extends View {
    private int lastX;
    private int lastY;
    private int offsetX;
    private int offsetY;

    //一个参数的构造函数在代码中创建view的时候调用
    public DragView1(Context context) {
        this(context,null);
    }

    //两个参数的构造函数是在布局中引用，或者布局中有自定义属性的时候都调用这个构造
    public DragView1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    //三个参数的构造函数一般是自身调用，比如前两个构造通过this方法调用，代码和布局引用都不会调用
    public DragView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        //给自定义view设置背景色
        setBackgroundColor(Color.RED);
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
                // 在当前left、top、right、bottom的基础上加上偏移量
//                layout(getLeft() + offsetX,getTop() + offsetY,getRight() + offsetX,getBottom() + offsetY);

                //这是系统提供的对View上下、左右同时进行移动的API，效果与上相同
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                break;
        }
        return true;
    }
}
