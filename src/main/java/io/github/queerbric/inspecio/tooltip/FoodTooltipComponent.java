/*
 * Copyright (c) 2020 LambdAurora <aurora42lambda@gmail.com>, Emi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.queerbric.inspecio.tooltip;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.FoodComponent;

public class FoodTooltipComponent implements ConvertibleTooltipData, TooltipComponent {
	private final FoodComponent component;

	public FoodTooltipComponent(FoodComponent component) {
		this.component = component;
	}

	@Override
	public TooltipComponent getComponent() {
		return this;
	}

	@Override
	public int getHeight() {
		return 11;
	}

	@Override
	public int getWidth(TextRenderer textRenderer) {
		return this.component.getHunger() / 2 * 9;
	}

	@Override
	public void drawItems(TextRenderer textRenderer, int x, int y, MatrixStack matrices, ItemRenderer itemRenderer, int z, TextureManager textureManager) {
		textureManager.bindTexture(InGameHud.GUI_ICONS_TEXTURE);
		for (int i = 0; i < (this.component.getHunger() + 1) / 2; i++) {
			DrawableHelper.drawTexture(matrices, x + i * 9, y, 16, 27, 9, 9, 256, 256);
		}
		for (int i = 0; i < this.component.getHunger() / 2; i++) {
			DrawableHelper.drawTexture(matrices, x + i * 9, y, 52, 27, 9, 9, 256, 256);
		}
		if (this.component.getHunger() % 2 == 1) {
			DrawableHelper.drawTexture(matrices, x + this.component.getHunger() / 2 * 9, y, 61, 27, 9, 9, 256, 256);
		}
	}
}
