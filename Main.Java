import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      boolean[] chptList = new boolean[16]; // Valid chapters are 1-15. 1 means include, 0 exclude. Element 0 unused. 
      int includeChpt;
      int i, j;
      
      // Get the chapter selections
      for (i = 1; i <= 15; ++i) {
         includeChpt = scnr.nextInt(); 
         if (includeChpt==1) {
            chptList[i] = true;
         }
         else {
            chptList[i] = false;
         }
      }
      
      // Boolean to track if any chapter was selected
      boolean chapterSelected = false;
      
      // Iterate through the chapters from 1 to 15
      for (i = 1; i <= 15; /* i is updated within the loop body */) {
         
         // 1. Check if the current chapter is selected
         if (chptList[i]) {
            chapterSelected = true;
            
            // Start of a potential range. 'j' will track the end of the range.
            int rangeStart = i;
            int rangeEnd = i;
            
            // 2. Use a while loop to find the end of the continuous selection (the range)
            j = i + 1;
            while (j <= 15 && chptList[j]) {
               rangeEnd = j;
               j++;
            }
            
            // 3. Determine output based on the length of the range
            int rangeLength = rangeEnd - rangeStart + 1;
            
            if (rangeLength >= 3) {
               // A range of 3 or more (e.g., 1-4)
               System.out.print(rangeStart + "-" + rangeEnd + " ");
               
               // Move the main loop index 'i' past the end of the range we just printed
               i = rangeEnd + 1;
               
            } else {
               // A single chapter (length 1) or a pair of chapters (length 2)
               // (e.g., 6 or 8 9)
               
               // Print the chapters individually
               for (int k = rangeStart; k <= rangeEnd; ++k) {
                  System.out.print(k + " ");
               }
               
               // Move the main loop index 'i' past the last chapter we just printed
               i = rangeEnd + 1;
            }
            
         } else {
            // Chapter 'i' is not selected, move to the next chapter
            i++;
         }
      }
      
      // 4. Output "None" if no chapters were ever selected
      if (!chapterSelected) {
         System.out.println("None ");
      } else {
         System.out.println(); // Output newline at the end of the selected chapters list
      }/* Type your code here. */
   }
}
