package com.fyp.fatin.iqra_app;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

// this is the core for Iqra App, but this is not the main
public class IqraActivity_Core extends ActionBarActivity {
    LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup the main layout
        setContentView(R.layout.activity_main);

        // get layout instance from the id
        mLayout = (LinearLayout) findViewById(R.id.mLayout);

    }

    // show a dialog with an image
    public void showImageDialog(int res) {
        ImageView iv;
        iv = new ImageView(IqraActivity_Core.this);
        iv.setImageResource(res);
        getAlertDialog(iv).show();
    }

    public AlertDialog getAlertDialog(View view) {
        // create a new dialog with custom view and return
        return new AlertDialog.Builder(this).setView(view).create();
    }

    public LinearLayout getImageFromResource(int res, View.OnTouchListener listener) {

        // inflate the layout of the image
        LinearLayout image = (LinearLayout) getLayoutInflater().inflate(R.layout.image, null);

        // get the image instance
        ImageView iv = (ImageView) image.findViewById(R.id.imageView);

        // set the image resource
        iv.setImageResource(res);

        // enable auto-adjustments
        iv.setAdjustViewBounds(true);
        if (listener != null) {
            // set on touch listener
            iv.setOnTouchListener(listener);
        }
        
        // return the image layout
        return image;
    }

    public void playSound(int resource) {

        // create media player for sound playing
        MediaPlayer mp = MediaPlayer.create(this,resource);

        // start the media player
        mp.start();

        // set action to do after the sound has played
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // release the media player memory
                mp.release();
            }
        });

    }

}
