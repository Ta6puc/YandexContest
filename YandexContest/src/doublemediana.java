import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class doublemediana {

	public static void main(String[] args) {
		int count = 0;
		String doubles = null;
		try {
			File input = new File("input.txt");
			FileReader fr = new FileReader(input);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			int l = 0;
			while (line != null) {
				if (l == 0) {
					count = Integer.parseInt(line);

				} else {
					doubles = line;
				}
				l++;
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(mediana(count, doubles));

	}

	private static String mediana(int count, String doubles) {
		String result = "-1";
		int c0 = 0;
		int c1 = 0;
		if (doubles.charAt(0) == '0')
			c0 = 1;
		else
			c1 = 1;
		for (int i = 1; i < count; i++) {
			if (doubles.charAt(i) == '0')
				c0++;
			else
				c1++;
			if (doubles.charAt(i) == '0' && c0 > c1)
				result += " 1";
			else if (doubles.charAt(i) == '1' && c1 > c0)
				result += " 1";
			else if (i == 1 && c1 == c0)
				result += " -1";
			else
				for (int j = 0; j <= i - 1; j++) {
					int cs0 = 0;
					int cs1 = 0;
					String subline = doubles.substring(j, i + 1);
					for (int k = 0; k < subline.length(); k++) {
						if (subline.charAt(k) == '0')
							cs0++;
						else
							cs1++;
					}
					if (doubles.charAt(i) == '0' && cs0 > cs1) {
						result += " " + (j + 1);
						break;
					} else if (doubles.charAt(i) == '1' && cs1 > cs0) {
						result += " " + (j + 1);
						break;
					}
					if (j + 2 == i)
						result += " -1";
				}
		}
		return result;
	}
}
