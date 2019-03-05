package main.tool;

import java.util.HashMap;

public class CommonTool {
  public static StringBuffer MapToStrBufWithSplit(
      HashMap<Integer, StringBuffer> hashMap, String splitString) {
    StringBuffer stringBuffer = new StringBuffer();
    for (Integer key : hashMap.keySet()) {
      stringBuffer.append(hashMap.get(key));
      stringBuffer.append(splitString);
    }
    return stringBuffer;
  }

  public static <K, V> HashMap<V, K> keyValueOverTurn(HashMap<K, V> hashMap) {
    HashMap<V, K> result = new HashMap<>();
    for (K key : hashMap.keySet()) {
      result.put(hashMap.get(key), key);
    }
    return result;
  }
}
