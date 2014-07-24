package com.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapWithSet {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("01", "zhangsan");
		map.put("02", "lisi");
		map.put("03", "wangwu");

		Collection<String> collection = map.values();// 返回值是个值的Collection集合
		System.out.println(collection + "\n**********************");

		Set<String> keySet = map.keySet();// 先获取map集合的所有键的Set集合

		Iterator<String> it = keySet.iterator();// 有了Set集合，就可以获取其迭代器。

		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);// 有了键可以通过map集合的get方法获取其对应的值。

			System.out.println("key: " + key + "-->value: " + value);// 获得key和value值
		}
		System.out.println("**********************");

		Set<Map.Entry<String, String>> entrySet = map.entrySet();

		// 将关系集合entrySet进行迭代，存放到迭代器中
		Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();

		while (it2.hasNext()) {
			Map.Entry<String, String> me = it2.next();// 获取Map.Entry关系对象me
			String key2 = me.getKey();// 通过关系对象获取key
			String value2 = me.getValue();// 通过关系对象获取value

			System.out.println("key: " + key2 + "-->value: " + value2);
		}
	}
}
