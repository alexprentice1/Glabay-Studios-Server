package dev.glabay.rsps.plugin.world.npc.impl.varrock;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.content.achievement_diary.impl.VarrockDiaryEntry;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Items.*;
import static io.xeros.model.definition.Npcs.APOTHECARY;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class Apothecary extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { APOTHECARY  };
    }

    @Override
    public Boolean handleActionOne(Player player,NPC npc) {
        if (player.getItems().playerHasItem(HARRALANDER) || player.getItems().playerHasItem(RED_SPIDERS_EGGS)) {
            player.sendMessage("The Apothecary takes your ingredients and creates a strength potion.");
            player.getItems().deleteItem(HARRALANDER, 1);
            player.getItems().deleteItem(RED_SPIDERS_EGGS, 1);
            player.getItems().addItem(STRENGTH_POTION3, 1);
            player.getDiaryManager().getVarrockDiary().progress(VarrockDiaryEntry.APOTHECARY_STRENGTH);
        }
        else {
            player.sendMessage("You must have a Limpwurt Root and Red Spiders' Eggs to do this.");
            return false;
        }
        return true;
    }
}
