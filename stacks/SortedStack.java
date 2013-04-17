import java.util.*;

public class SortedStack {
        public static void main(String[] args) {
                SortedStack ss = new SortedStack();

                ss.push(1);
                ss.push(3);
                ss.push(4);
                ss.push(2);
		ss.push(7);
		ss.push(10);
		ss.push(8);
		ss.push(5);
		ss.push(6);
		ss.push(9);

                for (int i = 0; i < 10; i++) {
                        System.out.println(ss.pop());
                }
        }

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        public int pop() {
                return s1.pop();
        }

        public void push(int i) {
                if (s1.isEmpty()) {
                        s1.push(i);
                } else {
                        while (i < s1.peek()) {
                                int j = s1.pop();
                                s2.push(j);
                        }
                        s1.push(i);
                        while (s2.isEmpty() == false) {
                                s1.push(s2.pop());
                        }
                }
        }
}

