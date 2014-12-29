package com.fyp.fatin.iqra_app;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
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
        View dorobaCard = getDorobaCard();
        View zoharoCard = getZoharoCard();

        mLayout.addView(dorobaCard);
        mLayout.addView(zoharoCard);

    }

    private View getDorobaCard() {

        OnComponentTouchListener onDorobaComponentTouchListener = new OnComponentTouchListener() {
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

        View.OnTouchListener onDorobaTouchListener =
                ImageComponentsManager.convertToOnTouchListener(onDorobaComponentTouchListener);

        LinearLayout doroba = getImageFromResource(R.drawable.doroba, onDorobaTouchListener);

        return doroba;

    }

    private View getZoharoCard() {

        OnComponentTouchListener onZoharoComponentTouchListener = new OnComponentTouchListener() {
            @Override
            public void onTouch(ImageView v, int componentCode) {
                switch (componentCode) {
                    case 1:
                        showImageDialog(R.drawable.ro);
                        playSound(R.raw.raa);
                        v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dzaharo_ro_red));
                        break;
                    case 2:
                        showImageDialog(R.drawable.ha);
                        playSound(R.raw.haa);
                        v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dzaharo_ha_red));
                        break;
                    case 3:
                        showImageDialog(R.drawable.dzo);
                        playSound(R.raw.dzo);
                        v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dzaharo_dzo_red));
                        break;
                }
            }
        };

        View.OnTouchListener onZoharoTouchListener =
                ImageComponentsManager.convertToOnTouchListener(onZoharoComponentTouchListener);

        LinearLayout zoharo = getImageFromResource(R.drawable.dzaharo, onZoharoTouchListener);

        return zoharo;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}


