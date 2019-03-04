package main.tool;

import main.config.commonconfig;

import java.util.HashMap;

public class common {
  public static StringBuffer MapToStrBufWithSplit(HashMap<Integer, StringBuffer> hashMap) {
    StringBuffer stringBuffer = new StringBuffer();
    for (Integer key : hashMap.keySet()) {
      stringBuffer.append(hashMap.get(key));
      stringBuffer.append(commonconfig.splitString);
    }
    return stringBuffer;
  }
}
