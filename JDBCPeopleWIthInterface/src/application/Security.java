package application;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Security {

	private String hashValue = "";

	public Security() {
	}

	/**
	 * hashes values
	 * 
	 * @param inputBytes
	 * @param algorithm
	 * @return
	 */
	public String getHash(byte[] inputBytes, String algorithm) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(inputBytes);
			byte[] digestedBytes = messageDigest.digest();
			hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hashValue;
	}

}
