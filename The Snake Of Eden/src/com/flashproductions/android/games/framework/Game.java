package com.flashproductions.android.games.framework;

import android.content.Intent;

/**
 * Created by Flash Productions
 * Date: 9/1/12
 * Time: 2:51 AM
 */

public interface Game
{
    public Input getInput ();

    public FileIO getFileIO ();

    public Graphics getGraphics ();

    public Audio getAudio ();

    public void setScreen ( Screen screen );

    public Screen getCurrentScreen ();

    public Screen getStartScreen ();

    public void start(Intent intent);
}
