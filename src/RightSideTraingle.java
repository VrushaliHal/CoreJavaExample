public class RightSideTraingle {
    public static void main(String[] args) {
        int n=7;
        for(int rows = 0; rows < n ;rows++)
        {
            for(int cols =rows; cols <n ;cols++)
            {
                System.out.print(" ");
            }
            for(int cols=0; cols< rows ; cols++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
