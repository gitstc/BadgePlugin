package com.stc.BadgePlugin.util;

import android.database.Cursor;

/**
 * @author leolin
 */
public class CloseHelper {
    public static void close(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
}
