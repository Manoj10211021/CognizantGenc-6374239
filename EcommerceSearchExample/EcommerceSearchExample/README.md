# E-commerce Platform Search Function

## Objective
Implement linear and binary search to find products by ID and analyze their time complexities.

## Algorithms Used
- **Linear Search**: O(n) time complexity, works on unsorted data.
- **Binary Search**: O(log n) time complexity, but requires sorted data.

## Best, Average, Worst Case
| Algorithm      | Best Case     | Average Case  | Worst Case    |
|----------------|---------------|---------------|---------------|
| Linear Search  | O(1)          | O(n/2) ≈ O(n) | O(n)          |
| Binary Search  | O(1)          | O(log n)      | O(log n)      |

## Recommendation
For large e-commerce datasets, binary search offers faster performance **if the data is sorted**. If products are being frequently added or reordered, consider more dynamic data structures like hash maps or trees.