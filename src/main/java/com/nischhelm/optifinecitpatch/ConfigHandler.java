package com.nischhelm.optifinecitpatch;

import com.cleanroommc.configanytime.ConfigAnytime;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = OptiFineCITPatch.MODID)
@Mod.EventBusSubscriber(modid = OptiFineCITPatch.MODID)
public class ConfigHandler {
    @Config.Comment("Enchanted Books will not have Enchantment Glint if set to true.")
    @Config.Name("Remove Glint")
    @Config.RequiresMcRestart
    public static boolean removeGlint = false;

    @Config.Comment("Will not spam the startup log with one line per registered CIT if enabled.")
    @Config.Name("Remove Log Spam")
    @Config.RequiresMcRestart
    public static boolean removeLogSpam = true;

    @Config.Comment("Will only render a CIT for the first enchant on a book with multiple enchantments.")
    @Config.Name("Only First Enchant")
    @Config.RequiresMcRestart
    public static boolean onlyFirstEnchant = true;

    @Config.Comment("Fixes CITs breaking completely if an enchantment couldn't be found.")
    @Config.Name("Fix Missing Enchantment")
    @Config.RequiresMcRestart
    public static boolean fixMissingEnchantment = true;

    static {
        ConfigAnytime.register(ConfigHandler.class);
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(OptiFineCITPatch.MODID)) {
            ConfigManager.sync(OptiFineCITPatch.MODID, Config.Type.INSTANCE);
        }
    }
}
