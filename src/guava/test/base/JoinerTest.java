package guava.test.base;

import java.util.*;

import com.google.common.base.*;
import org.junit.*;
import static org.junit.Assert.*;

public class JoinerTest{
	private String[] strRawData = new String[4];
	private Map<String, String> mapRawData = new TreeMap<String, String>();
	
	@Before
	public void init(){
		strRawData[0] = "str1";
		strRawData[1] = "str2";
		strRawData[2] = "str3";
		strRawData[3] = "str4";
		
		mapRawData.put("1", "data1");
		mapRawData.put("2", "data2");
		mapRawData.put("3", "data3");
		mapRawData.put("4", "data4");
	}
	
	@Test
	public void testGeneralJoin(){
		String commaResult = "str1,str2,str3,str4";
		assertEquals(commaResult,
				Joiner.on(",")
				.join(Arrays.asList(strRawData)));

		String colonResult = "str1:str2:str3:str4";
		assertEquals(colonResult,
				Joiner.on(":")
				.join(Arrays.asList(strRawData)));
	}
	
	@Test
	public void testMapJoin(){
		String result = "1:data1,2:data2,3:data3,4:data4";
		assertEquals(result,
				Joiner.on(",")
				.withKeyValueSeparator(":")
				.join(mapRawData));
	}
	
	@Test
	public void testAppendToStringBuilder(){
		StringBuilder resultStrBuilder = new StringBuilder("1:data1,2:data2,3:data3,4:data4");
		assertEquals(resultStrBuilder.toString(),
				Joiner.on(",")
				.withKeyValueSeparator(":")
				.appendTo(new StringBuilder(), mapRawData).toString());
	}
}