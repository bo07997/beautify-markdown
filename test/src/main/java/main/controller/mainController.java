package main.controller;

import main.config.CommonConfig;
import main.config.ReConfig;
import main.io.ReadFileToMap;
import main.io.WriteFileFromMap;
import main.service.Filter;
import main.service.Replace;
import main.tool.CommonTool;

import java.io.IOException;
import java.util.HashMap;

public class mainController {
  public static void main(String[] args) throws IOException {
    // 来源HashMap
    HashMap<Integer, StringBuffer> hashMap = ReadFileToMap.ReadLineOfFile("E:\\MyProject\\test.md");
    // 翻转HashMap
    HashMap<StringBuffer, Integer> overHashMap = CommonTool.keyValueOverTurn(hashMap);
    // 合成StringBuffer
    StringBuffer stringBuffer = CommonTool.MapToStrBufWithSplit(hashMap, CommonConfig.splitString);
    // copy临时的
    StringBuffer stringBufferTemp = new StringBuffer(stringBuffer.toString());
    // filter
    Filter.antiFilter(stringBufferTemp, ReConfig.antiFilterSet);
    // replace
    HashMap<StringBuffer, StringBuffer> result = Replace.replaceWithAdd(stringBuffer);
    for (StringBuffer str : result.keySet()) {
      if (overHashMap.containsKey(str)) {
        overHashMap.put(result.get(str), overHashMap.get(str));
        overHashMap.remove(str);
      } else {
        System.out.println("为什么匹配不了!!!");
      }
    }
    // 翻转HashMap
    HashMap<Integer, StringBuffer> resultOverHashMap = CommonTool.keyValueOverTurn(overHashMap);
    WriteFileFromMap.WriteLineFromMap(resultOverHashMap, "E:\\MyProject\\test2.md");
  }
}
