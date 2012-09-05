package com.flashproductions.android.games.framework;

/**
 * Created by Flash Productions.
 * Date: 9/1/12
 * Time: 2:35 AM
 */

import com.flashproductions.android.games.framework.Graphics.PixmapFormat;

public interface Pixmap
{
    public int getWidth ();

    public int getHeight ();

    public PixmapFormat getFormat ();

    public void dispose ();
}
