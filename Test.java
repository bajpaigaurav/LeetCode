import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
    


    public static void main(String[] args) {
        
        
            List<String> countries = new ArrayList<>();
            countries.add("India");
            countries.add("USA");
            countries.add("China");
            countries.add("India");
            countries.add("UK");
            countries.add("China");
    
           List<String> n = countries.stream()
                    .distinct()
                    .limit(3)
                    .collect(Collectors.toList());

        n.forEach(System.out::println);
        

    }
}