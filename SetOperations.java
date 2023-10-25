//--------------------------------------------------------------------
// Laiba Khan, CSCI3327 Probability and Applied Statistics
// Chapter 2:
// StatsLibrary: SetOperations (Union, Intersect, Compliment)
//--------------------------------------------------------------------
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SetOperations {
    //Union is the combinations of two lists.
    //Take the parameters of two lists.
    public static List<Integer> Union(Integer[] list1, Integer[] list2) {
        // Create a HashSet to store unique elements.
        HashSet<Integer> unionSet = new HashSet<>();
            
        // Add all elements from list1 to the set
        unionSet.addAll(Arrays.asList(list1));

        // Add all elements from list2 to the set
        unionSet.addAll(Arrays.asList(list2));

        // Create a new ArrayList to store the union
        List<Integer> union = new ArrayList<>(unionSet);

        return union;
    }
    
    //Intersection of two lists is the elements both lists have in common.
    //Take the parameters of two lists.
    public static List<Integer> Intersect(Integer[] list1, Integer[] list2){
        List<Integer> intersect = new ArrayList<>();
        
        //Iterate throught the values in list2 for each value in list1 to check if they equal.
        //If they are equal, add the value to a new list.
        for(int i : list1){
            for (int j : list2){
                //Check if values are equal. Add to list if true.
                if (i == j){
                    intersect.add(i);
                }
            }            
        }
        return intersect;
    }

    //The compliment of the list will be the remaining elements required to complete
    //the list. Or rather, add to the subset to turn it into the original arraylist.
    //Take the parameters of a list and its subset.
    public static List<Integer> Compliment(Integer[] list, Integer[] A){
        List<Integer> compliment = new ArrayList<>();
        for (int i : list){
            if (!Arrays.asList(A).contains(i)){
                compliment.add(i);
            }
        }
        return compliment;
    }

    public static void main(String[] tests){
        Integer l1test1[] = {1, 2, 3, 4, 5, 6, 7};
        Integer l2test1[] = {5, 6, 7, 8, 9, 10, 11};
        Integer A[] = {1, 2, 3, 4, 5};
        // Print Union test.
        System.out.println("Union of " + Arrays.toString(l1test1) +
        " and " + Arrays.toString(l2test1) + " is " + Union(l1test1, l2test1));
        // Print Intersect test.
        System.out.println("Intersect of " + Arrays.toString(l1test1) +
        " and " + Arrays.toString(l2test1) + " is " + Intersect(l1test1, l2test1));
        // Print Compliment test.
        System.out.println("Compliment of " + Arrays.toString(l1test1) +
        " and subset " + Arrays.toString(A) + " is " + Compliment(l1test1, A));
    }
}

