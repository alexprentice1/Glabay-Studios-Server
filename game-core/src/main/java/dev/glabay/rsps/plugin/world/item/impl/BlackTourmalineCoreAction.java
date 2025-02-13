package dev.glabay.rsps.plugin.world.item.impl;

import dev.glabay.rsps.plugin.world.item.WorldItemAction;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Items.BLACK_TOURMALINE_CORE;

/**
 * @author Glabay | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Glabay
 * @since 2024-10-04
 */
public class BlackTourmalineCoreAction extends WorldItemAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { BLACK_TOURMALINE_CORE };
    }

    @Override
    public Boolean handleActionOne(Player player, int itemId, int slotId, int interfaceId) {
        player.sendStatement("Fallen from the centre of a Grotesque Guardian. This could be attached to a pair of Bandos boots...");
        return true;
    }
}
