package com.flashproductions.android.games.thesnakeofeden;

/**
 * Created by Flash Productions.
 * Date: 9/10/12
 * Time: 9:43 PM
 */

import com.flashproductions.android.games.framework.Game;
import com.flashproductions.android.games.framework.Graphics;
import com.flashproductions.android.games.framework.Input.TouchEvent;
import com.flashproductions.android.games.framework.Screen;

import java.util.List;

public class MainMenuScreen extends Screen
{

    public MainMenuScreen ( Game game )
    {
        super ( game );

    }


    @Override
    public void update ( float deltaTime )
    {
        Graphics g = game.getGraphics ();
        List<TouchEvent> touchEvents = game.getInput ().getTouchEvents ();
        game.getInput ().getKeyEvents ();

        for ( TouchEvent event : touchEvents )
        {
            if ( event.type == TouchEvent.TOUCH_UP )
            {
                if ( inBounds ( event, 0, g.getHeight () - 64, 64, 64 ) )
                {
                    Settings.soundEnabled = ! Settings.soundEnabled;

                    if ( Settings.soundEnabled )
                    { Assets.click.play ( 1 ); }

                    return;
                }

                if ( inBounds ( event, g.getWidth () - 64, g.getHeight () - 64, 64, 64 ) )
                {
                    Settings.musicEnabled = ! Settings.musicEnabled;

                    if ( Settings.musicEnabled && Assets.menuMusic.isStopped () )
                    {
                        Assets.menuMusic.play ();
                    }

                    if ( ! Settings.musicEnabled )
                    {
                        Assets.menuMusic.stop ();
                    }
                }

                if ( inBounds ( event, 64, 220, 192, 42 ) )
                {
                    game.setScreen ( new GameScreen ( game ) );
                    if ( Settings.soundEnabled )
                    {
                        Assets.click.play ( 1 );
                    }

                    if ( Settings.musicEnabled && Assets.menuMusic.isPlaying () )
                    {
                        Assets.menuMusic.stop ();
                    }
                    if ( ! Assets.menuMusic.isDisposed () )
                    {
                        Assets.menuMusic.dispose ();
                    }

                    return;
                }
                if ( inBounds ( event, 64, 220 + 42, 192, 42 ) )
                {
                    game.setScreen ( new HighscoreScreen ( game ) );
                    if ( Settings.soundEnabled )
                    { Assets.click.play ( 1 ); }
                    return;
                }
                if ( inBounds ( event, 64, 220 + 84, 192, 42 ) )
                {
                    game.setScreen ( new HelpScreen ( game ) );
                    if ( Settings.soundEnabled )
                    { Assets.click.play ( 1 ); }
                    return;
                }
            }
        }
    }

    private boolean inBounds ( TouchEvent event, int x, int y, int width, int height )
    {
        return event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1;
    }

    @Override
    public void present ( float deltaTime )
    {
        Graphics g = game.getGraphics ();

        g.drawPixmap ( Assets.menuBackground, 0, 0 );
        g.drawPixmap ( Assets.logo, 32, 20 );
        g.drawPixmap ( Assets.mainMenu, 64, 220 );

        if ( Assets.menuMusic.isDisposed () && Settings.musicEnabled )
        {
            Assets.menuMusic = game.getAudio ().newMusic ( "menu-music.ogg" );
        }

        if ( Settings.soundEnabled )
        {
            g.drawPixmap ( Assets.buttons, 0, 416, 0, 0, 64, 64 );

        }
        else
        {
            g.drawPixmap ( Assets.buttons, 0, 416, 64, 0, 64, 64 );
        }

        if ( Settings.musicEnabled )
        {
            g.drawPixmap ( Assets.buttons, 256, 416, 0, 192, 64, 64 );
            Assets.menuMusic.play ();
            Assets.menuMusic.setLooping ( true );
        }
        else
        {
            g.drawPixmap ( Assets.buttons, 256, 416, 64, 192, 64, 64 );
        }


    }

    @Override
    public void pause ()
    {
        if ( Settings.musicEnabled && Assets.menuMusic.isPlaying () )
        {
            Assets.menuMusic.stop ();
        }

        Settings.save ( game.getFileIO () );
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
