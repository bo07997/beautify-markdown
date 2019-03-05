package main.config;

import main.model.ReplaceModel;

import java.util.HashSet;

public class ReConfig {
  public static final HashSet<String> antiFilterSet =
      new HashSet<String>() {
        {
          //          add("\'\'\'[\\s\\S]*\'\'\'");
          add("```.*?```"); // 代码过滤
          add("\\!\\[\\].*?\\)"); // 图片过滤
        }
      };
  public static final HashSet<ReplaceModel> replaceSet =
      new HashSet<ReplaceModel>() {
        {
          add(new ReplaceModel("`", "[a-z]+[\\-\\']?[a-z]*", "`")); // 英文
        }
      };
}
