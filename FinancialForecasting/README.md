# Financial Forecasting Tool

## 🔁 Concept: Recursion
Recursion simplifies problems like forecasting by solving smaller subproblems (e.g., forecasting year-by-year).

## 🔍 Algorithm Used
### Recursive Formula:
```
FV(n) = FV(n-1) * (1 + growthRate)
Base Case: FV(0) = presentValue
```

## ⏱️ Time Complexity
- Recursive: **O(n)** — linear number of recursive calls.
- Iterative: **O(n)** — same, but more efficient (no call stack overhead).

## ⚠️ Optimization
Recursion can lead to **stack overflow** for large `n`. Using an **iterative version** or **memoization** avoids this risk.

## ✅ Recommendation
Use **iterative** approach for high performance and stability in production systems.