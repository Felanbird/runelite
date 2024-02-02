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
public class RequirementCollections extends ClueScroll implements LocationClueScroll
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
