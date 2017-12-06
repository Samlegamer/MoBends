package net.gobbob.mobends.animation.player;

import net.gobbob.mobends.client.model.ModelPart;
import net.gobbob.mobends.client.model.entity.ModelBendsPlayer;
import net.gobbob.mobends.data.DataPlayer;
import net.minecraft.entity.player.EntityPlayer;

public class Animation_Attack_PunchStance {
	
	public static void animate(EntityPlayer player,ModelBendsPlayer model,DataPlayer data){
		if(!(data.motion.x == 0 & data.motion.z == 0)){
			return;
		}
		
		model.renderRotation.setSmoothY(20.0f);
		model.renderOffset.setSmoothY(-2.0f);
		
		((ModelPart)model.bipedRightArm).rotation.setSmoothX(-90,0.3f);
		((ModelPart)model.bipedRightForeArm).rotation.setSmoothX(-80,0.3f);
		
		((ModelPart)model.bipedLeftArm).rotation.setSmoothX(-90,0.3f);
		((ModelPart)model.bipedLeftForeArm).rotation.setSmoothX(-80,0.3f);
		
		((ModelPart)model.bipedRightArm).rotation.setSmoothZ(20,0.3f);
		((ModelPart)model.bipedLeftArm).rotation.setSmoothZ(-20,0.3f);
		
		((ModelPart)model.bipedBody).rotation.setSmoothX(10,0.3f);
		
		((ModelPart)model.bipedRightLeg).rotation.setSmoothX(-30,0.3f);
		((ModelPart)model.bipedLeftLeg).rotation.setSmoothX(-30,0.3f);
		((ModelPart)model.bipedLeftLeg).rotation.setSmoothY(-25,0.3f);
		((ModelPart)model.bipedRightLeg).rotation.setSmoothZ(10);
		((ModelPart)model.bipedLeftLeg).rotation.setSmoothZ(-10);
		
		((ModelPart)model.bipedRightForeLeg).rotation.setSmoothX(30,0.3f);
		((ModelPart)model.bipedLeftForeLeg).rotation.setSmoothX(30,0.3f);
		
		((ModelPart)model.bipedHead).rotation.setY(model.headRotationY-20);
		((ModelPart)model.bipedHead).rotation.setX(model.headRotationX-10);
	}
}