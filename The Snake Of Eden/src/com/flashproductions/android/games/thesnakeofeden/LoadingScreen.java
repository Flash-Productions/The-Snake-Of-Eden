package com.flashproductions.android.games.thesnakeofeden;

/**
 * Created by Flash Productions.
 * Date: 9/10/12
 * Time: 4:29 PM
 */


import com.flashproductions.android.games.framework.Game;
import com.flashproductions.android.games.framework.Graphics;
import com.flashproductions.android.games.framework.Graphics.PixmapFormat;
import com.flashproductions.android.games.framework.Screen;

public class LoadingScreen extends Screen
{
    public LoadingScreen ( Game game )
    {
        super ( game );

    }


    private int delay = 0;

    @Override
    public void update ( float deltaTime )
    {
        Graphics g = game.getGraphics ();

        Assets.menuBackground = g.newPixmap ( "menu-background.png", PixmapFormat.ARGB8888 );
        Assets.gameBackground = g.newPixmap ( "game-background.png", PixmapFormat.ARGB8888 );
        Assets.companyLogo = g.newPixmap ( "company-logo.png", PixmapFormat.ARGB8888 );

        g.drawPixmap ( Assets.companyLogo, 0, 0 );
        delay += 1;

        Assets.facebook = g.newPixmap ( "facebook.png", PixmapFormat.ARGB4444 );
        Assets.logo = g.newPixmap ( "logo.png", PixmapFormat.ARGB8888 );
        Assets.mainMenu = g.newPixmap ( "mainmenu.png", PixmapFormat.ARGB8888 );
        Assets.buttons = g.newPixmap ( "buttons.png", PixmapFormat.ARGB8888 );
        Assets.help1 = g.newPixmap ( "help1.png", PixmapFormat.ARGB8888 );
        Assets.help2 = g.newPixmap ( "help2.png", PixmapFormat.ARGB8888 );
        Assets.help3 = g.newPixmap ( "help3.png", PixmapFormat.ARGB8888 );
        Assets.numbers = g.newPixmap ( "numbers.png", PixmapFormat.ARGB8888 );
        Assets.ready = g.newPixmap ( "ready.png", PixmapFormat.ARGB8888 );
        Assets.pause = g.newPixmap ( "pause.png", PixmapFormat.ARGB8888 );
        Assets.gameOver = g.newPixmap ( "gameover.png", PixmapFormat.ARGB8888 );
        Assets.headUp = g.newPixmap ( "headup.png", PixmapFormat.ARGB8888 );
        Assets.headLeft = g.newPixmap ( "headleft.png", PixmapFormat.ARGB8888 );
        Assets.headDown = g.newPixmap ( "headdown.png", PixmapFormat.ARGB8888 );
        Assets.headRight = g.newPixmap ( "headright.png", PixmapFormat.ARGB8888 );
        Assets.tail = g.newPixmap ( "tail.png", PixmapFormat.ARGB8888 );
        Assets.apple1 = g.newPixmap ( "apple1.png", PixmapFormat.ARGB8888 );
        Assets.apple2 = g.newPixmap ( "apple2.png", PixmapFormat.ARGB8888 );
        Assets.apple3 = g.newPixmap ( "apple3.png", PixmapFormat.ARGB8888 );

        Assets.click = game.getAudio ().newSound ( "click.ogg" );
        Assets.eat = game.getAudio ().newSound ( "eat.ogg" );
        Assets.bitten = game.getAudio ().newSound ( "bitten.ogg" );


        Assets.gameMusic = game.getAudio ().newMusic ( "game-music.ogg" );
        Assets.menuMusic = game.getAudio ().newMusic ( "menu-music.ogg" );


        if ( delay > 8 )
        {
            Settings.load ( game.getFileIO () );
            game.setScreen ( new MainMenuScreen ( game ) );
        }

    }

    @Override
    public void present ( float deltaTime )
    {


    }

    @Override
    public void pause ()
    {

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
