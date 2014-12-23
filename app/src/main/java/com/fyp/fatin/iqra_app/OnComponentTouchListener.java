package com.fyp.fatin.iqra_app;

import android.widget.ImageView;

/**
 * OnComponentListener is a listener that listens to interaction of user with the image.
 * The arguments passed by onTouch() function is the ImageView
 * which the user touches and componentCode for which subdivision of image he/she touches
 *
 */
public interface OnComponentTouchListener {
    public void onTouch(ImageView v,int componentCode);
}
