package com.fyp.fatin.iqra_app;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by asfwan on 12/7/14.
 */
public class IqraActivity_Main extends IqraActivity_Core {

    private static final int OPTION_POPUP = 1;
    private static final int OPTION_HIGHLIGHT = 2;
    private static int OPTION_SELECTED = OPTION_POPUP;

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
                int option = getSelectedOption();
                switch (componentCode) {
                    case 1:
                        if(option==OPTION_POPUP) showImageDialog(R.drawable.ba);
                        playSound(R.raw.baa);
                        if(option==OPTION_HIGHLIGHT) v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.doroba_ba_red));
                        break;
                    case 2:
                        if(option==OPTION_POPUP) showImageDialog(R.drawable.ro);
                        playSound(R.raw.raa);
                        if(option==OPTION_HIGHLIGHT) v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.doroba_ro_red));
                        break;
                    case 3:
                        if(option==OPTION_POPUP) showImageDialog(R.drawable.dho);
                        playSound(R.raw.doo);
                        if(option==OPTION_HIGHLIGHT) v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.doroba_do_red));
                        break;
                }
            }
        };

        View.OnTouchListener onDorobaTouchListener =
                ImageComponentsManager.convertToOnTouchListener(onDorobaComponentTouchListener);

        LinearLayout doroba = getImageFromResource(R.drawable.doroba, onDorobaTouchListener);

        return doroba;

    }

    private int getSelectedOption() {
        return OPTION_SELECTED;
    }

    private View getZoharoCard() {

        OnComponentTouchListener onZoharoComponentTouchListener = new OnComponentTouchListener() {
            @Override
            public void onTouch(ImageView v, int componentCode) {
                int option = getSelectedOption();
                switch (componentCode) {
                    case 1:
                        if(option==OPTION_POPUP) showImageDialog(R.drawable.ro);
                        playSound(R.raw.raa);
                        if(option==OPTION_HIGHLIGHT) v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dzaharo_ro_red));
                        break;
                    case 2:
                        if(option==OPTION_POPUP) showImageDialog(R.drawable.ha);
                        playSound(R.raw.haa);
                        if(option==OPTION_HIGHLIGHT) v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dzaharo_ha_red));
                        break;
                    case 3:
                        if(option==OPTION_POPUP) showImageDialog(R.drawable.dzo);
                        playSound(R.raw.dzo);
                        if(option==OPTION_HIGHLIGHT) v.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dzaharo_dzo_red));
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.change_option:

                //SharedPreferences sp = getSharedPreferences("iqra_app",MODE_PRIVATE);
                //String interaction = sp.getString("interaction","popup");
                if(OPTION_SELECTED == OPTION_POPUP){
                    //sp.edit().putString("interaction","highlight").commit();
                    //item.setTitle("Enable Highlight");
                    OPTION_SELECTED = OPTION_HIGHLIGHT;
                }
                else{
                    //sp.edit().putString("interaction","popup").commit();
                    //item.setTitle("Enable Popup");
                    OPTION_SELECTED = OPTION_POPUP;
                    startActivity(new Intent(IqraActivity_Main.this,IqraActivity_Main.class));
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


