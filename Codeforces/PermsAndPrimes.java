import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class PermsAndPrimes
{
    public static void main(String[]args)
    {
        PermsAndPrimes pl = new PermsAndPrimes();
        pl.runIt();
    }
    public void runIt()
    {
        Kattio io = new Kattio(System.in, System.out);

        int times = io.getInt();

        for(int i = 0; i < times; i++)
        {
            int n = io.getInt();

            if(n == 1)
            {
                System.out.println("1");
            }
            else if(n == 2)
            {
                System.out.print("2 1");
            }
            else if(n%2 == 0)
            {
                int[]odd;

                if(n%2 == 1)
                    odd = new int[n/2 + 1];
                else
                    odd = new int[n/2];

                int[]even = new int[n/2];

                int times2 = 0;
                for(int j = 0; j < n/2; j++)
                {
                    if(prime(odd[j]+even[j]))
                        times2++;
                    int[]arrCheck = new int[i];
                    for(int k = 0; k <= n/2; k++)
                    {
                        
                    }
                }

                for(int j = 0; j < n/2; j++)
                {
                    System.out.println(odd[j] + " " + even[j]);
                    if(j != n/2 - 1)
                        System.out.println(" ");
                }
                if(odd.length > even.length)
                    System.out.println(" " + odd[odd.length-1] + "");
            }
            System.out.println("");
        }
    }
    public boolean prime(int num)
    {
        boolean bool = true;
        for(int i = 1; i <= num; i++)
        {
            if(i != 1 || i != num)
            {
                if(num%i == 0)
                {
                    bool = false;
                    break;
                }
            }
        }
        return bool;
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
	super(new BufferedOutputStream(System.out));
	r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
	super(new BufferedOutputStream(o));
	r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
	return peekToken() != null;
    }

    public int getInt() {
	return Integer.parseInt(nextToken());
    }

    public double getDouble() { 
	return Double.parseDouble(nextToken());
    }

    public long getLong() {
	return Long.parseLong(nextToken());
    }

    public String getWord() {
	return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
	if (token == null) 
	    try {
		while (st == null || !st.hasMoreTokens()) {
		    line = r.readLine();
		    if (line == null) return null;
		    st = new StringTokenizer(line);
		}
		token = st.nextToken();
	    } catch (IOException e) { }
	return token;
    }

    private String nextToken() {
	String ans = peekToken();
	token = null;
	return ans;
    }
}