package dev.glabay.rsps.plugin.world.loc.actions.handlers.areas.varrock.market;

import dev.glabay.rsps.plugin.world.loc.actions.WorldObjectAction;
import io.xeros.content.tradingpost.Listing;
import io.xeros.model.entity.player.Player;
import io.xeros.model.world.objects.GlobalObject;

import static io.xeros.model.definition.Objects.GRAND_EXCHANGE_BOOTH;
import static io.xeros.model.definition.Objects.GRAND_EXCHANGE_BOOTH_10061;

/**
 * @author Glabay | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Glabay
 * @since 2024-09-16
 */
public class TradingPost extends WorldObjectAction {
    @Override
    public Integer[] getIds() {
        return new Integer[] { GRAND_EXCHANGE_BOOTH, GRAND_EXCHANGE_BOOTH_10061 };
    }

    @Override
    public Boolean handleActionOne(Player player, GlobalObject object) {
        if (player.getMode().isUltimateIronman()) {
            player.sendMessage("@red@You are not permitted to make use of this.");
            return false;
        }
        player.itemAssistant.openUpBank();
        return true;
    }

    @Override
    public Boolean handleActionTwo(Player player, GlobalObject object) {
        if (player.getMode().isIronmanType()) {
            player.sendMessage("@red@You are not permitted to make use of this.");
            return false;
        }
        Listing.openPost(player, false);
        return true;
    }

    @Override
    public Boolean handleActionThree(Player player, GlobalObject object) {
        // TODO: Collect option
        return true;
    }
}
