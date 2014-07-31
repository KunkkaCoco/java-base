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
		Set<Map.Entry<String, String>> keys = map.entrySet();

		for (Map.Entry entry : keys) {
			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":\"");
			sb.append(entry.getValue());
			sb.append("\",");
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
