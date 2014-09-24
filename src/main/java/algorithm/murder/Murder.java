package algorithm.murder;

import java.util.ArrayList;
import java.util.List;

public class Murder {

	static List<List<String>> list = new ArrayList<List<String>>();

	public static void main(String[] args) {
		String[] a = new String[] { "A", "B", "C", "D", "E" };
		sort(a, 0, a.length - 1);
		for (int i = 0; i < list.size(); i++) {
			List<String> strings = list.get(i);
			for (int j = 0; j < 5; j++) {
				if (!"A".equals(strings.get(j)) ^ strings.indexOf("A") > j) {
					if ("C".equals(strings.get(j)) ^ strings.indexOf("B") > j) {
						if ("B".equals(strings.get(j)) ^ strings.indexOf("C") == 2) {
							if ("E".equals(strings.get(j)) ^ strings.indexOf("D") == 0) {
								if ("A".equals(strings.get(j)) ^ strings.indexOf("E") == 1) {
									for (int j2 = 0; j2 < strings.size(); j2++) {
										System.out.print(strings.get(j2));
									}
									System.out.println();
								} else {
									continue;
								}
							} else {
								continue;
							}
						} else {
							continue;
						}
					} else {
						continue;
					}
				} else {
					continue;
				}

			}
		}
	}

	public static void sort(String[] a, int start, int end) {

		List<String> list1 = new ArrayList<String>();
		if (start == end) {
			for (int i = 0; i <= end; i++) {
				list1.add(a[i]);
			}
			list.add(list1);
		} else {
			for (int i = start; i <= end; i++) {
				String temp = a[start];
				a[start] = a[i];
				a[i] = temp;
				sort(a, start + 1, end);
				temp = a[start];
				a[start] = a[i];
				a[i] = temp;
			}
		}
	}

}
