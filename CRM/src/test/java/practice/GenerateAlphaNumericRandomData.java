package practice;

public class GenerateAlphaNumericRandomData {
public static void main(String[] args) {
	int n=20;
	
	String AlphaNumericString ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	
	StringBuilder sb = new StringBuilder();
	
	for(int i=0;i<n;i++) {
		int index = (int) (AlphaNumericString.length()*Math.random());
		sb.append(AlphaNumericString.charAt(index));
	}
	System.out.println(sb);
}
}
