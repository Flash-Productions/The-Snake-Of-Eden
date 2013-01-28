package com.flashproductions.android.games.thesnakeofeden;

/**
 * Created by Flash Productions.
 * Date: 9/10/12
 * Time: 3:57 PM
 */

import com.flashproductions.android.games.framework.FileIO;

import java.io.*;

public class Settings
{
    public static boolean soundEnabled = true;
    public static boolean musicEnabled = true;

    public static int[]   highscores   = new int[] { 100, 80, 50, 30, 10 };

    public static void load ( FileIO files )
    {
        BufferedReader in = null;
        try
        {
            in = new BufferedReader (
                    new InputStreamReader ( files.readFile ( "/The Snake Of Eden/.thesnakeofeden" ) ) );
            soundEnabled = Boolean.parseBoolean ( in.readLine () );
            musicEnabled = Boolean.parseBoolean ( in.readLine () );
            for ( int i = 0; i < 5; i++ )
            {
                highscores[ i ] = Integer.parseInt ( in.readLine () );
            }
        }
        catch ( IOException ignored )
        {

        }
        catch ( NumberFormatException ignored )
        {

        }
        finally
        {
            try
            {
                if ( in != null )
                {
                    in.close ();
                }
            }
            catch ( IOException ignored )
            {

            }
        }
    }

    public static void save ( FileIO files )
    {
        BufferedWriter out = null;
        try
        {
            out = new BufferedWriter (
                    new OutputStreamWriter ( files.writeFile ( "/The Snake Of Eden/.thesnakeofeden" ) ) );
            out.write ( Boolean.toString ( soundEnabled ) );
            out.write ( Boolean.toString ( musicEnabled ) );
            for ( int i = 0; i < 5; i++ )
            {
                out.write ( Integer.toString ( highscores[ i ] ) );
            }
        }
        catch ( IOException ignored )
        {

        }
        finally
        {
            try
            {
                if ( out != null )
                {
                    out.close ();
                }
            }
            catch ( IOException ignored )
            {

            }
        }
    }

    public static void addScore ( int score )
    {
        for ( int i = 0; i < 5; i++ )
        {
            if ( highscores[ i ] < score )
            {
                System.arraycopy ( highscores, i, highscores, i + 1, 4 - i );
                highscores[ i ] = score;
                break;
            }
        }
    }
}
