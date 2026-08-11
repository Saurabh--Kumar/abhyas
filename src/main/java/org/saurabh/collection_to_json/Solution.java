package org.saurabh.collection_to_json;

import java.util.*;

public class Solution {

    public String toJson(Object c) {

        StringBuilder sb = new StringBuilder();
        toJson(c, sb);
        return sb.toString();

    }

    private void toJson(Object c, StringBuilder sb) {
        if(c == null){
            sb.append("");
            return;
        }

        if(c instanceof Number){
            sb.append((Number) c);
            return;
        } else if(c instanceof CharSequence){
            sb.append("\"" + (String) c + "\"");
            return;
        } else if(c instanceof Boolean){
            sb.append(c);
            return;
        } else if(c instanceof Iterable<?>){
            sb.append("[");
            Iterable iterable = (Iterable) c;
            int count = 0;
            for(Object o : iterable){
                if(count > 0){
                    sb.append(",");
                }
                toJson(o, sb);
                count++;
            }
            sb.append("]");

        } else if(c instanceof Map<?,?>){
            sb.append("{");
            Map map = (Map) c;
            int count = 0;
            for(Object o : map.entrySet()){
                Map.Entry e = (Map.Entry) o;
                if(count > 0){
                    sb.append(",");
                }
                sb.append("\"");
                toJson(e.getKey(), sb);
                sb.append("\" : ");
                toJson(e.getValue(), sb);
                count++;
            }
            sb.append("}");
        } else {
            sb.append(c.toString());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        record Example(String name, Collection<?> input, String expected) {}

        Example[] examples = new Example[]{
                new Example("null collection",        null,                   ""),
                new Example("list of numbers",        List.of(1, 2, 3),       "[1,2,3]"),
                new Example("list of strings",        List.of("a", "b"),      "[\"a\",\"b\"]"),
                new Example("empty list",             List.of(),              "[]"),
                new Example("set of numbers",         Set.of(1, 2),           "[1,2]"),
                //new Example("map",                    Map.of("k", 1),         "{\"k\":1}"),
                new Example("nested list",            List.of(List.of(1, 2)), "[[1,2]]"),
                //new Example("mixed list",             List.of(1, "x", null),  "[1,\"x\",null]"),
        };

        int passed = 0;
        for (Example e : examples) {
            String actual = s.toJson(e.input());
            boolean ok = actual.equals(e.expected());
            if (ok) passed++;

            System.out.println("----------------------------------------");
            System.out.println("Example : " + e.name());
            System.out.println("Input   : " + e.input());
            System.out.println("Expected: " + e.expected());
            System.out.println("Actual  : " + actual);
            System.out.println("Result  : " + (ok ? "PASS" : "FAIL"));
        }

        System.out.println("----------------------------------------");
        System.out.println("Passed " + passed + "/" + examples.length + " examples");
    }

}
