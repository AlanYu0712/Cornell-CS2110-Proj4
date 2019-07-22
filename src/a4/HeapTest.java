package a4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

class HeapTest {

	@Test
	void test() {
		
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
		
		
		Heap<String, Integer> h = new Heap<String, Integer>(c);
		
		System.out.println(h.size());
		h.add("a", 3);
		System.out.println(h.size());
		h.add("b", 2);
		
		System.out.println("current size"+h.size());
		h.add("c", 4);
		System.out.println(h.size());
		
		h.add("d", 5);
		
		assertEquals(4, h.size());
		
//		assertEquals("d", h.peek());
		
//		assertEquals("a", h.poll());
//		
//		assertEquals(2, h.size());
//		
//		
//		assertEquals("b", h.peek());
//		
//		
//		h.changePriority("c", 5);
//		assertEquals("c", h.peek());
		
		
		
		
		
		
	}

}
