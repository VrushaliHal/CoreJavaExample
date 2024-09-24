public class MinArray {
    public static void main(String[] args) {
        int[] arr1 = {123,134,55,167,78,89,100};
        int min =arr1[0];
        for (int ele : arr1)
        {
            if(ele < min)
            {
                min =ele;
            }
        }
        System.out.println(" Minimum Element in the Array : "+ min);
    }
}
