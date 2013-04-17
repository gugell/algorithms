import java.util.*;

public class MyQueue {
        public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.queue(1);
		q.queue(2);
		q.queue(3);

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		for (int i = 4; i < 10; i++) {
			q.queue(i);
		}

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
        }

        Stack<Integer> push = new Stack<Integer>();
        Stack<Integer> pop = new Stack<Integer>();

        public void queue(int i) {
                push.push(i);
        }

        public int dequeue() {
                if (pop.isEmpty() && push.isEmpty()) {
                        throw new EmptyStackException();
                }

                if (pop.isEmpty() == true) {
                        while (push.isEmpty() == false) {
                                int i = push.pop();
                                pop.push(i);
                        }
                }

                return pop.pop();
        }
}

