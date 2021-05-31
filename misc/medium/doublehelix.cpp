// Question Link : https://www.spoj.com/problems/ANARC05B/
// Aproach : 2 pointers + Memoization (can be optimized using Binary Search)

#include <bits/stdc++.h>

int main()
{
    while (true)
    {
        int n1; //size of array1
        cin >> n1;
        if (n1 == 0)
            break;
        else
        {
            int arr1[n1];
            for (int i = 0; i < n1; i++)
                cin >> arr1[i];

            int n2;
            cin >> n2;
            int arr2[n2];
            for (int i = 0; i < n2; i++)
                cin >> arr2[i];

            int s1 = 0, s2 = 0;
            int i = 0, j = 0;
            int maxSum = 0;

            while (i < n1 && j < n2)
            {

                //add smaller elements first so that both intersect at  'bridge' point
                if (arr1[i] < arr2[j])
                    s1 += arr1[i++];

                else if (arr1[i] > arr2[j])
                    s2 += arr2[j++];

                else
                {
                    //reached intersection point
                    maxSum += max(s1, s2) + arr1[i]; //consider the max path sum
                    s1 = s2 = 0;                     //reset for next bridge path
                    i++;
                    j++;
                }
            }

            //add remaining elements
            while (i < n1)
                s1 += arr1[i++];

            while (j < n2)
                s2 += arr2[j++];

            maxSum += max(s1, s2);

            cout << maxSum << endl;
        }
    }
}