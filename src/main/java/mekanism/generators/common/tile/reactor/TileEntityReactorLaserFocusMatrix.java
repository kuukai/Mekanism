package mekanism.generators.common.tile.reactor;

import mekanism.api.lasers.ILaserReceptor;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.util.InventoryUtils;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class TileEntityReactorLaserFocusMatrix extends TileEntityReactorBlock implements ILaserReceptor
{
	@Override
	public boolean isFrame()
	{
		return false;
	}

	@Override
	public void receiveLaserEnergy(double energy, EnumFacing side)
	{
		if(getReactor() != null)
		{
			getReactor().addTemperatureFromEnergyInput(energy);
		}
	}

	@Override
	public boolean canLasersDig()
	{
		return false;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing side)
	{
		return capability == Capabilities.LASER_RECEPTOR_CAPABILITY || super.hasCapability(capability, side);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing side)
	{
		if(capability == Capabilities.LASER_RECEPTOR_CAPABILITY)
		{
			return (T)this;
		}
		
		return super.getCapability(capability, side);
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side)
	{
		return InventoryUtils.EMPTY;
	}
}
