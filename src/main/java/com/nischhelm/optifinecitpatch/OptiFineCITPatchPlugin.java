package com.nischhelm.optifinecitpatch;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
public class OptiFineCITPatchPlugin implements IFMLLoadingPlugin, IEarlyMixinLoader {

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
		List<String> mixins = new ArrayList<>();

		if (ConfigHandler.removeGlint) {
			mixins.add("mixins.optifinecitpatch.glint.json");
		}
		if (isOptiFineLoaded()){
			if (ConfigHandler.removeLogSpam){
				mixins.add("mixins.optifinecitpatch.logspam.json");
			}
			if (ConfigHandler.onlyFirstEnchant) {
				mixins.add("mixins.optifinecitpatch.firstenchant.json");
			}
			if (ConfigHandler.fixMissingEnchantment) {
				mixins.add("mixins.optifinecitpatch.fixmissing.json");
			}
		}

		return mixins;
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