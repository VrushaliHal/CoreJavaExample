public class DecreaseTriangle {
    public static void main(String[] args) {
        int n =6;
        for(int rows = 0 ; rows < n ;rows ++)
        {
            for(int cols = rows  ; cols < n;cols ++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
