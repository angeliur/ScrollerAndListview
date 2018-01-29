package com.angeliur.scrollerandlistview.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public class FlexibleListView extends ListView {
    private Context mContext;
    private int mMaxOverDistance = 300;

    public FlexibleListView(Context context) {
        super(context,null);
    }

    public FlexibleListView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public FlexibleListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float density = metrics.density;
        mMaxOverDistance = (int)(density * mMaxOverDistance);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverDistance, isTouchEvent);
    }
}
