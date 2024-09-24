public class SortedArray {
    public static void main(String[] args) {

        int[] arr = {43,12,56,34,78,79,50,34,11};
        int l = arr.length;
        int temp=0;
        for (int i=0 ; i <=l -1 ; i++ )
        {
            System.out.print(arr[i]+ " ");
        }
        for (int j=0 ; j <=l-1 ; j++ )
        {
            for(int k=j+1; k<=l-1 ;k++)
            {

                if(arr[j] > arr[k])
                {
                    temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                }
            }
        }
        System.out.println(" ");
        for (int i=0 ; i <=l -1 ; i++ )
        {
            System.out.print(arr[i]+ " ");
        }

    }
    }

