package dev.glabay.rsps.plugin.world.npc.impl.karamja;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Npcs.PIRATE_JACKIE_THE_FRUIT;
import static io.xeros.model.definition.Npcs.PIRATE_JACKIE_THE_FRUIT_7651;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class PirateJackieTheFruit extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { PIRATE_JACKIE_THE_FRUIT, PIRATE_JACKIE_THE_FRUIT_7651 };
    }

    @Override
    public Boolean handleActionOne(Player player, NPC npc) {
        player.getDiaryManager().getKaramjaDiary().claimReward();
        return true;
    }
}
