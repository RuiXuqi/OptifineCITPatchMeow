package optifinecitpatch;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
public class OptiFineCITPatchPlugin implements IFMLLoadingPlugin, IEarlyMixinLoader {

	public OptiFineCITPatchPlugin() {
	}

	@Override
	public String[] getASMTransformerClass()
	{
		return new String[0];
	}

	@Override
	public String getModContainerClass()
	{
		return null;
	}

	@Override
	public String getSetupClass()
	{
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) { }

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}

	@Override
	public List<String> getMixinConfigs() {
		return isOptiFineLoaded() ? Arrays.asList("mixins.optifinecitpatch.vanilla.json", "mixins.optifinecitpatch.optifine.json") : Collections.singletonList("mixins.optifinecitpatch.vanilla.json");
	}

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
}