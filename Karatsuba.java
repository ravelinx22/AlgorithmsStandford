import java.math.BigInteger;

public class Karatsuba {
	public static BigInteger multiply(BigInteger x,BigInteger y) {
		if(x == BigInteger.ZERO || y == BigInteger.ZERO) {
			return BigInteger.ZERO;
		}
		else if(x == BigInteger.ONE) {
			return y;
		} else if(y == BigInteger.ONE) {
			return x;
		}

		int n = Math.max(x.toString().length(), y.toString().length());

		if(n <= 1) {
			return x.multiply(y);
		}

		BigInteger tenthPart = BigInteger.valueOf(10).pow(n);
		BigInteger tenthHalf = BigInteger.valueOf(10).pow(n/2);

		BigInteger a = x.divide(tenthHalf);
		BigInteger b = x.mod(tenthHalf);
		BigInteger c = y.divide(tenthHalf);
		BigInteger d = y.mod(tenthHalf);

		BigInteger ac = multiply(a,c);
		BigInteger middle = multiply(a.add(b),c.add(d));
		BigInteger bd = multiply(b,d);
		return (tenthPart.multiply(a.multiply(c))).add(tenthHalf.multiply(middle.subtract(a.multiply(c)).subtract(b.multiply(d)))).add(b.multiply(d));
	}

	public static void main(String args[]) {
		BigInteger x = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
		BigInteger y = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
		System.out.println(multiply(x,y));
	}
}
