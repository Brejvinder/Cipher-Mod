package com.github.brejvinder.ciphermod.ciphermachine;

import com.github.brejvinder.ciphermod.ciphermachine.ciphers.CeasarCipher;

// Wrapper class for different ciphers
public class CipherMachine {

	private CeasarCipher CM;

	private final String encryptKeyword = ".encrypt";
	private final String decryptKeyword = ".decrypt";
	private final String keyKeyword = ".setKey";

	// Constructor
	public CipherMachine() {
		CM = new CeasarCipher();
	}

	public void setKey(int key) {
		CM.setKey(key);
	}

	public void setKey(String key) {
		CM.setKey(key);
	}

	public String encrypt(String plaintext) {
		return (CM.encrypt(plaintext));
	}

	public String decrypt(String ciphertext) {
		return (CM.decrypt(ciphertext));
	}

	public String getEncryptKeyword() {
		return encryptKeyword;
	}

	public String getDecryptKeyword() {
		return decryptKeyword;
	}

	public String getKeyKeyword() {
		return keyKeyword;
	}
	
	public int getEKLength() {
		return encryptKeyword.length();
	}
	
	public int getDKLength() {
		return decryptKeyword.length();
	}
	
	public int getKKLength() {
		return keyKeyword.length();
	}
}
