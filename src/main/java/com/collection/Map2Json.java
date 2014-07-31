package com.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

public class Map2Json {
	static String map2Json(Map<String, String> map) {
		if (map.isEmpty()) {
			return "{}";
		}
		StringBuilder sb = new StringBuilder(map.size() << 4);
		sb.append('{');
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String value = map.get(key);
			sb.append('\"');
			sb.append(key);
			sb.append('\"');
			sb.append(':');
			sb.append('\"');
			sb.append(value);
			sb.append('\"');
			sb.append(',');
		}
		// 将最后的 ',' 变为 '}':
		sb.setCharAt(sb.length() - 1, '}');
		return sb.toString();
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "john");
		map.put("sex", "man");
		map.put("interest", "woman");

		String json = map2Json(map);
		System.out.println(json);

		System.out.println(JSON.toJSONString(map));
	}
}
