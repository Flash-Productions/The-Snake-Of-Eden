package com.flashproductions.android.games.framework.impl;

/**
 * Created by Flash Productions.
 * Date: 9/1/12
 * Time: 11:42 AM
 */

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import com.flashproductions.android.games.framework.Audio;
import com.flashproductions.android.games.framework.Music;
import com.flashproductions.android.games.framework.Sound;

import java.io.IOException;

public class AndroidAudio implements Audio
{
    AssetManager assets;
    SoundPool    soundPool;

    public AndroidAudio ( Activity activity )
    {
        activity.setVolumeControlStream ( AudioManager.STREAM_MUSIC );
        this.assets = activity.getAssets ();
        this.soundPool = new SoundPool ( 20, AudioManager.STREAM_MUSIC, 0 );
    }

    @Override
    public Music newMusic ( String fileName )
    {
        try
        {
            AssetFileDescriptor assetDescriptor = assets.openFd ( fileName );
            return new AndroidMusic ( assetDescriptor );
        }
        catch ( IOException e )
        {
            throw new RuntimeException ( "Couldn't load music '" + fileName + "'" );
        }
    }

    @Override
    public Sound newSound ( String fileName )
    {
        try
        {
            AssetFileDescriptor assetDescriptor = assets.openFd ( fileName );
            int soundID = soundPool.load ( assetDescriptor, 0 );
            return new AndroidSound ( soundPool, soundID );
        }
        catch ( IOException e )
        {
            throw new RuntimeException ( "Couldn't load sound '" + fileName + "'" );
        }
    }
}