class Solution{


static boolean isPerfectSquare(int N)
{
    int floorSqrt = (int)Math.sqrt(N);

    return (N == floorSqrt * floorSqrt);
}

static boolean legendreFunction(int N) {
     
    while (N % 4 == 0)
        N /= 4;
    
    return N % 8 != 7;
}


static int minSquares(int N)
{

    if (isPerfectSquare(N)) return 1;

    for(int i = 1; i * i < N; i++) 
    {
        if (isPerfectSquare(N - i * i))
            return 2;
    }
  
    if (legendreFunction(N)) return 3;

    return 4;
}


public static void main(String[] args)
{
    
    int N = 123;

    System.out.println("-----------------");
    System.out.print(minSquares(N));
}
}

