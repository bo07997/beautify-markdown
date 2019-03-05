package main;

import main.config.CommonConfig;
import main.config.ReConfig;
import main.io.ReadFileToMap;
import main.service.Filter;
import main.tool.CommonTool;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

/** Unit test for simple App. */
public class FilterTest {
  /**
   * 测试反过滤
   *
   * @throws IOException
   */
  @Test
  public void AntiFilterTest() throws IOException {
    HashMap<Integer, StringBuffer> test = ReadFileToMap.ReadLineOfFile("E:\\MyProject\\test.md");
    StringBuffer stringBuffer = CommonTool.MapToStrBufWithSplit(test, CommonConfig.splitString);
    TreeMap<Integer, Integer> locations = Filter.getFilter(stringBuffer, ReConfig.antiFilterSet);
    System.out.println();
  }
}
