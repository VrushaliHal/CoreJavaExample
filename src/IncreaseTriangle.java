public class IncreaseTriangle {
    public static void main(String[] args) {
        int n= 6;

        for(int rows = 0 ; rows < n ;rows++)
        {
            for(int cols = 0; cols < rows ;cols++ )
            {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
}
