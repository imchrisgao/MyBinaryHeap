package mybinaryheap;

/*import java.util.Arrays;
import java.util.Random;*/

public class MyBinaryHeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBinaryHeap mbh = new MyBinaryHeap(100);
		
		/*Random r = new Random();
		for(int i=1; i<15; i++){
			mbh.insert(r.nextInt());
		}*/
		
		for(int i=14; i>0; i--){
			mbh.insert(i);
		}
		
		mbh.printTree();
		mbh.delete(4);
		mbh.printTree();
	}

}
