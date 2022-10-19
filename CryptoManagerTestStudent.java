import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsStringInBounds() {
		assertFalse(CryptoManager.isStringInBounds("{}{}"));
	}

	@Test
	void testCaesarEncryption() {
		assertEquals("GNQH", CryptoManager.caesarEncryption("HORI", 127));
		assertEquals("*8/,:", CryptoManager.caesarEncryption("DRIFT", 38));
	}

	@Test
	void testBellasoEncryption() {
		assertEquals("OU %,XUST _", CryptoManager.bellasoEncryption("CITY LIGHTS", "LL"));
		assertEquals("UTZI$%N", CryptoManager.bellasoEncryption("SEAGULL", "BOY"));
	}

	@Test
	void testCaesarDecryption() {
		assertEquals("COCO BOTTLE", CryptoManager.caesarDecryption("HTHT%GTYYQJ", 5));
		assertEquals("SUMMER STORM", CryptoManager.caesarDecryption("]_WWO\\*]^Y\\W", 10));
	}

	@Test
	void testBellasoDecryption() {
		assertEquals("SONNY BOY", CryptoManager.bellasoDecryption("&T!S,%UT,", "SE"));
		assertEquals("COMING TO YOU LIVE", CryptoManager.bellasoDecryption("G__M^Y$$!$)!Y0^M&W", "DPR"));
	}

}
