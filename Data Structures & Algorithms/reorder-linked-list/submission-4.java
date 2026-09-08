/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 /*
 
 The core intuition behind this recursive solution is using the **call stack as a reverse iterator** while maintaining a normal forward iterator via the return value.

Think of it as two pointers: `cur` walks backward as the recursion unwinds, and `root` walks forward.

---

### The Intuitive Architecture: The Two-Way Relay

```
Forward pointer:  root  --> moves right: 1 -> 2 -> 3
Backward pointer: cur   <-- moves left:  5 <- 4 <- 3

```

1. **Dive to the End:** Call `reorder(root, cur.next)` until `cur == null`. The base case simply hands back `root` (node `1`) to kick off the pairing.
2. **Rewire during Unwind:** When the call returns, stack frame `cur = 5` pairs with `root = 1`:
* Save the next front node: `tmp = root.next` (node `2`).
* Insert `cur` after `root`: `1 -> 5 -> 2`.
* Return `tmp` (`2`) up to the caller so the next frame knows who is next in line.


3. **Collision Detection (The Middle):** When `root` and `cur` meet (`root == cur` for odd lengths, or `root.next == cur` for even lengths):
* Cap the list: `cur.next = null`.
* Return `null` (since `tmp` is initialized to `null`).


4. **Propagate Exit:** When earlier frames receive `null`, they trigger `if (root == null) return null;` to bypass all rewiring and exit cleanly.

---

### How Your Mind Should Run in an Interview

When sitting across from an interviewer, structure your thoughts in these 4 mental beats:

**1. State the Contract First**

> *"I want `cur` to walk to the very end recursively. When returning from each level, the function must return the **next front node** to be processed. Let's call that return value `tmp`."*

**2. Draft the Core Pairing Logic (Assuming the dive works)**
Before writing edge conditions, picture what one middle stack frame does:

```java
// I got root from below, now splice cur after root:
tmp = root.next;
root.next = cur;
cur.next = tmp;
return tmp; // Hand the baton forward

```

**3. Define the Two Ends of the Life Cycle**

* **The Tail Start:** What happens when `cur` falls off the edge (`cur == null`)? It must return the original head (`root`) to initiate the pairing chain.
* **The Middle Collision:** What happens when the two ends meet? If `root == cur` (odd) or `root.next == cur` (even), cut off the tail (`cur.next = null`) and return `null` instead of `root.next`.

**4. Add the Safety Net**
Ask: *"What happens to the frames above me now that I returned `null`?"*

* They will crash if they touch `root.next`.
* Fix: add `if (root == null) return null;` immediately after the recursive call to silently unwind the rest of the stack.

---

### Mental Anchor Checklist

* `cur == null` $\rightarrow$ **Ignition**: Return `root` to start the pairing.
* `root = reorder(...)` $\rightarrow$ **Receive**: Get the current front node from the previous unwind.
* `root == null` $\rightarrow$ **Bypass**: We are done; propagate `null` to the top.
* `root == cur || root.next == cur` $\rightarrow$ **Meeting Point**: Seal list with `.next = null`, return `null`.
* Splice $\rightarrow$ **Standard insertion**: `root.next = cur; cur.next = tmp; return tmp;`.

 */
 class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        reorder(head, head.next);
    }

    ListNode reorder(ListNode root, ListNode cur) {
        if (cur == null) return root;

        root = reorder(root, cur.next);

        if (root == null) return null;

        ListNode tmp = null ;

        if (root == cur || root.next == cur) {
            cur.next = null;
        } else {
            tmp = root.next;
            root.next = cur;
            cur.next = tmp;
        }
        return tmp;
    }
}
