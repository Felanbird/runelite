/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * Copyright (c) 2024, Felanbird <https://github.com/Felanbird>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.cluescrolls.clues;

import java.awt.Graphics2D;
import java.util.stream.Stream;
import lombok.Getter;
import net.runelite.api.ItemID;
import static net.runelite.api.ItemID.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.plugins.cluescrolls.clues.item.AllRequirementsCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.all;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.any;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.item;
import net.runelite.client.plugins.cluescrolls.clues.item.SingleItemRequirement;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Getter
public class ItemVariations extends ClueScroll implements LocationClueScroll
{
	static final AnyRequirementCollection ANY_SLAYER_HELMET = any("Any slayer helmet",
		ItemVariationMapping.getVariations(SLAYER_HELMET).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_RING_OF_WEALTH = any("Any ring of wealth",
		ItemVariationMapping.getVariations(RING_OF_WEALTH).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_PHARAOHS_SCEPTRE = any("Pharaoh's sceptre",
		ItemVariationMapping.getVariations(PHARAOHS_SCEPTRE).stream()
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_ABYSSAL_WHIP_OR_TENTACLE = any("Abyssal whip",
		Stream.of(
		ItemVariationMapping.getVariations(ABYSSAL_WHIP).stream(),
		ItemVariationMapping.getVariations(ABYSSAL_TENTACLE).stream())
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			// TODO: figure out what these are, 4178 is apparently never used
			.filter(itemId -> itemId != ABYSSAL_WHIP_4178 && itemId != ABYSSAL_WHIP_20405)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_TEAM_CAPE = any("Any team cape",
		Stream.of(
				ItemVariationMapping.getVariations(TEAM1_CAPE).stream(),
				Stream.of(TEAM_CAPE_I, TEAM_CAPE_X, TEAM_CAPE_ZERO))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_STOLE = any("Any stole",
		Stream.of(
			Stream.of(ANCIENT_STOLE, ARMADYL_STOLE, BANDOS_STOLE, GUTHIX_STOLE, SARADOMIN_STOLE, ZAMORAK_STOLE))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_MITRE = any("Any mitre",
		Stream.of(
				Stream.of(ANCIENT_MITRE, ARMADYL_MITRE, BANDOS_MITRE, GUTHIX_MITRE, SARADOMIN_MITRE, ZAMORAK_MITRE))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_RING_OF_DUELING = any("Any Ring of dueling",
		Stream.of(
				Stream.of(RING_OF_DUELING1, RING_OF_DUELING2, RING_OF_DUELING3, RING_OF_DUELING4, RING_OF_DUELING5,
					RING_OF_DUELING6, RING_OF_DUELING7, RING_OF_DUELING8))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_CHARGED_GLORY = any("Any Amulet of glory",
		Stream.of( // TODO: Figure out of the clues that used charged glories actually work with trimmed ones,
				// the wiki notes it as "An amulet of glory with any amount of charges or an amulet of eternal glory will work."
				// but for clues where AMULET_OF_GLORY_T does not work, it's explicitly mentioned
				// "Your amulet of glory must be uncharged in order to work. Amulet of glory (t) does not work for this clue step."
				Stream.of(AMULET_OF_GLORY1, AMULET_OF_GLORY2, AMULET_OF_GLORY3, AMULET_OF_GLORY4, AMULET_OF_GLORY5,
					AMULET_OF_GLORY5, AMULET_OF_GLORY6, AMULET_OF_GLORY_T1, AMULET_OF_GLORY_T2, AMULET_OF_GLORY_T3,
					AMULET_OF_GLORY_T4, AMULET_OF_GLORY_T5,	AMULET_OF_GLORY_T6))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ACTIVE_CRYSTAL_BOW_OR_BOW_OF_FAERDHINEN = any("Crystal Bow or Bow of Faerdhinen",
		Stream.of(
				ItemVariationMapping.getVariations(BOW_OF_FAERDHINEN_INACTIVE).stream(),
				Stream.of(CRYSTAL_BOW, CRYSTAL_BOW_24123))
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.filter(itemId -> itemId != BOW_OF_FAERDHINEN_INACTIVE)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection DRAGON_OR_AVERNIC_DEFENDER = any("Dragon or Avernic Defender",
		Stream.of(
				ItemVariationMapping.getVariations(DRAGON_DEFENDER).stream(),
				ItemVariationMapping.getVariations(AVERNIC_DEFENDER).stream(),
				ItemVariationMapping.getVariations(GHOMMALS_AVERNIC_DEFENDER_5).stream())
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.filter(itemId -> itemId != DRAGON_DEFENDER_BROKEN && itemId != AVERNIC_DEFENDER_BROKEN)
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_GOD_BOOK = any("Any God Book",
		Stream.of(
				ItemVariationMapping.getVariations(BOOK_OF_BALANCE).stream(),
				ItemVariationMapping.getVariations(BOOK_OF_DARKNESS).stream(),
				ItemVariationMapping.getVariations(BOOK_OF_LAW).stream(),
				ItemVariationMapping.getVariations(BOOK_OF_WAR).stream(),
				ItemVariationMapping.getVariations(HOLY_BOOK).stream(),
				ItemVariationMapping.getVariations(UNHOLY_BOOK).stream())
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.filter(itemId -> itemId != UNHOLY_BOOK_27191) // TODO: Figure out what this is
			.map(ItemRequirements::item)
			.toArray(SingleItemRequirement[]::new));
	static final AnyRequirementCollection ANY_PICKAXE = any("Any Pickaxe",
		item(ItemID.BRONZE_PICKAXE),
		item(ItemID.IRON_PICKAXE),
		item(ItemID.STEEL_PICKAXE),
		item(ItemID.BLACK_PICKAXE),
		item(ItemID.MITHRIL_PICKAXE),
		item(ItemID.ADAMANT_PICKAXE),
		item(ItemID.RUNE_PICKAXE),
		item(ItemID.DRAGON_PICKAXE),
		item(ItemID.DRAGON_PICKAXE_12797),
		item(ItemID.DRAGON_PICKAXE_OR),
		item(ItemID.DRAGON_PICKAXE_OR_25376),
		item(ItemID.INFERNAL_PICKAXE),
		item(ItemID.INFERNAL_PICKAXE_OR),
		item(ItemID.INFERNAL_PICKAXE_UNCHARGED),
		item(ItemID.INFERNAL_PICKAXE_UNCHARGED_25369),
		item(ItemID.GILDED_PICKAXE),
		item(ItemID._3RD_AGE_PICKAXE),
		item(ItemID.CRYSTAL_PICKAXE),
		item(ItemID.CRYSTAL_PICKAXE_INACTIVE),
		item(ItemID.TRAILBLAZER_PICKAXE));
	static final AnyRequirementCollection ANY_AXE = any("Any Axe",
		item(ItemID.BRONZE_AXE),
		item(ItemID.BRONZE_FELLING_AXE),
		item(ItemID.IRON_AXE),
		item(ItemID.IRON_FELLING_AXE),
		item(ItemID.STEEL_AXE),
		item(ItemID.STEEL_FELLING_AXE),
		item(ItemID.BLACK_AXE),
		item(ItemID.BLACK_FELLING_AXE),
		item(ItemID.MITHRIL_AXE),
		item(ItemID.MITHRIL_FELLING_AXE),
		item(ItemID.ADAMANT_AXE),
		item(ItemID.ADAMANT_FELLING_AXE),
		item(ItemID.RUNE_AXE),
		item(ItemID.RUNE_FELLING_AXE),
		item(ItemID.DRAGON_AXE),
		item(ItemID.DRAGON_AXE_OR),
		item(ItemID.DRAGON_FELLING_AXE),
		item(ItemID.INFERNAL_AXE),
		item(ItemID.INFERNAL_AXE_OR),
		item(ItemID.INFERNAL_AXE_UNCHARGED),
		item(ItemID.INFERNAL_AXE_UNCHARGED_25371),
		item(ItemID.GILDED_AXE),
		item(ItemID._3RD_AGE_AXE),
		item(ItemID._3RD_AGE_FELLING_AXE),
		item(ItemID.CRYSTAL_AXE),
		item(ItemID.CRYSTAL_AXE_INACTIVE),
		item(ItemID.CRYSTAL_FELLING_AXE),
		item(ItemID.CRYSTAL_FELLING_AXE_INACTIVE),
		item(ItemID.TRAILBLAZER_AXE));

	static final AnyRequirementCollection ANY_HARPOON = any("Harpoon",
		item(ItemID.HARPOON),
		item(ItemID.BARBTAIL_HARPOON),
		item(ItemID.DRAGON_HARPOON),
		item(ItemID.DRAGON_HARPOON_OR),
		item(ItemID.INFERNAL_HARPOON),
		item(ItemID.INFERNAL_HARPOON_OR),
		item(ItemID.INFERNAL_HARPOON_UNCHARGED),
		item(ItemID.INFERNAL_HARPOON_UNCHARGED_25367),
		item(ItemID.CRYSTAL_HARPOON),
		item(ItemID.CRYSTAL_HARPOON_INACTIVE),
		item(ItemID.TRAILBLAZER_HARPOON));
	static final AnyRequirementCollection ANY_HAMMER = any("Hammer",
		item(ItemID.HAMMER),
		item(ItemID.IMCANDO_HAMMER));
	static final AllRequirementsCollection A_FULL_GRACEFUL_SET = all("A full Graceful set",
		any("" /* graceful hood   */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_HOOD).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful top    */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_TOP).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful legs   */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_LEGS).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful gloves */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_GLOVES).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful boots  */, ItemVariationMapping.getVariations(ItemID.GRACEFUL_BOOTS).stream().map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)),
		any("" /* graceful cape   */, Stream.of(
				ItemVariationMapping.getVariations(ItemID.GRACEFUL_CAPE).stream(),
				ItemVariationMapping.getVariations(ItemID.AGILITY_CAPE).stream(),
				ItemVariationMapping.getVariations(ItemID.MAX_CAPE).stream())
			.reduce(Stream::concat)
			.orElseGet(Stream::empty)
			.map(ItemRequirements::item).toArray(SingleItemRequirement[]::new)));

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{

	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{

	}

	@Override
	public WorldPoint getLocation(ClueScrollPlugin plugin)
	{
		return null;
	}
}
