import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Codeforces3 
{
    public static void main(String[]args)
    {
        Codeforces3 cf = new Codeforces3();
        cf.runIt();
    }
    public void runIt()
    {
        Kattio io = new Kattio(System.in, System.out);
        int times = io.getInt();
        for(int i = times; i > 0; i--)
        {
            String answer = "";
            String line = io.getWord() + io.getWord() + io.getWord() + io.getWord() + io.getWord() + io.getWord() + io.getWord() + io.getWord();
            for(int j = 0; j < line.length(); j++)
            {
                if(line.charAt(j) != '.')
                answer += "" + line.charAt(j);
            }
            System.out.println("" + answer);
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