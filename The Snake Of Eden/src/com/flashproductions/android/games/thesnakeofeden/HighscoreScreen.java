package com.flashproductions.android.games.thesnakeofeden;

/**
 * Created by Flash Productions.
 * Date: 9/12/12
 * Time: 5:21 PM
 */

import com.flashproductions.android.games.framework.Game;
import com.flashproductions.android.games.framework.Graphics;
import com.flashproductions.android.games.framework.Input.TouchEvent;
import com.flashproductions.android.games.framework.Screen;

import java.util.List;

public class HighscoreScreen extends Screen
{
    String lines[] = new String[ 5 ];

    public HighscoreScreen ( Game game )
    {
        super ( game );

        for ( int i = 0; i < 5; i++ )
        {
            lines[ i ] = "" + ( i + 1 ) + ". " + Settings.highscores[ i ];
        }
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
                if ( event.x < 64 && event.y > 416 )
                {
                    if ( Settings.soundEnabled )
                    { Assets.click.play ( 1 ); }
                    game.setScreen ( new MainMenuScreen ( game ) );
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
        g.drawPixmap ( Assets.mainMenu, 64, 20, 0, 42, 196, 42 );

        int y = 100;
        for ( int i = 0; i < 5; i++ )
        {
            drawText ( g, lines[ i ], 20, y );
            y += 50;
        }

        g.drawPixmap ( Assets.buttons, 0, 416, 64, 64, 64, 64 );

        if ( Settings.soundEnabled && Assets.menuMusic.isStopped () )
        { Assets.menuMusic.play (); }
    }

    public void drawText ( Graphics g, String line, int x, int y )
    {
        int len = line.length ();
        for ( int i = 0; i < len; i++ )
        {
            char character = line.charAt ( i );

            if ( character == ' ' )
            {
                x += 20;
                continue;
            }

            int srcX;
            int srcWidth;
            if ( character == '.' )
            {
                srcX = 200;
                srcWidth = 10;
            }
            else
            {
                srcX = ( character - '0' ) * 20;
                srcWidth = 20;
            }

            g.drawPixmap ( Assets.numbers, x, y, srcX, 0, srcWidth, 32 );
            x += srcWidth;
        }
    }

    @Override
    public void pause ()
    {
        if ( Assets.menuMusic.isPlaying () )
        { Assets.menuMusic.stop (); }

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
