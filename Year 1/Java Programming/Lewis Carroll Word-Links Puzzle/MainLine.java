import java.io.*;
import java.util.*;

public class MainLine {
	
	public static ArrayList<String> ENGISH_WORDS = readDictionary();

	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Lewis Carroll Word-Links Puzzle.");
		Scanner input = new Scanner (System.in);
		boolean finished = false;
		while (!finished)
		{
			System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
			String stringOfWords = input.nextLine();
			if (stringOfWords.equals(""))
			{
				finished = true;
			}
			else
			{
				ArrayList<String> listOfWords = readWordList(stringOfWords);
				System.out.println(isWordChain(listOfWords)? "Valid chain of words from Lewis Carroll's word-links game." :
					"Not a valid chain of words from Lewis Carroll's word-links game.");
			}
		}
		input.close();
	}

	public static ArrayList<String> readDictionary()
	{
    	ArrayList<String> words = new ArrayList<String>();
    	try
    	{
    		FileReader fileReader = new FileReader("words.txt");
    		BufferedReader bufferedReader = new BufferedReader(fileReader);  
    		boolean endOfFile = false;

    		while(!endOfFile)
    		{
                String wordLine = bufferedReader.readLine();
                if (wordLine != null)
                {
                	words.add(wordLine);
                }
                else
                {
                	endOfFile = true;
                }
    		}
    		bufferedReader.close();    
	        fileReader.close();
        }

    	catch (FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    	
    	return words;
	}
	
	public static ArrayList<String> readWordList (String wordList)
	{		
		ArrayList<String> listOfWords= new ArrayList<String>(Arrays.asList(wordList.split("\\s*" + "," + "\\s*")));
		return listOfWords;
	}
	
	public static boolean isUniqueList ( ArrayList<String> listOfWords )
	{
		for(int i=0;i<listOfWords.size();i++)
		{
			for(int j=i+1;j<listOfWords.size();j++)
			{
				if (listOfWords.get(i)==listOfWords.get(j))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isEnglishWord (String word)
	{
		int position = Collections.binarySearch(ENGISH_WORDS, word);
		if (position>0)
		{
			return true;
		}
		return false;
	}
	
	public static boolean isDifferentByOne ( String word1, String word2 )
	{
		int count = 0;
		if (!(word1.length()==word1.length()))
			{
				return false;
			}
        ArrayList<String> arrayWord1 = new ArrayList<String>();
        for(int i=0;i<word1.length();i++)
        {
        	arrayWord1.add(String.valueOf(word1.charAt(i)));
        }
        ArrayList<String> arrayWord2 = new ArrayList<String>();
        for(int i=0;i<word2.length();i++)
        {
        	arrayWord2.add(String.valueOf(word2.charAt(i)));
        }        
        for(int i=0; i<word1.length(); i++)
        {
        	if (!(arrayWord1.get(i).contains(arrayWord2.get(i))))
        	{
        		count++;
        	}
        }
        if (count==1)
        {
        	return true;
        }
        else
        {
        	return false;
        }
	}
	
	public static boolean isWordChain ( ArrayList<String> words )
	{
		if (isUniqueList(words))
		{
			for (int i=0; i<words.size(); i++)
			{
				if (isEnglishWord(words.get(i)))
				{
					if(i+1<words.size())
					{
						if (isDifferentByOne(words.get(i), words.get(i+1)))
						{
						}
						else
						{
							return false;
						}
					}
				}
				else
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
		return true;
	}
}

/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes I do
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: Yes it does
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: Yes it does

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes I do
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: Yes it does

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes I do
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: Yes it does
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: Yes it does
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: Yes it does

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes I do
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: Yes it does
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: Yes it does

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes I do
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: Yes it does

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes I do
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: Yes it does

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: Yes it does
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Yes it does

 Total Mark out of 100 (Add all the previous marks):100
*/
