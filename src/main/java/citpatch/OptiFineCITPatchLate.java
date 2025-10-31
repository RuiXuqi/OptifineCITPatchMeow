package citpatch;

import net.minecraftforge.fml.client.FMLClientHandler;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class OptiFineCITPatchLate implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        List<String> mixins = new ArrayList<>();
        if (FMLClientHandler.instance().hasOptifine()) {
            if (ConfigHandler.removeLogSpam) {
                mixins.add("mixins.optifinecitpatch.logspam.json");
            }
            if (ConfigHandler.onlyFirstEnchant) {
                mixins.add("mixins.optifinecitpatch.firstenchant.json");
            }
            if (ConfigHandler.fixMissingEnchantment) {
                mixins.add("mixins.optifinecitpatch.fixmissing.json");
            }
            if (ConfigHandler.reloadOnLogin) {
                mixins.add("mixins.optifinecitpatch.reloadonlogin.json");
            }
        } else {
            OptiFineCITPatch.LOGGER.info("Mod not needed without optifine, auto-disabling");
        }
        return mixins;
    }
}
