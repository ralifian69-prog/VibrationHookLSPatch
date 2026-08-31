package com.ralifian69.vibrationhook;

import android.util.Log;

import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedModuleInterface.ModuleLoadedParam;
import io.github.libxposed.api.XposedModuleInterface.PackageLoadedParam;

public class ModuleMain extends XposedModule {

    private static final String TARGET_PACKAGE =
            "com.FishingPlanetLL.FishingPlanet";

    @Override
    public void onModuleLoaded(ModuleLoadedParam param) {
        log(
                Log.INFO,
                "VibrationHook",
                "Module berhasil dimuat: " + param.getProcessName()
        );
    }

    @Override
    public void onPackageLoaded(PackageLoadedParam param) {

        if (!TARGET_PACKAGE.equals(param.getPackageName())) {
            return;
        }

        log(
                Log.INFO,
                "VibrationHook",
                "Fishing Planet ditemukan!"
        );

        log(
                Log.INFO,
                "VibrationHook",
                "Process: " + param.getProcessName()
        );

        log(
                Log.INFO,
                "VibrationHook",
                "ClassLoader: " + param.getDefaultClassLoader()
        );
    }
}
