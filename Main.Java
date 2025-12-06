import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      boolean[] chptList = new boolean[16];
      int includeChpt;
      int i, j;
      
      for (i = 1; i <= 15; ++i) {
         includeChpt = scnr.nextInt(); 
         if (includeChpt == 1) {
            chptList[i] = true;
         }
         else {
            chptList[i] = false;
         }
      }
      
      boolean chapterSelected = false;
      
      for (i = 1; i <= 15;) {
         if (chptList[i]) {
            chapterSelected = true;
            
            int rangeStart = i;
            int rangeEnd = i;
            
            j = i + 1;
            while (j <= 15 && chptList[j]) {
               rangeEnd = j;
               j++;
            }
            
            int rangeLength = rangeEnd - rangeStart + 1;
            
            if (rangeLength >= 3) {
               System.out.print(rangeStart + "-" + rangeEnd + " ");
               i = rangeEnd + 1;
            } 
            else {
               for (int k = rangeStart; k <= rangeEnd; ++k) {
                  System.out.print(k + " ");
               }
               i = rangeEnd + 1;
            }
            
         } else {
            i++;
         }
      }
      
      if (!chapterSelected) {
         System.out.println("None ");
      } else {
         System.out.println();
      }

      scnr.close();
   }
}


