package com.flashproductions.android.games.framework.impl;

/**
 * Created by Flash Productions
 * Date: 9/4/12
 * Time: 12:15 AM
 */

import android.view.View;
import android.view.View.OnKeyListener;
import com.flashproductions.android.games.framework.Input.KeyEvent;
import com.flashproductions.android.games.framework.Pool;
import com.flashproductions.android.games.framework.Pool.PoolObjectFactory;

import java.util.ArrayList;
import java.util.List;

public class KeyboardHandler implements OnKeyListener
{
    boolean[] pressedKeys = new boolean[ 128 ];
    Pool<KeyEvent> keyEventPool;
    List<KeyEvent> keyEventsBuffer = new ArrayList<KeyEvent> ();
    List<KeyEvent> keyEvents       = new ArrayList<KeyEvent> ();

    public KeyboardHandler ( View view )
    {
        PoolObjectFactory<KeyEvent> factory = new PoolObjectFactory<KeyEvent> ()
        {
            @Override
            public KeyEvent createObject ()
            {
                return new KeyEvent ();
            }
        };
        keyEventPool = new Pool<KeyEvent> ( factory, 100 );
        view.setOnKeyListener ( this );
        view.setFocusableInTouchMode ( true );
        view.requestFocus ();
    }

    @Override
    public boolean onKey ( View v, int keyCode, android.view.KeyEvent event )
    {
        if ( event.getAction () == android.view.KeyEvent.ACTION_MULTIPLE )
        {
            return false;
        }

        synchronized ( this )
        {
            KeyEvent keyEvent = keyEventPool.newObject ();
            keyEvent.keyCode = keyCode;
            keyEvent.keyChar = ( char ) event.getUnicodeChar ();
            if ( event.getAction () == android.view.KeyEvent.ACTION_DOWN )
            {
                keyEvent.type = KeyEvent.KEY_DOWN;
                if ( keyCode > 0 && keyCode < 127 )
                {
                    pressedKeys[ keyCode ] = true;
                }
            }
            if ( event.getAction () == android.view.KeyEvent.ACTION_UP )
            {
                keyEvent.type = KeyEvent.KEY_UP;
                if ( keyCode > 0 && keyCode < 127 )
                {
                    pressedKeys[ keyCode ] = false;
                }
            }
            keyEventsBuffer.add ( keyEvent );
        }
        return false;
    }

    public boolean isKeyPressed ( int keyCode )
    {
        return ! ( keyCode < 0 || keyCode > 127 ) && pressedKeys[ keyCode ];
    }

    public List<KeyEvent> getKeyEvents ()
    {
        synchronized ( this )
        {
            for ( KeyEvent keyEvent : keyEvents ) { keyEventPool.free ( keyEvent ); }
            keyEvents.clear ();
            keyEvents.addAll ( keyEventsBuffer );
            keyEventsBuffer.clear ();
            return keyEvents;
        }
    }
}
