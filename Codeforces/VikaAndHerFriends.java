import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class VikaAndHerFriends
{
    public static void main(String[]args)
    {
        VikaAndHerFriends vahf = new VikaAndHerFriends();
        vahf.runIt();
    }
    public void runIt()
    {
        Kattio io = new Kattio(System.in, System.out); 
        int times = io.getInt();
        for(int i = times; i > 0; i--)
        {
            io.getInt();
            io.getInt();
            int k = io.getInt();
            int x = io.getInt();
            int y = io.getInt();
            String answer = "YES";
            for (int j = 0; j < k; j++) 
            {
                int x2 = io.getInt();
                int y2 = io.getInt();
                if ((x + y) % 2 == (x2 + y2) % 2) 
                    answer = "NO";
            }
            System.out.print(answer + "\n");
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