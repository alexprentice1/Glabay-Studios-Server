package dev.glabay.rsps.plugin.world.npc.impl.gnomestronghold;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.content.skills.thieving.Thieving;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Npcs.GNOME_6094;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class Gnome extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { GNOME_6094 };
    }

    @Override
    public Boolean handleActionTwo(Player player, NPC npc) {
        player.getThieving().steal(Thieving.Pickpocket.GNOME, npc);
        return true;
    }
}
