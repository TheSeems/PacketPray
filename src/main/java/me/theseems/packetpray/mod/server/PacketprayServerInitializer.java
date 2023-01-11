package me.theseems.packetpray.mod.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PacketprayServerInitializer implements DedicatedServerModInitializer {
    private static final Logger LOGGER = LogManager.getLogger(PacketprayServerInitializer.class);

    @Override
    public void onInitializeServer() {
        LOGGER.info("[Server] PacketPray is praying for your BetterMC from now on...");
    }
}
