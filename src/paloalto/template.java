import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        while(testcases > 0){
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            
            System.out.println(num1 + num2);
            testcases--;
        }
        in.close();
    }
}