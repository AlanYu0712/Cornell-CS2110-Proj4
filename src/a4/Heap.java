package a4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E,P> implements PriorityQueue<E, P> {

	private ArrayList<E> listE= new ArrayList<E>();
	private ArrayList<P> listP=new ArrayList<P>();
	private int size;
	private Comparator<P> conparator ;
	
	public Heap(Comparator<P> c) {
			 conparator= c;
			 
	}
	@Override
	public Comparator<? super P> comparator() 
	{
		// TODO Auto-generated method stub
		return conparator;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		return size;
	}

	@Override
	public E poll() throws NoSuchElementException {
		// TODO Auto-generated method stub
		E temp= listE.get(0);
	
		swapE(listE,0,size()-1);
		swapP(listP,0,size()-1);
		listE.remove(size-1);
		listP.remove(size-1);
		size--;
		this.fixheap(listP, 0);
		///fix the array list so it is a heap agian
		return temp;
	}

	@Override
	public E peek() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return listE.get(0);
	}

	@Override
	public void add(E e, P p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
//		int sizeP = listP.size();
//		int sizeE = listE.size();
		listE.add(e);
		listP.add(p);
		if(listP.size()!=1 && listE.size()!=1)
			this.fixheap(listP, listP.indexOf(p));
		
		size++;
		
	}

	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {
		// TODO Auto-generated method stub
		int i=listE.indexOf(e);
		listP.set(i, p);
	}

	private P left(P r) {
		int indexr= listP.indexOf(r);
		int leftIndex = (indexr*2)+1;
		if(listP.get(leftIndex) !=null)
			return listP.get((indexr*2)+1);
		return null;
	}
	private P right(P r) {
	int indexr= listP.indexOf(r);
	int rightIndex = (indexr*2)+2;
	if(listP.get(rightIndex) != null)
		return listP.get((indexr*2)+2);
	return null;
	}
	
	private P parent(P r) {
		int indexr= listP.indexOf(r);
		System.out.println("the index is" + indexr);
		int headL = ((indexr-1)/2);
		System.out.println("headL"+headL);
		System.out.println(listP.get(0));
		int headR = ((indexr/2)-1);
		
		if (indexr%2 == 0) {
			if(listP.get(headR)!= null) 
				return listP.get(headR);
			
		}else if(indexr%2 == 1) {
			if(listP.get(headL)!= null) {
				return listP.get(headL);
			}
		}
		
		return null;
	}
	private void swapE(ArrayList<E> h, int i,int j) {
		
		E temp=  h.get(i);
		h.set(i, h.get(j));
		h.set(j, temp);
	}
	private void swapP(ArrayList<P> h, int i,int j) {
		
		P temp=  h.get(i);
		h.set(i, h.get(j));
		h.set(j, temp);
	}
	
	
//	private void fixheap(ArrayList<P> h, int i) {
//		System.out.println("the input is"+i);
//		P r= h.get(i);
//		P storageR = r;
//		
//		System.out.println(r);
//		System.out.println("parent: "+parent(r));
//		
//		
//		while(this.comparator().compare(r, this.left(r))<0||this.comparator().compare(r, this.right(r))<0||this.comparator().compare(r, this.parent(r))>0) {
//			if(this.comparator().compare(r, this.parent(r))>0) {
//				swapP(h,h.indexOf(r),h.indexOf(this.parent(r)));
//				swapE(listE,h.indexOf(r),h.indexOf(this.parent(r)));
//			}
//			else if(this.comparator().compare(r, this.left(r))<0||this.comparator().compare(r, this.right(r))<0) {
//				if(this.comparator().compare(this.right(r),this.left(r))>0) {
//					swapP(h,h.indexOf(r),h.indexOf(this.right(r)));
//					swapE(listE,h.indexOf(r),h.indexOf(this.right(r)));
//				}
//				else if(this.comparator().compare(this.right(r),this.left(r))<0) {
//					swapP(h,h.indexOf(r),h.indexOf(this.left(r)));
//					swapE(listE,h.indexOf(r),h.indexOf(this.left(r)));
//				}
//			}
//		}
//		
//		if(parent(r)!=null) {
//			
//			while(this.comparator().compare(r, parent(r)) > 0) {
//				int storage = h.indexOf(r);
//				int Parent_storage = h.indexOf(parent(r));
//				while(listP.indexOf(r)!= h.indexOf(parent(r))) {
//					swapP(h,h.indexOf(r),h.indexOf(parent(r)));
//					swapE(listE,storage,Parent_storage);
//				}
//			}
//		}
//			
//	}
	
	
	private void moveUp(ArrayList<P> h, int i) {
		P value = listP.get(i);
		if(this.comparator().compare(value, parent(value))>0) {
			int j = listP.indexOf(parent(value));
			h.set(, parent(value));
			moveUp(h, i);
		}
	}

}