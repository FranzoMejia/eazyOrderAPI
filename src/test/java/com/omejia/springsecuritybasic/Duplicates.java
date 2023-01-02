package com.omejia.springsecuritybasic;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;





class Tree { } 
class Pine extends Tree { } 
class Oak extends Tree { } 
public class Duplicates {

	public static void main(String[] args) {
		  Tree tree = new Pine(); 
	        if( tree instanceof Pine ) 
	            System.out.println ("Pine"); 
	        else if( tree instanceof Tree ) 
	            System.out.println ("Tree"); 
	        else if( tree instanceof Oak ) 
	            System.out.println ( "Oak" ); 
	        else 
	            System.out.println ("Oops "); 
		
		
	}
	
	 private static String commonPrefix(String[] vals) {
		// TODO Auto-generated method stub
		for(int i=0;i<vals.length;i++) {
			String aux = vals[i];
			  int j=i-1;
			  while (j >= 0 && vals[j].length() > aux.length()) {
				  vals[j + 1] = vals[j];
	                j--;
	            }
			  vals[j + 1] = aux;
			
			}
		
		String palabra=vals[0];
		String sub = null;
		for(int i=palabra.length();i>0;i--)
		{
			boolean valid=true;
			 sub= palabra.substring(0,i);
			for (int j=1;j<vals.length;j++)
			{
				if(!sub.equalsIgnoreCase(vals[j].substring(0,i)))
				{
					valid=false;
				}
				

			}
			if(valid)
				return sub;
			
			
		}
		
		
		return "";
		}
			
	

	private static void ordenaInsercion(Integer[] vals) {
		 for(int i=0;i<vals.length;i++)
			{
			  int aux = vals[i];
			  int j=i-1;
			  while (j >= 0 && vals[j] > aux) {
				  vals[j + 1] = vals[j];
	                j--;
	            }
			  vals[j + 1] = aux;
			  System.out.println(Arrays.toString(vals));
			}
		
	}

	private static void ordenaSeleccion(Integer[] vals) {
		 int min = 0;
		for(int i=0;i<vals.length;i++)
		{
			min=i;
			for(int j=i;j<vals.length;j++)
				{
				if(vals[min]>vals[j])
					 min=j;
				}
			int aux= vals[i];
			vals[i]=vals[min];
			vals[min]=aux;
			System.out.println(Arrays.toString(vals));
		}
		
		System.out.println(Arrays.toString(vals));
		
	}

	private static void ordenaBurbuja(Integer[] vals) {
		for(int i=0;i<vals.length;i++)
		{
			for(int j=0;j<vals.length-i-1;j++)
				if(vals[j]>vals[j+1])
				{
					int aux= vals[j];
					vals[j]=vals[j+1];
					vals[j+1]=aux;
					System.out.println(vals[j]+"-"+vals[j+1]);
				}
			System.out.println(Arrays.toString(vals));
		}
			
				
		
	}

	private static String longestPalindrome(String s) {
		 if(s==null || s.length()<=1)
		        return s;
		 
		    int len = s.length();
		    int maxLen = 1;
		    boolean [][] dp = new boolean[len][len];
		 
		    String longest = null;
		    for(int l=0; l<s.length(); l++){
		        for(int i=0; i<len-l; i++){
		            int j = i+l;
		            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
		                dp[i][j]=true;
		 
		                if(j-i+1>maxLen){
		                   maxLen = j-i+1; 
		                   longest = s.substring(i, j+1);
		                }
		            }
		        }
		    }
		 
		    return longest;
		
	}
	 
	 

	private static int[] sortColor(int[] nums) {
		
		 int mem[] = new int[3];
		 for (int n:nums)
			 mem[n]++;
		 
		 for(int i=0;i<nums.length;i++)
		 	{ 
			 while(mem[0]>0)
			 {
				 nums[i]=0;
				 i++;
				 mem[0]--;
			 }
			 while(mem[1]>0)
			 {
				 nums[i]=1;
				 i++;
				 mem[1]--;
			 }
			 while(mem[2]>0)
			 {
				 nums[i]=2;
				 i++;
				 mem[2]--;
			 }
				 
			
			
			 }
		 
		 return nums;
	}

	private static boolean isValid(String s) {
		 Map<Character,Character> mappings= new HashMap<>();
		 mappings.put('}', '{');
		 mappings.put(']', '[');
		 mappings.put(')', '(');
		 s=s.replace(" ", "");
		
			Stack<Character> letters = new Stack<>();
			
	        for(int i = 0; i < s.length(); i++){
	            char temp = s.charAt(i);
	            if(mappings.containsKey(temp)){
	                if(letters.isEmpty() || letters.pop() != mappings.get(temp)){
	                    return false;
	                }
	            } else{
	                letters.push(temp);
	            }
	        }
	        return letters.isEmpty();
	}

	private static int romanToInt(String s) {
		int sum=0;
		Map<Character,Integer> roman= new HashMap<>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
		char arr[]=s.toCharArray();
		
		for(int i=0;i<arr.length;i++)
		{
			
			if(i<s.length()-1&& (roman.get(arr[i])<roman.get(arr[i+1])))
			{
				sum=sum + (roman.get(arr[i+1])-roman.get(arr[i]));
				i++;
			}
			else
				sum=sum + roman.get(arr[i]);
			
		
		}
		return sum;
		
	}

	public static int[] twoSum(int[] nums, int target) {
		 int res[]= new int[2];
		for(int elem=0;elem<nums.length;elem++)
			for(int parej=0;parej<nums.length;parej++) {
				if(elem!=parej&&(nums[elem]+nums[parej])==target)
					{
					res[0]=elem;
					res[1]=parej;
					 return res;
					}
				
			}
		
		 return null;
	    }
	
	

	



	private static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> hashMap = new HashMap<>();
		for(String str:words)
		{
			if(!hashMap.containsKey(str))
				hashMap.put(str, 1);
			else
			{
				hashMap.replace(str, hashMap.get(str)+1);
			}	
		}
		
		Comparator<Entry<String,Integer>> valueComparator = new Comparator<Entry<String,Integer>>(){
            public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2)
            {
                int val1 = e1.getValue();
                int val2 = e2.getValue();
                if(val1<val2)
                    return 1;
                else if(val1 > val2)
                    return -1;
                else
                {
                    return e1.getKey().compareTo(e2.getKey());
                }
            }
        };
        
        Set<Entry<String, Integer>> entries = hashMap.entrySet();
        List<Entry<String,Integer>> listOfEntries = new ArrayList<Entry<String,Integer>>(entries);
        Collections.sort(listOfEntries,valueComparator);
        
        LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(listOfEntries.size());
        
        // copying entries from List to Map
        for(Entry<String, Integer> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println(sortedByValue);
        
        List<String> answer = new ArrayList<String>();
        Iterator it = sortedByValue.entrySet().iterator();
        int index = 1;
        while (it.hasNext()) {
            if(index <= k)
            {
                Map.Entry pair = (Map.Entry)it.next();
                answer.add(String.valueOf(pair.getKey()));
            }
            else
                break;
           index++;
        }
        return answer;
	
		
	
	}

	private static String reverseStr(String s, int k) {
		StringBuffer sb = new StringBuffer(s);
	    if(sb.length()<k) sb.reverse().toString();
	    for(int i=0;i<s.length();i++)
	    {
	        if(i+k<=s.length())
	        {
	            StringBuffer str =new StringBuffer(s.substring(i,i+k)); 
	            str.reverse();
	            String thin=str.toString();
	            sb.replace(i,i+k,thin);
	            i+=2*k-1;
	        }
	        else if(i+k>s.length())
	        {
	            StringBuffer str =new StringBuffer(s.substring(i,s.length())); 
	            str.reverse();
	            String thin=str.toString();
	            sb.replace(i,s.length(),thin);
	            return sb.toString();
	        }
	    }
	    return sb.toString();
	}

	

}
