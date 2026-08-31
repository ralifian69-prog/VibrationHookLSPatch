package com.ralifian69.vibrationhook;

import io.github.libxposed.api.XposedModule;

public class ModuleMain extends XposedModule {

    @Override
    public void onModuleLoaded() {
        log(Log.INFO, "VibrationHook", "Module berhasil dimuat");
    }

    @Override
    public void onPackageLoaded(PackageLoadedParam param) {
        if (!"com.FishingPlanetLLC.FishingPlanet".equals(param.getPackageName())) {
            return;
        }

        log(Log.INFO, "VibrationHook",
                "Fishing Planet terdeteksi: " + param.getPackageName());
    }
}
