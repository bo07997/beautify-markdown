package main.config;

import main.model.ReplaceModel;

import java.util.HashSet;

public class ReConfig {
  public static final HashSet<String> antiFilterSet =
      new HashSet<String>() {
        {
          //          add("\'\'\'[\\s\\S]*\'\'\'");
          add("---.*?---"); // 注释过滤
          add("\\* .*?\\{\\:toc\\}"); // 开头目录生成器过滤
          add("\\`[A-Za-z]+[\\-\\']?[A-Za-z]*\\`"); // 已有的``过滤
          add("```.*?```"); // 代码过滤
          add("\\!\\[\\].*?\\)"); // 图片过滤
        }
      };
  public static final HashSet<ReplaceModel> replaceSet =
      new HashSet<ReplaceModel>() {
        {
          add(new ReplaceModel("`", "[A-Za-z]+[\\-\\']?[A-Za-z]*", "`")); // 英文
        }
      };
}
