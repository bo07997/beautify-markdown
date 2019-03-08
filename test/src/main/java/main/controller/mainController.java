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
import java.util.TreeMap;

public class mainController {
  public static void main(String[] args) throws IOException {
    // 来源HashMap
    HashMap<Integer, StringBuffer> hashMap = ReadFileToMap.ReadLineOfFile("E:\\MyProject\\test.md");
    // 合成StringBuffer
    StringBuffer stringBuffer = CommonTool.MapToStrBufWithSplit(hashMap, CommonConfig.splitString);
    // filter
    TreeMap<Integer, Integer> locations = Filter.getFilter(stringBuffer, ReConfig.antiFilterSet);
    // replace
    Replace.replaceWithAdd(stringBuffer, locations);
    WriteFileFromMap.WriteLineFromStringBuffer(
        stringBuffer, CommonConfig.parseSplitString, "E:\\MyProject\\test2.md");
  }

  public static void transferFile(String From, String To) throws IOException {
    // 来源HashMap
    HashMap<Integer, StringBuffer> hashMap = ReadFileToMap.ReadLineOfFile(From);
    // 合成StringBuffer
    StringBuffer stringBuffer = CommonTool.MapToStrBufWithSplit(hashMap, CommonConfig.splitString);
    // filter
    TreeMap<Integer, Integer> locations = Filter.getFilter(stringBuffer, ReConfig.antiFilterSet);
    // replace
    Replace.replaceWithAdd(stringBuffer, locations);
    WriteFileFromMap.WriteLineFromStringBuffer(stringBuffer, CommonConfig.parseSplitString, To);
  }
}
