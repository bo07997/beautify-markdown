package main.config;

import main.model.ReplaceModel;

import java.util.HashSet;

public class ReConfig {
  /**
   * 一键开启 上行:
   *
   * @param type:开启方式:int 1原价 2首周价 3vip价 下行:
   * @return r:返回码:short
   */
  private static final String CMD_ONE_KEY_OPEN = "1008_20190322_ve5";

  public static final HashSet<String> antiFilterSet =
      new HashSet<String>() {
        {
          //          add("\'\'\'[\\s\\S]*\'\'\'");
          add("---.*?---"); // 注释过滤
          add("\\* .*?\\{\\:toc\\}"); // 开头目录生成器过滤
          add("\\`[A-Za-z]+[\\-\\']?[A-Za-z]*\\`"); // 已有的``过滤
          add("```.*?```"); // 代码过滤
          add("\\!\\[.*?\\].*?\\)"); // 图片过滤
          add("\\{\\%.*? highlight markdown.*? \\%\\}.*?\\{\\%.*? endhighlight.*? \\%\\}"); // 代码过滤
          add("\\#.{0,6}"); // 过滤标题
        }
      };
  public static final HashSet<ReplaceModel> replaceSet =
      new HashSet<ReplaceModel>() {
        {
          add(new ReplaceModel("`", "[A-Za-z][A-Za-z0-9_]+[\\-\\']?[A-Za-z0-9_]*", "`")); // 英文
        }
      };
}
