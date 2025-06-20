public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Shoes", "Fashion"),
            new Product(101, "Laptop", "Electronics"),
            new Product(103, "Mobile", "Electronics"),
            new Product(102, "Chair", "Furniture"),
            new Product(104, "Watch", "Fashion")
        };

        int searchId = 103;

        System.out.println("🔍 Performing Linear Search:");
        Product foundLinear = SearchService.linearSearch(products, searchId);
        System.out.println(foundLinear != null ? foundLinear : "Product not found");

        SearchService.sortByProductId(products);

        System.out.println("\n🔍 Performing Binary Search:");
        Product foundBinary = SearchService.binarySearch(products, searchId);
        System.out.println(foundBinary != null ? foundBinary : "Product not found");

        System.out.println("\n📊 Complexity Analysis:");
        System.out.println("Linear Search - Time Complexity: O(n)");
        System.out.println("Binary Search - Time Complexity: O(log n) [Requires sorted array]");

        System.out.println("\n✅ Recommendation: Use Binary Search for large sorted datasets for faster performance.");
    }
}