package optifinecitpatch;

import net.minecraft.launchwrapper.Launch;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptiFineCITPatchPluginLate implements ILateMixinLoader {

    public static boolean isOptiFineLoaded() {
        try {
            Method method = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
            method.setAccessible(true);
            boolean isPresent = method.invoke(Launch.classLoader, "optifine.OptiFineClassTransformer") != null;
            if (isPresent)
                OptiFineCITPatch.LOGGER.info("OptiFine CIT Patch: The following PACKAGE_CLASSLOADER_EXCLUSION error is fine, it actually shows that it works.");
            return isPresent;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<String> getMixinConfigs() {
        return isOptiFineLoaded() ? Collections.singletonList("mixins.optifinecitpatch.optifine.json") : Collections.emptyList();
    }
}
