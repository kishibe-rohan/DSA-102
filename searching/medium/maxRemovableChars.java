//Question Link : https://leetcode.com/contest/weekly-contest-245/problems/maximum-number-of-removable-characters/

class maxRemovableChars {
    public int maximumRemovals(String s, String p, int[] removable) {
        //Binary search the number of characters that can be removed
        
        char[] str = s.toCharArray();
        int l = 0;
        int r = removable.length;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            
            //"remove" the first 'mid' removable characters by marking them as '#'
            for(int i=0;i<mid;i++)
                str[removable[i]] = '#';
            
            //check if p is still subsequence of s
            if(isSubsequence(str,p.toCharArray()))
                l = mid + 1;           //try removing more characters
            else
            {
                for(int i=0;i<mid;i++)
                    str[removable[i]] = s.charAt(removable[i]);
                    
                r = mid - 1;
            }
        }
        
        return r;    
    }
    
    public boolean isSubsequence(char[] s1,char[] s2)
    {
        int i=0,j = 0;
        while(i< s1.length && j<s2.length)
        {
            if(s1[i] != '#' && s1[i] == s2[j])       //matching? increment both i and j,else only increment i
                j++;
            
            i++;
        }
        
        return j == s2.length;
    }
}
