package optifinecitpatch.mixin.optifine;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.optifine.config.ParserEnchantmentId;
import optifinecitpatch.ConfigHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ParserEnchantmentId.class)
public abstract class ParserEnchantmentIdMixin {

    @ModifyReturnValue(method = "parse", at = @At("RETURN"), remap = false)
    private int optifinecitpatch_overrideReturnIfDefault(int returnValue, @Local(argsOnly = true) int defValue) {
        return ConfigHandler.fixMissingEnchantment && returnValue == defValue ? -1 : returnValue;
    }
}
