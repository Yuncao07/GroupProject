//import org.junit.jupiter.api.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class JsonifierTest {
//  @Test
//  public void shouldPutAllPropertiesToMap() {
//    Map<String, Object> simpleMap = Jsonifier.toMap(new SimpleSerializationTester());
//    assertEquals(simpleMap.get("testInt"), 123);
//    assertEquals(simpleMap.get("testBool"), true);
//    assertEquals(simpleMap.get("testString"), "some string");
//  }
//
//  @Test
//  public void shouldConvertToMapRecurively() {
//    Map<String, Object> map = Jsonifier.toMap(new ComplexSerializationTester());
//    assertEquals(map.get("testLong"), 456L);
//    assertEquals(((HashMap<String, Object>)map.get("tester")).get("testInt"), 123);
//  }
//
//  @Test
//  public void shouldConvertHahMapToString() {
//    Map<String, Object> simpleMap = Jsonifier.toMap(new SimpleSerializationTester());
//    String json = Jsonifier.toJson(simpleMap);
//    assertTrue(json.startsWith("{"));
//    assertTrue(json.endsWith("}"));
//    assertTrue(json.contains("\"testInt\":123,"));
//    assertTrue(json.contains("\"testBool\":true,"));
//    assertTrue(json.contains("\"testString\":\"some string\","));
//  }
//
//  private static class SimpleSerializationTester {
//    int testInt = 123;
//    boolean testBool = true;
//    String testString = "some string";
//  }
//
//  private static class ComplexSerializationTester {
//    long testLong = 456L;
//    SimpleSerializationTester tester = new SimpleSerializationTester();
//  }
//}
