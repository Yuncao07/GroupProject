import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Jsonifier {
  /**
   * Use Reflection to convert any object to a series of nested Maps
   *
   * @param object
   * @return
   */
  public static Map<String, Object> toMap(Object object) {
    Map<String, Object> properties = new HashMap<>();
    Arrays.asList(object.getClass().getDeclaredFields())
          .stream()
          .forEach(field -> {
            field.setAccessible(true);
            try {
              properties.put(field.getName(), isPrimitive(field.get(object).getClass()) ?
                    field.get(object) :
                    toMap(field.get(object))
              );
            } catch (IllegalAccessException e) {
            }
          });

    return properties;
  }


  /**
   * Convert a series of nested HashMaps to a JsonString
   * @param map
   * @return
   */
  public static String toJson (Map<String, Object> map) {
    String json = "{";
    for (String key : map.keySet()) {
      json += String.format("\"%s\":", key);
      Class clazz = map.get(key).getClass();
      if (clazz.getSimpleName().equals("String")) {
        json += String.format("\"%s\"", map.get(key));
      } else if (isPrimitive(clazz) ) {
        json += map.get(key);
      } else {
        json += toJson((HashMap)map.get(key));
      }

      json += ",";
    }

    return json + "}";
  }

  private static boolean isPrimitive(Class claz) {
    return claz.isPrimitive() || Stream.of("Integer", "Boolean", "String", "Char", "Long", "Short").anyMatch(className -> className.equals(claz.getSimpleName()));
  }
}
