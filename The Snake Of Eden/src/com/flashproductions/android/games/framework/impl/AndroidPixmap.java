package com.flashproductions.android.games.framework.impl;

/**
 * Created by Flash Productions
 * Date: 9/8/12
 * Time: 2:10 AM
 */

import android.graphics.Bitmap;
import com.flashproductions.android.games.framework.Graphics.PixmapFormat;
import com.flashproductions.android.games.framework.Pixmap;

public class AndroidPixmap implements Pixmap
{
    Bitmap       bitmap;
    PixmapFormat format;

    public AndroidPixmap ( Bitmap bitmap, PixmapFormat format )
    {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth ()
    {
        return bitmap.getWidth ();
    }

    @Override
    public int getHeight ()
    {
        return bitmap.getHeight ();
    }

    @Override
    public PixmapFormat getFormat ()
    {
        return format;
    }

    @Override
    public void dispose ()
    {
        bitmap.recycle ();
    }
}
