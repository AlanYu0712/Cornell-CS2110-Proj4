package a4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;



/**
 * 
 * @author Alan
 *A class for creating Heaps, consists of the element of the heap and also the priority of it
 * @param <E> an element of the heap, the information that is contains in each node
 * @param <P> the priority value, using it to create a priority queue, P should be comparable
 */
public class Heap<E,P> implements PriorityQueue<E, P> {

	/**
	 * creating variables for the heap
	 * including:
	 * array list to store the element of the heap
	 * array list to store the priorities of the heap
	 * the size of the heap
	 * a comparator 
	 */
	private ArrayList<E> listE = new ArrayList<E>();
	private ArrayList<P> listP = new ArrayList<P>();
	private int size;
	private Comparator<P> conparator ;
	
	
	
	/*
	 * Heap constructor
	 */
	public Heap(Comparator<P> c) {
		
		conparator = c;		 
	}
	
	
	
	@Override
	public Comparator<? super P> comparator() 
	{

		return conparator;
	}
	
	
	/**
	 * find the size of the heap, the number of nodes in the heap
	 * @return how many heap nodes are in the current node
	 */
	@Override
	public int size() {
		
		return size;
	}
	
	
	
	/**
	 * return the element with the highest priority 
	 * and then remove it by replacing with the smallest priority element
	 * and finally sort it that satisfies the heap invariants
	 * @return the element that use to be the hgiest priority in the heap (the one that is removed)
	 */
	@Override
	public E poll() throws NoSuchElementException {

		//getting the highest priority element
		E temp = listE.get(0);
		
		//replacing the highest element with the lowest
		swapE(listE,0,size()-1);
		swapP(listP,0,size()-1);
		//remove the highest element
		listE.remove(size-1);
		listP.remove(size-1);
		//decrease heap size
		size--;
		
		//sort the heap that it satisfies the invariants of a heap
		this.moveDown(listP, 0);
		///return the element that use to be the highest priority
		return temp;
	}

	
	
	/**
	 * return the element of the highest priority
	 * @return returns the element with the highest priority in the heap
	 */
	@Override
	public E peek() throws NoSuchElementException {

		//return the element with the highest priority
		return listE.get(0);
	}

	
	
	/**
	 * add a node with element and priority value into the heap
	 * @param e the element value of the new heap node
	 * @param p the priority value of the new heap node
	 */
	@Override
	public void add(E e, P p) throws IllegalArgumentException {
		//adding the new element and its priority into the 
		//priority and element array list of the heap
		
		listE.add(e);
		listP.add(p);
		
		//if heap isn't null
		if(listP.size()!=1 && listE.size()!=1)
			this.moveUp(listP, listP.indexOf(p));//sort the collection that satisfies the heap invariants
		
		//increase size of the heap
		size++;
		
	}
	
	
	
	/**
	 * change the priority value of an element
	 * @param e the element that needs to change its priority
	 * @param p the priority value that e needs ot change to 
	 */
	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {

		//change the priority value in the priority array list
		int i = listE.indexOf(e);
		listP.set(i, p);
		
		//sort the collection until it satisfies the invariants of a heap
		moveDown(listP, listP.indexOf(p));
		moveUp(listP, listP.indexOf(p));
	}
	
	
	
	/**
	 * Returning the left-side sub-child of the heap node
	 * @param r the input node
	 * @return left-side sub-child of the input node, null for such element doesn't exist
	 */
	private P left(P r) {
		
		//getting the index of the input node
		int indexr = listP.indexOf(r);
		// the index to find the left child
		int leftIndex = (indexr*2)+1;
		
		//return left child if exits
		if(leftIndex <= (listP.size()-1))
			return listP.get((indexr*2)+1);
		
		return null;//return null if no left child available
	}
	
	
	
	/**
	 * Returning the right-side sub-child of the heap node
	 * @param r the input node
	 * @return right-side sub-child of the input node, null for such element doesn't exist
	 */
	private P right(P r) {
		
		//getting the index of the input node
		int indexr = listP.indexOf(r);
		// the index to find the left child
		int rightIndex = (indexr*2)+2;
		
		//return right child if exists
		if(rightIndex <= (listP.size()-1))
			return listP.get((indexr*2)+2);
		
		return null;//return null if right child not available
	}
	
	
	
	/**
	 * getting the parent of the input node
	 * @param r the input node to find its parent
	 * @return the parent of the input node, null if doesn't exist
	 */
	private P parent(P r) {
		
		//getting the index of the input node
		int indexr = listP.indexOf(r);
		System.out.println("the index is" + indexr);
		
		//getting the index of the parent if input node is on its parent's left side
		int headL = ((indexr-1)/2);
		System.out.println("headL"+headL);
		//getting the index of the parent if input node is on its parent's right side
		System.out.println(listP.get(0));
		int headR = ((indexr/2)-1);
		
		//return if parent exists
		if (indexr%2 == 0) {
			if(headR>=0) 
				return listP.get(headR);
			
		}else if(indexr%2 == 1) {
			if(headL>=0) {
				return listP.get(headL);
			}
		}
		
		return null;//null if no parent available
	}
	
	
	
	/**
	 * switching two nodes in its element array list
	 * @param h the array list to operate (element type)
	 * @param i	the index of one of the node to swap with
	 * @param j the index of the other node to swap with
	 */
	private void swapE(ArrayList<E> h, int i,int j) {
		
		E temp =  h.get(i);//median
		h.set(i, h.get(j));
		h.set(j, temp);
	}
	
	
	/**
	 * switching two nodes in its priority array list
	 * @param h the array list to operate (priority type)
	 * @param i	the index of one of the node to swap with
	 * @param j the index of the other node to swap with
	 */
	private void swapP(ArrayList<P> h, int i,int j) {
		
		P temp =  h.get(i);//median
		h.set(i, h.get(j));
		h.set(j, temp);
	}
	

	
	/**
	 * a recurssive sorting method that sort large priorities from bottom to up until it satisfies the heap invariant
	 * @param h the array list to operate with (priority type)
	 * @param i the given index of the node to sort with
	 */
	private void moveUp(ArrayList<P> h, int i) {
		
		// get the priority value by its index
		P value = listP.get(i);
		
		// swap with parent if parent exist
		if(listP.indexOf(parent(value))>=0) {
			
			if(this.comparator().compare(value, parent(value))>0) {
				
				int a = listP.indexOf(parent(value));
				int z = listP.indexOf(value);
				P conservV = listP.get(z);
				P conservP = listP.get(a);
				
				swapP(h, listP.indexOf(value), listP.indexOf(parent(value)));
				swapE(listE, z, a);
				System.out.println("Final"+listP.indexOf(value));
				moveUp(h, a);// keep on going until satisfy heap invariant				
			}
		}
	}
	
	
	
	/**
	 * a recursive sorting method that sort small priorities from up to bottom until it satisfies the heap invariant
	 * @param h the array list to operate with (priority type)
	 * @param i the given index of the node to sort with
	 */
	private void moveDown(ArrayList<P> h, int i) {
		
		//get value of the the index
		P value = listP.get(i);
		
		//swap with child if child exists
		if(listP.indexOf(left(value))<=(listP.size()-1)&&left(value)!=null) {
			
			if(this.comparator().compare(value, left(value))<0) {
				
				int a = listP.indexOf(left(value));
				int z = listP.indexOf(value);
				
				P conservV = listP.get(z);
				P conservP = listP.get(a);
				
				swapP(h, listP.indexOf(value), listP.indexOf(left(value)));
				swapE(listE, z, a);
				System.out.println("Final"+listP.indexOf(value));
				moveDown(h, a);// keep on going until satisfy heap invariant				
			}
		} else if(listP.indexOf(right(value))<= (listP.size()-1)&& right(value)!=null) {
			
			if(this.comparator().compare(value, right(value))<0) {
				
				int a = listP.indexOf(right(value));
				int z = listP.indexOf(value);
				
				P conservV = listP.get(z);
				P conservP = listP.get(a);
				
				swapP(h, listP.indexOf(value), listP.indexOf(right(value)));
				swapE(listE, z, a);
				System.out.println("Final"+listP.indexOf(value));
				moveDown(h, a);// keep on going until satisfy heap invariant				
			}
		}
	}

}