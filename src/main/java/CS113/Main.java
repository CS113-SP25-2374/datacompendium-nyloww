package CS113;

public class Main {
    public static void main(String[] args) {
        // Create an instance of ArrayListPH
        ArrayListPH<Integer> intList = new ArrayListPH<>();

        // Test: Add elements
        System.out.println("Adding integers to the list:");
        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println("List after additions: " + intList);

        // Test: Add element at specific index
        intList.add(1, 15);
        System.out.println("\nList after adding 15 at index 1: " + intList);

        // Test: Access elements
        System.out.println("\nElement at index 2: " + intList.get(2));

        // Test: Remove element by index
        intList.remove(1);  // Removing 15
        System.out.println("\nList after removing element at index 1: " + intList);

        // Test: Remove element by value
        intList.remove(Integer.valueOf(30)); // Removing value 30
        System.out.println("\nList after removing 30: " + intList);

        // Test: Check size
        System.out.println("\nSize of list: " + intList.size());

        // Test: Clear the list
        intList.clear();
        System.out.println("\nList after clear: " + intList);
        System.out.println("\nSize of list after clear: " + intList.size());

        // Test: Check if the list is empty
        System.out.println("\nIs the list empty? " + intList.isEmpty());

        // Add some elements again and use other types like String
        ArrayListPH<String> strList = new ArrayListPH<>();
        strList.add("Hello");
        strList.add("There");
        System.out.println("\nString list after additions: " + strList);

        // Test: Contains
        System.out.println("\nDoes the list contain 'Hello'? " + strList.contains("Hello"));
        System.out.println("Does the list contain 'General Kenobi'? " + strList.contains("General Kenobi"));
    }
}
