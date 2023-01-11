package me.theseems.packetpray.mod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Environment(EnvType.CLIENT)
public class PacketprayClientInitializer implements ClientModInitializer {
    private static final Logger LOGGER = LogManager.getLogger(PacketprayClientInitializer.class);

    @Override
    public void onInitializeClient() {
        LOGGER.info("[Client] PacketPray is praying for your BetterMC from now on...");
    }
}
