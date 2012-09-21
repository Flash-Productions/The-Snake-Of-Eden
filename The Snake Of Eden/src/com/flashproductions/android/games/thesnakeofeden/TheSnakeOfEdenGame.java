package com.flashproductions.android.games.thesnakeofeden;

/**
 * Created by Flash Productions.
 * Date: 9/9/12
 * Time: 4:14 PM
 */

import com.flashproductions.android.games.framework.Screen;
import com.flashproductions.android.games.framework.impl.AndroidGame;

public class TheSnakeOfEdenGame extends AndroidGame
{
    @Override
    public Screen getStartScreen ()
    {
        return new LoadingScreen ( this );
    }
}
