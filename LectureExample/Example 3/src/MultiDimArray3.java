public class MultiDimArray3 {
	public static void main(String[] args) {
		String[][] names = new String[2][];
		String[] titles = {"Mr. ", "Mrs. ", "Ms. "};
		String[] surnames = {"Smith", "Jones"}; 
		names[0] = titles;
		names[1] = surnames;
		System.out.println(names[0][0] + names[1][0]);
		System.out.println(names[0][2] + names[1][1]);
	}
}
