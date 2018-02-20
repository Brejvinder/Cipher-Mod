package com.github.brejvinder.ciphermod;

import com.github.brejvinder.ciphermod.ciphermachine.CipherMachine;

import net.minecraft.init.Blocks;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = CipherMod.MODID, version = CipherMod.VERSION)
public class CipherMod {
	public static final String MODID = "ciphermod";
	public static final String VERSION = "1.0.0";

	@Mod.Instance(MODID)
	public static CipherMod instance;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("Welcome to the Cipher Mod for Minecraft");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new CipherModEventHandler());
	}

}