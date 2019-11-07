public class BinaryHeap {

    private int[] data; 
    private int size;
    private int maxSize; 

    public BinaryHeap(){
        this.size = 0;
        this.maxSize = 1; 
        data = new int[10];  
    }

    public void growArray(){
        int[] newArr = new int[data.length * 2];
        int size = data.length;
        for(int i = 0; i < size; i++){
            newArr[i] = data[i];
        }
        data = newArr;
    }

    public void add(int item){
        if(size >= data.length){
            growArray();
        }
        data[size++] = item;  
        maxSize++; 
        int child_index = size-1; 
        int parents_index = (child_index -1)/2;
        
        if(parents_index >= 0){
            while(data[parents_index] > data[child_index]){
                swap(data, parents_index, child_index);
                child_index = parents_index;
                parents_index = (child_index -1)/2;
        
            }//end of while loop
        }
       
    
    }

    public void swap(int[] data, int parents_index, int child_index){
        int temp = data[parents_index];
        data[parents_index] = data[child_index];
        data[child_index] = temp; 
    }
    
    
    public int remove(){
        int removed = data[0];
        data[0] = data[--size]; //moves the last element to the root
    
        siftdown(0); //compares left and right child and goes down that route
        return removed; 
    
    }
    
    public void siftdown(int parent){
        int child = 2 * parent + 1; 
        if(child >= size){
            return; 
        }
        
        if(child + 1 < size && data[child+1] < data[child]){
            child++; 
        }
       
        if(data[parent] > data[child]){
            swap(data,child,parent);
            siftdown(child);
        }
        
    }

}