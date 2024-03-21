public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hash table");

        HashTable<String, Integer> htable = new HashTable<>();
        htable.put("a", 1);
        htable.put("b", 2);
        htable.put("c", 3);
        htable.put("d", 4);
        htable.put("e", 5);

        System.out.println(htable.get("e"));
        System.out.println(htable.get("f"));

        System.out.println(htable.contains("a"));
        System.out.println(htable.contains("i"));

        htable.remove("a");
        System.out.println(htable.contains("a"));
        
        htable.remove("b");
        System.out.println(htable.contains("b"));

        htable.remove("i");
    }
}
