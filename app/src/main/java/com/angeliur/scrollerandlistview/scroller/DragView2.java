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

public class DragView2 extends View {
    private int lastX;
    private int lastY;
    private int offsetX;
    private int offsetY;

    //一个参数的构造函数在代码中创建view的时候调用
    public DragView2(Context context) {
        this(context,null);
    }

    //两个参数的构造函数是在布局中引用，或者布局中有自定义属性的时候都调用这个构造
    public DragView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    private void initView() {
        //给自定义view设置背景色
        setBackgroundColor(Color.BLUE);
    }

    //绝对坐标方式
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                offsetX = rawX - lastX;
                offsetY = rawY - lastY;
                // 在当前left、top、right、bottom的基础上加上偏移量
                layout(getLeft() + offsetX,getTop() + offsetY,getRight() + offsetX,getBottom() + offsetY);
                // 重新设置初始坐标
                lastX = rawX;
                lastY = rawY;
                break;
        }
        return true;
    }
}
