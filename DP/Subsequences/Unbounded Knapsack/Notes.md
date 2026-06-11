# Unbounded Knapsack & Rod Cutting — Lifelong Notes

> **Pattern Family:** Unbounded Knapsack DP
> **Twin Problems:** Unbounded Knapsack ↔ Rod Cutting
> **Core Idea:** After picking an item, you are allowed to pick it again.

---

# 1. Pattern Trigger 🚨

Whenever you see:

* Infinite supply of items
* Can use same item multiple times
* Cut rod into pieces repeatedly
* Coin denomination can be reused
* Length/weight can be consumed repeatedly

Think:

```text
0/1 Knapsack?
↓
Can I reuse the same item?

YES
↓
UNBOUNDED KNAPSACK
```

---

# 2. Mental Model

Imagine a shop:

```text
Weight  Value

2       5
4       11
6       13
```

Capacity = 10

In 0/1 Knapsack:

```text
Take item once
and move left

pick
↓
ind - 1
```

In Unbounded Knapsack:

```text
Take item
and keep item available

pick
↓
same ind
```

Because:

```text
Infinite supply exists
```

---

# 3. Golden Difference from 0/1 Knapsack

## 0/1 Knapsack

```text
pick
=
value[ind]
+
func(ind-1 , W-weight[ind])
```

Because item cannot be reused.

---

## Unbounded Knapsack

```text
pick
=
value[ind]
+
func(ind , W-weight[ind])
```

Because item can be reused.

---

# Entire Pattern in One Sentence

```text
0/1 Knapsack:
Pick → move to previous item

Unbounded Knapsack:
Pick → stay on same item
```

This single line is the whole pattern.

---

# 4. Recursion Tree Mindmap

```text
func(ind,W)

                    (ind,W)
                    /     \
                 pick    notpick
                  |         |
                  |         |
            (ind,W-wt)   (ind-1,W)
                  |
                  |
            same index
```

Notice:

```text
pick branch
never reduces index
```

That is exactly what creates:

```text
Infinite usage
```

---

# 5. State Definition

```text
func(ind,W)
```

Meaning:

```text
Maximum value obtainable
using items [0...ind]
for capacity W
```

---

# 6. Base Cases

### Capacity exhausted

```java
if(W <= 0)
    return 0;
```

Meaning:

```text
No space left.
No value can be earned.
```

---

### No items left

```java
if(ind < 0)
    return 0;
```

Meaning:

```text
Nothing available to pick.
```

---

# 7. Recurrence Flowchart

```text
func(ind,W)

          |
          v

    Can pick item?

      W>=wt[ind]
          |
     +----+----+
     |         |
    YES       NO
     |         |
     v         |
 pick branch   |
     |         |
 value[ind]    |
 +             |
 func(ind,     |
      W-wt)    |
     |         |
     +---------+

notpick branch
=
func(ind-1,W)

Answer
=
max(pick,notpick)
```

---

# 8. Why Pick Uses Same Index

Most important interview question.

Suppose:

```text
wt = 2
val = 5

Capacity = 10
```

Best answer:

```text
Take weight 2
5 times
```

After picking first time:

```text
Remaining Capacity = 8
```

Can we take weight 2 again?

```text
YES
```

Therefore:

```text
func(ind,W-wt[ind])
```

not

```text
func(ind-1,W-wt[ind])
```

---

# 9. Memoization Visualization

State:

```text
dp[ind][W]
```

Meaning:

```text
Maximum value
using items [0...ind]
for capacity W
```

---

Table shape:

```text
          Capacity

      0 1 2 3 4 5 6 ...

i=0

i=1

i=2

i=3
```

Whenever same state appears:

```text
func(2,7)

again

func(2,7)
```

Reuse:

```text
dp[2][7]
```

instead of recomputing.

---

# 10. Tabulation Translation

Recursion:

```text
dp(ind,W)
=
max(
    pick,
    notpick
)
```

---

Tabulation:

```java
pick =
val[i-1]
+
dp[i][j-wt[i-1]]
```

Notice:

```text
dp[i]
not
dp[i-1]
```

Again:

```text
same row
=
unbounded nature
```

---

# Memory Trick

```text
0/1 Knapsack
pick → previous row

Unbounded Knapsack
pick → same row
```

---

# 11. Why Same Row Appears

This is the deepest understanding point.

In recursion:

```text
pick

func(ind,W-wt[ind])
```

Index unchanged.

---

In DP table:

```text
dp[i][j]
```

depends on

```text
dp[i][j-wt]
```

same row

because index never changed.

---

Visualization:

```text
Current Cell

dp[i][j]

     ^
     |
     |
dp[i][j-wt]
```

Dependency remains in same row.

---

# 12. Space Optimization Logic

Tabulation:

```text
Current row depends on

1. Previous row
2. Same row
```

Therefore:

```text
Only 2 rows needed
```

---

Flow:

```text
prev

↓

curr
```

For pick:

```java
curr[j-wt]
```

For notpick:

```java
prev[j]
```

---

# 13. Why Single Array Works

Most important optimization idea.

Observe:

```text
pick
=
curr[j-wt]

notpick
=
curr[j]
```

All information already exists inside same array.

---

Flow:

```text
j = 0 → W

keep updating
same array
```

---

Visualization:

```text
capacity →

0 1 2 3 4 5 6 7

↑
already computed

used for future states
```

---

# 14. Rod Cutting Mapping

The easiest conversion ever.

---

Rod Cutting:

```text
Rod Length = Capacity

Piece Length = Weight

Price = Value
```

---

Mapping:

| Rod Cutting     | Unbounded Knapsack |
| --------------- | ------------------ |
| Rod Length      | Capacity W         |
| Piece Length    | Weight             |
| Price           | Value              |
| Cut Piece Again | Reuse Item         |

---

Example

```text
Rod Length = 8

Lengths:
1 2 3 4

Prices:
2 5 7 8
```

becomes

```text
wt =
[1,2,3,4]

val =
[2,5,7,8]

W = 8
```

Exact same code.

No changes.

---

# 15. Ultimate Pattern Recognition Chart

```text
Can item be reused?

            |
       +----+----+
       |         |
      NO        YES
       |         |
       |         |
   0/1 Knapsack  Unbounded Knapsack
       |         |
       |         |
pick    ind-1    ind
       |         |
       |         |
tab     prev row same row
```

---

# Active Recall 🔥

### Q1

What is the only difference between 0/1 and Unbounded Knapsack?

```text
0/1:
pick -> ind-1

Unbounded:
pick -> ind
```

---

### Q2

Why does Unbounded Knapsack use same row in DP?

```text
Because recursion keeps same index
after pick.
```

---

### Q3

How do I identify Rod Cutting?

```text
Infinite supply of cuts.

Each cut length behaves
like an item weight.
```

---

### Q4

Rod Length corresponds to what?

```text
Capacity W
```

---

### Q5

Piece Length corresponds to what?

```text
Weight
```

---

### Q6

Price corresponds to what?

```text
Value
```

---

# 30-Second Interview Summary

```text
Unbounded Knapsack is identical to 0/1 Knapsack except for one change:

When an item is picked, we stay on the same index because the item can be reused infinitely.

Recurrence:

pick
=
value[ind] + func(ind, W-wt[ind])

notpick
=
func(ind-1, W)

This same-index dependency translates into same-row dependency in tabulation:

pick =
value[i-1] + dp[i][j-wt[i-1]]

Rod Cutting is the exact same pattern where:

Rod Length → Capacity
Piece Length → Weight
Price → Value
```

**Pattern Trigger to permanently remember:**

```text
INFINITE SUPPLY
        ↓
PICK DOES NOT CHANGE INDEX
        ↓
SAME ROW DEPENDENCY
        ↓
UNBOUNDED KNAPSACK / ROD CUTTING
```
