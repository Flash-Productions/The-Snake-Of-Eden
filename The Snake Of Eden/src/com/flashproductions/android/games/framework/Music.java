package com.flashproductions.android.games.framework;

/**
 * Created by Flash Productions.
 * Date: 9/1/12
 * Time: 1:28 AM
 */
public interface Music
{
    public void play ();

    public void stop ();

    public void pause ();

    public void setLooping ( boolean looping );

    public void setVolume ( float volume );

    public boolean isPlaying ();

    public boolean isStopped ();

    public boolean isLooping ();

    public void dispose ();
}
