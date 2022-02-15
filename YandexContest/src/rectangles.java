import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class rectangles {

	public rectangles() {

	}

	public static void main(String[] args) {
		int count = 0;
		String rect[] = null;
		try {
			File input = new File("input.txt");
			FileReader fr = new FileReader(input);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			int l = 0;
			while (line != null) {
				if (l == 0) {
					count = Integer.parseInt(line);
					rect = new String[count];
				} else {
					rect[l - 1] = line;
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

		for (int i = 0; i < count; i++) {
			System.out.println(getIntersections(i, count, rect));
		}
	}

	private static int getIntersections(int i, int count, String[] rect) {
		int result = 0;
		int xl1, yl1, xr1, yr1;
		String coords[] = rect[i].split(" ");
		xl1 = Integer.parseInt(coords[0]);
		yl1 = Integer.parseInt(coords[1]);
		xr1 = Integer.parseInt(coords[2]);
		yr1 = Integer.parseInt(coords[3]);
		int xl2, yl2, xr2, yr2;
		for (int j = 0; j < rect.length; j++) {
			if (j == i)
				continue;
			coords = rect[j].split(" ");

			xl2 = Integer.parseInt(coords[0]);
			yl2 = Integer.parseInt(coords[1]);
			xr2 = Integer.parseInt(coords[2]);
			yr2 = Integer.parseInt(coords[3]);

			if ((xl1 > xl2 && yl1 > yl2 || xl1 > xr2 && yl1 > yr2) 
					&& (xr1 < xl2 && yr1 < yl2 || xr1 < xr2 && yr1 < yr2)
					|| (xl1 < xl2 && yl1 < yl2 || xl1 < xr2 && yl1 < yr2)
					&& (xr1 > xl2 && yr1 > yl2 || xr1 > xr2 && yr1 > yr2)) {
				result++;
			}
		}
		return result;

	}

}
