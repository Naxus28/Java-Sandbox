import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		
		// stack has methods similar to arrays in javascript
		Stack<String> st = new Stack<>();
		st.push("bottom");
		st.push("middle");
		st.push("top");
		System.out.println("Stack: " + st);
		
		st.pop();
		System.out.println("Stack after pop: " + st);
		
		// check also isEmpty()
		if (st.empty()) {
			System.out.println("stack empty");
		} else {
			System.out.println("Not empty");
		}
		

	}

}
