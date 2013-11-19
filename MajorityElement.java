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

// Given an array of 2n elements of which exactly n elements are same and the remaining n elements are all different. 
// Find out the value which is present n times in the array.
Function hasMajority(A[1:n]) 
create a stack S; 
push the first element of A onto S; 
for i = 2:n 
    if A[i] = the top element, push A[i] onto S; 
    else pop the top element of S; 
    if S is empty, push A[i] onto S; 
    i++; 
end for 
return the top element of S;
