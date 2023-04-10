package com.djs.tectonicbop;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TectonicBOP.MOD_ID)
public class TectonicBOP
{
    // Directly reference a slf4j logger
//    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "tectonicbop";
    
    public TectonicBOP()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
//        IEventBus bus = MinecraftForge.EVENT_BUS;
        // Register the setup method for modloading
//        modEventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
//        modEventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
//        modEventBus.addListener(this::processIMC);
		
        // Register ourselves for server and other game events we are interested in
//		modEventBus.addListener(this::gatherData);
//        MinecraftForge.EVENT_BUS.register(this);
                
//        RegisterTectonicBOPBiomes.REGISTER.register(modEventBus);
    }
}
//    private void setup(final FMLCommonSetupEvent event)
//    {
        // some preinit code
//        LOGGER.info("HELLO FROM PREINIT");
//        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
//    }

//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
        // Some example code to dispatch IMC to another mod
//        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
//    }

//    private void processIMC(final InterModProcessEvent event)
//    {
        // Some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.messageSupplier().get()).
//                collect(Collectors.toList()));
//    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event)
//    {
        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
//}
