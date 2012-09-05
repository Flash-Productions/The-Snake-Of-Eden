package com.flashproductions.android.games.framework.impl;

/**
 * Created by Flash Productions.
 * Date: 9/4/12
 * Time: 3:27 AM
 */

import java.util.ArrayList;
import java.util.List;

import android.view.MotionEvent;
import android.view.View;

import com.flashproductions.android.games.framework.Input;
import com.flashproductions.android.games.framework.Input.TouchEvent;
import com.flashproductions.android.games.framework.Pool;
import com.flashproductions.android.games.framework.Pool.PoolObjectFactory;

public class MultiTouchHandler implements TouchHandler
{
    boolean [] isTouched = new boolean[20];
    int[] touchX = new int[20];
    int[] touchY = new int[20];
    Pool<TouchEvent> touchEventPool;
    List<TouchEvent> touchEvents = new ArrayList<TouchEvent>();
    List<TouchEvent> touchEventsBuffer = new ArrayList<TouchEvent>();
    float scaleX;
    float scaleY;

    public MultiTouchHandler(View view, float scaleX, float scaleY){
        PoolObjectFactory<TouchEvent> factory = new PoolObjectFactory<TouchEvent> () {
            @Override
            public TouchEvent createObject ()
            {
                return new TouchEvent();
            }
        };
        touchEventPool = new Pool<TouchEvent>(factory, 100);
        view.setOnTouchListener(this);

        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    
}
