package org.techtown.list.listener;

import android.view.View;

import org.techtown.list.adapter.PersonAdapter;

public interface onPersonItemClickListener {
    public void onItemClick(PersonAdapter.ViewHolder holder, View view,int position);
}
