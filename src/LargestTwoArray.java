public class LargestTwoArray {
    public static void main(String[] args) {

        int[] arr1 = {123,134,153,167,78,89,100,155};
        int firstElement =0;
        int secondElement = 0 ;
        for( int element : arr1)
        {
            if(firstElement <element)
            {
                secondElement = firstElement;
                firstElement =element;
            }
            else if(secondElement < element)
            {
                secondElement = element;
            }

        }
        System.out.println(firstElement+ ","+secondElement);

    }
}
