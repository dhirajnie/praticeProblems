package hashings;

import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class Temp {
    int numb;
    String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temp temp = (Temp) o;
        return numb == temp.numb && Objects.equals(name, temp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numb, name);
    }


    public static void main(String[] args) {
        SortedMap<Integer,String> sortedMap = new TreeMap<>();
        sortedMap.put(1,"dhira");
        sortedMap.put(3,"ram");
        sortedMap.put(4,"ravi");
        sortedMap.put(5,"cat");
        Map<Integer,String> tailMap = sortedMap.headMap(2);
        System.out.println(tailMap);
    }
}
