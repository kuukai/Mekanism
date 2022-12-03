package mekanism.common.tier;

import java.util.function.Consumer;
import mekanism.common.Mekanism;
import mekanism.common.block.states.BlockStateMachine.MachineType;
import net.minecraft.util.ResourceLocation;

public enum FactoryTier implements ITier {
    BASIC(3, new ResourceLocation(Mekanism.MODID, "gui/factory/GuiBasicFactory.png")),
    ADVANCED(5, new ResourceLocation(Mekanism.MODID, "gui/factory/GuiAdvancedFactory.png")),
    ELITE(7, new ResourceLocation(Mekanism.MODID, "gui/factory/GuiEliteFactory.png")),
    ULTIMATE(9, new ResourceLocation(Mekanism.MODID, "gui/factory/GuiUltimateFactory.png"));

    public final int processes;
    public final ResourceLocation guiLocation;
    private final BaseTier baseTier;

    FactoryTier(int process, ResourceLocation gui) {
        processes = process;
        guiLocation = gui;
        baseTier = BaseTier.values()[ordinal()];
    }

    @Override
    public BaseTier getBaseTier() {
        return baseTier;
    }

    public static void forEnabled(Consumer<FactoryTier> consumer) {
        if (MachineType.BASIC_FACTORY.isEnabled()) {
            consumer.accept(FactoryTier.BASIC);
        }
        if (MachineType.ADVANCED_FACTORY.isEnabled()) {
            consumer.accept(FactoryTier.ADVANCED);
        }
        if (MachineType.ELITE_FACTORY.isEnabled()) {
            consumer.accept(FactoryTier.ELITE);
        }
        if (MachineType.ULTIMATE_FACTORY.isEnabled()) {
            consumer.accept(FactoryTier.ULTIMATE);
        }
    }
}