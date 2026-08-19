package org.saurabh.forwardNetworks.prefix_subnet_matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static class TrieNode{
        Map<String, TrieNode> trieNodeMap;
        String subNetPrefix = null;

        TrieNode(){}
    }

    public static List<String> findMatchingSubnetPrefix(List<String> subnetPrefixes, List<String> ipList) {
        TrieNode root = new TrieNode();


        //populate Trie
        for (String subnetPrefix : subnetPrefixes){
            String[] parts = subnetPrefix.split("\\.");

            TrieNode currentNode = root;

            for(String part : parts){
                if(currentNode.trieNodeMap == null) {
                    currentNode.trieNodeMap = new HashMap<>();
                }

                if ( ! currentNode.trieNodeMap.containsKey(part)) {
                    currentNode.trieNodeMap.put(part, new TrieNode());
                }
                currentNode = currentNode.trieNodeMap.get(part);
            }

            currentNode.subNetPrefix = subnetPrefix;


        }

        List<String> outPut = new ArrayList<>();

        for (String ip : ipList){
            String match = "*";
            String[] parts = ip.split("\\.");

            TrieNode currentNode = root;

            for(String part : parts) {
                if(currentNode.subNetPrefix != null) {
                    match = currentNode.subNetPrefix;
                }

                if (currentNode.trieNodeMap == null) {
                    break;
                }

                if(currentNode.trieNodeMap.containsKey("*")){
                    match = currentNode.trieNodeMap.get("*").subNetPrefix;
                }

                if(currentNode.trieNodeMap.containsKey(part) && currentNode.trieNodeMap.containsKey(part)){
                    currentNode = currentNode.trieNodeMap.get(part);
                } else {
                    break;
                }
            }

            if(currentNode.subNetPrefix != null){
                match = currentNode.subNetPrefix;
            }


            outPut.add(match);
        }

        return outPut;
    }


    public static void main(String[] args) {
        Solution matcher = new Solution();

        List<String> prefixes = List.of("192.168.*", "192.168.2.*", "192.168.2.1", "*");
        List<String> ipAddresses = List.of("0.0.0.0", "192.168.7.1", "192.168.2.3","192.168.2.1");

        List<String> result = matcher.findMatchingSubnetPrefix(prefixes, ipAddresses);
        System.out.println(result);
    }
}
