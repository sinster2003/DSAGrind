# 0/1 Knapsack

## Pattern Trigger

```text id="4h4rqm"
Finite Supply
↓
Pick item at most once
↓
0/1 Knapsack
```

---

# State

```java id="8az0p0"
func(ind, W)
```

```text id="z3x5ea"
Maximum value obtainable
using items [0...ind]
with capacity W
```

---

# Recurrence

```java id="x4itx5"
pick =
val[ind] +
func(ind - 1, W - wt[ind])

notpick =
func(ind - 1, W)
```

```text id="j56bjo"
Pick -> Previous Index

Not Pick -> Previous Index
```

---

# Base Cases

```java id="6n6clq"
if(W <= 0) return 0;
if(ind < 0) return 0;
```

---

# Approach 1 : Recursion

### Core Idea

```text id="mp10oe"
Try Pick / Not Pick

Pick
↓
Item consumed

Not Pick
↓
Move left
```

### Complexity

```text id="e9e58r"
Time  : O(2^N)
Space : O(N)
```

### Recall Trigger

```text id="68zkd4"
Finite Supply
↓
pick reduces index
```

---

# Approach 2 : Memoization

### Core Idea

```text id="2n2rmn"
Store repeated states

dp[ind][W]
```

### State Meaning

```text id="w3rqjw"
Maximum value obtainable
using items [0...ind]
for capacity W
```

### Complexity

```text id="qewcbm"
Time  : O(N × W)
Space : O(N × W) + recursion stack
```

### Recall Trigger

```text id="4j4sh8"
Recursion
+
Cache overlapping states
```

---

# Approach 3 : Tabulation

### State

```java id="n0qgq2"
dp[i][j]
```

```text id="x2t0sa"
Using first i items
Capacity = j
```

### Transition

```java id="9bzq73"
pick =
val[i-1] +
dp[i-1][j-wt[i-1]]

notpick =
dp[i-1][j]
```

### Critical Observation

```text id="y5q9jd"
Both transitions
use PREVIOUS ROW
```

because

```text id="3m8jrn"
pick consumes item
```

### Complexity

```text id="ptd6dr"
Time  : O(NW)
Space : O(NW)
```

### Recall Trigger

```text id="q6olko"
Finite Supply
↓
Previous Row Dependency
```

---

# Approach 4 : Two Array Optimization

### Observation

```text id="1ob1lk"
Current cell depends only on:

1. Previous Row Left
2. Previous Row Same Column
```

```java id="egimdf"
pick =
prev[j-wt]

notpick =
prev[j]
```

### Flow

```text id="ux9ztg"
prev
 ↓
curr
```

### Complexity

```text id="lfjlwm"
Time  : O(NW)
Space : O(W)
```

### Recall Trigger

```text id="jaj4o2"
Only previous row needed
↓
2 arrays sufficient
```

---

# Approach 5 : Single Array Optimization

### Observation

```text id="9y33qo"
Need

dp[i-1][j-wt]
and

dp[i-1][j]
```

Both must remain unchanged
while processing current item.

---

### Traversal

```text id="j5ojrf"
Right → Left
```

```java id="1yrf5r"
for(j = W; j >= wt[i]; j--)
```

### Why?

```text id="p0bxx5"
Need previous-row left value

dp[i-1][j-wt]
```

If traversed Left → Right:

```text id="6f95ki"
dp[j-wt]
gets overwritten
```

and becomes:

```text id="qho5cq"
dp[i][j-wt]
```

which accidentally allows
reusing the same item.

---

### Mental Model

```text id="93zt3w"
Protect previous-row values

by processing from right.
```

### Complexity

```text id="3gb7n9"
Time  : O(NW)
Space : O(W)
```

### Recall Trigger

```text id="xbt4f9"
Finite Supply
↓
Need previous-row left value
↓
Protect from overwrite
↓
Right → Left
↓
Single Array
```

---

# Unbounded vs 0/1

```text id="mqezxt"
0/1 Knapsack

pick -> previous row
↓
Right → Left
```

```text id="17zshk"
Unbounded Knapsack

pick -> current row
↓
Left → Right
```

---

# 15-Second Final Recall

```text id="qofx0v"
Finite Supply
↓
Pick consumes item
↓
pick = val + func(ind-1, W-wt)
↓
Tabulation uses PREVIOUS ROW
↓
dp[i-1][j-wt]
↓
Need previous-row left value
↓
Right → Left traversal
↓
Single Array Optimization
```

### Ultimate Pattern Rule

```text id="i4ub9p"
Pick uses Previous Row
→ Right to Left

Pick uses Current Row
→ Left to Right
```
