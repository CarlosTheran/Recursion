
public class Fibonacci {

	public static void main (String[] args)
	{
		for(int i=30; i<500; i++) {

			long t1 = System.currentTimeMillis();
			long fR=fibR(i);
			long t2 = System.currentTimeMillis();
			System.out.println("FibonacciR(" +i+ ") =" + fR+" time: "+ (t2-t1));

			t1 = System.currentTimeMillis();
			long fI=fibI(i);
			t2 = System.currentTimeMillis();

			System.out.println("FibonacciI(" +i+ ") =" + fI+" time: "+ (t2-t1));
		}
	}

	public static long fibR(long n)
	{
		if(n == 0)
		{return 0;}
		if(n> 0  && n <= 2)
		{
			return 1;
		}

		return fibR(n-1) + fibR(n-2);
	}


	public static long fibI(long n)
	{

		long f0 = 0;
		long f1 = 1;
		long fn = 1;
		for(int i=2; i<=n;i++)
		{
			fn = f0 + f1;
			f0 = f1;
			f1 = fn;
		}

		if(n == 0)
			return f0;
		else
			return fn;
	}
}        
