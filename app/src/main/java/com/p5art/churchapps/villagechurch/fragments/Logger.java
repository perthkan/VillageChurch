package com.p5art.churchapps.villagechurch.fragments;

import android.util.Log;
import org.json.JSONObject;

public class Logger {
    private static final String TAG_PREFIX = "VCApp";
    private static final String TAG = TAG_PREFIX + Logger.class.getSimpleName();

    private static String stackTraceToString(StackTraceElement[] stackTraceElements) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                stringBuilder.append(stackTraceElement.toString()).append(Globals.LineSeparator);
            }

            return stringBuilder.toString();
        } catch (Exception err) {
            Log.e(TAG, "Failed to convert stack trace to string.");
            err.printStackTrace();

            return "Exception occurred in converting stack trace to string.";
        }
    }

    /*
     * Exception that needs to be fixed.
     */
    public static void exception(Exception e) {
        try {
            error(TAG,
                    "!!!Exception!!!" + Globals.LineSeparator + e.toString() + Globals.LineSeparator
                            + stackTraceToString(e.getStackTrace()));
            e.printStackTrace();
        } catch (Exception err) {
            Log.e(TAG, "Failed to write error log.");
            err.printStackTrace();
        }
    }

    /*
 * Exception that is already handled.
 */
    public static void handledException(Exception e) {
        try {
            verbose(TAG, "Handled exception: " + e.toString());
        } catch (Exception err) {
            Log.e(TAG, "Failed to write error log.");
            err.printStackTrace();
        }
    }

    /*
     * Having some wrong data that CANNOT be corrected or discarded.
     *
     * Running into some wrong condition that CANNOT be bypassed.
     *
     * "error" indicates need of redesign.
     */
    public static void error(String tag, String msg) {
        try {
            String completeTag = buildCompleteTag(tag);
            Log.e(completeTag, msg);
        } catch (Exception err) {
            Log.e(TAG, "Failed to write error log.");
            err.printStackTrace();
        }
    }

    /*
     * Having some wrong data that can be corrected or discarded.
     *
     * Running into some wrong condition that can be bypassed.
     *
     * "warning" indicates need of bug fix. (bug is in other parts of the system)
     */
    public static void warning(String tag, String msg) {
        try {
            String completeTag = buildCompleteTag(tag);
            Log.w(completeTag, msg);
        } catch (Exception err) {
            Log.e(TAG, "Failed to write error log.");
            err.printStackTrace();
        }
    }

    /*
     * Exception caused by other parts in the system and cannot be fixed in AppLock.
     */
    public static void warning(String tag, String msg, Exception e) {
        try {
            warning(buildCompleteTag(tag), "!Warning!" + Globals.LineSeparator + msg + Globals.LineSeparator + e.toString() + Globals.LineSeparator
                    + stackTraceToString(e.getStackTrace()));
            e.printStackTrace();
        } catch (Exception err) {
            Log.e(TAG, "Failed to write error log.");
            err.printStackTrace();
        }
    }

    /*
     * Having some wrong input (from outside the app)
     */
    public static void abnormal(String tag, String msg) {
        try {
            String completeTag = buildCompleteTag(tag);
            Log.i(completeTag, msg);
        } catch (Exception err) {
            Log.e(TAG, "Failed to write error log.");
            err.printStackTrace();
        }
    }

    /*
     * Turning point.
     *
     * Code is running into a certain logic on some condition/input. (The condition/input is correct)
     */
    public static void conditional(String tag, String msg) {
        try {
            String completeTag = buildCompleteTag(tag);
            Log.d(completeTag, msg);
        } catch (Exception err) {
            Log.e(TAG, "Failed to write error log.");
            err.printStackTrace();
        }
    }

    public static void verbose(String tag, String msg) {
        try {
            String completeTag = buildCompleteTag(tag);
            Log.v(completeTag, msg);
        } catch (Exception err) {
            Log.e(TAG, "Failed to write error log.");
            err.printStackTrace();
        }
    }

    private static final int log_length_limit = 1000;

    public static void verbose(String tag, String msg, JSONObject jsonObject) {
        try {
            if(jsonObject == null){
                verbose(tag, msg + " the json object is null");
                return;
            }

            String completeTag = buildCompleteTag(tag);
            String jsonString = jsonObject.toString(4);

            boolean isFirstPart = true;
            do {
                int subStringLength = Math.min(jsonString.length(), log_length_limit);
                String strToLog = jsonString.substring(0, subStringLength);
                jsonString = jsonString.substring(subStringLength);

                if(isFirstPart) {
                    Log.v(completeTag, msg + " json: " + Globals.LineSeparator + strToLog);
                    isFirstPart = false;
                }else{
                    Log.v(completeTag, strToLog);
                }
            } while(jsonString.length() > log_length_limit);

            Log.v(completeTag, jsonString);
        } catch (Exception err) {
            Log.e(TAG, "Failed to write error log.");
            err.printStackTrace();
        }
    }

    private static String buildCompleteTag(String tag) {
        try {
            return TAG_PREFIX + tag + ">" + Thread.currentThread().getName();
        } catch (Exception err) {
            Log.e(TAG, "Failed to build complete tag.");
            err.printStackTrace();
            return null;
        }
    }
}
