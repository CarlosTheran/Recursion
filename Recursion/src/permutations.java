import java.util.ArrayList;

public class permutations {
	
	public static void main (String[] arg)
	{
			ArrayList<String> result = perms("Apple");
			
			int count = 0;
			for(String w: result)
			{
				System.out.println("word_" +count+":" + w);
				count++;
			}
	}
	
	public static ArrayList<String> perms(String word)
	{
		ArrayList<String> result = new ArrayList<String>(); 
	    if (word.length() == 1)
	    {
	    	result.add(word);
	    	return result;
	    }
	    
	    for(int i = 0; i<word.length() ;i++)
	    {
	    	String letter = word.substring(i,i+1);  //la letra i+1 no se incluye en letter
	    	String shoterWord = word.substring(0,i) + word.substring(i+1); //la letra en la pos i no esta incluida
	    	ArrayList<String> shoterPerms = perms(shoterWord);
	    	for(String w: shoterPerms)
	    	{
	    		result.add(letter + w);
	    	}
	    	
	    }
		
		return result;	
	}

}
