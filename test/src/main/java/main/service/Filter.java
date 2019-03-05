package main.service;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
  public static TreeMap<Integer, Integer> getFilter(
      StringBuffer stringBuffer, HashSet<String> patterns) {
    TreeMap<Integer, Integer> locations = new TreeMap<>();
    for (String pattern : patterns) {
      // 创建 Pattern 对象
      Pattern re = Pattern.compile(pattern);
      // 现在创建 matcher 对象
      Matcher m = re.matcher(stringBuffer);
      while (m.find()) {
        locations.put(m.start(), m.end());
      }
    }
    return locations;
  }
}
