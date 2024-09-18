
import java.io.*;
import java.util.*;

public class CandyCaneFeast
{
    long[]Nheight;
    long[]Mheight;
    long start;
    public static void main (String[]args)
    {
        CandyCaneFeast ccf = new CandyCaneFeast();
        try
        {
            ccf.runner();
        }
        catch(IOException e){}
    }
    public void runner() throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (f.readLine());

        long N = (long)Integer.parseInt (st.nextToken());
        long M = (long)Integer.parseInt (st.nextToken());

        st = new StringTokenizer (f.readLine());
        Nheight = new long[(int)N];
        for(int i = 0; i < N; i++)
            Nheight[i] = (long)Integer.parseInt (st.nextToken()) ;;
        
        st = new StringTokenizer (f.readLine());
        Mheight = new long[(int)M];
        for(int i = 0; i < M; i++)
            Mheight[i] = (long)Integer.parseInt (st.nextToken()) ;;

        for(int i = 0; i < M; i++)
        {
            start = 0;
            for(int j = 0; j < N; j++)
            {
                long add = oneCaneSim(j,Mheight[i]);
            }
            
        }
        for(int i = 0; i < N; i++)
        {
            System.out.println("" + Nheight[i]);
        }
    }
    public long oneCaneSim(int in, long end)
    {
        long saveNum = 0;
        long thing = 0;
        
        if(Nheight[in] >= start && end - start > 0 && Nheight[in] <= end)
        {
            thing = Nheight[in] - start;
            Nheight[in] += thing;
            start += thing;
        }
        else if (Nheight[in] > end)
        {
            thing = end - start;
            Nheight[in] += thing;
            start += thing;
        }
        return saveNum;
    }
}