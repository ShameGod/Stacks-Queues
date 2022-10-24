# Stacks-Queues
a cheat sheet about stacks and queues 
source : https://www.youtube.com/watch?v=wjI1WNcIntg


Stacks and queues are similar data structures, they are both linear. 
Queues are a FIFO : First In First Out
Stacks are a LIFO : Last In First Out

To declare a queue : 

![image](https://user-images.githubusercontent.com/42012627/183361105-dbf8d688-c68f-45ba-8388-af3ffd61f852.png)

![image](https://user-images.githubusercontent.com/42012627/183361187-1382b59b-1fc7-419b-8438-a6191fd688eb.png)

*Notice in this declaration we should add a check to see if head is null in order to avoied a NPE*

There are two limited operation with the queue data structure :
* Queuing : adding an element at **end/ tail** of the queue 
* Dequeueing : removing an element at the **front/ head** of the queue, ***only possible on the head of the queue***


To declare a stacks : 

![image](https://user-images.githubusercontent.com/42012627/183361425-2262c6ec-1f54-42cd-8645-4f05d43db026.png)

we just need a top since we add and remove from the top of the stack. 

![image](https://user-images.githubusercontent.com/42012627/183361947-3ab135cf-3f51-4e06-bb30-aed10cef80a6.png)

Once again the NPE are not checked in order to make this simple 

## Queues and BFS (breath first search) :
BFS is usually used to find the shortest path between the root and the target node. For example : 

![image](https://user-images.githubusercontent.com/42012627/185054073-01451d20-8cf7-49d5-b897-fc6147b1875b.png)

This queue will be traversed level by level (round by round). Each round corresponds to a level of searching. 
**We use a queue because the nodes are treated in the exact same order as they are added to the queue**
template of the use of the BFS : 
```
/**
 * Return the length of the shortest path between root and target node.
 */
int BFS(Node root, Node target) {
    Queue<Node> queue;  // store all nodes which are waiting to be processed
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    add root to queue;
    // BFS
    while (queue is not empty) {
        // iterate the nodes which are already in the queue
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node cur = the first node in queue;
            return step if cur is target;
            for (Node next : the neighbors of cur) {
                add next to queue;
            }
            remove the first node from queue;
        }
        step = step + 1;
    }
    return -1;          // there is no path from root to target
}
```


### Stacks use : 
Stacks can be used for usual problems such as : https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/ 
They can also be used to do DFS. The famous recursive algoritm to do DFS is implicitly using a stack called *the system call stack* the OS stacks the sub routines to execute. 

DFS can be used with an explicite stack in order to avoid stack overflow errors when the depth is too long.
For example : https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1383/
```
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
```


## Leetcode exercises :
By completing leetcode exercises I will be able to : 
* Understand the principle of the processing orders of FIFO and LIFO;
* Implement these two data structures;
* Be familiar with the built-in queue and stack structure;
* Solve basic queue-related problems, especially BFS;
* Solve basic stack-related problems;
* Understand how system stack helps you when you solve problems using DFS and other recursion algorithms;

### Exercise 1 : design a circular queue 
In this exercise I had to design a circular queue using a fixed sized array. https://github.com/ShameGod/Stacks-Queues/blob/main/designCircularQueue.java

I didn't succeed when trying, because I had way too many ifs. The solution was to store two sizes : the total size of the array and the current size of the queue. 

### Exercise 2 : island count with DFS
https://github.com/ShameGod/Stacks-Queues/blob/main/islandCount.java
I didn't use queues with this exercise I don't how to 
What I found great with this exercise is the way we avoid using a new data structure (hashmaps) for visited islands just by replacing the visited places with 0.

### Exercise 3 perfect square : https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/

availabler in the repo. The solution is to use a BFS.

### Exercise 4 : open the lock : 

public int openLock(String[] deadEnds, String target){
	String start = "0000";
	Queue queue = new LinkedList<String>;
	int changesCount =0;
	queue.add(start);
	while(!queue.isEmpty){
		if(queue.contains(target)){return changesCount;}
		foreach element in queue {
			if(!deadEnds.contains(element)){
				get all the possible digit changes
				add  all these possibilities to the queue;
			}
			dequeue element
		}
		changesCount = changesCount+1;
	}

	return -1;
}


