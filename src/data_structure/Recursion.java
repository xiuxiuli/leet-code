package data_structure;

public class Recursion {
    public static int sum(int n){

        if (n == 1) return 1;

        int result = n + sum(n-1);

        System.out.println("n="+ n + ", "+ "sum="+result);
        return result;
    }

    public static void main(String[] args){
        System.out.println(sum(5));
    }
}