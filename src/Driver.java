
public class Driver {
	public static void main(String[] args) {
		char x = 'x';
		char o = 'o';
		char e = ' ';
		int xoro = (int) (Math.random() * 100);
		char[][] foshow = { { e, e, e }, { e, e, e }, { e, e, e } };
		for (char[] t : foshow) {
			for (char b : t) {
				String up = "" + b;
				up = up.toUpperCase();
				System.out.print(up + " | ");
			}
			System.out.println("");
		}
		Methods m;
		if (xoro > 50) {
			char[][] bobo = { { e, e, e }, { e, e, e }, { e, e, e } };
			m = new Methods(bobo, x, o);
			m.playFirstMove();
		} else {
			char[][] bobo = { { e, e, e }, { e, e, e }, { e, e, e } };
			m = new Methods(bobo, o, x);			
		}
		
	}
}
