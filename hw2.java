import java.util.concurrent.ArrayBlockingQueue;

public class hw2 {


	private static ArrayBlockingQueue<String>Merge(ArrayBlockingQueue<String> a, ArrayBlockingQueue<String> b){

		ArrayBlockingQueue<String> c = new ArrayBlockingQueue<String>(a.size() + b.size());

		while (a.size()!=0 && b.size()!=0){
			if (a.peek().compareTo(b.peek())<0){
				c.add(a.peek());
				a.poll();
			}
			else if (a.peek().compareTo(b.peek())>0){
				c.add(b.peek());
				b.poll();
			}
			else{
				c.add(a.peek());
				a.poll();

			}
		}
		if (a.size()>0||b.size()>0){
			while (a.size()!=0){
				c.add(a.peek());
				a.poll();
			}

			while (b.size()!=0){
				c.add(b.peek());
				b.poll();
			}

		}

		return c;

	}


	public static void MergeSort(ArrayBlockingQueue<String> a){

		if( a.size()>1){
			int s = a.size();
			ArrayBlockingQueue<String> total = new ArrayBlockingQueue<String>(s);
			ArrayBlockingQueue<String> start = new ArrayBlockingQueue<String>((s/2));
			ArrayBlockingQueue<String> end = new ArrayBlockingQueue<String>(s-(s/2));
			int t = (s-(s/2));

			while (a.size()!= t){
				start.add(a.poll());
			}

			while (a.size()!= 0){
				end.add(a.poll());
			}


			MergeSort(start);

			MergeSort(end);

			total = Merge(start,end);
			System.out.println(total);
			
			while (total.size() != 0){
				a.add(total.poll());
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBlockingQueue<String> r1 = new ArrayBlockingQueue<String>(5);
		ArrayBlockingQueue<String> r2 = new ArrayBlockingQueue<String>(8);
		/*
		r1.add("a");
		r1.add("d");
		r1.add("e");
		 */
		r2.add("a");
		r2.add("n");
			r2.add("i");

		r2.add("d");
		r2.add("e");

	//	r2.add("r");
		/*
		System.out.println("a = "+r1);
		System.out.println("b = "+r2);
		System.out.println("Ans = "+Merge(r1,r2));
		 */
		MergeSort(r2);
	}

}
