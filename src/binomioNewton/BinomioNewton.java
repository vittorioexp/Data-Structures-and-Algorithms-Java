import java.util.Scanner;
import java.math.BigInteger;

public class BinomioNewton 
{
	public static void main(String[] args) 
	{
		BigInteger a,b,n,k,res;
		Scanner in = new Scanner(System.in);
		
		System.out.print("a=");
		a = in.nextBigInteger();
		
		System.out.print("b=");
		b = in.nextBigInteger();
		
		System.out.print("n=");
		n = in.nextBigInteger();
		
		res = BigInteger.ZERO;
		
		for (k=BigInteger.ZERO; k.compareTo(n)<=0; k=k.add(BigInteger.ONE)) {
			res = res.add((fattoriale(n).divide((fattoriale(k).multiply(fattoriale(n.subtract(k)))))).multiply(potenza(a, n.subtract(k)).multiply(potenza(b, k))));
		}
		System.out.println("(" + a + " + " + b + ")^" + n + " = " + res);
		
		//System.out.println(potenza(a.add(b),n));
	}
	public static BigInteger fattoriale(BigInteger num)  
	{
		BigInteger u;
		BigInteger res = BigInteger.ONE;
		for (u=BigInteger.ONE; u.compareTo(num)<=0; u=u.add(BigInteger.ONE)) {
			res = res.multiply(u);
		}
		return res;
	}
	public static BigInteger potenza(BigInteger base, BigInteger esp)
	{
		BigInteger j;
		BigInteger res = BigInteger.ONE;
		for (j=BigInteger.ZERO; j.compareTo(esp)<0; j=j.add(BigInteger.ONE))
		{
			res = res.multiply(base);
		}
		return res;
	}
}

