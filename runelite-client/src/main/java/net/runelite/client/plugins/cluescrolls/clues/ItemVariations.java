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
import static net.runelite.api.ItemID.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements;
import static net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirements.any;
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
	static final AnyRequirementCollection ANY_TEAM_CAPE = any("Any team cape",
		Stream.of(
				ItemVariationMapping.getVariations(TEAM1_CAPE).stream(),
				Stream.of(TEAM_CAPE_I, TEAM_CAPE_X, TEAM_CAPE_ZERO))
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
