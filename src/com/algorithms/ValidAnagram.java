package com.algorithms;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if ( s.length() != t.length() ) return false;

        Map<Character, Integer> anagram = new HashMap<>();

        for (char c : s.toCharArray()) {
            int x = anagram.getOrDefault( c , 0);
            anagram.put( c , x + 1);
        }
        for (char c : t.toCharArray()) {
            if (!anagram.containsKey(c)) return false;
            int newVal = anagram.get(c) - 1;
            if  (newVal < 0) return false;
            anagram.put(c, newVal);
        }
        return true;
    }
}

