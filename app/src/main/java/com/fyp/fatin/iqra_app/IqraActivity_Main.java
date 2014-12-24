package com.fyp.fatin.iqra_app;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by asfwan on 12/7/14.
 */
public class IqraActivity_Main extends IqraActivity_Core {

    // this is the main function - onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup the cards
        setupCards();

    }

    // the function definition for setupCards()
    private void setupCards() {


        LinearLayout imageLayout = getImageFromResource(R.drawable.doroba,
                ImageManager.convertToOnTouchListener(onDorobaTouchListener));

        mLayout.addView(imageLayout);

    }



    OnComponentTouchListener onDorobaTouchListener = new OnComponentTouchListener() {
        @Override
        public void onTouch(ImageView v, int componentCode) {
            switch (componentCode) {
                case 1:
                    showImageDialog(R.drawable.ba);
                    playSound(R.raw.baa);
                    v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.doroba_ba_red));
                    break;
                case 2:
                    showImageDialog(R.drawable.ro);
                    playSound(R.raw.raa);
                    v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.doroba_ro_red));
                    break;
                case 3:
                    showImageDialog(R.drawable.dho);
                    playSound(R.raw.doo);
                    v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.doroba_do_red));
                    break;
            }
        }
    };
}


