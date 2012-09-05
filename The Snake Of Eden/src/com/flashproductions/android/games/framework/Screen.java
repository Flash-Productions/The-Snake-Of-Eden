package com.flashproductions.android.games.framework;

/**
 * Created by Flash Productions.
 * Date: 9/1/12
 * Time: 2:57 AM
 */
public abstract class Screen
{
    protected final Game game;

    public Screen ( Game game )
    {
        this.game = game;
    }

    public abstract void update ( float deltaTime );

    public abstract void present ( float deltaTime );

    public abstract void pause ();

    public abstract void resume ();

    public abstract void dispose ();
}
