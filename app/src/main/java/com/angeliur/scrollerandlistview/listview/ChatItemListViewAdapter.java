package com.angeliur.scrollerandlistview.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.angeliur.scrollerandlistview.R;

import java.util.List;

/**
 * Created by Administrator on 2018/1/26 0026.
 */

class ChatItemListViewAdapter extends BaseAdapter {

    private final LayoutInflater mInflate;
    private List<ChatItemListViewBean> mData;

    public ChatItemListViewAdapter(Context context, List<ChatItemListViewBean> mData) {
        this.mData = mData;
        mInflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public ChatItemListViewBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        ChatItemListViewBean item = getItem(position);
        return item.getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ChatItemListViewBean item = getItem(position);
        if (convertView == null){
            holder = new ViewHolder();
            if (getItemViewType(position) == 0){
                convertView = mInflate.inflate(R.layout.chat_item_in,null);
                holder.icon = (ImageView) convertView.findViewById(R.id.icon_in);
                holder.text = (TextView) convertView.findViewById(R.id.text_in);
            }else {
                convertView = mInflate.inflate(R.layout.chat_item_out,null);
                holder.icon = (ImageView) convertView.findViewById(R.id.icon_out);
                holder.text = (TextView) convertView.findViewById(R.id.text_out);
            }
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.icon.setImageBitmap(item.getIcon());
        holder.text.setText(item.getText());
        return convertView;
    }

    public final class ViewHolder {
        public ImageView icon;
        public TextView text;
    }
}
