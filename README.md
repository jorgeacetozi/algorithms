# Algorithms and Data Structures

# Array (Data Structure)

An array is a fundamental data structure that supports the getting and setting of values by index. The size of an array dictates how many values it can hold. An array of size n can hold n values. Arrays are distinguished by the fact that getting or setting any element in the array can be done in constant time if you know the index the element is, regardless of the size of the array.

Arrays can be either fixed-sized (in general, this is the built-in implementation in most programming languages) or dynamic. 

## Fixed-sized Regular Arrays

Fixed-sized array are instantiated by defining an initial size. Fixed-sized regular arrays are excelent for implementing:

- Stack with fixed amount of elements because you can insert and remove at the end of the array in constant time complexity O(1)
- Heap with fixed amount of nodes
- Hash tables for inserting and getting elements in constant time (nearly for get). However, the typical implementations perform a resizing operation on it when it's around 75% full (load factor = 0.75) to avoid having too much colisions

## Dynamic Array

A Dynamic Array is an regular array that includes the `grow()` and `shrink()` operations that are used when it increase/decrease the number of elements by a factor (if the factor is 2, it means it will double the size when it gets full or shrink to half of the size when it gets half empty). It makes the ADTs implemented by using arrays as their underlying data structure more flexible as they wouldn't need to know the number of elements in advance. However, the grow() and shrink() operations have linear time complexity O(N), so if there will be lots of rezising due to variable number of elements and you don't need array indices like in Queues and Stacks, it's better to use a Linked List.

## Circular Array (Circular Buffer)

A [Circular Array](https://en.wikipedia.org/wiki/Circular_buffer) has two pointers (start and end), which makes it suitable for both add() and remove() operations at both ends of the array. So, it's excellent for implementing Queue, Stack and Deque - all of them in constant time complexity O(1).

Bottom line: useful for implementing Queue and Deque (for a Stack, just replace it by a regular Array)

## Dynamic Circular Array

This is exactly the same as Circular Array, but implemented with a Dynamic Array (that is, it's able to be resized as the amount of elements increase/decrease).

# Singly Linked List (Data Structure)

By definition, a Singly Linked List has a pointer to the head of the list and each element has the data and a pointer to the next element. Having just a pointer to the head, a Singly Linked List would just allow constant time O(1) operations for addStart() and removeStart(), which means it is optimal for implementing a Stack but not a Queue.

Bottom line: useful for implementing a Stack with flexible number of elements.

## Singly Linked List (Head and Tail references)

Again, the typical defition of a Singly Linked List just have a pointer to the head, which allows add() and remove() operations at the beginning of the list in O(1) but at the end in linear time complexity O(n). However, if we add a pointer to the tail in your implementation, we can make the add() operation at the end of the list (tail) in constant time complexity O(1) (the remove() at the end of the list would still be linear O(n) because it needs the tail's reference of the previous node, which is not possible to obtain by using the tail itself but only traversing the entire list starting from the head), which allows optimal implementation for a Queue with all operations in constant time O(1).

Bottom line: useful for implementing a Queue in O(1), but note that this is not the default definition of Singly Linked Lists in the books. Removing an item from the tail is still bad, linear time complexity O(n). For a Stack, just use a regular Singly Linked List.

## Singly Circular Linked List

This is very similar to the Singly Linked List with head and tail references. However, the Singly Circular Linked List has the tail always pointing to the head instead of null. The benefit of it over the Singly Linked List with head and tail references is that you wouldn't need to keep the head reference, as you could always obtain it with `tail.next`. As it's pretty much the same as the Singly Linked List with head and tail references, it also allows to implement a Queue in O(1) for all operations.

Bottom line: useful for implementing a Queue in O(1). Removing an item from the tail is still bad, linear time complexity O(n). For a Stack, just use a regular Singly Linked List.

# Stack (Abstract Data Type)

Insert and remove from the same end (LIFO).

In order to implement all stack operations in constant time complexity O(1), you would have to use one of the options below:

- **Array** (either Dynamic of fixed)
- **Singly Linked List**

Of course you could also implement it in constant time using more complexes data structures as well, but you don't need them. Examples:

- Circular Array (you would't be using one of the pointers, so this is just a overhead)
- Singly Circular Linked List (a Singly Linked List is enough - the tail reference would just be an overhead)
- Singly Linked List with head and tail references (a Singly Linked List is enough - the tail reference would just be an overhead)
- Doubly Linked List (that's too much for a simple Stack)

# Queue (Abstract Data Type)

Insert at one end and remove from another (FIFO).

In order to implement all queue operations in constant time complexity O(1), you would have to use one of the options below:

- **Circular Array** (either Dynamic of fixed)
- **Singly Circular Linked Lists** or Singly Linked Lists with head and tail references (well, this is just a special case of the Singly Circular Linked Lists)

Of course you could also implement it in constant time using more complexes data structures as well, but you don't need them. Examples:

- Doubly Linked List (that's too much for a simple Queue)

# Deque: **D**ouble-**E**nded **Que**ue (Abstract Data Type)

There are many data structures that make it possible to efficiently (O(1) for `addFront(item)`, `addBack(item)`, `removeFront()`, `removeBack()`, `front()` and `back()`) implement a Deque, like:

- Circular Array
- Doubly Linked List
- Doubly Circular Linked List

A Singly Linked List or a Circular Singly Linked List would not be suitable for implementing a Deque because the `removeBack()` would still cost linear time complexity O(n) to traverse the list and get the reference to previous node of the node being removed.

[Python Deque implementation](https://hg.python.org/cpython/file/3.5/Modules/_collectionsmodule.c) uses a Doubly Linked List.

# Binary Search vs Binary Tree vs Binary Search Tree

# Binary Search Tree (Data Structure)

Traversing a BST (in-order, for example) is just a simplified case of traversing general tree, which in turn is a simplified case of traversing a graph that might contain cycles with Depth-First Search. In DFS and BFS algorithms for graphs, we have to set the node to visited, and as we add its neighbors with a for loop we also set them as visited to avoid cycles. As BST or a general tree don't contain cycles by definition, you don't have to set them as visited.

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



The Travelling Salesman Problem is about going to each city exactly once while returning to the original city (thus walking along a Hamiltonian cycle) and also taking the shortest route among all possible routes that fulfill this criterium (if such a route exists). Finding such a cycle, perforce finding the possibly unique optimal cycle with the shortest distance, is "hard".

The Chinese Postman Problem or Route Inspection Problem is about visiting each route between cities at least once while returning to the original city and taking the shortest route among all possible routes that fulfill this criterium (if such a route exists). A solution that takes each route exactly once is automatically optimal and called an Eulerian Cycle. Finding such a cycle is "feasible".



Em Java, se vc precisa que uma recursão devolva algo, vc precisa passar este "algo" como parâmetro da recursão e fazer todos os "return" da função retornarem este "algo", tipo:

```java
List<T> findPartials(String str) {
	return findPartials(root, str, i, new ArrayList<>());
}

List<T> findPartials(Node<T> currentNode, String str, int i, List<T> partials) {
	
	if (currentNode == null) {
		return partials;
	}

	char currentChar = str.charAt(i);

	if (currentChar < currentNode.value) {
		findPartials(currentNode.leftChild, str, i, partials);
	} else if (currentChar > currentNode.value) {
		findPartials(currentNode.rightChild, str, i, partials);
	} else if (i < str.length() - 1) {
		findPartials(currentNode.middleChild, str, i + 1, partials);
	} else if (i == str.length() - 1) {
		return traverse(currentNode.middleChild, partials);
	}
	return partials;
}

List<T> traverse(Node<T> currentNode, List<T> partials) {
	
	if (currentNode == null) { 
		return partials;
	}

	traverse(currentNode.leftChild, partials);
	traverse(currentNode.middleChild, partials);
	traverse(currentNode.rightChild, partials);

	if (currentNode.value != null) {
		partials.add(currentNode.value);
	}
	return partials;
}
```

Se este "algo" for um objeto (Qlq Collection, array, Map, qlq objeto customizado, etc), vc não precisa fazer:

partials = findPartials(currentNode.leftChild, str, i, partials);

Porque uma alteração num objeto dentro da função reflete no objeto original (a cópia que é passada é a cópia da referência, e não do objeto em si: https://dzone.com/articles/java-pass-by-reference-or-pass-by-value). Caso vc faça isso, vai funcionar do mesmo jeito, mas seria uma atribuição desnecessária, tipo assim:

```java
  List<String> findPartials(String prefix) {
    return findPartials(this.root, prefix, 0, new ArrayList<>());
  }

  List<String> findPartials(Node currentNode, String prefix, int i, List<String> partials) {
    if (currentNode == null) {
      return partials;
    }

    char currentCharacterFromPrefix = prefix.charAt(i);

    if (currentCharacterFromPrefix < currentNode.character) {
      partials = findPartials(currentNode.leftChild, prefix, i, partials); // é desnecessário o partials = 
    } else if (currentCharacterFromPrefix > currentNode.character) {
      partials = findPartials(currentNode.rightChild, prefix, i, partials); // é desnecessário o partials = 
    } else if (i < prefix.length() - 1) {
      partials = findPartials(currentNode.middleChild, prefix, i + 1, partials); // é desnecessário o partials = 
    } else if (i == prefix.length() - 1) {
      return traverse(currentNode.middleChild, partials);
    }
    return partials;
  }
```

No entanto, se for um tipo primitivo ou seus wrappers (Integer), cada chamada possui uma cópia de verdade do valor, entao se vc não capturar o retorno da chamada recursiva, vc vai perder o valor calculado pela recursao, por exemplo:

```java
  boolean isConnected(List<Vertex> vertices) {
    int numberOfVisitedNodes = DFS(vertices.get(0), 0);
    return numberOfVisitedNodes == vertices.size();
  }

  private int DFS(Vertex vertex, int count) {
    if (vertex.visited == false) {
      vertex.visited = true;
      count++;
      for (Vertex neighbor : vertex.neighbors) {
        count = DFS(neighbor, count);
      }
    }
    return count;
  }
```

Sem o `count = DFS(neighbor, count);`, ou seja, se fosse somente `DFS(neighbor, count);`, o retorno final dessa função seria sempre 1 se o vertice nao tivesse visitado, ou 0 caso estivesse.


Outra forma retornar valores em recursão é simplesmente não usar argumentos das funções, mas sim sempre adicionar os resultados da recursão:
```java
  private int DFS2(Vertex vertex) {
    int count = 0;
    if (vertex.visited == false) {
      vertex.visited = true;
      count++;
      for (Vertex neighbor : vertex.neighbors) {
        count = count + DFS2(neighbor);
      }
    }
    return count;
  }
```

Ou:

```java
  private List<String> traverse(Node currentNode) {
    List<String> partials = new ArrayList<>();
    
    if (currentNode == null) {
      return partials;
    }

    if (currentNode.value != null) {
      partials.add((String) currentNode.value);
    }

    partials.addAll(traverse(currentNode.leftChild));
    partials.addAll(traverse(currentNode.middleChild));
    partials.addAll(traverse(currentNode.rightChild));
    return partials;
  }
```

- - - - - - - -
0 1 2 3 4 5 6


linear probing tem o problema do clustering (mtos elementos juntos formando um cluster) mas nao acontece loop infinito na insercao se vc implementar rehashing quando ultrapassa o loadfactor. Já quadratic probing pode acontecer loop infinito, já que os numeros (casa da unidade) comecam a se repetir e se os slots ja tiverem sido ocupados, o while nao vai parar. O mesmo probelma vale pro double hashing (double hashing é uma tecnica de open addressing que usa uma segunda funcao para calcular o incremento (ao inveés de ser sempre linear, ou sempre quadratico)). Pra evitar este problema, parece que usar uma tabela cujo tamanhjo é um numero primo resolveria, mas nao sei.
Ja o metodo chaining nao tem este problema, mas ocupa mais memoria. Lembrando que o chaning poderia nao ser uma linked list, mas sim uma BBST

1 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384


first statistic order (1): greatest item or smallest item in the list
second statistic order (2): second greatest item or second smallest item in the list


TreeMap : Red-Black Tree. All operations in O(log(N))
TreeSet : it is basically a TreeMap with additional behavior (of not allowing duplicates in), so Red-Black Tree again. All operations in O(log(N))
HashMap : hashtable. All O(1)
HashSet : it is basically a HashMap with additional behavior, so hashtable again. All O(1) 
LinkedHashMap: a hashtable and a doubly linked list (that is used to keep the insertion order, like in LRU). All O(1)
LinkedHashSet: a hashtable (with additional behavior of not allowing duplicates in) and a doubly linked list (that is used to keep the insertion order, like in LRU). All O(1)
