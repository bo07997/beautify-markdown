package main.service;

import main.config.ReConfig;
import main.model.ReplaceModel;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replace {
  public static StringBuffer replaceWithAdd(
      StringBuffer stringBuffer, TreeMap<Integer, Integer> locations) {
    HashSet<ReplaceModel> replaceModels = ReConfig.replaceSet;
    StringBuffer stringBufferTemp = new StringBuffer(stringBuffer);
    for (ReplaceModel replaceModel : replaceModels) {
      // 创建 Pattern 对象
      Pattern re = Pattern.compile(replaceModel.getPattern());
      // 现在创建 matcher 对象
      int addInt = 0;
      Matcher m = re.matcher(stringBufferTemp);
      while (m.find()) {
        if (isInLocations(locations, m.start(), addInt)) {
          continue;
        }
        addInt =
            AddStringBufferByLocations(
                stringBuffer, replaceModel, m.start() + addInt, m.end() + addInt, addInt);
      }
    }
    return stringBuffer;
  }

  private static int AddStringBufferByLocations(
      StringBuffer stringBuffer, ReplaceModel replaceModel, int start, int end, int addInt) {
    int tempOffset = 0;
    if (replaceModel.getPre() != null) {
      stringBuffer.insert(start, replaceModel.getPre());
      addInt += replaceModel.getPre().length();
      tempOffset += replaceModel.getPre().length();
    }
    if (replaceModel.getBack() != null) {
      stringBuffer.insert(end + tempOffset, replaceModel.getBack());
      addInt += replaceModel.getBack().length();
    }
    return addInt;
  }

  private static boolean isInLocations(TreeMap<Integer, Integer> locations, int start, int offset) {
    int myKey =
        locations.descendingKeySet().stream().filter(key -> key < start + offset).findFirst().get();
    return locations.get(myKey) > start;
  }
}
