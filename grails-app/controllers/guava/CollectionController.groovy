package guava

import com.google.common.collect.BiMap
import com.google.common.collect.HashBasedTable
import com.google.common.collect.HashBiMap
import com.google.common.collect.HashMultimap
import com.google.common.collect.HashMultiset
import com.google.common.collect.Multimap
import com.google.common.collect.Multiset
import com.google.common.collect.Table
import com.google.common.collect.Tables

class CollectionController {

    def index() {}


    def createMultimap() {

//        Map<Integer, List<String>> mapList = new HashMap<>()  ///       in java
//        mapList.put(1, ["a", "a2"]);
//        mapList.put(2, ["b"]);
//        mapList.put(3, ["c"]);


        Multimap<Integer, String> multimap = HashMultimap.create();
        multimap.put(1, "a");
        multimap.put(2, "b");
        multimap.put(3, "c");
        multimap.put(1, "a2");

        for (Map.Entry entry : multimap.entries()) {
            println "key =====>>> " + entry.key + " value =====>>>> " + entry.value
        }

        println  multimap.get(1)
        render "created multimap"
    }

    def createMultiset(){

        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("b");
        multiset.add("b");

        System.out.println("Occurrence of 'b' ==========>>>>>>>>>>>>> : "+multiset.count("b"));

        render "Created Multiset"
    }


    def createBiMap() {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "a");
        biMap.put(2, "b");
//        biMap.put(3, "a"); // an exception
        for (Map.Entry entry : biMap.entrySet()) {
            println "key =====>>> " + entry.key + " value =====>>>> " + entry.value
        }

        println "<<<<<<<<<<===== Inverse Map ================>>>>>> "

        BiMap<String, Integer> invertedMap = biMap.inverse();
        for (Map.Entry entry : invertedMap.entrySet()) {
            println "key =====>>> " + entry.key + " value =====>>>> " + entry.value
        }
        render "Created BiMap"
    }

    def createTable(){
        Table<Integer, String, String> table = HashBasedTable.create();
        table.put(1, "a", "1a");
        table.put(2, "b", "2b");
        table.put(3, "c", "3c");

        for (Table.Cell<Integer, String, String> cell: table.cellSet()){
            System.out.println(cell.getRowKey()+" "+cell.getColumnKey()+" "+cell.getValue());
        }
        render "Created table"
    }


}
