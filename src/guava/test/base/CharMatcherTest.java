package guava.test.base;

import com.google.common.base.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CharMatcherTest{
	private String testStr;
	
	@Before
	public void init(){
		testStr = "<--- AbC1 dEf2 GhI3 jKl4 --->";
	}
	
	@Test
	public void testCollapseFrom(){
		assertEquals("<* AbC1 dEf2 GhI3 jKl4 *>",
				CharMatcher.is('-').collapseFrom(testStr, '*'));
	}
	
	@Test
	public void testMatchesAllOf(){
		assertTrue(CharMatcher.ASCII.matchesAllOf(testStr));
		assertTrue(CharMatcher.DIGIT.matchesAnyOf(testStr));
		assertFalse(CharMatcher.DIGIT.matchesAllOf(testStr));
	}
	
	@Test
	public void testRemoveFrom(){
		assertEquals("<--- b1 df2 h3 jl4 --->",
				CharMatcher.inRange('A', 'Z').removeFrom(testStr));
		
		assertEquals("<--- AC1 E2 GI3 K4 --->",
				CharMatcher.inRange('a', 'z').removeFrom(testStr));
		
		assertEquals("<--- 1 2 3 4 --->",
				CharMatcher.inRange('A', 'Z')
				.or(CharMatcher.inRange('a', 'z'))
				.removeFrom(testStr));
	}
	
	@Test
	public void testRetainFrom(){
		assertEquals("ACEGIK",
				CharMatcher.inRange('A', 'Z').retainFrom(testStr));
		
		assertEquals("bdfhjl",
				CharMatcher.inRange('a', 'z').retainFrom(testStr));
		
		assertEquals("AbCdEfGhIjKl",
				CharMatcher.inRange('A', 'Z')
				.or(CharMatcher.inRange('a', 'z'))
				.retainFrom(testStr));
	}
	
	@Test
	public void testreplaceFrom(){
		assertEquals("<*** AbC1 dEf2 GhI3 jKl4 ***>",
				CharMatcher.is('-').replaceFrom(testStr, "*"));
		
		assertEquals("<--- AbC%d dEf%d GhI%d jKl%d --->",
				CharMatcher.DIGIT.replaceFrom(testStr, "%d"));
	}
	
}