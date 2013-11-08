package guava.test.primitives;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

import com.google.common.collect.*;
import com.google.common.primitives.*;

public class IntsTest{
	@Test
	public void testAsList(){
		List<Integer> expected = Lists.newArrayList();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(5);
		List<Integer> result = Ints.asList(1, 2, 3, 4, 5);
		assertEquals(expected, result);
	}

	@Test
	public void testCompare(){
		assertTrue(Ints.compare(1, 2) < 0);
		assertFalse(Ints.compare(1, 2) > 0);
		assertFalse(Ints.compare(1, 2) == 0);

		assertFalse(Ints.compare(2, 2) < 0);
		assertFalse(Ints.compare(2, 2) > 0);
		assertTrue(Ints.compare(2, 2) == 0);

		assertFalse(Ints.compare(3, 2) < 0);
		assertTrue(Ints.compare(3, 2) > 0);
		assertFalse(Ints.compare(3, 2) == 0);
	}

	@Test
	public void testFromBytes(){
		assertEquals(1077952576, Ints.fromBytes((byte)64, (byte)64, (byte)64, (byte)64));
		assertEquals(16843009, Ints.fromBytes((byte)1, (byte)1, (byte)1, (byte)1));
	}

	@Test
	public void testHashCode(){
		assertEquals(12, Ints.hashCode(12));
		assertEquals(13, Ints.hashCode(13));
		assertEquals(14, Ints.hashCode(14));
	}

	@Test
	public void testJoin(){
		int[] ints = {1, 2, 3, 4};
		assertEquals("1,2,3,4", Ints.join(",", ints));
		assertEquals("1/2/3/4", Ints.join("/", ints));
		assertEquals("1~2~3~4", Ints.join("~", ints));
	}

	@Test
	public void testMinMax(){
		int[] ints = {87, 52, 17, 91, 11, 46, 74, 34};
		assertEquals(91, Ints.max(ints));
		assertEquals(11, Ints.min(ints));
	}

	@Test
	public void testTryParse(){
		assertEquals(new Integer(1), Ints.tryParse("1"));
		assertEquals(new Integer(2), Ints.tryParse("2"));
		assertEquals(new Integer(3), Ints.tryParse("3"));
		assertNull(Ints.tryParse("one"));
		assertNull(Ints.tryParse("twe"));
		assertNotNull(Ints.tryParse("3"));
	}
}