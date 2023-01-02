package com.omejia.springsecuritybasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class A 
{ 
	public static void stringReplace (String text) 
    {
        text = text.replace ('j' , 'c'); /* Line 5 */
    } 
    public static void bufferReplace (StringBuffer text) 
    { 
        text = text.append ("c");  /* Line 9 */
    } 
    public static void main (String args[]) 
    { 
    	
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	arrayList.add(8);
    	arrayList.add(7);
    	arrayList.add(6);
    	arrayList.add(5);
    	arrayList.add(4);
    	arrayList.add(3);
    	arrayList.add(2);
    	arrayList.indexOf(8);
    	
    	HashMap<Integer,String> hashMap= new HashMap<Integer,String>();
    	hashMap.put(1, null);
    	hashMap.put(null, null);
    	hashMap.put(null, null);
    	
    	Collections.sort(arrayList);
    	
    	//Arrays.sort(arrayList);
    	
    	
     } 
}