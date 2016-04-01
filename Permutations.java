/**
 *  <h2>Permutations of strings and integers</h2>
 *  All possible permutations of given set of integers or string is printed.
 *  The output is printed to the console.
 * 
 *  @author  Brahmendra Sravan Kumar Patibandla
 *  @since   2016-04-01
 *  permutation function for string [permutations()] courtesy of Princeton University
 *  URL: http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
 */ 

import java.util.*;
public class Permutations {
    
	public static long count = 0;
	
  public static void getPermutations(ArrayList<Integer> num_list) {
    
    ArrayList<Integer> temp_num_list = null;
    ArrayList<Integer> rest_num = null;
    ArrayList<Integer> sequence = null;
    
    temp_num_list = new ArrayList<Integer>(num_list);
    
    for(int i = 0; i < temp_num_list.size(); i++) {
      rest_num = new ArrayList<Integer>(temp_num_list);
      rest_num.remove(i);
      sequence = new ArrayList<Integer>();
      sequence.add(temp_num_list.get(i));
      getPermutations(rest_num, sequence);
    }    
  }
    
  public static void getPermutations(ArrayList<Integer> num_list, ArrayList<Integer> current_sequence) {
    
    ArrayList<Integer> temp_num_list = null;
    ArrayList<Integer> temp_rest_num = null;
    ArrayList<Integer> temp_sequence = null;
    
    if(num_list.size() == 0)  {
      for(Integer n : current_sequence) {
        System.out.print(n);
      }
      System.out.println();
    }
    else  {
      temp_num_list = new ArrayList<Integer>(num_list);
        
      for(int i = 0; i < temp_num_list.size(); i++) {
        temp_rest_num = new ArrayList<Integer>(temp_num_list);
        temp_rest_num.remove(i);
        temp_sequence = new ArrayList<Integer>(current_sequence);
        temp_sequence.add(temp_num_list.get(i));
        getPermutations(temp_rest_num, temp_sequence);
      }
    }
  }

	public static void permutations(String str) {
		permutations(str, "");
	}
	
	public static void permutations(String rest_str, String current_sequence) {
		if(rest_str.length() == 0)  {
			System.out.println(current_sequence);
		}
		else  {
			for(int i = 0; i < rest_str.length(); i++)  {
				permutations(rest_str.substring(0,i) + rest_str.substring(i+1,rest_str.length()), current_sequence + rest_str.charAt(i));	
			}
		}
	}
	
  public static void main(String[] args)  {
    Integer[] num1 = new Integer[] {0, 1, 2, 3};	
		String str = "0123";		
		ArrayList<Integer> num_list = new ArrayList<>(Arrays.asList(num1));    
		
		permutations(str);
		System.out.println("\n**********************************************\n");
		getPermutations(num_list);
  }
}
