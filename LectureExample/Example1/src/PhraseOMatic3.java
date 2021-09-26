public class PhraseOMatic3 {
	public static void main(String[] args) {
		String[] girls = {"Amanda", "Jessica", "Chrissie"};
		String[] verbs = {"loves", "hates"};
		String[] boys = {"Andy", "Aaron", "Eason", "Jacky"};

		for (String girl : girls) { // for each string in girls[]
			int j = (int) (Math.random() * verbs.length);
			int k = (int) (Math.random() * boys.length);
			System.out.println(girl + " " + verbs[j] + " " + boys[k]);
		}
	}
}
