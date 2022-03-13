package net.blahblahbal.coreascent.item.custom;

import net.blahblahbal.coreascent.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TadaniteArmorItem extends ArmorItem
{
    public TadaniteArmorItem(ArmorMaterial materialIn, EquipmentSlot slots, Properties builder)
    {
        super(materialIn, slots, builder);
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }

    public void onArmorTick(final ItemStack stack, final Level world, final Player player)
    {
        if(player instanceof Player)
        {
            ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
            ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

            //Full Set
            if(head.getItem() == ModItems.TADANITE_HELMET.get() &&
                    chest.getItem() == ModItems.TADANITE_CHESTPLATE.get() &&
                    legs.getItem() == ModItems.TADANITE_LEGGINGS.get() &&
                    feet.getItem() == ModItems.TADANITE_BOOTS.get())
            {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 1, false, false));
                //add warmth later
            }
        }
    }
}
