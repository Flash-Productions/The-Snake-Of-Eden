package com.flashproductions.android.games.framework.impl;

/**
 * Created by Flash Productions
 * Date: 9/1/12
 * Time: 11:57 AM
 */

import android.media.SoundPool;
import com.flashproductions.android.games.framework.Sound;

public class AndroidSound implements Sound
{
    int       soundId;
    SoundPool soundPool;

    public AndroidSound ( SoundPool soundPool, int soundId )
    {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play ( float volume )
    {
        soundPool.play ( soundId, volume, volume, 0, 0, 1 );
    }

    @Override
    public void dispose ()
    {
        soundPool.unload ( soundId );
    }

}
