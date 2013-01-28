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

        Assets.menuBackground = g.newPixmap ( "pictures/menu-background.png", PixmapFormat.ARGB8888 );
        Assets.gameBackground = g.newPixmap ( "pictures/game-background.png", PixmapFormat.ARGB8888 );
        Assets.companyLogo = g.newPixmap ( "pictures/company-logo.png", PixmapFormat.ARGB8888 );

        g.drawPixmap ( Assets.companyLogo, 0, 0 );
        delay += 1;

        Assets.facebook = g.newPixmap ( "pictures/facebook.png", PixmapFormat.ARGB4444 );
        Assets.logo = g.newPixmap ( "pictures/logo.png", PixmapFormat.ARGB8888 );
        Assets.mainMenu = g.newPixmap ( "pictures/mainmenu.png", PixmapFormat.ARGB8888 );
        Assets.buttons = g.newPixmap ( "pictures/buttons.png", PixmapFormat.ARGB8888 );
        Assets.help1 = g.newPixmap ( "pictures/help1.png", PixmapFormat.ARGB8888 );
        Assets.help2 = g.newPixmap ( "pictures/help2.png", PixmapFormat.ARGB8888 );
        Assets.help3 = g.newPixmap ( "pictures/help3.png", PixmapFormat.ARGB8888 );
        Assets.numbers = g.newPixmap ( "pictures/numbers.png", PixmapFormat.ARGB8888 );
        Assets.ready = g.newPixmap ( "pictures/ready.png", PixmapFormat.ARGB8888 );
        Assets.pause = g.newPixmap ( "pictures/pause.png", PixmapFormat.ARGB8888 );
        Assets.gameOver = g.newPixmap ( "pictures/gameover.png", PixmapFormat.ARGB8888 );
        Assets.headUp = g.newPixmap ( "pictures/headup.png", PixmapFormat.ARGB8888 );
        Assets.headLeft = g.newPixmap ( "pictures/headleft.png", PixmapFormat.ARGB8888 );
        Assets.headDown = g.newPixmap ( "pictures/headdown.png", PixmapFormat.ARGB8888 );
        Assets.headRight = g.newPixmap ( "pictures/headright.png", PixmapFormat.ARGB8888 );
        Assets.tail = g.newPixmap ( "pictures/tail.png", PixmapFormat.ARGB8888 );
        Assets.apple1 = g.newPixmap ( "pictures/apple1.png", PixmapFormat.ARGB8888 );
        Assets.apple2 = g.newPixmap ( "pictures/apple2.png", PixmapFormat.ARGB8888 );
        Assets.apple3 = g.newPixmap ( "pictures/apple3.png", PixmapFormat.ARGB8888 );

        Assets.click = game.getAudio ().newSound ( "sounds/click.ogg" );
        Assets.eat = game.getAudio ().newSound ( "sounds/eat.ogg" );
        Assets.bitten = game.getAudio ().newSound ( "sounds/bitten.ogg" );


        Assets.gameMusic = game.getAudio ().newMusic ( "music/game-music.ogg" );
        Assets.menuMusic = game.getAudio ().newMusic ( "music/menu-music.ogg" );


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
