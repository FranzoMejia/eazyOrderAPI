package com.omejia.springsecuritybasic;



public class Solution {
	
	
   public static boolean exist(char[][] board, String word) {
    	
	
	  int wordLenght= word.length(); 
	  int indexX=0; 
	  int indexY=0; 
	  int lengX=board[0].length; 
	  int lengY= board.length;
	  char[] arr= word.toCharArray();
	  
	  
	  
	  for(indexY=0;indexY<lengY;indexY++) { 
		  for(indexX=0;indexX<lengX;indexX++) {
			  	if(buscaVecinosDFS(board,arr,indexY,indexX,0))return true;
			  		
		  }
	  } 
	  return false;
   }
	  
	  
	  private static boolean buscaVecinosDFS(char[][] board, char[] word, int indexY, int indexX, int idx) {
		  
		  //Validar Error y si es la letra
		  if(
				  indexY<0 ||
				  indexY>=board.length ||
				  indexX<0 ||
				  indexX>=board[0].length ||
				  board[indexY][indexX] == '0'||
				  board[indexY][indexX] != word[idx]
				  )return false;
			  
		  if (idx == word.length - 1) return true; //Cadena Encontrada
		  
		  char temp = board[indexY][indexX]; // la marca como 0 
	        board[indexY][indexX] = '0';
	        
	        boolean dfs = buscaVecinosDFS(board, word, indexY + 1, indexX, idx + 1) || //ABAJO
	        		buscaVecinosDFS(board, word, indexY - 1, indexX, idx + 1) ||  //ARRIBA
	        		buscaVecinosDFS(board, word, indexY, indexX + 1, idx + 1) || //DERECHA
	        		buscaVecinosDFS(board, word, indexY, indexX - 1, idx + 1);  //IZQUIERDA
	                board[indexY][indexX] = temp;  // SI NO LA ENCONTRO LA RESTAURA
	
		  
		return dfs;
	  }


	
	 
    	
	/*
	 * public static boolean exist(char[][] board, String word) { char[] arr =
	 * word.toCharArray(); for (int i = 0; i < board.length; i++) for (int j = 0; j
	 * < board[0].length; j++) if (dfs(board, arr, i, j, 0)) return true; return
	 * false; }
	 * 
	 * private static boolean dfs(char[][] board, char[] word, int i, int j, int
	 * idx) { if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
	 * board[i][j] == '0' || board[i][j] != word[idx]) return false;
	 * 
	 * if (idx == word.length - 1) return true;
	 * 
	 * char temp = board[i][j]; board[i][j] = '0'; boolean dfs = dfs(board, word, i
	 * + 1, j, idx + 1) || dfs(board, word, i - 1, j, idx + 1) || dfs(board, word,
	 * i, j + 1, idx + 1) || dfs(board, word, i, j - 1, idx + 1); board[i][j] =
	 * temp;
	 * 
	 * return dfs; }
	 */

	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		boolean a = exist(board,"ABCCED");
		System.out.println(a);
	}
}
