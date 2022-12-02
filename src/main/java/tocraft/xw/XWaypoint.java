package tocraft.xw;

import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.LOTRWaypoint;

public class XWaypoint {
   public static LOTRWaypoint Spawn;
   public static LOTRWaypoint Dwaling;
   public static LOTRWaypoint BombadilsHouse;
   public static LOTRWaypoint Withywindle;
   public static LOTRWaypoint GridleyIsland;

/*
 * NOTE:
 * 
 * The coordinates are diffrent to the normal ones.
 * Here's how you calculate them:
 * 
 * X: x/128+809.5
 * 
 * Y: y/128+725.5
 * 
 */
   public static void setupWaypoints() {
	   Dwaling = XW.addWaypoint("Dwaling", LOTRWaypoint.Region.SHIRE, LOTRFaction.HOBBIT, 841.9, 702);
	   BombadilsHouse = XW.addWaypoint("BombadilsHouse", LOTRWaypoint.Region.OLD_FOREST, LOTRFaction.UNALIGNED, 890.4, 743.4);
	   GridleyIsland = XW.addWaypoint("GridleyIsland", LOTRWaypoint.Region.SHIRE, LOTRFaction.HOBBIT, 851.4, 746.3);
   }
}
