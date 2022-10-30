class Solution {
    HashMap<String,Integer> hashmap = new HashMap<>();
    public List<String> topKFrequent(String[] words, int k) {
        for(String s : words){
            if(hashmap.containsKey(s)){hashmap.put(s,hashmap.get(s)+1);}
            else{hashmap.put(s,1);}
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String word1, String word2){
                int frequency1 = hashmap.get(word1);
                int frequency2 = hashmap.get(word2);
                if(frequency1==frequency2){return word2.compareTo(word1);}
                return frequency1 - frequency2;
            }
        });
        
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            //System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
            priorityQueue.add(entry.getKey());
            if(priorityQueue.size()>k){priorityQueue.poll();}
        }
        System.out.println("this is the queue" + priorityQueue);
        List<String> result = new ArrayList<>();
        while(!priorityQueue.isEmpty()){result.add(priorityQueue.poll());}
        Collections.reverse(result);
        return result;
    }
}
