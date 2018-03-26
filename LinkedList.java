package LinkedList;

public class LinkedList {
	private int size = 0;
	private Node header; 
	private Node tail; 

	public LinkedList() {

	}

	public void add(Integer data) {  
	   
	    Node node = new Node(); 
	    node.setData(data);     
	    if (tail == null) {
	        header = node;  
	        tail = node;   
	       
	    } else {   
	        tail.next = node;
	        tail = node;  
	    }
	    size++;
	   
	}

	
	public Integer get(int index) {
	    
	    if (size() == 0 || index > size()-1) {
	        return null;
	    }
	    Node t = header; 
	    int i = 0; 
	    while (i < index) { 
	        t = t.next; 
	        i++;
	    }
	    return t.getData(); 
	    
	}

	public boolean delete(int index) {
	    
	    if (size() == 0 || index > size()-1) {
	        return false;
	    }

	    if (index == 0) {
	        header = header.next;
	        size--;
	        return true;
	    }
	     if (index <0) 
	     {return false;
	}
	    Node t = header;
	    int i = 0;
	    while (i < index-1) {
	        t = t.next;
	        i++;
	    }
	    if (tail == t.next) {
	        tail = t;
	    }
	    t.next = t.next.next;
	    size--;
	    return true;
	    
	    
	}

	public int size() {
	   
	    return this.size;
	    
	}

	class Node{
	    private Node next; 
	    private Integer data; 

	    public Node() {  
	    }

	    public Node getNext() {
	        return next;
	    }
	    public void setNext(Node next) {
	        this.next = next;
	    }
	    public Integer getData() {
	        return data;
	    }
	    public void setData(Integer data) {
	        this.data = data;
	    }
	}

}
