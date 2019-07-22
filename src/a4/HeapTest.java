package a4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

class HeapTest {

	@Test
	void test() {
		
		Comparator<Integer> c = null;
		
		ArrayList<String> s = new ArrayList<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		
		ArrayList<Integer> i = new ArrayList<Integer>();
		i.add(1);
		i.add(2);
		i.add(3);
		
		Heap<String, Integer> h = new Heap<String, Integer>(c);
		
		h.add("a", 1);
//		h.add("b", 2);
//		h.add("c", 3);
		
		System.out.println(h.size());
		
		
		
		
		
	}

}
