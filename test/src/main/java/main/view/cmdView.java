package main.view;

import main.controller.mainController;
import main.io.CreateFileUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class cmdView {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入你要做的动作:1 转换 2 其他");
    String type = "1";
    if (scanner.hasNext()) {
      type = scanner.next();
    }
    if (type.equals("1")) {
      transfer(scanner);
    } else {
      System.out.println("暂时未开通，再见");
    }
  }

  static void transfer(Scanner scanner) {
    System.out.println("请输入你要转换的文件或文件夹绝对路径:");
    String typeOne = "";
    if (scanner.hasNext()) {
      typeOne = scanner.next();
    }
    File file = new File(typeOne);
    if (file.exists() && file.isDirectory()) {
      transferFromFile(file);
    } else {
      System.out.println("文件夹不存在!");
    }
  }

  static void transferFromFile(File files) {
    File k = files.getParentFile();
    String newPath = k.toPath().toString() + File.separator + files.getName() + "Temp";
    CreateFileUtil.createDir(newPath);
    File[] fs = files.listFiles(); // 遍历path下的文件和目录，放在File数组中
    for (File f : fs) { // 遍历File[]数组
      if (!f.isDirectory()) {
        try {
          mainController.transferFile(f.getAbsolutePath(), newPath + File.separator + f.getName());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
