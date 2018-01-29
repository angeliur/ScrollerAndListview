package com.angeliur.scrollerandlistview.listview;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.angeliur.scrollerandlistview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26 0026.
 */

class FocusListViewAdapter extends BaseAdapter {
    private List<String> mData;
    private Context mContext;
    private int mCurrentPosition = 0;

    public FocusListViewAdapter(Context context, List<String> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);
        if (mCurrentPosition == position){
            layout.addView(addFocusView(position));
        }else {
            layout.addView(addNormalView(position));
        }
        return layout;
    }

    private View addNormalView(int position) {
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        ImageView iv = new ImageView(mContext);
        iv.setImageResource(R.drawable.in_icon);
        layout.addView(iv,LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(mContext);
        tv.setText(mData.get(position));
        layout.addView(tv,LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setGravity(Gravity.CENTER);
        return layout;
    }

    private View addFocusView(int position) {
        ImageView iv = new ImageView(mContext);
        iv.setImageResource(R.mipmap.ic_launcher);
        return iv;
    }

    public void setCurrentItem(int currentItem) {
        this.mCurrentPosition = currentItem;
    }

    public class ViewHolder{
        ImageView img;
        TextView title;
    }
}
