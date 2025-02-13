package dev.glabay.rsps.plugin.world.npc.impl.karamja.shilovillage;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.content.achievement_diary.impl.WesternDiaryEntry;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Dialogues.*;
import static io.xeros.model.definition.Npcs.DURADEL;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class Duradel extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { DURADEL };
    }

    @Override
    public Boolean handleActionOne(Player player, NPC npc) {
        if (player.combatLevel < 20) {
            player.getDH().sendNpcChat2("Do not waste my time peasent.", "You need a Combat level of 20.", DURADEL, "Duradel");
            return false;
        }
        player.getDH().sendDialogues(SLAYER_MASTER_IMPOSSIBLE_TASK_DIALOGUE, DURADEL);
        return true;
    }

    @Override
    public Boolean handleActionTwo(Player player, NPC npc) {
        if (player.fullVoidMelee()) {
            player.getDiaryManager().getWesternDiary().progress(WesternDiaryEntry.FULL_VOID);
        }
        if (player.getSlayer().getTask().isPresent()) {
            player.getDH().sendDialogues(SLAYER_MASTER_TASK_RESET_DIALOGUE, DURADEL);
        } else {
            player.getDH().sendDialogues(SLAYER_MASTER_TASK_CHOICE_DIALOGUE, DURADEL);
        }
        return true;
}
}
