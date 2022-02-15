import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class homework {

	public homework() {
	}

	public static void main(String[] args) {
		int count = 0;
		String tasks[] = null;
		try {
			File input = new File("input.txt");
			FileReader fr = new FileReader(input);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			int l = 0;
			while (line != null) {
				if (l == 0) {
					count = Integer.parseInt(line);
					tasks = new String[count];
				} else {
					tasks[l - 1] = line;
				}
				l++;
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long x = 0;
		long y = 0;
		for (int i = 0; i < tasks.length; i++) {
			x = Long.parseLong(tasks[i].split(" ")[0]);
			y = Long.parseLong(tasks[i].split(" ")[1]);
			System.out.println(getGCD(x, y));
		}
	}

	private static long getGCD(long x, long y) {
		BigInteger min = new BigInteger(""+Math.min(x, y));
		BigInteger max = new BigInteger(""+Math.max(x, y));
		BigInteger p = new BigInteger("" + 0);
		BigInteger gcd = new BigInteger("" + 0);
		while (p.longValue() <= max.divide(max.gcd(min)).longValue()) {
			p = p.nextProbablePrime();
			gcd = gcd.max(max.gcd(min.multiply(p)));
		}
		return gcd.longValue();
	}

}
