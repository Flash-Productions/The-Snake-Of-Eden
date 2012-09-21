package com.flashproductions.android.games.framework.impl;

/**
 * Created by Flash Productions
 * Date: 9/1/12
 * Time: 12:07 PM
 */

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.flashproductions.android.games.framework.Music;

import java.io.IOException;

public class AndroidMusic implements Music, OnCompletionListener
{
    MediaPlayer mediaPlayer;
    public boolean isPrepared = false;
    public boolean isDisposed = false;

    public AndroidMusic ( AssetFileDescriptor assetDescriptor )
    {
        mediaPlayer = new MediaPlayer ();
        try
        {
            mediaPlayer.setDataSource ( assetDescriptor.getFileDescriptor (), assetDescriptor.getStartOffset (),
                                        assetDescriptor.getLength () );
            mediaPlayer.prepare ();
            isPrepared = true;
            isDisposed = false;
            mediaPlayer.setOnCompletionListener ( this );
        }
        catch ( Exception e )
        {
            throw new RuntimeException ( "Couldn't load music" );
        }
    }

    @Override
    public void dispose ()
    {
        if ( mediaPlayer.isPlaying () )
        {
            mediaPlayer.stop ();
        }
        mediaPlayer.release ();

        isDisposed = true;
    }

    @Override
    public boolean isLooping ()
    {
        return mediaPlayer.isLooping ();
    }

    @Override
    public boolean isPlaying ()
    {
        return mediaPlayer.isPlaying ();
    }

    @Override
    public boolean isStopped ()
    {
        return ! isPrepared;
    }

    @Override
    public void pause ()
    {
        if ( mediaPlayer.isPlaying () )
        {
            mediaPlayer.pause ();
        }
    }

    @Override
    public void play ()
    {
        if ( mediaPlayer.isPlaying () )
        {
            return;
        }

        try
        {
            synchronized ( this )
            {
                if ( ! isPrepared )
                {
                    mediaPlayer.prepare ();
                }
                mediaPlayer.start ();
            }
        }
        catch ( IllegalStateException e )
        {
            e.printStackTrace ();
        }
        catch ( IOException e )
        {
            e.printStackTrace ();
        }
    }

    @Override
    public void setLooping ( boolean isLooping )
    {
        mediaPlayer.setLooping ( isLooping );
    }

    @Override
    public void setVolume ( float volume )
    {
        mediaPlayer.setVolume ( volume, volume );
    }

    @Override
    public void stop ()
    {
        mediaPlayer.stop ();
        synchronized ( this )
        {
            isPrepared = false;
        }
    }

    @Override
    public void onCompletion ( MediaPlayer player )
    {
        synchronized ( this )
        {
            isPrepared = false;
        }
    }

    @Override
    public boolean isDisposed ()
    {
        return isDisposed;
    }
}
