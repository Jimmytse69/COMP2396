public class PhraseOMatic {
	public static void main(String[] args) {
		String[] girls = {"Amanda", "Jessica", "Chrissie"};
		String[] verbs = {"loves", "hates"};
		String[] boys = {"Andy", "Aaron", "Eason", "Jacky"};

		int i = (int) (Math.random() * girls.length);
		int j = (int) (Math.random() * verbs.length);
		int k = (int) (Math.random() * boys.length);

		System.out.print(girls[i] + " " + verbs[j] + " " + boys[k]);
	}
}
