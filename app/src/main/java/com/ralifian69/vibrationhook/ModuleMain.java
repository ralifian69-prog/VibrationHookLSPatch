package com.ralifian69.vibrationhook;

import android.util.Log;

import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedModuleInterface.PackageLoadedParam;

public class ModuleMain extends XposedModule {

    private static final String TAG = "VibrationHook";
    private static final String TARGET_PACKAGE =
            "com.FishingPlanetLL.FishingPlanet";

    @Override
    public void onPackageLoaded(PackageLoadedParam param) {

        if (!TARGET_PACKAGE.equals(param.getPackageName())) {
            return;
        }

        Log.i(TAG, "Fishing Planet ditemukan!");
        Log.i(TAG, "Process: " + param.getProcessName());
        Log.i(TAG, "ClassLoader: " + param.getDefaultClassLoader());
    }
}
