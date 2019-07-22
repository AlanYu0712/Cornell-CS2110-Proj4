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
	public Comparator<? super P> comparator() {
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
		int sizeP = listP.size();
		int sizeE = listE.size();
		
		listE.add(e);
		listP.add(p);
		if(sizeP != 0 && sizeE != 0)
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
		
		return listP.get(indexr*2+1);
	}
	private P right(P r) {
	int indexr= listP.indexOf(r);
		return listP.get(indexr*2+2);
	}
	private P parent(P r) {
	int indexr= listP.indexOf(r);
	if (indexr ==0) {
	if(indexr%2==0) {
		return listP.get(indexr/2-2);
	}
	else {
		return listP.get(indexr/2-1);
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
	private void fixheap(ArrayList<P> h, int i) {
		P r= h.get(i);
		while(this.comparator().compare(r, this.left(r))<0||this.comparator().compare(r, this.right(r))<0||this.comparator().compare(r, this.parent(r))>0) {
			if(this.comparator().compare(r, this.parent(r))>0) {
				swapP(h,h.indexOf(r),h.indexOf(this.parent(r)));
				swapE(listE,h.indexOf(r),h.indexOf(this.parent(r)));
			}
			else if(this.comparator().compare(r, this.left(r))<0||this.comparator().compare(r, this.right(r))<0) {
				if(this.comparator().compare(this.right(r),this.left(r))>0) {
					swapP(h,h.indexOf(r),h.indexOf(this.right(r)));
					swapE(listE,h.indexOf(r),h.indexOf(this.right(r)));
				}
				else if(this.comparator().compare(this.right(r),this.left(r))<0) {
					swapP(h,h.indexOf(r),h.indexOf(this.left(r)));
					swapE(listE,h.indexOf(r),h.indexOf(this.left(r)));
				}
			}
		}
	}

}