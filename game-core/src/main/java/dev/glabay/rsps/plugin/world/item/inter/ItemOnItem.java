package dev.glabay.rsps.plugin.world.item.inter;

import io.xeros.model.entity.player.Player;
import io.xeros.model.items.GameItem;

/**
 * @author Glabay | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Glabay
 * @since 2024-10-05
 */
public interface ItemOnItem {
    default Boolean handleItemOnItem(Player player, GameItem itemUsed, GameItem itemUsedOn) {
        return false;
    }
}
