package testers;

import indexList.LLIndexList;
import linkedLists.DLDHDTList;
import linkedLists.SLList;

public class testArray {
	public static void main(String[]args) {
		LLIndexList<Integer> x = new LLIndexList<Integer>(new SLList<Integer>());
		x.add(0, 1);
		x.add(4);
		Object[] y = x.toArray();
		System.out.println(y[1]);
	}

}
