package dev.glabay.rsps.plugin.world.npc.impl.global;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.content.skills.crafting.Tanning;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Npcs.TANNER;
import static io.xeros.model.definition.Shops.CRAFTING_SHOP;

/**
 * @author Glabay | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Glabay
 * @since 2024-10-01
 */
public class Tanner extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { TANNER };
    }

    @Override
    public Boolean handleActionOne(Player player, NPC npc) {
        Tanning.sendTanningInterface(player);
        return true;
    }

    @Override
    public Boolean handleActionTwo(Player player, NPC npc) {
        player.getShops().openShop(CRAFTING_SHOP);
        return true;
    }
}
