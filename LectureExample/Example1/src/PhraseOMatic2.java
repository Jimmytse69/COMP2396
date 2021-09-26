public class PhraseOMatic2 {
	public static void main(String[] args) {
		String[] girls = {"Amanda", "Jessica", "Chrissie"};
		String[] verbs = {"loves", "hates"};
		String[] boys = {"Andy", "Aaron", "Eason", "Jacky"};

		for (int i = 0; i < girls.length; i++) {
			int j = (int) (Math.random() * verbs.length);
			int k = (int) (Math.random() * boys.length);
			System.out.println(girls[i] + " " + verbs[j] + " " + boys[k]);
		}
	}
}
