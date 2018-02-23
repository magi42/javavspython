package fi.magi.javavspython.typing;

public class ReturnValueType {

/*
	public static int returnAValue() {
		return 21;
	}
*/
	// Change to this:

	static class ResultType {
		int val;
		String s;
		public ResultType(int val, String s) {
			this.val = val;
			this.s = s;
		}
	}

	public static ResultType returnAValue() {
		return new ResultType(21, "hello");
	}


	// This won't work after the change
/*
	public static int multiplyByTwo1() {
		return returnAValue() * 2;
	}
*/
	// Now have to use this:

	public static ResultType multiplyByTwo1() {
		ResultType result = returnAValue();
		return new ResultType(result.val * 2, result.s);
	}

	public static void main(String[] args) {
		System.out.print((int) multiplyByTwo1().val);
		System.out.print(" ");
		System.out.print((int) multiplyByTwo1().val);
		System.out.print("\n");
	}











































/*
	public static int multiplyByTwo2() {
		return returnAValue() * 2;
	}
	*/
}
