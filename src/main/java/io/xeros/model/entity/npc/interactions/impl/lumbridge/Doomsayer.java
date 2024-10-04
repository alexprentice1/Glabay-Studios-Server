package io.xeros.model.entity.npc.interactions.impl.lumbridge;

import io.xeros.Configuration;
import io.xeros.content.referral.EnterReferralDialogue;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.npc.interactions.NpcOptionAction;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.Npcs.*;

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
        return new Integer[] { DOOMSAYER, DOOMSAYER_2 };
    }

    @Override
    public Boolean handleActionOne(Player player, NPC npc) {
        if (!player.pkDistrict) {
            player.sendMessage("You cannot do this right now.");
            return false;
        }
        player.getDH().sendDialogues(800, 6773);
        return true;
    }

    @Override
    public Boolean handleActionTwo(Player player, NPC npc) {
        if (!player.pkDistrict) {
            player.sendMessage("You cannot do this right now.");
            return false;
        }
        player.getDH().sendDialogues(800, 6773);
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