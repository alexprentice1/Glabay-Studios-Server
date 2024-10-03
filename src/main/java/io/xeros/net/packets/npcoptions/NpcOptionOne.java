package io.xeros.net.packets.npcoptions;

import io.xeros.Server;
import io.xeros.content.achievement_diary.impl.KandarinDiaryEntry;
import io.xeros.content.achievement_diary.impl.LumbridgeDraynorDiaryEntry;
import io.xeros.content.achievement_diary.impl.VarrockDiaryEntry;
import io.xeros.content.bosses.nightmare.NightmareActionHandler;
import io.xeros.content.dialogue.DialogueBuilder;
import io.xeros.content.dialogue.impl.IronmanNpcDialogue;
import io.xeros.content.dialogue.impl.MacDialogue;
import io.xeros.content.dialogue.impl.MonkChaosAltarDialogue;
import io.xeros.content.skills.Fishing;
import io.xeros.content.skills.crafting.Tanning;
import io.xeros.content.skills.hunter.impling.Impling;
import io.xeros.content.skills.mining.Mineral;
import io.xeros.content.skills.thieving.Thieving;
import io.xeros.model.Npcs;
import io.xeros.model.entity.npc.NPC;
import io.xeros.model.entity.npc.NPCHandler;
import io.xeros.model.entity.npc.pets.PetHandler;
import io.xeros.model.entity.player.Boundary;
import io.xeros.model.entity.player.Player;
import io.xeros.model.entity.player.Right;
import io.xeros.model.entity.player.mode.group.GroupIronman;
import io.xeros.model.entity.player.mode.group.GroupIronmanDialogue;
import io.xeros.util.Location3D;
import io.xeros.util.Misc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class NpcOptionOne {

    public static final Logger logger = LoggerFactory.getLogger(NpcOptionOne.class);

    public static void handleOption(Player player, int npcType) {
        if (Server.getMultiplayerSessionListener().inAnySession(player)) {
            return;
        }
        player.clickNpcType = 0;
        player.clickedNpcIndex = player.npcClickIndex;
        player.npcClickIndex = 0;

        if (PetHandler.isPet(npcType))
            if (Objects.equals(PetHandler.getOptionForNpcId(npcType), "first"))
                if (PetHandler.pickupPet(player, npcType, true))
                    return;

        if (NightmareActionHandler.clickNpc(player, npcType, 1)) return;
        NPC npc = NPCHandler.npcs[player.clickedNpcIndex];

        var npcActionManager = Server.getNpcOptionActionManager();
        if (npcActionManager.findHandlerById(npcType).isPresent()) {
            var npcAction = npcActionManager.findHandlerById(npcType).get();
            if (npcAction.performedAction(player, npc, 1))
                return;
            else
                logger.error("Unhandled NPC Action 1: {} ", npcAction.getClass().getSimpleName());
        }

        switch (npcType) {

            case 1635:
            case 1636:
            case 1637:
            case 1638:
            case 1639:
            case 1640:
            case 1641:
            case 1642:
            case 1643:
            case 1654:
            case 7302:
                Impling.catchImpling(player, npc);
                break;

            case 17: // Rug merchant
                player.getDH().sendDialogues(837, 17);
                break;
            case 5520:
                player.getDiaryManager().getDesertDiary().claimReward();
                break;
            case 5519:
                player.getDiaryManager().getArdougneDiary().claimReward();
                break;
            case 5790:
                player.getDiaryManager().getKaramjaDiary().claimReward();
                break;
            case 5525:
                player.getDiaryManager().getVarrockDiary().claimReward();
                break;
            case 5523:
                player.getDiaryManager().getLumbridgeDraynorDiary().claimReward();
                break;
            case 5524:
                player.getDiaryManager().getFaladorDiary().claimReward();
                break;
            case 5521:
                player.getDiaryManager().getMorytaniaDiary().claimReward();
                break;
            case 5514:
                player.getDiaryManager().getWildernessDiary().claimReward();
                break;
            case 5517:
                player.getDiaryManager().getKandarinDiary().claimReward();
                break;
            case 5526:
                player.getDiaryManager().getFremennikDiary().claimReward();
                break;
            case 5518:
                player.getDiaryManager().getWesternDiary().claimReward();
                break;

            case 3936:
                player.getDH().sendNpcChat1("Right click on me and i will take you on-board.", 3936, "Sailor");
                break;

            case 1896:
                if (player.getItems().playerHasItem(995, 30)) {
                    player.getItems().deleteItem(995, 30);
                    player.getItems().addItem(36, 1);
                    player.getDiaryManager().getKandarinDiary().progress(KandarinDiaryEntry.BUY_CANDLE);
                }
                else {
                    player.sendMessage("You need 30 coins to purchase a candle.");
                    return;
                }
                break;
            case 9400:
                player.getDH().sendDialogues(3454, 9400);
                break;
            case 6586:
                player.getDH().sendNpcChat1("No shirt, Sherlock", 6586, "Sherlock");
                player.getDiaryManager().getKandarinDiary().progress(KandarinDiaryEntry.SHERLOCK);
                break;

            case 5036:
                if (player.getItems().playerHasItem(225) || player.getItems().playerHasItem(223)) {
                    player.sendMessage("The Apothecary takes your ingredients and creates a strength potion.");
                    player.getItems().deleteItem(225, 1);
                    player.getItems().deleteItem(223, 1);
                    player.getItems().addItem(115, 1);
                    player.getDiaryManager().getVarrockDiary().progress(VarrockDiaryEntry.APOTHECARY_STRENGTH);
                }
                else {
                    player.sendMessage("You must have limpwurt root and red spiders' eggs to do this.");
                    return;
                }
                break;

            case 3500:
                player.getDH().sendDialogues(64, npcType);
                break;

            case 5870:
                player.getDH().sendDialogues(105, npcType);
                break;

            case 7283:
                player.getDH().sendDialogues(105, npcType);
                break;

            case Npcs.MAC:
                player.start(new MacDialogue(player, true));
                break;

            case 3307: // Combat instructor
                player.getDH().sendDialogues(1390, npcType);
                break;

            case 394:
                player.getDH().sendDialogues(669, npcType);
                break;
            case GroupIronman.GROUP_FORM_NPC:
                player.start(new GroupIronmanDialogue(player));
                break;
            case Npcs.ADAM:
                player.start(new IronmanNpcDialogue(player, npc));
                break;
            case 1159:
                player.start(new MonkChaosAltarDialogue(player, npc));
                break;
            // Noting Npc At Skill Area
            case 905:
                player.talkingNpc = 905;
                player.getDH().sendNpcChat("Hello there, I can note your resources.",
                    "I charge @red@25%@bla@ of the yield, this @red@does not apply to donators@bla@.",
                    "Use any resource item obtained in this area on me.");
                player.nextChat = -1;
                break;

            case 2040:
                player.getDH().sendDialogues(637, npcType);
                break;

            case 6866:
                player.getShops().openShop(82);
                player.sendMessage("You currently have @red@" + player.getShayPoints() + " @bla@Assault Points!");
                break;

            case 6601:
                NPC golem = npc;
                if (golem != null) {
                    player.getMining().mine(golem, Mineral.RUNE,
                        new Location3D(golem.getX(), golem.getY(), golem.heightLevel));
                }
                break;
            case 1850:
                player.getShops().openShop(112);
                break;
            case 2580:
                player.getDH().sendDialogues(629, npcType);
                break;
            case 4305:
                player.getThieving().steal(Thieving.Pickpocket.DRUNKEN_DWARF, npc);
                break;
            case 5730:
                if (Boundary.isIn(player, Boundary.FALADOR_BOUNDARY)) {
                    player.getThieving().steal(Thieving.Pickpocket.FARMER, npc);
                    break;
                }
                if (Boundary.isIn(player, Boundary.DRAYNOR_BOUNDARY)) {
                    player.getThieving().steal(Thieving.Pickpocket.FARMER, npc);
                    player.getDiaryManager().getLumbridgeDraynorDiary().progress(LumbridgeDraynorDiaryEntry.PICKPOCKET_FARMER_DRAY);
                    break;
                }
                player.getThieving().steal(Thieving.Pickpocket.FARMER, npc);
                player.getDiaryManager().getLumbridgeDraynorDiary().progress(LumbridgeDraynorDiaryEntry.PICKPOCKET_FARMER_DRAY);
                break;
            case 3894:
                player.getShops().openShop(26);
                break;
            case 3220:
                player.getShops().openShop(25);
                break;
            case 637:
                player.getShops().openShop(6);
                break;
            case 6875:
                player.specRestore = 120;
                player.specAmount = 10.0;
                player.setRunEnergy(100, true);
                player.getItems().addSpecialBar(player.playerEquipment[Player.playerWeapon]);
                player.playerLevel[5] = player.getPA().getLevelForXP(player.playerXP[5]);
                player.getHealth().removeAllStatuses();
                player.getHealth().reset();
                player.getPA().refreshSkill(5);
                player.getDH().sendItemStatement("Restored your HP, Prayer, Run Energy, and Spec", 4049);
                player.nextChat = -1;
                break;
            case 732:
                player.getShops().openShop(16);
                break;
            case 8688:
                player.getShops().openShop(113);
                break;
            case 2949:
                player.getPestControlRewards().showInterface();
                break;
            case 2461:
                player.getWarriorsGuild().handleDoor();
                break;
            case 7663:
                player.getDH().sendDialogues(3299, npcType);
                break;
            case 402:// slayer
                if (player.combatLevel < 20) {
                    player.getDH().sendNpcChat2("Do not waste my time peasent.", "You need a Combat level of 20.", 402, "Mazchna");
                    return;
                }
                player.getDH().sendDialogues(3300, npcType);
                break;
            case 401:
                if (player.combatLevel < 20) {
                    player.getDH().sendNpcChat2("Do not waste my time peasent.", "You need a Combat level of 20.", 402, "Mazchna");
                    return;
                }
                player.getDH().sendDialogues(3300, npcType);
                break;

            case 405:
                if (player.combatLevel < 100) {
                    player.getDH().sendNpcChat2("Do not waste my time peasent.", "You need a Combat level of at least 100.", 402, "Duradel");
                    return;
                }
                if (player.playerLevel[18] < 50) {
                    player.getDH().sendNpcChat1("You must have a slayer level of at least 50 weakling.", 490, "Duradel");
                    return;
                }
                player.getDH().sendDialogues(3300, npcType);
                break;
            case 8623:
            case 6797: // Nieve
                player.getDH().sendDialogues(3300, npcType);
                break;
            case 308:
                player.getDH().sendDialogues(550, npcType);
                break;

            case 1308:
                player.getDH().sendDialogues(538, npcType);
                break;
            case Npcs.BOSS_POINT_SHOP:
                player.getShops().openShop(121);
                player.sendMessage("You currently have " + Misc.insertCommas(player.bossPoints) + " Boss points.");
                break;
            case Npcs.PERDU:
                player.getDH().sendDialogues(619, npcType);
                break;
            case 4306:
                player.getShops().openSkillCape();
                break;
            case 1933:
                player.getShops().openMillCape();
                break;
            case 3341:
                player.getDH().sendDialogues(2603, npcType);
                break;
            case 5919:
                player.getDH().sendDialogues(14400, npcType);
                break;
            case 603:
                player.getDH().sendDialogues(11955, npcType);
                break;
            case 8761:
                player.getDH().sendDialogues(10955, npcType);
                break;
            case 8605:
                if (player.playerLevel[18] >= 95) {
                    player.getDH().sendDialogues(11155, npcType);
                    break;
                }
                player.sendMessage("You need a slayer level of 95 to get a task from me.");
                break;
            case 6599:
                player.getShops().openShop(12);
                break;
            case 2578:
                player.getDH().sendDialogues(2401, npcType);
                break;
            case 3789:
                player.getShops().openShop(75);
                break;
            // FISHING
            case 3913: // NET + BAIT
                player.clickNpcType = 1;
                Fishing.attemptdata(player, 1);
                break;
            case 3317:
                player.clickNpcType = 1;
                Fishing.attemptdata(player, 14);
                break;
            case 4712:
                player.clickNpcType = 1;
                Fishing.attemptdata(player, 15);
                break;
            case 1524:
                player.clickNpcType = 1;
                Fishing.attemptdata(player, 11);
                break;
            case 3417: // TROUT
                player.clickNpcType = 1;
                Fishing.attemptdata(player, 4);
                break;
            case 3657:
                player.clickNpcType = 1;
                Fishing.attemptdata(player, 8);
                break;
            case 635:
                Fishing.attemptdata(player, 13); // DARK CRAB FISHING
                break;
            case 6825: // Anglerfish
                player.clickNpcType = 1;
                Fishing.attemptdata(player, 16);
                break;
            case 1520: // LURE
            case 310:
            case 314:
            case 317:
            case 318:
            case 328:
            case 331:
                Fishing.attemptdata(player, 9);
                break;

            case 944:
                player.getDH().sendOption5("Hill Giants", "Hellhounds", "Lesser Demons", "Chaos Dwarf", "-- Next Page --");
                player.teleAction = 7;
                break;

            case 559:
                player.getShops().openShop(16);
                break;
            case 5809:
                Tanning.sendTanningInterface(player);
                break;

            case 2913:
                player.getShops().openShop(22);
                break;
            case 403:
                player.getDH().sendDialogues(2300, npcType);
                break;
            case 1599:
                break;

            case 953: // Banker
            case 2574: // Banker
            case 166: // Gnome Banker
            case 1702: // Ghost Banker
            case 494: // Banker
            case 495: // Banker
            case 496: // Banker
            case 497: // Banker
            case 498: // Banker
            case 499: // Banker
            case 567: // Banker
            case 766: // Banker
            case 1036: // Banker
            case 1360: // Banker
            case 2163: // Banker
            case 2164: // Banker
            case 2354: // Banker
            case 2355: // Banker
            case 2568: // Banker
            case 2569: // Banker
            case 2570: // Banker
                player.getPA().c.itemAssistant.openUpBank();
                break;
            case 1986:
                player.getDH().sendDialogues(2244, player.npcType);
                break;
            case 1576:
                player.getShops().openShop(4);
                break;
            case 1577:
                player.getShops().openShop(8);
                break;
            case 1578:
                player.getShops().openShop(6);
                break;

            case 6747:
                player.getShops().openShop(77);
                break;
            case 1785:
                player.getShops().openShop(8);
                break;

            case 1860:
                player.getShops().openShop(47);
                break;

            case 519:
                player.getShops().openShop(48);
                break;

            case 548:
                player.getDH().sendDialogues(69, player.npcType);
                break;

            case 2258:
                player.getDH().sendOption2("Teleport me to Runecrafting Abyss.", "I want to stay here, thanks.");
                player.dialogueAction = 2258;
                break;

            case 532:
                player.getShops().openShop(47);
                break;


            case 7913:
                if (player.getMode().isIronmanType()
                    || player.getRights().contains(Right.OWNER) || player.getRights().contains(Right.ADMINISTRATOR)) {
                    player.getShops().openShop(41);
                }
                else {
                    player.sendMessage("You must be an Iron Man to access this shop.");
                }
                break;
            case 7769:
                player.getShops().openShop(2);
                break;



            /*
             * case 198: c.getShops().openSkillCape(); break;
             */

            /**
             * Make over mage.
             */

        }
    }

}
