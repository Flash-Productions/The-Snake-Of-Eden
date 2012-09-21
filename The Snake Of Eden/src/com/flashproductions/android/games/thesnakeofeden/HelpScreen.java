package com.flashproductions.android.games.thesnakeofeden;

/**
 * Created by Flash Productions.
 * Date: 9/12/12
 * Time: 12:37 PM
 */

import com.flashproductions.android.games.framework.Game;
import com.flashproductions.android.games.framework.Graphics;
import com.flashproductions.android.games.framework.Input.TouchEvent;
import com.flashproductions.android.games.framework.Screen;

import java.util.List;

public class HelpScreen extends Screen
{
    public HelpScreen ( Game game )
    {
        super ( game );

    }

    @Override
    public void update ( float deltaTime )
    {
        List<TouchEvent> touchEvents = game.getInput ().getTouchEvents ();
        game.getInput ().getKeyEvents ();

        for ( TouchEvent event : touchEvents )
        {
            if ( event.type == TouchEvent.TOUCH_UP )
            {
                if ( event.x > 256 && event.y > 416 )
                {
                    game.setScreen ( new HelpScreen2 ( game ) );
                    if ( Settings.soundEnabled )
                    {
                        Assets.click.play ( 1 );
                    }
                    return;
                }
            }
        }
    }

    @Override
    public void present ( float deltaTime )
    {
        Graphics g = game.getGraphics ();
        g.drawPixmap ( Assets.gameBackground, 0, 0 );
        g.drawPixmap ( Assets.help1, 64, 100 );
        g.drawPixmap ( Assets.buttons, 256, 416, 0, 64, 64, 64 );
        if ( Settings.musicEnabled && Assets.menuMusic.isStopped () )
        {
            Assets.menuMusic.play ();
        }
    }

    @Override
    public void pause ()
    {
        if ( Assets.menuMusic.isPlaying () )
        {
            Assets.menuMusic.stop ();
        }

    }

    @Override
    public void resume ()
    {

    }

    @Override
    public void dispose ()
    {

    }
}
