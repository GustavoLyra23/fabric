/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.impl.biome.modification;

import org.jetbrains.annotations.ApiStatus;

import net.minecraft.util.registry.RegistryKeys;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntryLookup;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;

/**
 * Utility class for accessing the worldgen data that vanilla uses to generate its vanilla datapack.
 */
@ApiStatus.Internal
public final class BuiltInRegistryKeys {
	private static final RegistryWrapper.WrapperLookup vanillaRegistries = BuiltinRegistries.createWrapperLookup();

	private BuiltInRegistryKeys() {
	}

	public static boolean isBuiltinBiome(RegistryKey<Biome> key) {
		return biomeRegistryWrapper().getOptional(key).isPresent();
	}

	public static RegistryEntryLookup<Biome> biomeRegistryWrapper() {
		return vanillaRegistries.getWrapperOrThrow(RegistryKeys.BIOME_WORLDGEN);
	}
}
