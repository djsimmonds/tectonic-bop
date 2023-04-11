package com.djs.tectonicbop;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.io.IOException;
import java.nio.file.Path;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.resource.PathPackResources;

@Mod(TectonicBOP.MOD_ID)
public class TectonicBOP {

	public static final String MOD_ID = "tectonicbop";

	public TectonicBOP() {
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(Type.COMMON, TectonicBOPConfig.GENERAL_SPEC, "tectonicbopconfig.toml");		
		
		modEventBus.addListener(this::setupBuiltInDatapack);
		MinecraftForge.EVENT_BUS.register(this);
		
        RegisterTectonicBiomes.REGISTER.register(modEventBus);
	}    

	private void setupBuiltInDatapack(AddPackFindersEvent event) {	
		if ((event.getPackType() == PackType.SERVER_DATA))
		{
			String BiomeLayout = TectonicBOPConfig.OVERWORLD_JSON.get().toString();
		    String MODID = "tectonicbop";

            Path resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resourcepacks/" + BiomeLayout);
            
            try (PathPackResources pack = new PathPackResources(ModList.get().getModFileById(MODID).getFile().getFileName() + ":" + resourcePath, resourcePath)) {
				try {
					PackMetadataSection metadataSection = pack.getMetadataSection(PackMetadataSection.SERIALIZER);
				    event.addRepositorySource((packConsumer, packConstructor) ->
				    packConsumer.accept(packConstructor.create(
				            "builtin/" + BiomeLayout, Component.literal("Tectonic BOP: " + BiomeLayout), false,
				            () -> pack, metadataSection, Pack.Position.TOP, PackSource.BUILT_IN, false)));            
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}