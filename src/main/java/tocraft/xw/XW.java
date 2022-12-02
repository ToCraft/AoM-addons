package tocraft.xw;

import com.google.common.math.IntMath;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraftforge.common.util.EnumHelper;

@Mod(
   modid = "xw",
   version = "Version 1.0",
   name = "Xtra Waypoints",
   dependencies = "required-before:lotr"
)
public class XW {
   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
      XWaypoint.setupWaypoints();
      FMLLog.info("[To_Craft] XW: Registered Xtra Waypoints");
   }
   
   public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z) {
	      return addWaypoint(name, region, faction, x, z, false);
	   }

	   public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
	      Class[] classArr = new Class[]{LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE};
	      Object[] args = new Object[]{region, faction, x, z, hidden};
	      return (LOTRWaypoint)EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	   }
}
