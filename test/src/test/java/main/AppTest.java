package main;

import main.io.ReadFileToMap;
import main.io.WriteFileFromMap;
import main.tool.common;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;
/** Unit test for simple App. */
public class AppTest {
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
  /** test write */
  @Test
  public void TestTransfer() throws IOException {

    HashMap<Integer, StringBuffer> test =
        ReadFileToMap.ReadLineOfFile("E:\\MyProject\\myBlog\\_posts\\2019-01-23-IDEA快捷使用.md");
    StringBuffer stringBuffer = common.MapToStrBufWithSplit(test);
    System.out.println();
  }
}
