package main.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class WriteFileFromMap {
  public static void WriteLineFromMap(HashMap<Integer, StringBuffer> in, String dst)
      throws IOException {
    String newLine = System.getProperty("line.separator");
    try (OutputStream out = new FileOutputStream(dst)) {
      for (int i = 1; i <= in.size(); i++) {
        StringBuffer stringBuffer = in.get(i);
        out.write(stringBuffer.toString().getBytes());
        out.write(newLine.getBytes());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void WriteLineFromStringBuffer(StringBuffer in, String splitString, String dst)
      throws IOException {
    String newLine = System.getProperty("line.separator");
    String[] strings = in.toString().split(splitString);
    try (OutputStream out = new FileOutputStream(dst)) {
      for (String string : strings) {
        out.write(string.getBytes());
        out.write(newLine.getBytes());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
