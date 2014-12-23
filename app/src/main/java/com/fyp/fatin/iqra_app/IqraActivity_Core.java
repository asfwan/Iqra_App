package com.fyp.fatin.iqra_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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

    public LinearLayout getImage(int res, View.OnTouchListener listener) {

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

    public Bitmap getHighlightedImageBitmap(Context gContext, int gResId,float left,float top,float width,float height) {
        Resources resources = gContext.getResources();
        Bitmap bitmap =
                BitmapFactory.decodeResource(resources, gResId);

        Bitmap.Config bitmapConfig =
                bitmap.getConfig();
        // set default bitmap config if none
        if(bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        // resource bitmaps are imutable,
        // so we need to convert it to mutable one
        bitmap = bitmap.copy(bitmapConfig, true);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // CUSTOMIZE YOUR COLOR HERE
        paint.setARGB(200,500,500,300);


        Rect bounds = new Rect();
        int x = (bitmap.getWidth() - bounds.width())/2;
        int y = (bitmap.getHeight() + bounds.height())/2;

        canvas.drawRect(left,top,width,height,paint);
        return bitmap;
    }


}
