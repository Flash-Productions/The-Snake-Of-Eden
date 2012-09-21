package com.flashproductions.android.games.framework.impl;

/**
 * Created by Flash Productions
 * Date: 9/4/12
 * Time: 2:51 AM
 */

import android.view.MotionEvent;
import android.view.View;
import com.flashproductions.android.games.framework.Input.TouchEvent;
import com.flashproductions.android.games.framework.Pool;
import com.flashproductions.android.games.framework.Pool.PoolObjectFactory;

import java.util.ArrayList;
import java.util.List;

public class SingleTouchHandler implements TouchHandler
{
    boolean          isTouched;
    int              touchX;
    int              touchY;
    Pool<TouchEvent> touchEventPool;
    List<TouchEvent> touchEvents       = new ArrayList<TouchEvent> ();
    List<TouchEvent> touchEventsBuffer = new ArrayList<TouchEvent> ();
    float scaleX;
    float scaleY;

    public SingleTouchHandler ( View view, float scaleX, float scaleY )
    {
        PoolObjectFactory<TouchEvent> factory = new PoolObjectFactory<TouchEvent> ()
        {
            @Override
            public TouchEvent createObject ()
            {
                return new TouchEvent ();
            }
        };
        touchEventPool = new Pool<TouchEvent> ( factory, 100 );
        view.setOnTouchListener ( this );

        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    public boolean onTouch ( View v, MotionEvent event )
    {
        synchronized ( this )
        {
            TouchEvent touchEvent = touchEventPool.newObject ();
            switch ( event.getAction () )
            {
                case MotionEvent.ACTION_DOWN:
                    touchEvent.type = TouchEvent.TOUCH_DOWN;
                    isTouched = true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    touchEvent.type = TouchEvent.TOUCH_DRAGGED;
                    isTouched = true;
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    touchEvent.type = TouchEvent.TOUCH_UP;
                    isTouched = false;
                    break;
            }

            touchEvent.x = touchX = ( int ) ( event.getX () * scaleX );
            touchEvent.y = touchY = ( int ) ( event.getY () * scaleY );
            touchEventsBuffer.add ( touchEvent );

            return true;
        }
    }

    @Override
    public boolean isTouchDown ( int pointer )
    {
        synchronized ( this )
        {
            return pointer == 0 && isTouched;
        }
    }

    @Override
    public int getTouchX ( int pointer )
    {
        synchronized ( this )
        {
            return touchX;
        }
    }

    @Override
    public int getTouchY ( int pointer )
    {
        synchronized ( this )
        {
            return touchY;
        }
    }

    @Override
    public List<TouchEvent> getTouchEvents ()
    {
        synchronized ( this )
        {
            for ( TouchEvent touchEvent : touchEvents ) { touchEventPool.free ( touchEvent ); }
            touchEvents.clear ();
            touchEvents.addAll ( touchEventsBuffer );
            touchEventsBuffer.clear ();
            return touchEvents;
        }
    }
}
