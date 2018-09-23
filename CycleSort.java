
public class CycleSort {
    public static void sort(int array[]){
        int count = 0;
        for(int start=0;start<array.length-1;start++){
            int curr = array[start];
            int smaller = start;
            for (int i=start+1;i<array.length;i++){
                if (array[i]<curr) {
                    smaller++;
                }
            }
            if(smaller==start){
                continue;
            }
            while(curr==array[smaller]){
                smaller++;
            }
            if(smaller!=start){
                int temp = curr;
                curr=array[smaller];
                array[smaller]=temp;
                count++;
            }
            while(smaller!=start){
                smaller=start;
                for(int i=start+1;i<array.length;i++){
                    if(array[i]<curr){
                        smaller++;
                    }
                }
                while (curr==array[smaller]){
                    smaller++;
                }
                if(curr!=array[smaller]){
                    int temp = curr;
                    curr=array[smaller];
                    array[smaller]=temp;
                    count++;
                }
            }
        }
    }
    
}
