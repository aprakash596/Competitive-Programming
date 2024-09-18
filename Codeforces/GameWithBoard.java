import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class GameWithBoard 
{
    public static void main(String[]args)
    {
        GameWithBoard gwb = new GameWithBoard();
        gwb.runIt();
    }
    public void runIt()
    {
        Kattio io = new Kattio(System.in);
        String output = "";
        int numTimes = io.getInt();
        for(int i = 0; i <numTimes; i++)
        {
            int input = io.getInt();
            int[]arr = new int[input];
            if(input == 1)
                output+= "1";
            else
            {
                for(int j = 0; j < input; j++)
                {
                    arr[j] = io.getInt();
                }
                for(int k = 0; k < input; k++)
                {
                    String line = "";
                    for(int l = 0; l < k; l++)
                    {
                        if(l == 0)
                            line += "" + arr[l];
                        else
                            line+= "," + arr[l];
                    }
                    String[] strArray = line.split(",");
                    int[] intArray = new int[strArray.length];
                    for(int l = 0; l < strArray.length; l++) 
                    {
                        intArray[l] = Integer.parseInt(strArray[l]);
                    }
                    boolean bool = checker(intArray);
                    int appended = 0;
                    while(!bool && appended < intArray.length)
                    {
                        int saver = intArray[0];
                        appended++;
                        for(int l = 1; l < intArray.length; l++)
                        {
                            intArray[l-1] = intArray[l];
                        }
                        intArray[intArray.length-1] = saver;
                        bool = checker(intArray);
                    }
                    if(bool)
                        output += "1";
                    else
                        output += "0";
                }
                output += "\n";
            }
        }
        System.out.print("" + output);
    }
    public boolean checker(int[]data)
    {
        for (int i = 0; i < data.length-1; i++) {
            if (data[i] < data[i+1]) {
                return false;
            }
        }
        return true;
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
