package com.flashproductions.android.games.framework;

/**
 * Created by Flash Productions.
 * Date: 9/1/12
 * Time: 12:44 AM
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileIO
{
    public InputStream readAsset ( String fileName ) throws IOException;

    public InputStream readFile ( String fileName ) throws IOException;

    public OutputStream writeFile ( String FileName ) throws IOException;
}
