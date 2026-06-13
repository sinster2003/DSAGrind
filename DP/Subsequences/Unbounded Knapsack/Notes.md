# Unbounded Knapsack / Rod Cutting

## Pattern Trigger

```text
Infinite Supply
↓
Pick does NOT reduce index
↓
Unbounded Knapsack
```

---

# State

```java
func(ind, W)
```

```text
Maximum value obtainable
using items [0...ind]
with capacity W
```

---

# Recurrence

```java
pick =
val[ind] +
func(ind, W - wt[ind])

notpick =
func(ind - 1, W)
```

```text
Pick -> Same Index
Not Pick -> Previous Index
```

---

# Base Cases

```java
if(W <= 0) return 0;
if(ind < 0) return 0;
```

---

# Approach 1 : Recursion

### Core Idea

```text
Try Pick / Not Pick

Pick
↓
Stay on same item

Not Pick
↓
Move left
```

### Complexity

```text
Time  : O(2^N × W) (Exponential)
Space : O(W) recursion stack
```

### Recall Trigger

```text
Infinite Supply
↓
pick keeps same index
```

---

# Approach 2 : Memoization

### Core Idea

```text
Store repeated states

dp[ind][W]
```

### State Meaning

```text
Maximum value obtainable
using items [0...ind]
for capacity W
```

### Complexity

```text
Time  : O(N × W)
Space : O(N × W) + recursion stack
```

### Recall Trigger

```text
Recursion
+
Cache overlapping states
```

---

# Approach 3 : Tabulation

### State

```java
dp[i][j]
```

```text
Using first i items
Capacity = j
```

### Transition

```java
pick =
val[i-1] +
dp[i][j-wt[i-1]]

notpick =
dp[i-1][j]
```

### Critical Observation

```text
Pick uses SAME ROW

dp[i][j-wt]
```

because

```text
pick does not change index
```

### Complexity

```text
Time  : O(NW)
Space : O(NW)
```

### Recall Trigger

```text
Same Index
↓
Same Row
```

---

# Approach 4 : Two Array Optimization

### Observation

```text
Current cell depends on:

1. Previous Row
2. Current Row Left
```

```java
pick =
curr[j-wt]

notpick =
prev[j]
```

### Flow

```text
prev
 ↓
curr
```

### Complexity

```text
Time  : O(NW)
Space : O(W)
```

### Recall Trigger

```text
Need current-left
and previous-column
↓
2 arrays sufficient
```

---

# Approach 5 : Single Array Optimization

### Observation

```text
Never need
prev[j-wt]
```

Need only:

```java
pick =
curr[j-wt]

notpick =
curr[j]
```

### Traversal

```text
Left → Right
```

### Why?

```text
Pick needs current-row left value.

Current-row left value
must already be computed.
```

### Mental Model

```text
Previous row gradually
transforms into current row.
```

### Complexity

```text
Time  : O(NW)
Space : O(W)
```

### Recall Trigger

```text
Infinite Supply
↓
Current Row Dependency
↓
Left → Right
↓
Single Array
```

---

# Rod Cutting Mapping

```text
Rod Length  -> Capacity

Piece Length -> Weight

Price -> Value
```

```text
Rod Cutting
=
Unbounded Knapsack
```

Same recurrence.

Same DP.

Same optimizations.

---

# 15-Second Final Recall

```text
Infinite Supply
↓
Pick stays on same index
↓
pick = val + func(ind, W-wt)
↓
Tabulation uses SAME ROW
↓
dp[i][j-wt]
↓
Left → Right traversal
↓
Single Array Optimization
```