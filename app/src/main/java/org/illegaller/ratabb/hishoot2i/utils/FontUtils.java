package org.illegaller.ratabb.hishoot2i.utils;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import java.io.File;

// TODO:  add cache file font typeface
public class FontUtils {
  private static final Typeface DEFAULT_TYPEFACE =
      Typeface.create("sans-serif-black", Typeface.BOLD);
  private static Typeface sBadgeTypeface;

  private FontUtils() {
    throw new AssertionError("no instance");
  }

  static Typeface getBadgeTypeface() {
    if (sBadgeTypeface == null) sBadgeTypeface = DEFAULT_TYPEFACE;
    return sBadgeTypeface;
  }

  public static void setBadgeTypeface(@NonNull final File file) {
    if (!file.exists() && !file.canRead()) return;
    try {
      sBadgeTypeface = Typeface.createFromFile(file);
    } catch (Exception e) {
      CrashLog.logError("FontUtils: " + file.getName(), e);
      FontUtils.setBadgeTypefaceDefault();
    }
  }

  public static void setBadgeTypefaceDefault() {
    sBadgeTypeface = DEFAULT_TYPEFACE;
  }
}
