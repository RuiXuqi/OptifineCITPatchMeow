package optifinecitpatch;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = OptiFineCITPatch.MODID,
        version = OptiFineCITPatch.VERSION,
        name = OptiFineCITPatch.NAME,
        dependencies = "required-after:mixinbooter",
        acceptableRemoteVersions = "*"
)
public class OptiFineCITPatch {
    public static final String MODID = "optifinecitpatch";
    public static final String VERSION = "1.0.4";
    public static final String NAME = "OptiFine CIT Patch Meow";
    public static final Logger LOGGER = LogManager.getLogger();
}