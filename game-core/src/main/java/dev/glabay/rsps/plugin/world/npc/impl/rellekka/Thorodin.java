package dev.glabay.rsps.plugin.world.npc.impl.rellekka;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Npcs.THORODIN;
import static io.xeros.model.definition.Npcs.THORODIN_5526;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class Thorodin extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { THORODIN, THORODIN_5526 };
    }

    @Override
    public Boolean handleActionOne(Player player, NPC npc) {
        player.getDiaryManager().getFremennikDiary().claimReward();
        return true;
    }
}
