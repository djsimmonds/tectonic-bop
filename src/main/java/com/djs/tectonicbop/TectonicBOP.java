package com.djs.tectonicbop;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.resource.PathResourcePack;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;
import java.io.IOException;

@Mod(TectonicBOP.MOD_ID)
public class TectonicBOP {

	public static final String MOD_ID = "tectonicbop";

	public TectonicBOP() {
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(Type.COMMON, TectonicBOPConfig.GENERAL_SPEC, "tectonicbopconfig.toml");		
		
		modEventBus.addListener(this::loadTerratonicBuiltInDatapack);
		modEventBus.addListener(this::setupBuiltInDatapack);
		MinecraftForge.EVENT_BUS.register(this);
		
        RegisterTectonicBiomes.REGISTER.register(modEventBus);
        RegisterTerralithBiomes.REGISTER.register(modEventBus);
	}    

	private void setupBuiltInDatapack(AddPackFindersEvent event) {	
		if ((event.getPackType() == PackType.SERVER_DATA))
		{
			String BiomeLayout = TectonicBOPConfig.OVERWORLD_JSON.get().toString();
		    String MODID = "tectonicbop";

            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resourcepacks/" + BiomeLayout);
            try (var pack = new PathResourcePack(ModList.get().getModFileById(MODID).getFile().getFileName() + ":" + resourcePath, resourcePath)) {
				var metadataSection = pack.getMetadataSection(PackMetadataSection.SERIALIZER);
				if (metadataSection != null)
				{
				    event.addRepositorySource((packConsumer, packConstructor) ->
				            packConsumer.accept(packConstructor.create(
				            		"builtin/" + BiomeLayout, new TextComponent("Tectonic BOP: " + BiomeLayout), true,
				                    () -> pack, metadataSection, Pack.Position.TOP, PackSource.BUILT_IN, false)));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// load terratonic in place of tectonic if bopTerralith is selected
	// at this time, will need to remove tectonic mod for this to work, but will change once apollo integrates them
	private void loadTerratonicBuiltInDatapack(AddPackFindersEvent event) {	
		if ((event.getPackType() == PackType.SERVER_DATA) )
		{
			String BiomeLayout = TectonicBOPConfig.OVERWORLD_JSON.get().toString();
			if (BiomeLayout.contains("Terratonic")) {
			    String MODID = "tectonicbop"; // distribute in tectonicbop until apollo updates mod
	
	            var resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("resourcepacks/terratonic");
	            try (var pack = new PathResourcePack(ModList.get().getModFileById(MODID).getFile().getFileName() + ":" + resourcePath, resourcePath)) {
					var metadataSection = pack.getMetadataSection(PackMetadataSection.SERIALIZER);
					if (metadataSection != null)
					{
					    event.addRepositorySource((packConsumer, packConstructor) ->
					            packConsumer.accept(packConstructor.create(
					            		"builtin/terratonic", new TextComponent("Terratonic"), true,
					                    () -> pack, metadataSection, Pack.Position.TOP, PackSource.BUILT_IN, false)));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
