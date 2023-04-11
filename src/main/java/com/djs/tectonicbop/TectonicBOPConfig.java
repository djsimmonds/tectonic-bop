package com.djs.tectonicbop;

//import java.util.Arrays;
//import java.util.List;
import net.minecraftforge.common.ForgeConfigSpec;

public class TectonicBOPConfig {

	public static final ForgeConfigSpec GENERAL_SPEC;
	
	static {
//		List<String> BiomesLayout = Arrays.asList("vanilla", "bop", "bopAlt", "bopSkylands", "bopAltSkylands", "bopTerratonic");
	    ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
	    setupConfig(configBuilder);
//	    setupConfig(configBuilder, BiomesLayout);
	    GENERAL_SPEC = configBuilder.build();		
	}
	
	public static ForgeConfigSpec.ConfigValue<String> OVERWORLD_JSON;
//	public static ForgeConfigSpec.ConfigValue<List<? extends String>> OVERWORLD_OPTIONS;
	
//	private static void setupConfig(ForgeConfigSpec.Builder builder, List<String> BiomesLayout) { 
	private static void setupConfig(ForgeConfigSpec.Builder builder) { 

		builder.push("Tectonic BOP Biome Layout");

		OVERWORLD_JSON = builder
                .comment("Assign biome layout by selecting desired overworld.json file.\n" +
                		"OPTIONS: bop (default), bopAlt (more bop, less vanilla), bopSkylands, bopAltSkylands, bopTerratonic, vanilla")
                .define("overworld_json_config_entry", "bop");

//			builder.push("Nested Category");
//	
//			OVERWORLD_OPTIONS = builder
//	                .comment("Assign biome layout by selecting desired overworld.json file.\n" +
//	                		"OPTIONS: vanilla, bop, bopAlt, bopSkylands, bopAltSkylands, bopTerratonic")
//	                .defineList("biome_layout_config_entry", BiomesLayout, entry -> true);
//
//			builder.pop();

		builder.pop();
	}
}
