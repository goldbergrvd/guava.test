package guava.test.collect;

import java.util.*;

import com.google.common.base.*;
import com.google.common.collect.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MapTest{
	private Map<String, String> map;
	private Map allTrueCommunion;
	private Map flowerIsland;
	private Map oldTombFaction;
	private Map beggerGang;
	
	@Before
	public void initMap(){
		map = Maps.newHashMap();
		map.put("王重陽", "全真教");
		map.put("周伯通", "全真教");
		map.put("馬鈺", "全真教");
		map.put("丘處機", "全真教");
		map.put("黃藥師", "桃花島");
		map.put("黃蓉", "桃花島");
		map.put("梅超風", "桃花島");
		map.put("陸乘風", "桃花島");
		map.put("林朝英", "古墓派");
		map.put("李莫愁", "古墓派");
		map.put("小龍女", "古墓派");
		map.put("楊過", "古墓派");
		map.put("洪七公", "丐幫");
		map.put("郭靖", "丐幫");
		map.put("魯有腳", "丐幫");
		map.put("喬峰", "丐幫");
		
		allTrueCommunion = ImmutableMap.of("王重陽", "全真教", "周伯通", "全真教", "馬鈺", "全真教", "丘處機", "全真教");
		flowerIsland = ImmutableMap.of("黃藥師", "桃花島", "黃蓉", "桃花島", "梅超風", "桃花島", "陸乘風", "桃花島");
		oldTombFaction = ImmutableMap.of("林朝英", "古墓派", "李莫愁", "古墓派", "小龍女", "古墓派", "楊過", "古墓派");
		beggerGang = ImmutableMap.of("洪七公", "丐幫", "郭靖", "丐幫", "魯有腳", "丐幫", "喬峰", "丐幫");
	}
	
	@Test
	public void testFilter(){
		
		Map resultMap = Maps.filterKeys(map, new Predicate<String>(){
							public boolean apply(String name){
								return name.contains("黃") || name.contains("風");
							}
						});
		assertEquals(flowerIsland, resultMap);
		
		resultMap = Maps.filterValues(map, new Predicate<String>(){
						public boolean apply(String org){
							return org.equals("全真教");
						}
					});
		assertEquals(allTrueCommunion, resultMap);
		
		resultMap = Maps.filterValues(map, new Predicate<String>(){
						public boolean apply(String org){
							return org.equals("桃花島");
						}
					});
		assertEquals(flowerIsland, resultMap);

		resultMap = Maps.filterValues(map, new Predicate<String>(){
						public boolean apply(String org){
							return org.equals("古墓派");
						}
					});
		assertEquals(oldTombFaction, resultMap);
		
		resultMap = Maps.filterValues(map, new Predicate<String>(){
						public boolean apply(String org){
							return org.equals("丐幫");
						}
					});
		assertEquals(beggerGang, resultMap);
	}
}