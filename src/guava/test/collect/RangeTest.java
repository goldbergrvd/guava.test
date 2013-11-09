package guava.test.collect;

import org.junit.*;
import static org.junit.Assert.*;

import com.google.common.collect.*;

public class RangeTest{
	@Test
	public void testRangeAll(){
		assertEquals("(-∞‥+∞)", Range.all().toString());
	}

	@Test
	public void testRangeGreaterLess(){
		assertEquals("[10‥+∞)", Range.atLeast(new Integer(10)).toString());
		assertEquals("(-∞‥10]", Range.atMost(new Integer(10)).toString());

		assertEquals("(10‥+∞)", Range.greaterThan(new Integer(10)).toString());
		assertEquals("(-∞‥10)", Range.lessThan(new Integer(10)).toString());
	}

	@Test
	public void testOpenClosed(){
		assertEquals("[10‥20]", Range.closed(new Integer(10), new Integer(20)).toString());
		assertEquals("[10‥20)", Range.closedOpen(new Integer(10), new Integer(20)).toString());

		assertEquals("(10‥20)", Range.open(new Integer(10), new Integer(20)).toString());
		assertEquals("(10‥20]", Range.openClosed(new Integer(10), new Integer(20)).toString());
	}

	@Test
	public void testUpDown(){
		assertEquals("(-∞‥10]", Range.upTo(new Integer(10), BoundType.CLOSED).toString());
		assertEquals("(10‥+∞)", Range.downTo(new Integer(10), BoundType.OPEN).toString());
	}
}