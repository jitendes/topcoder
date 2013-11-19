// Moore’s Voting Algorithm 
// Time Complexity: O(n) 
// Auxiliary Space : O(1) 
// This is a two step process. 
// 1. Get an element occurring most of the time in the array. 
// 2. One more pass to check if the element obtained from above step is majority element.

int findMajorityElement(int * arr, int size) { 
     int count = 0, i, majorityElement;
     for (i = 0 ; i < size ; i++) {
        if (count == 0) {
            majorityElement = arr[i];
        }
        if(arr[i] == majorityElement) 
           count++;
        else 
           count--;
     }
     count = 0;
     for (i = 0; i < size; i++) {
          if (arr[i] == majorityElement) {
                count++;
          }
     if (count > size/2) {
          return majorityElement;
     }
     else return -1;
}
