import java.util.*;

public class Methods {
	private char[][] arr;
	private char comp, person;
	private String check = null;
	private int played = 0;
	// information hiding

	public Methods(char[][] not, char comp1, char person1) {
		arr = not;
		comp = comp1;
		person = person1;
	}

	// constructor for the board that initializes the char array and the 2 char
	// variables.

	public String getCheck() {
		return check;
	}

	// return check will be used in while loop for the main class to see if
	// someone has won the game yet

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

	// prints the tic tac toe board using 2 for each loops

	public void playFirstMove() {
		ArrayList<int[]> rands = new ArrayList<int[]>();
		rands.add(new int[] {0,0});
		rands.add(new int[] {2,0});
		rands.add(new int[] {0,2});
		rands.add(new int[] {2,2});
		if (played == 0) {
			int b = (int) (Math.random()*4);
			arr[rands.get(b)[0]][rands.get(b)[1]] = comp;
			played++;
		}else if (played == 1){
			boolean corner = false;
			for(char [] r : arr){
				for(char c : r){
					if(c  != ' '){
						corner = true;
					}
				}
			}
			if(corner == true){
				arr[1][1] = comp;
			}else{
				int b = (int) (Math.random()*4);
				arr[rands.get(b)[0]][rands.get(b)[1]] = comp;
				played++;
			}
		}
	}

	//logic for the first move
	
	public void play(){
		String str = toString();
		boolean winnable = canWin();
			if(winnable == true){
				letsWin();
			}
		boolean tie = checkTwo();
		
	}
	
	public boolean checkTwo(){
		String str = toString();
		if((str.charAt(6) == person && str.charAt(7) == person && str.charAt(8) == ' ') || (str.charAt(6) == person && str.charAt(8) == person && str.charAt(7) == ' ') || (str.charAt(7) == person && str.charAt(8) == person && str.charAt(6) == ' ')) {
			return true;
		} // for one row
		if((str.charAt(3) == person && str.charAt(4) == person && str.charAt(5) == ' ') || (str.charAt(3) == person && str.charAt(5) == person && str.charAt(4) == ' ') || (str.charAt(4) == person && str.charAt(5) == person && str.charAt(3) == ' ')) {
			return true;
		}
		if((str.charAt(6) == person && str.charAt(4) == person && str.charAt(2) == ' ') || (str.charAt(6) == person && str.charAt(2) == person && str.charAt(4) == ' ') || (str.charAt(4) == person && str.charAt(2) == person && str.charAt(6) == ' ')) {
			return true;
		}
		if((str.charAt(0) == person && str.charAt(4) == person && str.charAt(8) == ' ') || (str.charAt(4) == person && str.charAt(8) == person && str.charAt(0) == ' ') || (str.charAt(8) == person && str.charAt(0) == person && str.charAt(4) == ' ')) {
			return true;
		}
		if((str.charAt(0) == person && str.charAt(1) == person && str.charAt(2) == ' ') || (str.charAt(1) == person && str.charAt(2) == person && str.charAt(0) == ' ') || (str.charAt(0) == person && str.charAt(2) == person && str.charAt(1) == ' ')) {
			return true;
		}
		return false;
	}
	
	public boolean canWin(){
		String str = toString();
		if((str.charAt(6) == comp && str.charAt(7) == comp && str.charAt(8) == ' ') || (str.charAt(6) == comp && str.charAt(8) == comp && str.charAt(7) == ' ') || (str.charAt(7) == comp && str.charAt(8) == comp && str.charAt(6) == ' ')) {
			return true;
		} // for one row
		if((str.charAt(3) == comp && str.charAt(4) == comp && str.charAt(5) == ' ') || (str.charAt(3) == comp && str.charAt(5) == comp && str.charAt(4) == ' ') || (str.charAt(4) == comp && str.charAt(5) == comp && str.charAt(3) == ' ')) {
			return true;
		}
		if((str.charAt(6) == comp && str.charAt(4) == comp && str.charAt(2) == ' ') || (str.charAt(6) == comp && str.charAt(2) == comp && str.charAt(4) == ' ') || (str.charAt(4) == comp && str.charAt(2) == comp && str.charAt(6) == ' ')) {
			return true;
		}
		if((str.charAt(0) == comp && str.charAt(4) == comp && str.charAt(8) == ' ') || (str.charAt(4) == comp && str.charAt(8) == comp && str.charAt(0) == ' ') || (str.charAt(8) == comp && str.charAt(0) == comp && str.charAt(4) == ' ')) {
			return true;
		}
		if((str.charAt(0) == comp && str.charAt(1) == comp && str.charAt(2) == ' ') || (str.charAt(1) == comp && str.charAt(2) == comp && str.charAt(0) == ' ') || (str.charAt(0) == comp && str.charAt(2) == comp && str.charAt(1) == ' ')) {
			return true;
		}	
		return false;
	}
	
	public void letsWin(){
		String str = toString();
		if(winHelp(0, 1 ,2, str)) 
			winHelp(0, 1 ,2, str);
		else if(winHelp(3, 4 , 5, str)){
			winHelp(3, 4 , 5, str);
		}
		else if(winHelp(6, 7, 8, str)){
			winHelp(6, 7, 8, str);
		}
		else if(winHelp(6, 4, 2, str)){
			winHelp(6, 4, 2, str);
		}
		else if(winHelp(0, 4, 8, str)){
			winHelp(0, 4, 8, str);
		}
	}
	
	public void toArr(String str){
		int d = 0;
		for(int i = 0; i < arr.length; i++){
			for(int c = 0; c < arr[i].length; c++){
				arr[i][c] = str.charAt(d);
				d++;
			}
		}
	}
	
	public boolean winHelp(int i, int c, int d, String str){
		if(str.charAt(i) == ' ' && str.charAt(c) == comp && str.charAt(d) == comp){
			str = str.substring(0, i) + comp + str.substring(i+1);
			toArr(str);
			return true;
		}
		if(str.charAt(c) == ' ' && str.charAt(i) == comp && str.charAt(d) == comp){
			str = str.substring(0, c) + comp + str.substring(c+1);
			toArr(str);
			return true;
		}
		if(str.charAt(d) == ' ' && str.charAt(c) == comp && str.charAt(i) == comp){
			str = str.substring(0, d) + comp + str.substring(d+1);
			toArr(str);
			return true;
		}
			
		return false;
	}
	
	public void input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input row index: ");
		int r = input.nextInt();
		System.out.println("Input column index");
		int c = input.nextInt();
		if(arr[r][c] == ' '){
		arr[r][c] = person;
		played++;
		}else{
			System.out.println("Please enter another index:");
			input();
		}
	}
	
	// takes in user input
	
	public String toString(){
		String str = "";
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				str += "" + arr[r][c];
			}
		}
		return str;
	}

}
