package dev.glabay.rsps.plugin.world.npc.impl.portphasmatys;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Npcs.AKHARANU;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class AkHaranu extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { AKHARANU  };
    }

    @Override
    public Boolean handleActionTwo(Player player,NPC npc) {
        player.getPrestige().openPrestige();
        return true;
    }
}
