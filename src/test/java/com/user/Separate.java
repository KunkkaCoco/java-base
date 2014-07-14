package com.user;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.util.Lang;
import com.xinhuanet.user.model.User;

public class Separate {

	public void separate(List<User> list, List<Object> codes) {

		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			boolean flag = true;
			User user = it.next();
			Object code = user.getJobCode();
			Map<Object, Integer> map = new HashMap<Object, Integer>();
			for (Object codetype : codes) {
				if (code.equals(codetype)) {
					Integer num = (map.get(codetype) == null ? 0 : map.get(codetype)) + 1;
					map.put(codetype, num);
					flag = false;
					continue;
				}
			}
			if (flag == false) {
				Integer num = (map.get(-1) == null ? 0 : map.get(-1)) + 1;
				map.put(-1, num);
				flag = true;
			}
		}
	}

	public List<User> getUsers() {
		// TODO userService.getUserByIds(List<Integer> userIds)
		return null;
	}

	public static void main(String[] args) {
		Map<Object, Integer> map = new HashMap<Object, Integer>();

		map.put(-1, 0);
		map.put(1, 0);
		map.put(2, 0);
		map.put(3, 0);
		map.put(4, 0);
		map.put(5, 0);
		for (int i = 0; i < 50; i++) {
			boolean flag = true;
			Random random = new Random();
			Integer code = random.nextInt(6);
			List<Integer> cods = Lang.list(1, 2, 3, 4, 5);
			for (Object codetype : cods) {
				if (code.equals(codetype)) {
					Integer num = (map.get(codetype) == null ? 0 : map.get(codetype)) + 1;
					map.put(codetype, num);
					flag = false;
					continue;
				}
			}
			if (flag == true) {
				Integer num = (map.get(-1) == null ? 0 : map.get(-1)) + 1;
				map.put(-1, num);
			}
		}
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&:" + JSON.toJSONString(map));

		/**********************************/

		// map.put("-1", 0);
		// map.put("1", 0);
		// map.put("2", 0);
		// map.put("3", 0);
		// map.put("4", 0);
		// map.put("5", 0);
		//
		// for (int i = 0; i < 50; i++) {
		// boolean flag = true;
		// Random random = new Random();
		// String code = String.valueOf(random.nextInt(6));
		// List<String> cods = Lang.list("1", "2", "3", "4", "5");
		// for (Object codetype : cods) {
		// if (code.equals(codetype)) {
		// Integer num = (map.get(codetype) == null ? 0 : map.get(codetype)) + 1;
		// map.put(codetype, num);
		// flag = false;
		// continue;
		// }
		// }
		// if (flag == true) {
		// Integer num = (map.get("-1") == null ? 0 : map.get("-1")) + 1;
		// map.put("-1", num);
		// }
		// }
		// System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&:" + JSON.toJSONString(map));
	}
}
