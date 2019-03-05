package main.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
  public static StringBuffer antiFilter(StringBuffer stringBuffer, HashSet<String> patterns) {
    HashMap<Integer, Integer> locations = new HashMap<>();
    for (String pattern : patterns) {
      // 创建 Pattern 对象
      Pattern re = Pattern.compile(pattern);
      // 现在创建 matcher 对象
      Matcher m = re.matcher(stringBuffer);
      while (m.find()) {
        System.out.println(m.group(0));
        locations.put(m.start(), m.end() + 1); // 由于后面删除是到前一位
      }
    }
    return DelStringBufferByLocations(stringBuffer, locations);
  }

  public static StringBuffer DelStringBufferByLocations(
      StringBuffer stringBuffer, HashMap<Integer, Integer> locations) {
    int delInt = 0;
    for (Integer locationKey : locations.keySet()) {
      int end = locations.get(locationKey);
      stringBuffer.delete(locationKey - delInt, end - delInt);
      delInt = delInt + end - locationKey;
    }
    return stringBuffer;
  }
}
