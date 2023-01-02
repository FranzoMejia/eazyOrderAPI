package com.omejia.springsecuritybasic;




public class Test116 {

	 	static int x; 
	    static boolean catche()
	    {
	        x++; 
	        return true; 
	    } 
	    public static void main(String[] args)
	    {
	    	String s = "hello"; 
	    	Object o = s; 
	    	if( o.equals(s) )
	    	{
	    	    System.out.println("A"); 
	    	} 
	    	else
	    	{
	    	    System.out.println("B"); 
	    	} 
	    	if( s.equals(o) )
	    	{
	    	    System.out.println("C"); 
	    	} 
	    	else
	    	{ 
	    	    System.out.println("D"); 
	    	}
	    } 
}
