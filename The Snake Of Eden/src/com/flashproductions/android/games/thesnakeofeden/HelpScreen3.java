package com.flashproductions.android.games.thesnakeofeden;

/**
 * Created by Flash Productions.
 * Date: 9/12/12
 * Time: 3:14 PM
 */

import com.flashproductions.android.games.framework.Game;
import com.flashproductions.android.games.framework.Graphics;
import com.flashproductions.android.games.framework.Input;
import com.flashproductions.android.games.framework.Screen;

import java.util.List;


public class HelpScreen3 extends Screen
{
    public HelpScreen3 ( Game game )
    {
        super ( game );

    }

    @Override
    public void update ( float deltaTime )
    {


        List<Input.TouchEvent> touchEvents = game.getInput ().getTouchEvents ();
        game.getInput ().getKeyEvents ();


        for ( Input.TouchEvent event : touchEvents )
        {
            if ( event.type == Input.TouchEvent.TOUCH_UP )
            {
                if ( event.x > 256 && event.y > 416 )
                {
                    game.setScreen ( new MainMenuScreen ( game ) );
                    if ( Settings.soundEnabled )
                    {
                        Assets.click.play ( 1 );
                    }
                    return;
                }

                if ( event.x < 64 && event.y > 416 )
                {
                    if ( Settings.soundEnabled )
                    {
                        Assets.click.play ( 1 );
                    }
                    game.setScreen ( new HelpScreen2 ( game ) );
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
        g.drawPixmap ( Assets.help3, 64, 100 );
        g.drawPixmap ( Assets.buttons, 256, 416, 0, 192, 64, 64 );
        g.drawPixmap ( Assets.buttons, 0, 416, 64, 64, 64, 64 );
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
