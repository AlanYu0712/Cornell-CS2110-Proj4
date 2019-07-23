package a4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

class HeapTest {

	@Test
	void test() {
		
		//create comparator
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1>o2)
					return 1;
				else if(o1<o2)
					return -1;
				else {
					return 0;
				}
			}
		};
		
		
		//create an instance of string
		Heap<String, Integer> h = new Heap<String, Integer>(c);
		
		//testing add method in different situations
		System.out.println(h.size());
		h.add("a", 2);
		System.out.println(h.size());
		h.add("b", 1);		
		System.out.println("current size"+h.size());
		h.add("c", 3);
		System.out.println(h.size());		
		h.add("d", 5);
		
		//check the size method
		assertEquals(4, h.size());
		
		//check the pick method
		assertEquals("d", h.peek());
		
		//another scenario of the adding method
		h.add("e", 4);
		
		//checking is adding method validating
		assertEquals("d", h.peek());
		
		//checking the poll method
		assertEquals("d", h.poll());		
		assertEquals(4, h.size());
		assertEquals("e", h.peek());
		
		//checking the change priority method
		h.changePriority("c", 5);
		assertEquals("c", h.peek());	
	}

}
