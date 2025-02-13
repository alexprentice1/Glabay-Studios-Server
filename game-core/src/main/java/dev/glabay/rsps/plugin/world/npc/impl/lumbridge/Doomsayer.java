package dev.glabay.rsps.plugin.world.npc.impl.lumbridge;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.Configuration;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Dialogues.DOOMSAYER_DIALOGUE;
import static io.xeros.model.definition.Npcs.DOOMSAYER;
import static io.xeros.model.definition.Npcs.DOOMSAYER_6774;
import static io.xeros.model.definition.Shops.DOOMSAYER_SHOP;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class Doomsayer extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[]{DOOMSAYER, DOOMSAYER_6774};
    }

    @Override
    public Boolean handleActionOne(Player player, NPC npc) {
        if (!player.pkDistrict) {
            player.sendMessage("You cannot do this right now.");
            return false;
        }
        player.getDH().sendDialogues(DOOMSAYER_DIALOGUE, DOOMSAYER);
        return true;
    }

    @Override
    public Boolean handleActionTwo(Player player, NPC npc) {
        player.getShops().openShop(DOOMSAYER_SHOP);
        return true;

    }

    @Override
    public Boolean handleActionThree(Player player, NPC npc) {
        player.isSkulled = true;
        player.skullTimer = Configuration.EXTENDED_SKULL_TIMER;
        player.headIconPk = 0;
        player.getPA().requestUpdates();
        player.sendMessage("@cr10@@blu@You are now skulled.");
        return true;
    }
}
