package com.github.brejvinder.ciphermod;

import com.github.brejvinder.ciphermod.ciphermachine.CipherMachine;

import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CipherModEventHandler {

	private CipherMachine CM = new CipherMachine();

	// When receiving messages, intercept them
	@SubscribeEvent
	public void recievedMessage(ClientChatReceivedEvent event) {
		ITextComponent messageInComp = event.getMessage();
		String messageIn = messageInComp.getUnformattedComponentText();
		String messageOut = "";

		// If the message contains the decrypt keyword,
		// plaintext decryptKeyword ciphertext ->
		// plaintext plaintext
		if (messageIn.contains(CM.getDecryptKeyword())) {
			try {
				messageOut += " > ";
				messageOut += CM.decrypt(
						messageIn.substring(messageIn.indexOf(CM.getDecryptKeyword()) + CM.getDKLength() + 1, messageIn.length()));
				event.setMessage(messageInComp.appendText(messageOut));
			} catch (Exception e) {
				// Void
			}
		}

	}

	// When sending messages, intercept them
	@SubscribeEvent
	public void sendMessage(ClientChatEvent event) {
		String messageIn = event.getMessage();
		String messageOut = "";

		// If the message contains the key set keyword, extract and pass it to the
		// ciphermachine and prevent it from being sent
		if (messageIn.contains(CM.getKeyKeyword())) {
			try {
				CM.setKey(messageIn.substring(messageIn.indexOf(CM.getKeyKeyword()) + CM.getKKLength() + 1, messageIn.length()));
				event.setMessage("");
			} catch (Exception e) {
				// Void
			}
		}

		// If the message contains the encrypt keyword,
		// plaintext encryptKeyword plaintext ->
		// plaintext decryptKeyword ciphertext
		if (messageIn.contains(CM.getEncryptKeyword())) {
			try {
				messageOut += messageIn.substring(0, messageIn.indexOf(CM.getEncryptKeyword()));
				messageOut += " " + CM.getDecryptKeyword() + " ";
				messageOut += CM.encrypt(
						messageIn.substring(messageIn.indexOf(CM.getEncryptKeyword()) + CM.getEKLength() + 1, messageIn.length()));
				event.setMessage(messageOut);
			} catch (Exception e) {
				// Void
			}
		}
	}
}
