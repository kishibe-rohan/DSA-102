# Question:

Given an array containing both positive and negative numbers in random order,rearrange the array elements so that all negative numbers appear before all positive numbers. (relative order does not matter)

* Example:
\
 Input array = [-3,2,7,4,-1,-6,8]
\
 Output array = [-3,-6,-1,4,7,2,8]

 ## Apporach 1: (Two pointers - positive and negative)
- Traverse the array left to right using pointer variable 
- Another variable j keeps track of leftmost index with non-negative value.
- Once we come across a negative number ,we swap it with the leftmost available index indicated by j (if it is not there already) and increment j.

## Approach 2: (Two pointers - left and right)
- Initialize left = 0 and right = n - 1 (where n is size of array)
- while(left <= right),do the following:
   - if(a[left] < 0 && a[right] < 0) left++;
   - if(a[left] > 0 && a[right] < 0) swap a[left] with a[right],left++,right--;
   - if(a[left] > 0 && a[right] > 0) right--;
   - else left++,right--;
  
All the elements at indices <=left will be the negatives.

 
