package practice;

public class Alpha_numeric_random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		String alph_numeric="dfkkf45";
		StringBuilder sb=new StringBuilder(n);
		
		
		for(int i=0;i<n;i++)
		{
			int index=(int)(alph_numeric.length()*Math.random());
			sb.append(alph_numeric.charAt(index));
		}
  System.out.println(sb);
	}

}
