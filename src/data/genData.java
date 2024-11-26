package data;

import java.util.Random;

public class genData {
	public String randomId(int j) {
		Random r = new Random();
			String result="";
			for (int i=0; i<j ;i++)
			{
				result+=r.nextInt(10);
			}
			return result;
	}
}
