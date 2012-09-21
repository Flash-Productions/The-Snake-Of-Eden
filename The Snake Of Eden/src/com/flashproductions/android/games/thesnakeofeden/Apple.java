package com.flashproductions.android.games.thesnakeofeden;

/**
 * Created by Flash Productions.
 * Date: 9/15/12
 * Time: 3:00 AM
 */

public class Apple
{
    public static final int TYPE_1 = 0;
    public static final int TYPE_2 = 1;
    public static final int TYPE_3 = 2;
    public int x, y;
    public int type;

    public Apple ( int x, int y, int type )
    {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
