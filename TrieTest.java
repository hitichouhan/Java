import java.io.*;
import java.util.*;
 
class HashTrie
{
    private HashMap<Character, HashMap> root;
 
    
    public HashTrie() 
    {
       root = new HashMap<Character, HashMap>();
    }
    
    public HashTrie(String[] arr) 
    {
        root = new HashMap<Character, HashMap>();
        for (String s: arr)
            add(s);
		  
			
		   
    }
 
  
    public void add(String str) 
    {
        HashMap<Character, HashMap> node = root;
        for (int i = 0; i < str.length(); i++)
        {
            if (node.containsKey(str.charAt(i)))
                node = node.get(str.charAt(i));
            else 
            {
                node.put(str.charAt(i), new HashMap<Character, HashMap>());
                node = node.get(str.charAt(i));
            }
       }

        node.put('\0', new HashMap<Character, HashMap>(0)); 
    }
 
    
    public boolean contains(String str) 
    {
        HashMap<Character, HashMap> currentNode = root;
        for (int i = 0; i < str.length(); i++)
        {
            if (currentNode.containsKey(str.charAt(i)))
                currentNode = currentNode.get(str.charAt(i));
            else 
                return false;
        }        
        return currentNode.containsKey('\0') ? true : false;            
    }
}
 

public class TrieTest
{
    public static void main(String[] args) throws IOException
    {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       
        System.out.println ("Enter words to be entered into trie");
        String a = br.readLine();
        String[] s = a.split(" ");
     
        HashTrie t = new HashTrie(s);
       
        char ch = 'n';
        do
        { 
            System.out.println("\nEnter word to search ");
            String key = br.readLine();
            System.out.println("Search status : "+ t.contains(key));
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = br.readLine().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');         
    }
}