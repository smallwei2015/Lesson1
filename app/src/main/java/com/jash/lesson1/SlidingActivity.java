package com.jash.lesson1;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SlidingActivity extends AppCompatActivity implements SlidingPaneLayout.PanelSlideListener {

    private SlidingPaneLayout sliding;
    private View view;
    private View menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);
        sliding = (SlidingPaneLayout) findViewById(R.id.sliding);
        view = findViewById(R.id.content);
        //滑动监听
        sliding.setPanelSlideListener(this);
        menu = findViewById(R.id.menu);
    }

    /**
     * 滑动中
     * @param panel
     * @param slideOffset [0-1]
     */
    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        ViewCompat.setPivotX(view, 0);
        ViewCompat.setPivotY(view, view.getHeight() / 2);
        ViewCompat.setScaleX(view, 1 - slideOffset * 0.5f);
        ViewCompat.setScaleY(view, 1 - slideOffset * 0.5f);
        ViewCompat.setTranslationX(menu, -menu.getWidth() / 2 * (1 - slideOffset));


    }

    @Override
    public void onPanelOpened(View panel) {

    }

    @Override
    public void onPanelClosed(View panel) {

    }
}
