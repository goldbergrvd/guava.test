package guava.test.base;

import com.google.common.base.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CaseFormatTest{
	private String lowerCamelStr;
	private String lowerHyphenStr;
	private String lowerUnderscoreStr;
	private String upperCamelStr;
	private String upperUnderscoreStr;
	
	@Before
	public void init(){
		lowerCamelStr = "variableName";
		lowerHyphenStr = "variable-name";
		lowerUnderscoreStr = "variable_name";
		upperCamelStr = "VariableName";
		upperUnderscoreStr = "VARIABLE_NAME";
	}
	
	@Test
	public void testLowerCamel(){
		assertEquals(lowerCamelStr,
				CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, lowerHyphenStr));
		
		assertEquals(lowerCamelStr,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, lowerUnderscoreStr));
		
		assertEquals(lowerCamelStr,
				CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, upperCamelStr));
		
		assertEquals(lowerCamelStr,
				CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, upperUnderscoreStr));
	}
	
	@Test
	public void testUpperCamel(){
		assertEquals(upperCamelStr,
				CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, lowerCamelStr));
		
		assertEquals(upperCamelStr,
				CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, lowerHyphenStr));
		
		assertEquals(upperCamelStr,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, lowerUnderscoreStr));
		
		assertEquals(upperCamelStr,
				CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, upperUnderscoreStr));
	}
	
	@Test
	public void testLowerUnderscore(){
		assertEquals(lowerUnderscoreStr,
				CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, lowerCamelStr));
		
		assertEquals(lowerUnderscoreStr,
				CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_UNDERSCORE, lowerHyphenStr));
		
		assertEquals(lowerUnderscoreStr,
				CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, upperCamelStr));
		
		assertEquals(lowerUnderscoreStr,
				CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, upperUnderscoreStr));
	}
	
	@Test
	public void testUppeUnderscore(){
		assertEquals(upperUnderscoreStr,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, lowerUnderscoreStr));
		
		assertEquals(upperUnderscoreStr,
				CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_UNDERSCORE, lowerHyphenStr));
		
		assertEquals(upperUnderscoreStr,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, lowerUnderscoreStr));
		
		assertEquals(upperUnderscoreStr,
				CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, upperCamelStr));
	}
	
	@Test
	public void testLowerHyphen(){
		assertEquals(lowerHyphenStr,
				CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, lowerCamelStr));
		
		assertEquals(lowerHyphenStr,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, lowerUnderscoreStr));
		
		assertEquals(lowerHyphenStr,
				CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, upperCamelStr));
		
		assertEquals(lowerHyphenStr,
				CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, upperUnderscoreStr));
	}
}