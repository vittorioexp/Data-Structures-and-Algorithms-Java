public class Esercizio09_2 {
	public static void main(String[] args) {
		if (args.length!=2) {
			System.out.println("Inserire due argomenti su riga di comando");
			System.exit(1);
		}
		if (args[0].charAt(0)=='-' || args[1].charAt(0)=='-') {
			System.out.println("Inserire due interi positivi su riga di comando");
			System.exit(1);
		}
		Stack one = new ArrayStack();
		Stack two = new ArrayStack();
		Stack result = new ArrayStack();
		try {
			one = newNumber(one, args[0]);
			two = newNumber(two, args[1]);
		
			result = sum(one, two);
			System.out.println("Stampa del risultato a partire dalle cifre piu significative: ");
			result = reverse(result);
			while (!result.isEmpty()) {
				System.out.print(result.pop());
			}
			} catch (NumberFormatException e) {
				System.out.println("Not a number");
				System.exit(1);
		}	
	}
	private static Stack newNumber(Stack stack, String str) {
		for (int i=0; i<str.length(); i++) {
			Integer num = Integer.parseInt(str.substring(i, i+1));
			System.out.print(num);
			stack.push(num);
		}
		System.out.println();
		return stack;
	}
	private static Stack reverse(Stack stack) {
		Stack s = new ArrayStack();
		while (!stack.isEmpty()) {
			s.push(stack.pop());
		}
		return s;
	}
	public static Stack sum(Stack one, Stack two) {
		
		int carry=0;
		Stack res = new ArrayStack();
		
		while (!one.isEmpty() || !two.isEmpty() || carry>0) {
			
			Integer num1=0, num2=0, num3=0;
			
			if (one.isEmpty()) {
				num1=0;
			} else {
				num1=(Integer) one.pop();
			}
			
			if (two.isEmpty()) {
				num2=0;
			} else {
				num2 =(Integer) two.pop();
			}
			
			num3 = num1+num2;
			
			if (carry>0) {
				num3+=carry;
				carry=0;
			}
			if (num3>=10) {
				num3=num3-10;
				carry++;
			}
			
			res.push(num3);
			
			
		}
		
		return reverse(res);
	}	
}