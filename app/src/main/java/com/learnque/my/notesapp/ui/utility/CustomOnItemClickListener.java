package com.learnque.my.notesapp.ui.utility;

import android.view.View;

public class CustomOnItemClickListener implements View.OnClickListener {

    private int position;
    private OnItemClickCallback clickCallback;

    public CustomOnItemClickListener(int position, OnItemClickCallback callback) {
        this.position = position;
        this.clickCallback = callback;
    }

    @Override
    public void onClick(View v) {
        clickCallback.onItemClicked(v, position);
    }

    public interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
}
