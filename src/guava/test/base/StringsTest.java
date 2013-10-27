package guava.test.base;

import com.google.common.base.Strings;
import org.junit.*;
import static org.junit.Assert.*;

public class StringsTest{
	
	@Test
	public void testCommonPrefix(){
		String str1 = "this is, str1";
		String str2 = "this is str2";
		assertEquals("this is", Strings.commonPrefix(str1, str2));
	}
	
	@Test
	public void testCommonSrffix(){
		String str1 = "Hello Guava, My Name is Hubert!";
		String str2 = "Good afternoon, how are you, Hubert!";
		assertEquals("Hubert!", Strings.commonSuffix(str1, str2).trim());
	}

	@Test 
	public void testEmptyToNull(){
		String nullStr = null;
		String emptyStr = "";
		String str = "123";
		
		assertNull(Strings.emptyToNull(nullStr));
		assertNull(Strings.emptyToNull(emptyStr));
		assertNotNull(Strings.emptyToNull(str));
	}
	
	@Test 
	public void testIsNullOrEmpty(){
		String nullStr = null;
		String emptyStr = "";
		String str = "123";
		
		assertTrue(Strings.isNullOrEmpty(nullStr));
		assertTrue(Strings.isNullOrEmpty(emptyStr));
		assertFalse(Strings.isNullOrEmpty(str));
	}
}