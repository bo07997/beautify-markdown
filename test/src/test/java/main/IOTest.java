package main;

import main.config.CommonConfig;
import main.io.ReadFileToMap;
import main.io.WriteFileFromMap;
import main.tool.CommonTool;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;
/** Unit test for simple App. */
public class IOTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  /** test read */
  @Test
  public void TestRead() throws IOException {

    HashMap test =
        ReadFileToMap.ReadLineOfFile("E:\\MyProject\\myBlog\\_posts\\2019-01-23-IDEA快捷使用.md");
    System.out.println("");
  }

  /** test write */
  @Test
  public void TestWrite() throws IOException {

    HashMap<Integer, StringBuffer> test =
        ReadFileToMap.ReadLineOfFile("E:\\MyProject\\myBlog\\_posts\\2019-01-23-IDEA快捷使用.md");
    WriteFileFromMap.WriteLineFromMap(test, "E:\\MyProject\\test.md");
  }
  /** test transfer */
  @Test
  public void TestTransfer() throws IOException {
    HashMap<Integer, StringBuffer> test =
        ReadFileToMap.ReadLineOfFile("E:\\MyProject\\myBlog\\_posts\\2019-01-23-IDEA快捷使用.md");
    StringBuffer stringBuffer = CommonTool.MapToStrBufWithSplit(test, CommonConfig.splitString);
    System.out.println();
  }

  @Test
  public void Test() throws IOException {
    StringBuffer stringBuffer = new StringBuffer("123456");
    StringBuffer stringBuffer2 = new StringBuffer("1234567");
    HashMap<StringBuffer, Integer> test = new HashMap<>();
    test.put(stringBuffer, 1);
    test.put(stringBuffer2, 2);
    System.out.println(stringBuffer);
  }
}
