package com.github.brejvinder.ciphermod.ciphermachine.ciphers;

public class CeasarCipher {
	private int key;
	private final String alphanums = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	private final String[] alphabet = { "A", "B", "C", "D", "E", "F", 
										"G", "H", "I", "J", "K", "L", 
										"M", "N", "O", "P", "Q", "R", 
										"S", "T", "U", "V", "W", "X", 
										"Y", "Z" , " "};
	
	// Constructor
	public CeasarCipher() {
		key = 0;
	}

	// Set the offset of the Caesar Cipher 
	public void setKey(String key) {
		this.key = Math.abs(Integer.parseInt(key)) % 27;
	}

	public void setKey(int key) {
		this.key = Math.abs(key) % 27;
	}

	// Converts plaintext to ciphertext 
	public String encrypt(String plaintextInput) {
		int indexer = 0;
		String[] plaintext = stringToArray(plaintextInput.toUpperCase());
		for (int i = 0; i < plaintext.length; i++) {
			indexer = alphanums.indexOf(plaintext[i]);

			plaintext[i] = alphabet[((indexer + key) % 27)];
		}
		return (arrayToString(plaintext));
	}

	// Converts ciphertext to plaintext
	public String decrypt(String ciphertextInput) {
		int indexer = 0;
		String[] ciphertext = stringToArray(ciphertextInput);
		for (int i = 0; i < ciphertext.length; i++) {
			indexer = alphanums.indexOf(ciphertext[i]);

			ciphertext[i] = alphabet[((27 + indexer - key) % 27)];
		}
		return (arrayToString(ciphertext));
	}

	// Converts a given String to an array
	private String[] stringToArray(String input) {
		return (input.split(""));
	}

	// Converts a given array to a String
	private String arrayToString(String[] input) {
		String output = "";
		for (int i = 0; i < input.length; i++) {
			output += input[i];
		}
		return (output);
	}
}
