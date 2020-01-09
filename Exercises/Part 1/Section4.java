public class Section4{

    public static void main(String[] args){
        double[] doubleArray = {9.3, 4.7, 2.0, 23.63};

        int[] intArray = {9, 23, 9, 0, 23, 7, 10, 39, 2, 10};

        int[] intArray2 = {7, 9};

        int[] sortedOdd = {1, 3, 5, 7, 9};

        int[] sortedEven = {2, 4, 6, 8, 10};

        int[] same = {1, 1, 1, 1};

        double[] neg = {-3.4, -2.3};

        System.out.println(same[i]);

        // //Task 1
        // System.out.println(sum(doubleArray));

        // //Task 2
        // System.out.println(zeros(intArray));

        // //Task 3
        // System.out.println(count(intArray, 7));

        // //Task 4
        // System.out.println(smallerThan(intArray, 20));

        // //Task 5
        // System.out.println(member(intArray, 7));

        // //Task 6
        // System.out.println(twoZeros(intArray));

        // //Task 7
        // System.out.println(toString(intArray));

        // //Task 8
        // System.out.println(toString(squares(intArray)));

        // //Task 9
        // System.out.println(toString(decreasingSquares(5)));

        // //Task 10
        // System.out.println(toString(divisors(10)));

        // //Task 11
        // System.out.println(max(neg));

        // //Task 12
        // System.out.println(subset(intArray, intArray2));

        // //Task 13
        // System.out.println(setEquals(intArray, intArray));

        // //Task 14
        // System.out.println(toString(intersection(intArray, intArray2)));

        // //Task 15
        // System.out.println(firstPositionMax(intArray));

        // //Task 16
        // System.out.println(lastPositionMax(intArray));

        // //Task 17
        // System.out.println(addPositionMax(intArray));

        // //Task 18
        // System.out.println(toString(positionMax(intArray)));

        // //Task 19
        // System.out.println(toString(doubleArray));
        // squareIt(doubleArray);
        // System.out.println(toString(doubleArray));

        // //Task 20
        // System.out.println(toString(intArray));
        // reverse(intArray);
        // System.out.println(toString(intArray));

        // //Task 21
        // System.out.println(toString(compare(intArray, 10)));

        // //Task 22
        // System.out.println(evenAfterSeven(intArray));

        // //Task 23
        // System.out.println(evenAfterLastSeven(intArray));

        // //Task 24
        // System.out.println(toString(join(intArray, intArray2)));

        // //Task 25
        // System.out.println(toString(sortedJoin(sortedOdd, sortedEven)));

        // //Task 26
        // System.out.println(toString(shuffle(sortedEven, sortedOdd)));

        // //Task 27
        // System.out.println(isSorted(same));

        // //Task 28
        // System.out.println(toString(remove(intArray, 23)));

        // //Task 29
        // System.out.println(largestIncreasingSequence(intArray));

        // //Task 30
        // System.out.println(toString(eratosthenes(10)));



    }

    //Task 1
    public static double sum(double[] v){
        int i = 0;
        double sum = 0;
        while (i < v.length){
            sum = sum + v[i];
            i++;
        }
        return sum;
    }

    //Task 2
    public static int zeros(int[] v){
        int i = 0;
        int zeros = 0;
        while (i < v.length){
            if (v[i] == 0){
                zeros++;
            }
            i++;
        }
        return zeros;
    }

    //Task 3
    public static int count(int[] v, int n){
        int i = 0;
        int occurences = 0;
        while (i < v.length){
            if (v[i] == n){
                occurences++;
            }
            i++;
        }
        return occurences;
    }

    //Task 4
    public static int smallerThan(int[] v, int n){
        int i = 0;
        int count = 0;
        while (i < v.length){
            if (v[i] < n){
                count++;
            }
            i++;
        }
        return count;
    }

    //Task 5
    public static boolean member(int[] v, int n){
        int i = 0;
        boolean flag = false;
        while ((i < v.length) && !flag){
            if (v[i] == n){
                flag = true;
            }
            i++;
        }
        return flag;
    }

    //Task 6
    public static boolean twoZeros(int[] v){
        int i = 0;
        boolean flag = false;
        while ((i < v.length-1) && !flag){
            if (v[i] == 0 && v[i+1] == 0){
                flag = true;
            }
            i++;
        }
        return flag;
    }

    //Task 7
    public static String toString(int[] v){
        String res = "";
        int i = 0;
        while (i < v.length-1){
            res = res + v[i] + ", ";
            i++;
        }
        res = res + v[i];
        return res;
    }

    //toString but with a double[]
    public static String toString(double[] v){
        String res = "";
        int i = 0;
        while (i < v.length-1){
            res = res + v[i] + ", ";
            i++;
        }
        res = res + v[i];
        return res;
    }

    //Task 8
    public static int[] squares(int[] v){
        int i = 0;
        int[] squares = new int[v.length];

        while (i < v.length){
            squares[i] = v[i] * v[i];
            i++;
        }
        return squares;

    }

    //Task 9
    public static int[] decreasingSquares(int n){
        int i = n;
        int[] squares = new int[n];

        while (i > 0){
            squares[n-i] = i*i;
            i--;
        }
        return squares;

    }

    //Task 10
    public static int[] divisors(int n){
        int i = 1;
        int j = 0;

        int[] divisors = new int[n]; //The largest number of divisors n can have is not greate than n - also this is just a temporary array

        while (i < n){
            if (n % i == 0){
                divisors[j] = i;
                j++;
            }
            i++;
        }

        int[] res = new int[j]; //Actual array to be returned
        i = 0;

        while (i < j){
            res[i] = divisors[i];
            i++;
        }

        return res;

    }

    //Task 11
    public static double max(double[] v){
        int i = 0;
        double max = Double.NEGATIVE_INFINITY;
        // double max = 0.0;

        while (i < v.length){
            if (v[i] > max){
                max = v[i];
            }
            i++;
        }
        return max;

    }

    //Task 12
    public static boolean subset(int[] v, int[] w){
        int i = 0;
        boolean isSubset = true;

        while (i < v.length && isSubset){
            if (!member(w, v[i])){
                isSubset = false;
            }
            i++;
        }
        return isSubset;
    }

    //Task 13
    public static boolean setEquals(int[] v, int[] w){
        return (subset(v, w) && subset(w, v));
    }

    //Task 14
    //If an element occurs more than one time, the resulting array will not contain only one copy of this element.
    //However, if this was a proper set, no such thing would occur
    public static int[] intersection(int[] v, int[] w){
        int i = 0;
        int j = 0;
        int[] intersection = new int[v.length];

        while (i < v.length){
            if (member(w, v[i])){
                intersection[j] = v[i];
                j++;
            }
            i++;
        }

        i = 0;
        int[] res = new int[j];

        while (i < j){
            res[i] = intersection[i];
            i++;
        }
        return res;
    }

    //Task 15
    public static int firstPositionMax(int[] v){
        int i = 0;
        int max = 0;
        int maxPos = 0;

        while (i < v.length){
            if (v[i] > max){
                max = v[i];
                maxPos = i;
            }
            i++;
        }

        return maxPos;
    }

    //Task 16
    public static int lastPositionMax(int[] v){
        int i = 0;
        int max = 0;
        int maxPos = 0;

        while (i < v.length){
            if (v[i] > max){
                max = v[i];
                maxPos = i;
            } else if (v[i] == max){
                maxPos = i;
            }
            i++;
        }
        return maxPos;
    }

    //Task 17
    public static int addPositionMax(int[] v){
        int i = 0;
        int sum = 0;
        int max = 0;

        while (i < v.length){
            if (v[i] > max){
                max = v[i];
                sum = i;
            } else if (v[i] == max){
                sum = sum + i;
            }
            i++;
        }

        return sum;
    }

    //Task 18
    public static int[] positionMax(int[] v){
        int i = 0;
        int j = 0;
        int max = 0;
        int[] positions = new int[v.length];

        while (i < v.length){
            if (v[i] > max){
                max = v[i];
                j = 0;

            }
            if (v[i] == max){
                positions[j] = i;
                j++;
            }
            i++;
        }

        int[] res = new int[j];
        i = 0;
        while (i < j){
            res[i] = positions[i];
            i++;
        }
        return res;

    }

    //Task 19
    public static void squareIt(double[] v){
        int i = 0;

        while (i < v.length){
            v[i] = v[i]*v[i];
            i++;
        }
    }

    //Task 20
    public static void reverse(int[] v){
        int i = 0;
        int holder;

        while (i < v.length/2){
            holder = v[i];
            v[i] = v[v.length-i-1];
            v[v.length-i-1] = holder;
            i++;
        }

    }

    //Task 21
    public static int[] compare(int[] v, int n){
        int i = 0;
        int smaller = 0;
        int larger = 0;
        int equals = 0;

        while (i < v.length){
            if (v[i] == n){
                equals++;
            } else if (v[i] < n){
                smaller++;
            } else {
                larger++;
            }
            i++;
        }

        int[] res = {larger, equals, smaller};
        return res;
    }

    //Task 22
    public static int evenAfterSeven(int[] v){
        int i = 0;
        boolean flag = false;
        int even = 0;

        while (i < v.length){
            if (v[i] == 7){
                flag = true;
            }
            if (flag && (v[i] % 2 == 0)){
                even++;
            }
            i++;
        }
        return even;

    }

    //Task 23
    public static int evenAfterLastSeven(int[] v){
        int i = v.length-1;
        int even = 0;
        boolean flag = false;
        while (i >= 0 && !flag){
            if (v[i] == 7){
                flag = true;
            }
            if (v[i] % 2 == 0){
                even++;
            }
            i--;
        }
        return even;

    }

    //Task 24
    public static int[] join(int[] v, int[] w){
        int i = 0;
        int[] res = new int[v.length+w.length];

        while (i < v.length){
            res[i] = v[i];
            i++;
        }

        i = 0;
        while (i < w.length){
            res[v.length+i] = w[i];
            i++;
        }
        return res;

    }

    //Task 25
    public static int[] sortedJoin(int[] v, int[] w){
        int i = 0;
        int j = 0;
        int n = 0;
        int[] join = new int[v.length+w.length];
        while (i < v.length && j < w.length){
            if (v[i] < w[j]){
                join[n] = v[i];
                i++;
            } else {
                join[n] = w[j];
                j++;
            }
            n++;
        }

        //Have to put the rest of the elements into join
        while (i < v.length){
            join[n] = v[i];
            n++;
            i++;
        }
        while (j < w.length){
            join[n] = w[j];
            n++;
            j++;
        }
        return join;

    }

    //Task 26
    public static int[] shuffle(int[] v, int[] w){
        int i = 0;
        int[] shuffle = new int[v.length+w.length];

        while (i < v.length && i < w.length){
            shuffle[i*2] = v[i];
            shuffle[i*2+1] = w[i];
            i++;
        }

        //Have to put the rest of the elements into shuffle
        while (i < v.length){
            shuffle[w.length+i] = v[i];
            i++;
        }
        while (i < w.length){
            shuffle[v.length+i] = w[i];
            i++;
        }
        return shuffle;

    }

    //Task 27
    public static boolean isSorted(int[] v){
        int i = 1;
        boolean isSorted = true;
        int lastElem = v[0];

        while (i < v.length && isSorted){
            if (v[i] < lastElem){
                isSorted = false;
            }
            lastElem = v[i];
            i++;
        }
        return isSorted;
    }

    //Task 28
    public static int[] remove(int[] v, int n){
        int i = 0;
        int[] remove = new int[v.length]; //Use the count() function to get exact length, so we don't need to copy to another array later
        int count = 0;

        while (i < v.length){
            if (v[i] != n){
                remove[count] = v[i];
                count++;
            }
            i++;
        }

        i = 0;
        int[] res = new int[count];
        while (i < count){
            res[i] = remove[i];
            i++;
        }
        return res;
    }

    //Task 29
    public static int largestIncreasingSequence(int[] v){
        int i = 0;
        int length = 1;
        int maxLength = 1;

        while (i < v.length-1){
            if (v[i] > v[i+1]){
                if (length > maxLength){
                    maxLength = length;
                }
                length = 1;
            } else {
                length++;
            }
            i++;

        }
        return maxLength;
    }

    //Task 30
    public static int[] eratosthenes(int n){
        int i = 1;
        int j;
        int k;
        int[] list = new int[n];
        int primes = 0; //Count amount of primes, so we can return a "clean" array later, instead of one filled with 0's

        //Initialize array
        while (i <= n){
            list[i-1] = i;
            i++;
        }

        //Cross out the 1
        list[0] = 0;

        j = 2;

        while (j <= n){
            if (list[j-1] != 0){
                primes++;
                k = j*2; //Start at the first multiple, could probably also be done with % operator
                while (k <= n){
                    list[k-1] = 0;
                    k = k+j;
                }
            }

            j++;
        }

        //Clean up
        int[] res = new int[primes];
        i = 0;
        j = 0;
        while (j < primes){
            if (list[i] != 0){
                res[j] = list[i];
                j++;
            }
            i++;

        }



        return res;
    }


}
