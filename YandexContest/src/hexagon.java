import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class hexagon {

	public hexagon() {
	}

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		String lines[] = null;
		try {
			File input = new File("input.txt");
			FileReader fr = new FileReader(input);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			int l = 0;
			while (line != null) {
				if (l == 0) {
					y = Integer.parseInt(line.split(" ")[0]);
					x = Integer.parseInt(line.split(" ")[1]);
					lines = new String[y];
				} else {
					lines[l - 1] = line;
				}
				l++;
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mirrorVertical(x, y, lines);
		
		mirrorHorizontal(x, y, lines);
		
		repair(x, y, lines);

		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
	}

	private static String[] repair(int x, int y, String[] lines) {
		for (int i = y-1; i >=0; i--) {
			for (int j = x - 1; j >= 0; j--) {
				if (lines[i].charAt(j) == '/') {
					lines[i+1] = lines[i+1].substring(0, j)+"/"+lines[i+1].substring(j+1, x);
					lines[i] = lines[i].substring(0, j)+"."+lines[i].substring(j+1, x);
				}

				if (lines[i].charAt(j) == '\\') {
					lines[i+1] = lines[i+1].substring(0, j)+"\\"+lines[i+1].substring(j+1, x);
					lines[i] = lines[i].substring(0, j)+"."+lines[i].substring(j+1, x);
				}
			}
		}
		return lines;

	}

	private static String[] mirrorVertical(int x, int y, String[] lines) {
		for (int i = 0; i < (y / 2); i++) {
			String line = lines[i];
			lines[i] = lines[(y - 1) - i];
			lines[(y - 1) - i] = line;
		}
		return lines;

	}

	private static String[] mirrorHorizontal(int x, int y, String[] lines) {
		for (int i = 0; i < y; i++) {
			String line = "";
			for (int j = x - 1; j >= 0; j--) {
				line += lines[i].charAt(j);
			}
			lines[i] = line;
		}
		return lines;

	}

}
