package com.fyp.fatin.iqra_app;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by asfwan on 12/6/14.
 *
 */
public class ImageSettings {

    // boundary settings for the image
    // the boundaries are auto-set when the touch events occur
    public static float top_bound=0, bottom_bound=0, left_bound=0, right_bound=0;

    public static View.OnTouchListener getConvertedOnTouchListener(final int components, final OnComponentTouchListener onComponentTouchListener){

        // create te listener and then return it back
        return new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // DEBUG
                //Toast.makeText(context,""+event.getAction(),Toast.LENGTH_SHORT).show();

                // get X anD Y positions
                float _X = event.getX();
                float _Y = event.getY();

                // get the height and the offset of X
                int width = v.getWidth();
                int offset_X = width/components;

                // get the height and the offset of Y
                int height = v.getHeight();
                int offset_Y = height/4;

                top_bound = 0;//offset_Y;
                bottom_bound = height;//offset_Y*3;

                // deny touch event on upper side of the card
                if(_Y<offset_Y) return false;
                // deny touch event on lower side of the card
                if(_Y>offset_Y*3) return false;

                // the offset engine
                for(int i=0;i<=components;i++){
                    if(offset_X*i>_X){
                        left_bound = offset_X*(i-1)-offset_X/4;
                        right_bound = offset_X*i-offset_X/4;
                        onComponentTouchListener.onTouch((ImageView)v,i);
                        break;
                    }
                }

                // just return false
                return false;
            }
        };
    }

    // 4-letter word
    public static View.OnTouchListener get4ComponentsConvertedOnTouchListener(final OnComponentTouchListener onComponentTouchListener){
        return getConvertedOnTouchListener(4, onComponentTouchListener);
    }

    // 3-letter word
    public static View.OnTouchListener getOnTouchListenerFor3Components(final OnComponentTouchListener onComponentTouchListener){
        return getConvertedOnTouchListener(3, onComponentTouchListener);
    }

}
