package com.asphyxia.core;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.contents.TranslatableContents;

public final class asphyxiacore implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ScreenEvents.AFTER_INIT.register((client, screen, width, height) -> {
			if (screen instanceof OptionsScreen) {
				Screens.getWidgets(screen).removeIf(widget -> widget instanceof Button
						&& widget.getMessage().getContents() instanceof TranslatableContents text
						&& "screen.lumen_tooltips.config.open".equals(text.getKey()));
			}
		});
	}
}
