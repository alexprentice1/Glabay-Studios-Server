package dev.glabay.rsps.plugin.world.item.impl.wilderness;

import dev.glabay.rsps.plugin.world.item.WorldItemAction;
import io.xeros.content.miniquests.magearenaii.MageArenaII;
import io.xeros.model.entity.player.Player;

import static io.xeros.content.miniquests.magearenaii.MageArenaII.SYMBOL_ID;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */

public class EnchantedSymbol extends WorldItemAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { SYMBOL_ID };
    }

    @Override
    public Boolean handleActionOne(Player player, int itemId, int slotId, int interfaceId) {
        MageArenaII.handleEnchantedSymbol(player);
        return true;
    }
}
