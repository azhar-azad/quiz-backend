package com.azad.practice.quizbackend.shared.util;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateQuestionId(int length) {
        return "que:-" + generateRandomString(length) + "Q";
    }
    
    public String generateOptionsId(int length) {
        return "opt:-" + generateRandomString(length) + "O";
    }

	public String generateAnswerId(int length) {
		return "ans:-" + generateRandomString(length) + "A";
	}

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }
}
