package main.service;

import main.config.CommonConfig;
import main.config.ReConfig;
import main.model.ReplaceModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replace {
  public static HashMap<StringBuffer, StringBuffer> replaceWithAdd(StringBuffer stringBuffer) {
    HashSet<ReplaceModel> replaceModels = ReConfig.replaceSet;
    HashMap<StringBuffer, StringBuffer> result = new HashMap<>();
    for (ReplaceModel replaceModel : replaceModels) {
      // 创建 Pattern 对象
      Pattern re = Pattern.compile(replaceModel.getPattern());
      // 现在创建 matcher 对象
      Matcher m = re.matcher(stringBuffer);
      int addInt = 0;
      while (m.find()) {
        addInt =
            AddStringBufferByLocations(
                result, stringBuffer, replaceModel, m.start(), m.end(), addInt);
      }
    }
    return result;
  }

  // 这里太恶心了
  private static int AddStringBufferByLocations(
      HashMap<StringBuffer, StringBuffer> result,
      StringBuffer stringBuffer,
      ReplaceModel replaceModel,
      int start,
      int end,
      int addInt) {
    String[] strings = stringBuffer.substring(start, end + 1).split(CommonConfig.splitString);
    if (replaceModel.getPre() != null) {
      StringBuffer temp = new StringBuffer(strings[0]);
      result.put(temp, temp.insert(0, replaceModel.getPre()));
      addInt += replaceModel.getPre().length();
    }
    if (replaceModel.getBack() != null) {
      StringBuffer temp = new StringBuffer(strings[strings.length - 1]);
      result.put(temp, temp.append(replaceModel.getBack()));
      addInt += replaceModel.getBack().length();
    }
    return addInt;
  }
}
