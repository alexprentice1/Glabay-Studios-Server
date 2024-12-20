package dev.glabay.rsps.plugin.world.item.impl.prayer;

import dev.glabay.rsps.plugin.world.item.WorldItemAction;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Dialogues.ARCANE_PRAYER_SCROLL_DIALOGUE;
import static io.xeros.model.definition.Items.ARCANE_PRAYER_SCROLL;
import static io.xeros.model.definition.Npcs.BROTHER_JERED;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */

public class ArcanePrayerScroll extends WorldItemAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { ARCANE_PRAYER_SCROLL };
    }

    @Override
    public Boolean handleActionOne(Player player, int itemId, int slotId, int interfaceId) {
        player.getDH().sendDialogues(ARCANE_PRAYER_SCROLL_DIALOGUE, BROTHER_JERED);
        return true;
    }
}
