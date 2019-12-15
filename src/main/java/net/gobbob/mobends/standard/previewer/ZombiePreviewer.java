package net.gobbob.mobends.standard.previewer;

import net.gobbob.mobends.standard.data.ZombieData;

public class ZombiePreviewer extends BipedPreviewer<ZombieData>
{

	/*
	 * The Entity is generated specifically just for preview, so
	 * it can be manipulated in any way.
	 */
	@Override
	public void prePreview(ZombieData data, String animationToPreview)
	{
		super.prePreview(data, animationToPreview);
	}

	@Override
	public void postPreview(ZombieData data, String animationToPreview)
	{
	}

}
