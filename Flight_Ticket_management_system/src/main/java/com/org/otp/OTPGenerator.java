package com.org.otp;

import java.util.Random;

public class OTPGenerator {
	private static final String OTP_CHARACTERS = "0123456789";
	private static final int OTP_LENGTH = 6;

	public static String generateOTP() {
		Random random = new Random();
		StringBuilder otp = new StringBuilder(OTP_LENGTH);

		for (int i = 0; i < OTP_LENGTH; i++) {
			int randomIndex = random.nextInt(OTP_CHARACTERS.length());
			char randomChar = OTP_CHARACTERS.charAt(randomIndex);
			otp.append(randomChar);
		}

		return otp.toString();
	}
}
