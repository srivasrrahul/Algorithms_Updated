import java.util.*;

public class WordSubSequence {


    HashMap<Character,TreeSet<Integer>> formIndex(String doc) {
        HashMap<Character,TreeSet<Integer>> index = new HashMap<>();
        for (int i = 0;i<doc.length();++i) {
            char ch = doc.charAt(i);
            if (index.containsKey(ch)) {
                TreeSet<Integer> indexValue = index.get(ch);
                indexValue.add(i);
            }else {
                TreeSet<Integer> indexValue = new TreeSet<>();
                indexValue.add(i);
                index.put(ch,indexValue);
            }
        }

        return index;
    }
    boolean isSubsequence(String key,int keyIndex ,String doc,int suffixIndex,HashMap<Character,TreeSet<Integer>> index) {
        if (keyIndex == key.length()-1) {
//            for (int j= suffixIndex;j<doc.length();++j) {
//                if (doc.charAt(j) == key.charAt(keyIndex)) {
//                    return true;
//                }
//            }

            char ch = key.charAt(keyIndex);
            if (index.containsKey(ch)) {
                TreeSet<Integer> indexValue = index.get(ch);
                if (indexValue.ceiling(suffixIndex) == null) {
                    return false;
                }else {
                    return true;
                }
            }

            return false;
        }else {
            char ch = key.charAt(keyIndex);
            if (index.containsKey(ch)) {
                TreeSet<Integer> indexValue = index.get(ch);
                SortedSet<Integer> next = indexValue.tailSet(suffixIndex);
                if (next == null) {
                    return false;
                }else {
                    for (Integer nextIndex : next) {
                        boolean checkNext = isSubsequence(key,keyIndex+1,doc,nextIndex+1,index);
                        if (checkNext == true) {
                            return true;
                        }
                    }


                }
            }


            return false;
        }
    }

    public List<String> wordSubsequence(String s, Set<String> wordDict) {
        HashMap<Character,TreeSet<Integer>> indexes =formIndex(s);
        List<String> retValue = new LinkedList<>();
        for (String word : wordDict) {
            if (isSubsequence(word,0,s,0,indexes)) {
                retValue.add(word);
            }
        }

        return retValue;


    }

    public static void main(String[] args) {
        WordSubSequence wordSubSequence = new WordSubSequence();
        Set<String> dict = new HashSet<>(Arrays.asList("de","ding","co","code","lint"));
        //Set<String> dict = new HashSet<>();

        List<String> lst = wordSubSequence.wordSubsequence("lintcode",dict);
        System.out.println("===");
        for (String l : lst) {
            System.out.println(l);
        }
    }
}
