public class WrapperClassesExample {
	public static void main(String[] args) {
		boolean b = true;
		Boolean bWrap = new Boolean(b);

		char c = 'K';
		Character cWrap = new Character(c);
		
		int i = 288;
		Integer iWrap = new Integer(i);

		double d = 1.234567;
		Double dWrap = new Double(d);

		boolean bUnWrap = bWrap.booleanValue();
		System.out.println("bUnWrap = " + bUnWrap);
		
		char cUnWrap = cWrap.charValue();
		System.out.println("cUnWrap = '" + cUnWrap + "'");
		
		int iUnWrap = iWrap.intValue();
		System.out.println("bUnWrap = " + iUnWrap);
		
		double dUnWrap = dWrap.doubleValue();
		System.out.println("bUnWrap = " + dUnWrap);	
	}
}
