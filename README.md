# Algorithms and Data Structures

# Array (Data Structure)

An array is a fundamental data structure that supports the getting and setting of values by index. The size of an array dictates how many values it can hold. An array of size n can hold n values. Arrays are distinguished by the fact that getting or setting any element in the array can be done in constant time if you know the index the element is, regardless of the size of the array.

## Fixed-sized Regular Arrays

Fixed-sized regular arrays are excelent for implementing:

- Stack with fixed amount of elements because you can insert and remove at the end of the array in constant time complexity O(1) 
- Heap with fixed amount of nodes
- Hash tables for inserting and getting elements in constant time (nearly for get). However, the typical implementations perform a resizing operation on it when it's around 75% full (load factor = 0.75) to avoid having too much colisions

## Dynamic Array

A Dynamic Array is an regular array that includes the `grow()` and `shrink()` operations that are used when it increase/decrease the number of elements by a factor (if the factor is 2, it means it will double the size when it gets full or shrink to half of the size when it gets half empty). It makes the ADTs implemented by using arrays as their underlying data structure more flexible as they wouldn't need to know the number of elements in advance. However, the grow() and shrink() operations have linear time complexity O(N), so if there will be lots of rezising due to variable number of elements and you don't need array indices like in Queues and Stacks, it's better to use a Linked List.

## Circular Array (Circular Buffer)

A [Circular Array](https://en.wikipedia.org/wiki/Circular_buffer) has two pointers (start and end), which makes it suitable for both add() and remove() operations at both ends of the array. So, it's excellent for implementing Queue, Stack and Deque - all of them in constant time complexity O(1).

## Dynamic Circular Array

This is exactly the same as the Circular Array, but it provides the additional features of grow() and shrink().

# Singly Linked List (Data Structure)

A Singly Linked List 

## Singly Linked List (Head and Tail references)

The typical defition of a Singly Linked List just have a pointer to the head, which allows adding and removing operations at the beginning of the list in O(1) but at the end in O(N). If our implementation adds a pointer to the tail, we can make the add operation O(1) at the end of the list (the remove operation would still be O(N) because it needs the reference to the previous node of the tail, which is not possible to obtain by using the tail but only traversing the entire list starting from the head), which allows the implementation of a Queue in O(1).

Bottom line: Singly Linked List with head and tail references allows to implement both Queue and Stack in O(1), but adding a pointer to the tails is an implementation trick, it's not the default definition of a Singly Linked List.

## Singly Circular Linked List

# Stack (Abstract Data Type)

Insert and remove from the same end (LIFO).

In order to implement all stack operations in constant time complexity O(1), you would have to use one of the options below:

- Array
- Singly Linked List
- Doubly Linked List (too much)

Note that the Array could either be dynamic or a fixed one - it doesn't matter.

# Queue (Abstract Data Type)

Insert at one end and remove from another (FIFO).

In order to implement all queue operations in constant time complexity O(1), you would have to use one of the options below:

- Circular Array
- Singly Linked Lists with head and tail references
- Singly Circular Linked Lists
- Doubly Linked List (too much)

Note that the Circular Array could either be dynamic or a fixed one - it doesn't matter.

# Deque: **D**ouble-**E**nded **Que**ue (Abstract Data Type)

There are many data structures that make it possible to efficiently (O(1) for `addFront(item)`, `addBack(item)`, `removeFront()`, `removeBack()`, `front()` and `back()`) implement a Deque, like a `Circular Array`, `Doubly Linked List` or `Doubly Circular Linked List`.

Circular Singly Linked List is not suitable for implementing a Deque because removeBack() would still cost linear time complexity O(n) to traverse the list and get the reference to previous node of the node being removed.

[Python Deque implementation](https://hg.python.org/cpython/file/3.5/Modules/_collectionsmodule.c) uses a `Doubly Linked List`.

# Binary Search vs Binary Tree vs Binary Search Tree



# Binary Search Tree (Data Structure)

# Self-balancing Binary Search Tree: AVL Tree (Data Structure)

# Self-balancing Binary Search Tree: Red-Black Tree (Data Structure)

# Priority Queue (Abstract Data Type)

It's possible to implement Priority Queue ADT using different data structures, like:

1. Binary Search Tree (BST)
2. Self-balancing BST (Red-Black Tree, AVL Tree, etc)
3. **Heap**. Generally, it's implemented by using the Heap data structure because it can perform lookups for the minimum item (Minimum Heap) or maximum item (Maximum Heap) in O(1) (which is what we are after on a Priority Queue, the next item with the lowest or the highest priority), whereas BST would perform in O(N) and Self-balancing BSTs in O(log n).

## Double-ended Priority Queue (Abstract Data Type)

# Associative Array / Map / Dictionary (Abstract Data Type)

It's possible to implement Associative Array / Map / Dictionary ADT by using different data structures, like:

1. Array: if the entry key corresponds to an array index out-of-the-box. This has the advantage of O(1) on `get` operation.
2. BST: has the advantage of keeping the order in which elements are inserted but bad worst case time complexity O(n).
3. Self-balancing BST: has the advantage of keeping the order in which elements are inserted but `get` operation costs O(log n) for both average and worst cases.
4. **HashTable**: relies on Array data structure and uses a hash function to map anything (a string, integer, object, etc) to an array index, therefore it has the advantage of providing O(1) for `get` operation on average. The worst case is O(n), which is worse than Self-balancing BST's worst case, but even so in practice they are faster. Has the disadvantage of not preserving the order in which elements are inserted. HashTable is not so memory friendly as BST, Self-balancing BST and TST because a fixed-size array must be allocated in advance, even though the load factor is nearly 0 (which means the table, or the array, is almost empty). A disadvantage is that when the load factor is nearly 1 (in Java 0.75 and in Python 0.66), a resizing operation must be performed, which means a new array has to be recreated and all the already stored elements rehashed again, which is a costly operation. Generally, Associative Array ADT is implemented as a HashTable though (in Associative Array ADT we are often not looking forward to keep the order of elements).
5. Ternary Search Trees: if the key is a string, a TST can be also be used too implement the Associative Array ADT, proving increased searching functionality around the key (like spell-checking, auto-completion).

# Trie (Data Structure)

# Ternary Search Tree (Data Structure)

The Ternary Search Tree (TST) behaves like a HashTable, in that it uses a key to quickly locate, store, and retrieve data. TST keys are stored (and thus retrieved) in sorted order. A HashTable can use any Object as a key, as long as the object implements a hash function. In contrast, a TST must use a string key. A TST is superior to a HashTable in its ability to find data having keys that partially match a target string. Furthermore, a TST allocates no memory for data that has yet to be placed in the tree and reuses nodes (memory) that multiple data values have in common, thus reducing memory requirements for large data amounts. The flexible way in which the TST searches for and accesses data provides numerous opportunities for creative programming.

# Splay Tree (Data Structure)

# B-Tree (Data Structure)

# Graph Theory Concepts

# Euler Path

An Euler path is a path that uses every edge in a graph with no repeats. Being a path, it does not have to return to the starting vertex.

![Euler Path](resources/images/)

## Euler Path Theorem

A graph will contain an Euler path if it contains **at most** to vertices of odd degree.

![Euler Path Theorem](resources/images/)

**Note**: The theorem does not tell us how to find the Euler path, but only whether it exists or not. Use Fleury's algorithm to determine the actual Euler path.

# Euler Circuit

An Euler circuit is a circuit that uses every edge in a graph with no repeats. Being a circuit, it must start and end at the same vertex.

![Euler Circuit](resources/images/)

A graph will contain an Euler circuit if all vertices have even degree.

![Euler Circuit Theorem](resources/images/)

**Note**: The theorem does not tell us how to find the Euler path, but only whether it exists or not. Use Fleury's algorithm to determine the actual Euler circuit.

# Eulerization

Not every graph has an Euler path or Euler circuit. However, there is often still the goal of finding an Euler path or circuit. If a graph does not have an Euler path or Euler circuit, one can be created by duplicating edges.

**Note**: We can only duplicate edges, not create edges where there wasn't one before.

# Hamiltonian Path

Instead of looking for a circuit that covers every edge once, sometimes we are interested in a circuit that visits every vertex once. This concept would be helpful for example for a delivery person wanting to stop at every delivery location rather than going down every street (Euler).

A Hamiltonian path is a path that visits every vertex once with no repeats. Being a path, it does not have to return to the starting vertex.

![Hamiltonian Path](resources/images/)

Unlike Euler path, there is no theorem to determine whether a graph has a Hamiltonian path.

# Hamiltonian Circuit

A Hamiltonian circuit is a circuit that visits every vertex once with no repeats. Being a circuit, it must start and end at the same vertex.

![Hamiltonian Circuit](resources/images/)

Unlike Euler circuit, there is no theorem to determine whether a graph has a Hamiltonian circuit.

# Spanning Tree

A Spanning Tree is a connected graph using all vertices in which there are no circuits. In other words, there is a path from any vertex to any other vertex, but no circuits.

The **Minimum Cost Spanning Tree** is a Spanning Tree that not only satisfies the above definition but also gives us the minimum sum of edge weights.

## Spanning Tree vs Hamiltonian Path

- **Hamiltonian path**: It is a path that passes through every vertex exactly once.
- **Spanning tree**: It is a subtree which contains all the vertices.

Q1) Are they same?

A) No, because both are different data structures. Hamiltonian path is a sequence of vertices(or edges) whereas spanning tree is a graph. Even if you consider the hamiltonian path as a graph,ie, a tuple of vertex set and edge set, the answer is still no(Why? See Q2 and Q3)

Q2) Is every hamiltonian path(converted to graph type) a spanning tree?

A) Yes, because a hamiltonian path can't have any cycles(if it had cycles, a vertex would be visited more than once) --> it is acyclic --> it is a tree. Also, it covers all the vertices. Hence it is a spanning tree.

Q3) Is every spanning tree a hamiltonian path(converted to graph type)?

A) No. Consider the following counter example:

![Spanning Tree but not Hamiltonian Path](resources/images/spanning_tree_not_hamiltonian_path.png)

The blue colored edges form a spanning tree but not a hamiltonian path.
