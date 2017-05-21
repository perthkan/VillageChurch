package com.p5art.churchapps.villagechurch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.p5art.churchapps.villagechurch.fragments.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

public class SharedPreferenceManager {
	private static final String TAG = SharedPreferenceManager.class.getSimpleName();

	public static String VillageChurchAppSharedPreferences = "VillageChurchAppSharedPreferences";

	public static final String Key = "Key";

	public static final int Value = 0;

	// SharedPreferences
	public static SharedPreferences sharedPreferences = null;
	public static Editor sharedPreferencesEditor = null;

	@SuppressLint("InlinedApi")
	private static void intiSP() {
		try {
			sharedPreferences = VCApp.getContext().getSharedPreferences(VillageChurchAppSharedPreferences, Context.MODE_PRIVATE);
			sharedPreferencesEditor = sharedPreferences.edit();
		} catch (Exception err) {
			Logger.exception(err);
		}
	}

	private static SharedPreferences getSPReader() {
		intiSP();
		return sharedPreferences;
	}

	private static Editor getSPWriter() {
		intiSP();
		return sharedPreferencesEditor;
	}

	public static void init() {
		try {

		} catch (Exception err) {
			Logger.exception(err);
		}
	}

    public static synchronized float getFloat(String fieldName, float defaultValue) {
        try {
            float retVal = getSPReader().getFloat(fieldName, defaultValue);
            Logger.verbose(TAG, "get " + fieldName + " = " + retVal);
            return retVal;
        } catch (Exception err) {
            Logger.exception(err);
            return defaultValue;
        }
    }

    public static synchronized void putFloat(String fieldName, float value) {
        try {
            Editor spWriter = getSPWriter();
            spWriter.putFloat(fieldName, value);
            spWriter.commit();
            Logger.verbose(TAG, "put " + fieldName + " = " + value);
        } catch (Exception err) {
            Logger.exception(err);
        }
    }

	public static synchronized int getInt(String fieldName, int defaultValue) {
		try {
			int retVal = getSPReader().getInt(fieldName, defaultValue);
			Logger.verbose(TAG, "get " + fieldName + " = " + retVal);
			return retVal;
		} catch (Exception err) {
			Logger.exception(err);
			return defaultValue;
		}
	}

	public static synchronized void putInt(String fieldName, int value) {
		try {
			Editor spWriter = getSPWriter();
			spWriter.putInt(fieldName, value);
			spWriter.commit();
			Logger.verbose(TAG, "put " + fieldName + " = " + value);
		} catch (Exception err) {
			Logger.exception(err);
		}
	}

	public static synchronized long getLong(String fieldName, long defaultValue) {
		try {
			long retVal = getSPReader().getLong(fieldName, defaultValue);
			Logger.verbose(TAG, "get " + fieldName + " = " + retVal);
			return retVal;
		} catch (Exception err) {
			Logger.exception(err);
			return defaultValue;
		}
	}

	public static synchronized void putLong(String fieldName, long value) {
		try {
			Editor spWriter = getSPWriter();
			spWriter.putLong(fieldName, value);
			spWriter.commit();
			Logger.verbose(TAG, "put " + fieldName + " = " + value);
		} catch (Exception err) {
			Logger.exception(err);
		}
	}

	public static synchronized Boolean getBoolean(String fieldName, Boolean defaultValue) {
		try {
			Boolean retVal = getSPReader().getBoolean(fieldName, defaultValue);
			Logger.verbose(TAG, "get " + fieldName + " = " + retVal);
			return retVal;
		} catch (Exception err) {
			Logger.exception(err);
			return defaultValue;
		}
	}

	public static synchronized void putBoolean(String fieldName, Boolean value) {
		try {
			Editor spWriter = getSPWriter();
			spWriter.putBoolean(fieldName, value);
			spWriter.commit();
			Logger.verbose(TAG, "put " + fieldName + " = " + value);
		} catch (Exception err) {
			Logger.exception(err);
		}
	}

	public static synchronized String getString(String fieldName, String defaultValue) {
		try {
			String retVal = getSPReader().getString(fieldName, defaultValue);
			Logger.verbose(TAG, "get " + fieldName + " = " + retVal);
			return retVal;
		} catch (Exception err) {
			Logger.exception(err);
			return defaultValue;
		}
	}

	public static synchronized void putString(String fieldName, String value) {
		try {
			Editor spWriter = getSPWriter();
			spWriter.putString(fieldName, value);
			spWriter.commit();
			Logger.verbose(TAG, "put " + fieldName + " = " + value);
		} catch (Exception err) {
			Logger.exception(err);
		}
	}

	public static synchronized JSONArray getJsonArray(String fieldName) {
		try {
			String stringRep = getSPReader().getString(fieldName, "");
			Logger.verbose(TAG, "get " + fieldName + " = " + stringRep);

			if (stringRep.length() > 0) {
				try {
					return new JSONArray(stringRep);
				} catch (Exception e) {
					Logger.verbose(TAG, "it's not a JSON Array. " + stringRep);
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception err) {
			Logger.exception(err);
			return null;
		}
	}

	public static synchronized JSONObject getJsonObject(String fieldName) {
		try {
			String stringRep = getSPReader().getString(fieldName, "");
			Logger.verbose(TAG, "get " + fieldName + " = " + stringRep);

			if (stringRep.length() > 0) {
				try {
					return new JSONObject(stringRep);
				} catch (Exception e) {
					Logger.verbose(TAG, "it's not a JSON Object. " + stringRep);
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception err) {
			Logger.exception(err);
			return null;
		}
	}

	public static synchronized void putJson(String fieldName, Object jsonObjectOrArray) {
		try {
			String value = jsonObjectOrArray.toString();

			Editor spWriter = getSPWriter();
			spWriter.putString(fieldName, value);
			spWriter.commit();
			Logger.verbose(TAG, "put " + fieldName + " = " + value);
		} catch (Exception err) {
			Logger.exception(err);
		}
	}

}
