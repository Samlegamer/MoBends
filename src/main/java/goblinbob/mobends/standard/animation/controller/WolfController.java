package goblinbob.mobends.standard.animation.controller;

import goblinbob.mobends.core.animation.controller.IAnimationController;
import goblinbob.mobends.core.animation.keyframe.AnimationLoader;
import goblinbob.mobends.core.animation.keyframe.KeyframeAnimation;
import goblinbob.mobends.core.client.event.DataUpdateHandler;
import goblinbob.mobends.core.kumo.state.KumoAnimatorState;
import goblinbob.mobends.core.kumo.state.template.AnimatorTemplate;
import goblinbob.mobends.core.kumo.state.template.MalformedKumoTemplateException;
import goblinbob.mobends.core.util.GsonResources;
import goblinbob.mobends.standard.data.WolfData;
import goblinbob.mobends.standard.main.ModStatics;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Collection;

/**
 * This is an animation controller for a wolf instance. It's a part of the
 * EntityData structure.
 *
 * @author Iwo Plaza
 */
public class WolfController implements IAnimationController<WolfData>
{

    protected static final ResourceLocation WOLF_ANIMATOR = new ResourceLocation(ModStatics.MODID, "animators/wolf.json");
    protected AnimatorTemplate animatorTemplate;
    protected KumoAnimatorState<WolfData> kumoAnimatorState;

    public WolfController()
    {
        try
        {
            animatorTemplate = GsonResources.get(WOLF_ANIMATOR, AnimatorTemplate.class);
            kumoAnimatorState = new KumoAnimatorState<>(animatorTemplate, key -> {
                try
                {
                    KeyframeAnimation animation = AnimationLoader.loadFromPath(key);
                    animation.mirrorRotationYZ("body");
                    animation.mirrorRotationYZ("head");
                    return animation;
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    return null;
                }
            });
        }
        catch (IOException | MalformedKumoTemplateException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    public Collection<String> perform(WolfData data)
    {
        try
        {
            kumoAnimatorState.update(data, DataUpdateHandler.ticksPerFrame);
        }
        catch (MalformedKumoTemplateException e)
        {
            e.printStackTrace();
        }

        // Head rotation
        //data.head.rotation.localRotateY(data.headYaw.get()).finish();
        //data.head.rotation.localRotateX(data.headPitch.get()).finish();

        //data.body.rotation.rotateZ(DataUpdateHandler.getTicks()).finish();

        return null;
    }

}
