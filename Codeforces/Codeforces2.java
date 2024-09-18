import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Codeforces2 
{
    public static void main(String[]args)
    {
        Codeforces2 cf = new Codeforces2();
        cf.runIt();
    }
    public void runIt()
    {
        Kattio io = new Kattio(System.in, System.out);
        int times = io.getInt();
        for(int i = times; i > 0; i--)
        {
            int responseNum = io.getInt();
            int [][]arr = new int[responseNum][2];
            for(int j = 0; j < responseNum; j++)
            {
                arr[j][0] = io.getInt();//num words
                arr[j][1] = io.getInt();//quality
            }
            int quality = 0;
            for(int j = 0; j < responseNum; j++)
            {
                if(arr[j][0] <= 10 && arr[j][1] >= quality)
                {
                    quality = arr[j][1];
                }
            }
            int num = 0;
            boolean done = false;
            for(int j = 0; j < responseNum; j++)
            {
                if(!done)
                {
                    num++;
                }
                if(!done && quality == arr[j][1])
                {
                    done = true;
                }
            }
            System.out.println("" + num);
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