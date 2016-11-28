package mrtjp.projectred

import mrtjp.projectred.core._
import net.minecraft.creativetab.CreativeTabs
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent, FMLServerStartingEvent}
import org.apache.logging.log4j.LogManager

@Mod(modid = "ProjRed|Core", useMetadata = true, modLanguage = "scala", guiFactory = "mrtjp.projectred.core.GuiConfigFactory")
object ProjectRedCore
{
    val log = LogManager.getFormatterLogger("ProjRed|Core")

    /** Items **/
    var itemPart:ItemPart = _
    var itemDrawPlate:ItemDrawPlate = _
    var itemScrewdriver:ItemScrewdriver = _
    var itemWireDebugger:ItemWireDebugger = _

    var tabCore = new CreativeTabs("core")
    {
        override def getTabIconItem = itemScrewdriver
    }

    @Mod.EventHandler
    def preInit(event:FMLPreInitializationEvent)
    {
        Configurator.loadConfig()
        CoreProxy.versionCheck()
        CoreProxy.preinit()
    }

    @Mod.EventHandler
    def init(event:FMLInitializationEvent)
    {
        CoreProxy.init()
    }

    @Mod.EventHandler
    def postInit(event:FMLPostInitializationEvent)
    {
        CoreProxy.postinit()
    }

    @Mod.EventHandler
    def onServerStarting(event:FMLServerStartingEvent){}
}