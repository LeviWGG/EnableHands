package app.main.wangliwei.baselib.utils;

import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * Created by wangliwei on 2018/4/30.
 */

public final class UriUtils {
    private UriUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Return a content URI for a given file.
     *
     * @param file The file.
     * @return a content URI for a given file
     */
    public static Uri getUriForFile(final File file) {
        if (file == null) return null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String authority = BaseUtils.getApp().getPackageName() + ".utils.provider";
            return FileProvider.getUriForFile(BaseUtils.getApp(), authority, file);
        } else {
            return Uri.fromFile(file);
        }
    }
}
