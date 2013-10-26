package guava.test.base;

import java.util.*;

import com.google.common.base.*;
import com.google.common.collect.Iterables;
import org.junit.*;
import static org.junit.Assert.*;

public class SplitterTest{
	private String commaStr;
	private String semicolonStr;
	
	@Before
	public void initStr(){
		commaStr = "str1,str2,str3,str4";
		semicolonStr = "str1:str2:str3:str4";
	}

	@Test 
	public void testGeneralSplit(){
		String[] StrSplited = {"str1", "str2", "str3", "str4"};
		
		String[] commaStrSplited = Iterables.toArray(Splitter.on(",").split(commaStr), String.class);
		assertArrayEquals(StrSplited, commaStrSplited);
		
		String[] semicolonStrSplited = Iterables.toArray(Splitter.on(":").split(semicolonStr), String.class);
		assertArrayEquals(StrSplited, semicolonStrSplited);
	}
	
	@Test 
	public void testSplitLimitLength(){
		String[] StrSplited1 = {"str", "1,s", "tr2", ",st", "r3,", "str", "4"};
		String[] StrSplited2 = {"str", "1:s", "tr2", ":st", "r3:", "str", "4"};
		
		String[] commaStrSplited = Iterables.toArray(Splitter.on(",").fixedLength(3).split(commaStr), String.class);
		assertArrayEquals(StrSplited1, commaStrSplited);
		
		String[] semicolonStrSplited = Iterables.toArray(Splitter.on(":").fixedLength(3).split(semicolonStr), String.class);
		assertArrayEquals(StrSplited2, semicolonStrSplited);
	}
	
	@Test
	public void testMapSplit(){
		String rawData = "1:data1\n2:data2\n3:data3\n4:data4";
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("1", "data1");
		resultMap.put("2", "data2");
		resultMap.put("3", "data3");
		resultMap.put("4", "data4");
		
		assertEquals(resultMap, Splitter.on("\n").withKeyValueSeparator(":").split(rawData));
	}
}