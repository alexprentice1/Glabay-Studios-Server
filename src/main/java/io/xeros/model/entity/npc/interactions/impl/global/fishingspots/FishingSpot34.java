package io.xeros.model.entity.npc.interactions.impl.global.fishingspots;

import io.xeros.content.skills.Fishing;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.npc.interactions.NpcOptionAction;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.Npcs.FISHING_SPOT_34;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class FishingSpot34 extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { FISHING_SPOT_34 };
    }

    @Override
    public Boolean handleActionOne(Player player, NPC npc) {
        player.clickNpcType = 1;
        Fishing.attemptdata(player, 1); //Not true NPC ID -- check Fishing.Java
        return true;
    }

    @Override
    public Boolean handleActionTwo(Player player, NPC npc) {
        Fishing.attemptdata(player, 2); //Not true NPC ID -- check Fishing.Java
        return true;
}
}
