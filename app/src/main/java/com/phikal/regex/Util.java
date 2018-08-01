package com.phikal.regex;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Vibrator;
import android.preference.PreferenceManager;

public class Util {
    private Util() { }

    public static final String // preference names
            GAME_MODE = "game_",
            CURRENT_TASK = "task_",
            CHAR_BAR_ON = "charm",
            FEEDBACK_ON = "notif",
            CURRENT_INPUT = "input_",
            VERSION = "vers",
            MODE = "mode",
            COUNT = "_count",
            PROGRESS = "_progress";

    public static final String[]
            CHARS = {"[", "]", "(", ")", ".", "*", "+", "?", "^", "|", "{", "}", "-", "\\"};

    public static void notif(Context ctx) {
        Ringtone r = RingtoneManager.getRingtone(ctx, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        Vibrator v = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);

        if (PreferenceManager.getDefaultSharedPreferences(ctx)
                .getBoolean(FEEDBACK_ON, false)) {
            if (r != null) r.play();
            if (v != null) v.vibrate(250);
        }
    }


}
