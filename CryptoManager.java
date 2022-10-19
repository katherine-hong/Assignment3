
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple ìsubstitution cipherî where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		boolean check = true;
		int val = 0;
		
		for(int i = 0; i < plainText.length(); i++)
		{
//			val = plainText.charAt(i);
//			
//			if(plainText.charAt(i) < LOWER_RANGE)
//			{
//				while(val < LOWER_RANGE)
//					val = val + RANGE;
//			}
//			else if(plainText.charAt(i) > UPPER_RANGE)
//			{
//				while(val > UPPER_RANGE)
//					val = val - RANGE;
//			}
			
			if(plainText.charAt(i) > UPPER_RANGE || plainText.charAt(i) < LOWER_RANGE)
				val++;
			else
				val += 0;
			

			
		}
		
		if(val == 0)
			check = true;
		else
			check = false;
		
		return check;
		
//		for(int i = 0; i <= plainText.length();i++)
//		{
//			
//			if(plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE)
//				boundCheck++;
//			else 
//				boundCheck += 0; 
//		}
//		
//		if(boundCheck > 0)
//			return false;
//		else
//			return true;
//		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
		boolean inBounds;
		inBounds = isStringInBounds(plainText);
		
		String newText = "";
		int val;
		
		if(inBounds == true)
		{
			for(int i = 0; i < plainText.length(); i++)
			{
				val = plainText.charAt(i);
				val += key;
				
				while(val > UPPER_RANGE)
					val = val - RANGE;
				
				newText += (char)val;
				
			}
		}
		else
		{
			newText = "The selected string is not in bounds, Try again.";
		}

		
//		for(int i = 0; i < plainText.length(); i++)
//		{
//			char newChar;
//			newChar = (char) (plainText.charAt(i) + key);
//			
//			if(newChar > UPPER_RANGE)
//			{
//				while(newChar > UPPER_RANGE)
//				{
//					newChar -= RANGE; 
//				}
//				
//				newText += newChar;
//				
//			}
//			else
//			{
//				newText += newChar;	
//			}
//		}
		
//		if(inBounds = true)
//		{
//			for(int i = 0; i < plainText.length(); i++)
//			{
//				char newChar;
//				newChar = (char) (plainText.charAt(i) + key);
//				newText += newChar;
//				//return newText;
//			}
//		}
//		else if(inBounds = false)
//		{
//			//System.out.println("The selected string is not in bounds, Try again.");
//			for(int i = 0; i < plainText.length(); i++)
//			{
//				char newChar;
//				newChar = (char) (plainText.charAt(i) + key);
//				
//				if(newChar > UPPER_RANGE)
//				{
//					while(newChar > UPPER_RANGE)
//					{
//						newChar -= 64; 
//					}
//					
//					newText += newChar;
//					
//				}
//				else
//				{
//					newText += newChar;	
//				}
//					
//				//return newText;
//				
//			}
//		}
		
		return newText;
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		
		String newText = "";
		int val;
		
		for(int i = 0; i < plainText.length(); i++)
		{
			val = plainText.charAt(i);
			val = val + bellasoStr.charAt(i % bellasoStr.length());
			
			while(val > UPPER_RANGE)
				val = val - RANGE;
			
			val = (char)(val + 0);
			newText += (char) val;
				
		}
		
		return newText;
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		
		String newText = "";

		for(int i = 0; i < encryptedText.length(); i++)
		{
			char newChar;
			newChar = (char) (encryptedText.charAt(i) - key);
			
			if(newChar < LOWER_RANGE)
			{
				while(newChar < LOWER_RANGE)
				{
					newChar += RANGE; 
				}
				
				newText += newChar;
				
			}
			else if(newChar > UPPER_RANGE)
			{
				while(newChar > UPPER_RANGE)
				{
					newChar -= RANGE; 
				}
				
				newText += newChar;
			}
			else
			{
				newText += newChar;	
			}
		}
		
		return newText;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		String newText = "";
		int val;
		
		for(int i = 0; i < encryptedText.length(); i++)
		{
			val = encryptedText.charAt(i);
			val = val - bellasoStr.charAt(i % bellasoStr.length());
			
			while(val < LOWER_RANGE)
				val = val + RANGE;
			
			val = (char)(val + 0);
			newText += (char) val;
				
		}
		
		return newText;
		
	}
}





