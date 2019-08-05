package net.gobbob.mobends.core.pack.variable;

import net.gobbob.mobends.core.client.event.DataUpdateHandler;
import net.gobbob.mobends.core.data.EntityData;
import net.gobbob.mobends.core.data.LivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import java.util.HashMap;

public class BendsVariableRegistry
{

    public static final BendsVariableRegistry instance = new BendsVariableRegistry();

    private EntityData<?> tempData;
    private HashMap<String, BendsVariableEntry> variables = new HashMap<>();

    public void provideTemporaryData(EntityData<?> tempData)
    {
        this.tempData = tempData;
    }

    // Static methods

    static
    {
        registerVariable("ticks", DataUpdateHandler::getTicks);
        registerVariable("random", Math::random);
        registerVariable("ticksAfterPunch", () -> {
            if (instance.tempData instanceof LivingEntityData)
                return ((LivingEntityData<?>) instance.tempData).getTicksAfterAttack();
            return 0;
        });
        registerVariable("health", () -> {
            Entity entity = instance.tempData.getEntity();
            if (entity instanceof EntityLivingBase)
                return ((EntityLivingBase) entity).getHealth();
            return 0;
        });
    }

    private static void registerVariable(String key, IBendsVariable variable)
    {
        instance.variables.put(key, new BendsVariableEntry(variable, key));
    }

}
