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
			// creates instance of message digest with given algorithm
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			
			// updates the digest with the input bytes--the byte representation of the value to be hashed
			// i.e. credit card, ssn, etc
			messageDigest.update(inputBytes);
			
			// "digest the bytes--type of return is byte as well"
			byte[] digestedBytes = messageDigest.digest();
			
			// convert the digested bytes to hex
			hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hashValue;
	}

}
