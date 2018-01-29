package com.angeliur.scrollerandlistview.listview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.angeliur.scrollerandlistview.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/26 0026.
 */

class ChatItemListViewBean{

    private int type;
    private Bitmap icon;
    private String text;

    public ChatItemListViewBean() {

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
