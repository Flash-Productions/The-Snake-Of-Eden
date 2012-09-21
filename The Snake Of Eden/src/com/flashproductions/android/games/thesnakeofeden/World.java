package com.flashproductions.android.games.thesnakeofeden;

/**
 * Created by Flash Productions.
 * Date: 9/17/12
 * Time: 12:03 AM
 */

import java.util.Random;

public class World
{
    static final int   WORLD_WIDTH     = 10;
    static final int   WORLD_HEIGHT    = 13;
    static final int   SCORE_INCREMENT = 10;
    static final float TICK_INITIAL    = 0.5f;
    static final float TICK_DECREMENT  = 0.05f;

    public Snake snake;
    public Apple apple;
    public boolean gameOver = false;
    public int     score    = 0;

    boolean fields[][] = new boolean[ WORLD_WIDTH ][ WORLD_HEIGHT ];
    Random  random     = new Random ();
    float   tickTime   = 0;
    float tick = TICK_INITIAL;

    public World ()
    {
        snake = new Snake ();
        placeApple ();
    }

    private void placeApple ()
    {
        for ( int x = 0; x < WORLD_WIDTH; x++ )
        {
            for ( int y = 0; y < WORLD_HEIGHT; y++ )
            {
                fields[ x ][ y ] = false;
            }
        }

        int len = snake.parts.size ();
        for ( int i = 0; i < len; i++ )
        {
            SnakePart part = snake.parts.get ( i );
            fields[ part.x ][ part.y ] = true;
        }

        int appleX = random.nextInt ( WORLD_WIDTH );
        int appleY = random.nextInt ( WORLD_HEIGHT );
        while ( true )
        {
            if ( ! fields[ appleX ][ appleY ] )
            {
                break;
            }
            appleX += 1;
            if ( appleX >= WORLD_WIDTH )
            {
                appleX = 0;
                appleY += 1;
                if ( appleY >= WORLD_HEIGHT )
                {
                    appleY = 0;
                }
            }
        }
        apple = new Apple ( appleX, appleY, random.nextInt ( 3 ) );
    }

    public void update ( float deltaTime )
    {
        if ( gameOver )
        {
            return;
        }

        tickTime += deltaTime;

        while ( tickTime > tick )
        {
            tickTime -= tick;
            snake.advance ();
            if ( snake.checkBitten () )
            {
                gameOver = true;
                return;
            }

            SnakePart head = snake.parts.get ( 0 );
            if ( head.x == apple.x && head.y == apple.y )
            {
                score += SCORE_INCREMENT;
                snake.eat ();
                if ( snake.parts.size () == WORLD_WIDTH * WORLD_HEIGHT )
                {
                    gameOver = true;
                    return;
                }
                else
                {
                    placeApple ();
                }

                if ( score % 100 == 0 && tick - TICK_DECREMENT > 0 )
                {
                    tick -= TICK_DECREMENT;
                }
            }
        }
    }
}
