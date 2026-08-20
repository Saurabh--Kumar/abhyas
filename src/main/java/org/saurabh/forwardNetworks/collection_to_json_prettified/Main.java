package org.saurabh.forwardNetworks.collection_to_json_prettified;

import java.util.*;
import java.util.stream.*;


public final class Main {

    private static final String defaultIndentation = "  ";


    private Main() { }

    /**
     * Formats a value (possibly {@code null}) as a pretty JSON string.
     *
     * <p>Each JSON array value should begin on a new line, indented two spaces
     * further than its container. The same goes for JSON object keys.
     *
     * <p>Supported types include {@link Boolean}, {@link Integer}, {@link Double},
     * {@link String}, {@link Collection}, and {@link Map}.
     */

    public static String toJson(Object value) {
        return toJson(value, 0);
    }


    public static String toJson(Object value, int level) {

        String indentation = "";
        for(int i = 0; i< level; i++){
            indentation = indentation+"  ";
        }

        if(value == null){
            return indentation + "null";
        }
        if(value instanceof Boolean || value instanceof Integer || value instanceof Double) {
            return indentation + value.toString();
        }

        if(value instanceof String) {
            String s = (String) value;
            return indentation + "\"" + s.replace("\"","\\\"") + "\"";
        }

        if(value instanceof Collection) {
            StringBuffer output = new StringBuffer();
            output.append(indentation + "[\n");
            Collection iterable = (Collection) value;

            int count = 0;

            for(Object element : iterable) {
                if(count > 0) {
                    output.append(",\n");
                }
                output.append(toJson(element, level+1));
                count ++;
            }
            if(iterable.size() > 0){
                output.append("\n");
            }

            output.append(indentation + "]");

            return output.toString();

        }

        if(value instanceof Map) {
            StringBuffer output = new StringBuffer(indentation + "{\n");
            Map<?,?> map = (Map<?,?>) value;

            int count = 0;

            for(Map.Entry<?,?> element : map.entrySet()){
                if(count > 0) {
                    output.append(",\n");
                }

                output.append(toJson(element.getKey(), level+1));
                output.append(": ");
                output.append(toJson(element.getValue(), level+1).trim());

                count ++;
            }

            if(map.entrySet().size()>0){
                output.append("\n");
            }

            output.append(indentation + "}");

            return output.toString();
        }

        return "";

    }



    // -------------------------------------------------------------------
    // Test runner. Do not edit.
    // -------------------------------------------------------------------

    static int numTestCases;
    static int numPassingTestCases;

    public static void main(String[] args) {
        assertEquals(toJson(null), "null");
        assertEquals(toJson(true), "true");
        assertEquals(toJson(false), "false");
        assertEquals(toJson(3), "3");
        assertEquals(toJson(-0.12), "-0.12");
        assertEquals(toJson(""), "\"\"");
        assertEquals(toJson("We saw \"Jaws\" yesterday."),
                "\"We saw \\\"Jaws\\\" yesterday.\"");
        assertEquals(toJson(List.of(0, 1, 2, 3)),
                """
                [
                  0,
                  1,
                  2,
                  3
                ]""");
        assertEquals(toJson(Set.of(Set.of(Set.of()))),
                """
                [
                  [
                    [
                    ]
                  ]
                ]""");
        assertEquals(toJson(map("a", 1, "b", true, "c", "C")),
                """
                {
                  "a": 1,
                  "b": true,
                  "c": "C"
                }""");
        assertEquals(toJson(List.of(map("color", "blue",
                                "coords", List.of(map("x", 1.2, "y", -2.3),
                                        map("x", -12.4, "y", 0))),
                        map("color", null,
                                "coords", List.of(map("x", 7.3, "y", 5))))),
                """
                [
                  {
                    "color": "blue",
                    "coords": [
                      {
                        "x": 1.2,
                        "y": -2.3
                      },
                      {
                        "x": -12.4,
                        "y": 0
                      }
                    ]
                  },
                  {
                    "color": null,
                    "coords": [
                      {
                        "x": 7.3,
                        "y": 5
                      }
                    ]
                  }
                ]""");

        System.out.println("\n" + numPassingTestCases + " passed, " +
                (numTestCases - numPassingTestCases) + " failed");
    }

    private static Map<String, Object> map(Object... keysAndValues) {
        assert keysAndValues.length % 2 == 0;
        var map = new LinkedHashMap<String, Object>();
        for (int i = 0; i < keysAndValues.length; i += 2) {
            map.put(keysAndValues[i].toString(), keysAndValues[i + 1]);
        }
        return map;
    }

    private static void assertEquals(String actual, String expected) {
        int n = ++numTestCases;
        if (expected.equals(actual)) {
            numPassingTestCases++;
        } else {
            System.out.println("\n#" + n + " Expected:\n" + expected + "\n#" + n + " Actual:\n" + actual);
        }
    }
}