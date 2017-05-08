import java.util.*;

public class Methods {
	private char[][] arr;
	private char comp, person;
	private String check = null;
	
	public Methods(char[][] not, char comp1, char person1){
		arr = not;
		comp = comp1;
		person = person1;
	}
	
	public String getCheck(){
		return check;
	}

	public String checkRow() {
		String str = "";
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				str += "" + arr[r][c];
			}
		}
		str = str.toLowerCase();
		if (str.indexOf("xxx") >= 0 || (str.charAt(0) == 'x' && str.charAt(4) == 'x' && str.charAt(8) == 'x')
				|| (str.charAt(2) == 'x' && str.charAt(4) == 'x' && str.charAt(6) == 'x')
				|| (str.charAt(0) == 'x' && str.charAt(3) == 'x' && str.charAt(6) == 'x')
				|| (str.charAt(1) == 'x' && str.charAt(4) == 'x' && str.charAt(7) == 'x')
				|| (str.charAt(2) == 'x' && str.charAt(5) == 'x' && str.charAt(8) == 'x')) {
			return "X player won";
		}
		if (str.indexOf("ooo") >= 0 || (str.charAt(0) == 'o' && str.charAt(4) == 'o' && str.charAt(8) == 'o')
				|| (str.charAt(2) == 'o' && str.charAt(4) == 'o' && str.charAt(6) == 'o')
				|| (str.charAt(0) == 'o' && str.charAt(3) == 'o' && str.charAt(6) == 'o')
				|| (str.charAt(1) == 'o' && str.charAt(4) == 'o' && str.charAt(7) == 'o')
				|| (str.charAt(2) == 'o' && str.charAt(5) == 'o' && str.charAt(8) == 'o')) {
			return "O player won";
		}
		if (str.indexOf(" ") == -1) {
			return "Tie";
		}
		return null;
	}

	// check to see if someone has won game the game. Uses if statements.
	public void printArr() {
		for (char[] x : arr) {
			for (char b : x) {
				String up = "" + b;
				up = up.toUpperCase();
				System.out.print(up + " | ");
			}
			System.out.println("");
		}
	}

	public void playGame() {
		double b = Math.random();

	}

	public void input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input row index: ");
		int r = input.nextInt();
		System.out.println("Input column index");
		int c = input.nextInt();
		arr[r][c] = person;
	}
	
	
	
}
