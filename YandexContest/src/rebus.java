import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class rebus {

	public rebus() {
	}

	public static void main(String[] args) {
		char letters[] = new char[27];
		for (int i = 0; i < letters.length - 1; i++)
			letters[i] = (char) ('a' + i);
		letters[26] = ' ';
		int w = 0;
		int count = 0;
		String code = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			count = Integer.parseInt(reader.readLine());
			code = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String codedLetters[] = code.split(" ");
		String result = "";
		for (int i = 0; i < count; i++) {
			result += letters[invert(w, Integer.parseInt(codedLetters[i]))];
			w = Integer.parseInt(codedLetters[i]);
		}

		System.out.println(result);
	}

	private static int invert(int w, int newW) {
		String wBinary = String.format("%27s", Integer.toBinaryString(w)).replace(' ', '0');
		String newWBinary = String.format("%27s", Integer.toBinaryString(newW)).replace(' ', '0');
		int register = 0;
		for (int i = 0; i < newWBinary.length(); i++) {
			if (wBinary.charAt(i) != newWBinary.charAt(i)) {
				register = 26 - i;
				break;

			}
		}
		return register;
	}

}
