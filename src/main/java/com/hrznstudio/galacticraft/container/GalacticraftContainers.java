package com.hrznstudio.galacticraft.container;

import com.hrznstudio.galacticraft.Constants;
import com.hrznstudio.galacticraft.blocks.machines.basicsolarpanel.BasicSolarPanelContainer;
import com.hrznstudio.galacticraft.blocks.machines.circuitfabricator.CircuitFabricatorContainer;
import com.hrznstudio.galacticraft.blocks.machines.coalgenerator.CoalGeneratorContainer;
import com.hrznstudio.galacticraft.blocks.machines.compressor.CompressorContainer;
import com.hrznstudio.galacticraft.blocks.machines.electriccompressor.ElectricCompressorContainer;
import com.hrznstudio.galacticraft.blocks.machines.energystoragemodule.EnergyStorageModuleContainer;
import com.hrznstudio.galacticraft.blocks.machines.oxygencollector.OxygenCollectorContainer;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.util.Identifier;

/**
 * @author <a href="https://github.com/StellarHorizons">StellarHorizons</a>
 */
public class GalacticraftContainers {
    public static final Identifier PLAYER_INVENTORY_CONTAINER = new Identifier(Constants.MOD_ID, Constants.Container.PLAYER_INVENTORY_CONTAINER);

    public static final Identifier COAL_GENERATOR_CONTAINER = new Identifier(Constants.MOD_ID, Constants.Container.COAL_GENERATOR_CONTAINER);
    public static final Identifier BASIC_SOLAR_PANEL_CONTAINER = new Identifier(Constants.MOD_ID, Constants.Container.BASIC_SOLAR_PANEL_CONTAINER);
    public static final Identifier CIRCUIT_FABRICATOR_CONTAINER = new Identifier(Constants.MOD_ID, Constants.Container.CIRCUIT_FABRICATOR_CONTAINER);
    public static final Identifier COMPRESSOR_CONTAINER = new Identifier(Constants.MOD_ID, Constants.Container.COMPRESSOR_CONTAINER);
    public static final Identifier ELECTRIC_COMPRESSOR_CONTAINER = new Identifier(Constants.MOD_ID, Constants.Container.ELECTRIC_COMPRESSOR_CONTAINER);
    public static final Identifier ENERGY_STORAGE_MODULE_CONTAINER = new Identifier(Constants.MOD_ID, Constants.Container.ENERGY_STORAGE_MODULE_CONTAINER);
    public static final Identifier REFINERY_CONTAINER = new Identifier(Constants.MOD_ID, Constants.Container.REFINERY_CONTAINER);
    public static final Identifier OXYGEN_COLLECTOR_CONTAINER = new Identifier(Constants.MOD_ID, Constants.Container.OXYGEN_COLLECTOR_CONTAINER);

    public static void register() {
        ContainerProviderRegistry.INSTANCE.registerFactory(PLAYER_INVENTORY_CONTAINER, (syncId, id, player, buf) -> new PlayerInventoryGCContainer(player.inventory, !player.world.isClient, player));

        ContainerProviderRegistry.INSTANCE.registerFactory(COAL_GENERATOR_CONTAINER, CoalGeneratorContainer.FACTORY);
        ContainerProviderRegistry.INSTANCE.registerFactory(CIRCUIT_FABRICATOR_CONTAINER, CircuitFabricatorContainer.FACTORY);
        ContainerProviderRegistry.INSTANCE.registerFactory(BASIC_SOLAR_PANEL_CONTAINER, BasicSolarPanelContainer.FACTORY);
        ContainerProviderRegistry.INSTANCE.registerFactory(COMPRESSOR_CONTAINER, (syncId, id, player, buf) -> new CompressorContainer(syncId, buf.readBlockPos(), player));
        ContainerProviderRegistry.INSTANCE.registerFactory(ELECTRIC_COMPRESSOR_CONTAINER, (syncId, id, player, buf) -> new ElectricCompressorContainer(syncId, buf.readBlockPos(), player));
        ContainerProviderRegistry.INSTANCE.registerFactory(ENERGY_STORAGE_MODULE_CONTAINER, (syncId, id, player, buf) -> new EnergyStorageModuleContainer(syncId, buf.readBlockPos(), player));
        ContainerProviderRegistry.INSTANCE.registerFactory(OXYGEN_COLLECTOR_CONTAINER, (syncId, id, player, buf) -> new OxygenCollectorContainer(syncId, buf.readBlockPos(), player));
    }
}
