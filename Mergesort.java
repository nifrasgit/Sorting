class Mergesort{
	
	int[] list={22, 5, 93, 5, 7, 99, 1, 8, 59, 18, 1, 58, 6, 4, 57};
    //int [] list={1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    //int [] list={15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	int tmp[];
	int n;
	
	Mergesort(){
		n = list.length;
		tmp = new int[n];
	}
	void merge( int low, int mid, int high){
		int i=low; 
		int j=mid+1;
		int t=low;
		
		while(i<=mid && j<=high){
			if(list[i]<=list[j])
				tmp[t++]=list[i++];
			else
				tmp[t++]=list[j++];
		}
		if (i<=mid)
			for(int k=i;k<=mid; k++) 
				tmp[t++]=list[k];

		if (j<=high) 
			for (int k=j; k<=high;k++) 
				tmp[t++]=list[k];

		for(int k=low; k<=high; k++)
			list[k]=tmp[k];
	}
	
	private void mergeSort(int low, int high){
		int mid = (high+low)/2;
		if(low < high){
			mergeSort(low,mid);
			mergeSort(mid+1,high);
		}
		merge(low,mid,high);
		
	}
	
	private void MergeSorts(){
		mergeSort(0,n-1);
	}

	 public void printArray()
    {
        System.out.println("Array Contents");
        for (int i=0; i<n; i++)
        {
            System.out.print(list[i]+", ");
            if (n%10==0) System.out.println();
		}
        System.out.println(list[n-1]);
    }
    
	public static void  main(String argv[])
    {
        //Quicksort qs1=new Quicksort(15);
        Mergesort ms1=new Mergesort();
        System.out.print("Given ");
        ms1.printArray();
        ms1.MergeSorts();
        System.out.print("After Sorting  ");
        ms1.printArray();
    }
}
