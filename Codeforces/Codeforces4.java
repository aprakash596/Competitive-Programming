import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Arrays;

public class Codeforces4
{
    public static void main(String[]args)
    {
        Codeforces4 cf = new Codeforces4();
        cf.runIt();
    }
    public void runIt()
    {
        Kattio io = new Kattio(System.in, System.out);
        int times = io.getInt();
        for(int i = times; i > 0; i--)
        {
            int numProb = io.getInt();
            int numDif = io.getInt();
            int[]arr = new int[numProb];
            for(int j = 0; j < numProb; j++)
            {
                arr[j] = io.getInt();
            }
            Arrays.sort(arr);
            int remove = 0;
            for(int j = 1; j < numProb; j++)
            {
                if(arr[j]-arr[j-1] > numDif)
                {
                    if(j < numProb/2)
                    {
                        numProb+=j;
                    }
                    else if(j >= numProb/2)
                    {
                        remove = numProb-j;
                    }
                }
            }
            System.out.println("" + remove);
        }
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