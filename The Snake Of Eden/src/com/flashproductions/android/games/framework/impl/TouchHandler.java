package com.flashproductions.android.games.framework.impl;

/**
 * Created by Flash Productions.
 * Date: 9/4/12
 * Time: 2:42 AM
 */

import android.view.View.OnTouchListener;
import com.flashproductions.android.games.framework.Input.TouchEvent;

import java.util.List;

public interface TouchHandler extends OnTouchListener
{
    public boolean isTouchDown ( int pointer );

    public int getTouchX ( int pointer );

    public int getTouchY ( int pointer );

    public List<TouchEvent> getTouchEvents ();
}