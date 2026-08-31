package com.ralifian69.vibrationhook;

import android.util.Log;

import java.lang.reflect.Method;

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

        try {
            Class<?> vibrationEffect = Class.forName(
                    "android.os.VibrationEffect",
                    false,
                    param.getDefaultClassLoader()
            );

            Method createOneShot = vibrationEffect.getDeclaredMethod(
                    "createOneShot",
                    long.class,
                    int.class
            );

            hook(createOneShot).intercept(chain -> {

                long duration = (long) chain.getArg(0);
                int amplitude = (int) chain.getArg(1);

                Log.i(
                        TAG,
                        "VIBRATION! duration="
                                + duration
                                + " amplitude="
                                + amplitude
                );

                return chain.proceed();
            });

            Log.i(TAG, "Hook VibrationEffect berhasil!");

        } catch (Throwable e) {
            Log.e(TAG, "Gagal hook VibrationEffect", e);
        }
    }
}
