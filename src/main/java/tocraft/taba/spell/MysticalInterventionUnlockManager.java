package tocraft.taba.spell;

import am2.api.events.SpellCastingEvent;
import am2.api.spell.enums.SkillPointTypes;
import am2.api.spell.enums.SpellCastResult;
import am2.playerextensions.ExtendedProperties;
import am2.playerextensions.SkillData;
import am2.spell.SkillTreeManager;
import am2.spell.SpellUtils;
import am2.spell.components.DivineIntervention;
import am2.spell.components.EnderIntervention;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import tocraft.taba.Taba;

public class MysticalInterventionUnlockManager {
   @SubscribeEvent
   public void onCast(SpellCastingEvent.Post event) {
      if (event.caster instanceof EntityPlayerMP) {
         EntityPlayerMP player = (EntityPlayerMP)event.caster;
         if (ExtendedProperties.For(player).getCurrentMana() >= event.manaCost && event.castResult == SpellCastResult.SUCCESS) {
            ItemStack stack = event.stack;
            checkSpell(player, stack);
        }
     }
  }

   private void checkSpell(EntityPlayerMP player, ItemStack stack) {
      boolean divineFound = false;
      boolean enderFound = false;

      for(int stage = 0; stage < SpellUtils.instance.numStages(stack); ++stage) {
         if (SpellUtils.instance.componentIsPresent(stack, DivineIntervention.class, stage)) {
            divineFound = true;
         }

         if (SpellUtils.instance.componentIsPresent(stack, EnderIntervention.class, stage)) {
            enderFound = true;
         }
      }

      if (divineFound && enderFound) {
         this.unlock(player);
      }

   }

   private void unlock(EntityPlayerMP player) {
      SkillData.For(player).incrementSpellPoints(SkillPointTypes.SILVER);
      SkillData.For(player).learn(SkillTreeManager.instance.getSkillTreeEntry(Taba.mysticalIntervention).registeredItem);
      SkillData.For(player).forceSync();
   }
}
