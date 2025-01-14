package dev.glabay.rsps.plugin.world.npc.impl.global;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.content.achievement_diary.impl.LumbridgeDraynorDiaryEntry;
import io.xeros.content.skills.thieving.Thieving;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Boundary;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Npcs.MASTER_FARMER;
import static io.xeros.model.definition.Npcs.MASTER_FARMER_5731;
import static io.xeros.model.definition.Shops.MASTER_FARMER_SHOP;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class MasterFarmer extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[]{MASTER_FARMER, MASTER_FARMER_5731};
    }

    @Override
    public Boolean handleActionOne(Player player, NPC npc) {
        if (Boundary.isIn(player, Boundary.FALADOR_BOUNDARY)) {
            player.getThieving().steal(Thieving.Pickpocket.FARMER, npc);
            return false;
        }
        if (Boundary.isIn(player, Boundary.DRAYNOR_BOUNDARY)) {
            player.getThieving().steal(Thieving.Pickpocket.FARMER, npc);
            player.getDiaryManager().getLumbridgeDraynorDiary().progress(LumbridgeDraynorDiaryEntry.PICKPOCKET_FARMER_DRAY);
            return false;
        }
        player.getThieving().steal(Thieving.Pickpocket.FARMER, npc);
        player.getDiaryManager().getLumbridgeDraynorDiary().progress(LumbridgeDraynorDiaryEntry.PICKPOCKET_FARMER_DRAY);
        return true;
    }

    @Override
    public Boolean handleActionTwo(Player player, NPC npc) {
        if (player.getMode().isIronmanType()) {
            player.getThieving().steal(Thieving.Pickpocket.FARMER, npc);
            if (Boundary.isIn(player, Boundary.FALADOR_BOUNDARY)) {
                player.getThieving().steal(Thieving.Pickpocket.FARMER, npc);
            }
            if (Boundary.isIn(player, Boundary.DRAYNOR_BOUNDARY)) {
                player.getThieving().steal(Thieving.Pickpocket.FARMER, npc);
                player.getDiaryManager().getLumbridgeDraynorDiary().progress(LumbridgeDraynorDiaryEntry.PICKPOCKET_FARMER_DRAY);
            }
            player.sendMessage("@red@Restricted accounts can only steal from this npc.");
        } else {
            player.getShops().openShop(MASTER_FARMER_SHOP);
        }
        return true;
    }
}