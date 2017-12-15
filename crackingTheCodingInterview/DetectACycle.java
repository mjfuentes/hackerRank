package crackingTheCodingInterview;

import java.util.HashMap;

public class DetectACycle {

	/*
	Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

	A Node is defined as: 
	    class Node {
	        int data;
	        Node next;
	    }
	*/

	boolean hasCycle(Node head) {
	        
	    HashMap<Node,Boolean> map = new HashMap<Node, Boolean>();
	    while (head != null){
	        if (map.containsKey(head)){
	            return true;
	        }
	        map.put(head, true);
	        head = head.next;
	    }
	    
	    return false;
	    

	}
	
}
