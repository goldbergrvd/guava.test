package guava.test.base;

import com.google.common.base.Ascii;
import org.junit.*;
import static org.junit.Assert.*;

public class AsciiTest {
	private char[] lowerCharacter = {'a', 'b', 'c', 'd', 'e',
									'f', 'g', 'h', 'i', 'j',
									'k', 'l', 'm', 'n', 'o',
									'p', 'q', 'r', 's', 't',
									'u', 'v', 'w', 'x', 'y', 'z'};
	private char[] upperCharacter= {'A', 'B', 'C', 'D', 'E',
									'F', 'G', 'H', 'I', 'J',
									'K', 'L', 'M', 'N', 'O',
									'P', 'Q', 'R', 'S', 'T',
									'U', 'V', 'W', 'X', 'Y', 'Z'};
	private String lowerCaseString;
	private String upperCaseString;
	
	private static final short UPPER_START = 65;
	private static final short UPPER_END= 90;
	private static final short LOWER_START = 97;
	private static final short LOWER_END = 122;
	
	@Before
	public void initString(){
		lowerCaseString = new String(lowerCharacter);
		upperCaseString = new String(upperCharacter);
	}
	
	@Test
	public void testIsLowerCase(){
		for(int i=0; i<26; i++){
			assertTrue(Ascii.isLowerCase(lowerCharacter[i]));
			assertFalse(Ascii.isLowerCase(upperCharacter[i]));
		}
		
		for(short s=LOWER_START; s<=LOWER_END; s++){
			assertTrue(Ascii.isLowerCase((char)s));
		}
		
		for(short s=0; s<LOWER_START; s++){
			assertFalse(Ascii.isLowerCase((char)s));
		}
		
		for(short s=LOWER_END+1; s<128; s++){
			assertFalse(Ascii.isLowerCase((char)s));
		}
	}
	
	@Test
	public void testIsUpperCase(){
		for(int i=0; i<26; i++){
			assertTrue(Ascii.isUpperCase(upperCharacter[i]));
			assertFalse(Ascii.isUpperCase(lowerCharacter[i]));
		}
		
		for(short s=UPPER_START; s<=UPPER_END; s++){
			assertTrue(Ascii.isUpperCase((char)s));
		}
		
		for(short s=0; s<UPPER_START; s++){
			assertFalse(Ascii.isUpperCase((char)s));
		}
		
		for(short s=UPPER_END+1; s<128; s++){
			assertFalse(Ascii.isUpperCase((char)s));
		}
	}
	
	@Test
	public void testToLowerCase(){
		for(int i=0; i<26; i++){
			assertEquals(lowerCharacter[i], Ascii.toLowerCase(upperCharacter[i]));
		}
		
		assertEquals(upperCaseString, Ascii.toUpperCase(lowerCaseString));
	}
	
	@Test
	public void testToUpperCase(){
		for(int i=0; i<26; i++){
			assertEquals(upperCharacter[i], Ascii.toUpperCase(lowerCharacter[i]));
		}
		
		assertEquals(lowerCaseString, Ascii.toLowerCase(upperCaseString));
	}
}
