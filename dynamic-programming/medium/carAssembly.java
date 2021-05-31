/*


In a car factory with two assembly lines each with n stations
Each station is dedicated to a particular task
The car must move through each station in order (i.e it can visit station 3 only after visiting station 2,it cannot move to 3 from 1)
The car may proceed along the same assembly line (without incurring extra time cost)
or move to the next station in the other assembly line i.e. diagonally (incurring time cost to move between assembly lines)
Find the minimum time needed for the car to move through all stations (including entry and exit times)

Approach: Dynamic Programming
Recurrence Relation:

for car at S(1,j) it either  came from S(1,j-1) or S(2,j-1)

Case 1: it came from S(1,j-1):
T1(j) = T1(j-1) + a(1,j)

Case 2: it came from S(2,j-1):
T1(j) = T2(j-1) + a(1,j) + T(2,j)
  

*/

public class carAssembly {

    public static int main(int[][] a, int[][] t, int e[], int x[]) {
        /*
         * a[i][j] => time spent on jth station of assembly line i t[i][j] => time
         * needed to switch from station i to j e => entry time x => exit time
         */
        int stations = a[0].length;

        int T1[] = new int[stations];
        int T2[] = new int[stations];

        // base cases for 1st station
        T1[0] = e[0] + a[0][0];
        T2[0] = e[1] + a[1][0];

        for (int i = 1; i < stations; i++) {
            T1[i] = Math.min(T1[i - 1] + a[0][i], T2[i - 1] + a[0][i] + t[1][i]);
            T2[i] = Math.min(T2[i - 1] + a[1][i], T1[i - 1] + a[1][i] + t[0][i]);
        }

        return Math.min(T1[stations - 1] + x[0], T2[stations - 1] + x[1]);
    }

}
