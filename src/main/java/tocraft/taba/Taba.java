package tocraft.taba;

import am2.AMCore;
import am2.api.ArsMagicaApi;
import am2.api.spell.component.interfaces.ISkillTreeEntry;
import am2.api.spell.enums.SkillPointTypes;
import am2.api.spell.enums.SkillTrees;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import tocraft.taba.spell.MysticalIntervention;
import tocraft.taba.spell.MysticalInterventionUnlockManager;

@Mod(
   modid = "taba",
   name = "There-and-back-again",
   dependencies = "required-after:arsmagica2;required-after:lotr"
)
public class Taba {
	public static final MysticalIntervention mysticalIntervention = new MysticalIntervention();
	
   @EventHandler
   public void postInit(FMLPostInitializationEvent event) {
	  ArsMagicaApi.instance.registerSkillTreeEntry(mysticalIntervention, "MysticalIntervention", SkillTrees.Utility, 75, 225, SkillPointTypes.SILVER, new ISkillTreeEntry[0]);
      AMCore.skillConfig.save();
      MinecraftForge.EVENT_BUS.register(new MysticalInterventionUnlockManager());
   }
}
