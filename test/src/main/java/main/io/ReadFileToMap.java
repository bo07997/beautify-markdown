package main.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadFileToMap {
  /**
   * @param path
   * @return HashMap
   * @throws IOException
   */
  public static HashMap<Integer, StringBuffer> ReadLineOfFile(String path) throws IOException {
    HashMap<Integer, StringBuffer> result = new HashMap<>();
    String s;
    int i = 1;
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      while ((s = br.readLine()) != null) {
        StringBuffer stringBuffer = new StringBuffer(s);
        result.put(i++, stringBuffer);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
