package dev.glabay.rsps.plugin.world.npc.impl.lumbridge;

import dev.glabay.rsps.plugin.world.npc.NpcOptionAction;
import io.xeros.content.dialogue.impl.IronmanNpcDialogue;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.player.Player;

import static io.xeros.model.definition.Npcs.IRON_MAN_TUTOR;

/**
 * @author Zei | Glabay-Studios
 * @project Glabay-Studios-Server
 * @social Discord: Z
 * @social Github: <a href="https://github.com/Zeighe">Zeighe</a>
 * @since 10/2/2024
 */
public class Adam extends NpcOptionAction {
    @Override
    protected Integer[] getIds() {
        return new Integer[] { IRON_MAN_TUTOR };
    }

    @Override
    public Boolean handleActionOne(Player player, NPC npc) {
        player.start(new IronmanNpcDialogue(player, npc));
        return true;
    }

    @Override
    public Boolean handleActionTwo(Player player, NPC npc) {
        IronmanNpcDialogue.giveIronmanArmour(player, npc);
        return true;
    }
}
