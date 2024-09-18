
import java.io.*;
import java.util.*;

public class CowntactTracing 
{
    public static void main (String[]args)
    {
        CowntactTracing ct = new CowntactTracing();
        try
        {
            ct.runner();
        }
        catch(IOException e){}
    }
    public void runner() throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (f.readLine());

        int numCow = Integer.parseInt (st.nextToken());

        st = new StringTokenizer (f.readLine());
        int line = Integer.parseInt (st.nextToken());

        String str = "" + line;
        String line1 = "";
        int count = 0;
        int saveCount = 1;
        
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '0')
                line1 += " ";
            else
                line1 += "" + str.charAt(i);
        }
        if(line1.charAt(0) == '1')
            line1 = "1" + line1;
        if(line1.charAt(line1.length()-1) == '1')
            line1 += "1";
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '1')
            {
                count++;
            }
            else if(str.charAt(i) == ' ' && count > 0)
            {
                if((count < saveCount && saveCount != 0)||saveCount == 1)
                {
                    saveCount = count;
                    count = 0;
                }
            }
        }
        if(saveCount == 1)
        {
            saveCount = count;
            count = 0;
        }
        
        int ans = 0;
        if(saveCount%2 == 1)
            ans = saveCount/2;
        else
            ans = (saveCount/2)-1;
        
        int total = 0;
        count = 0;
        for(int i = 0; i < str.length(); i++)
        {
            //System.out.println(" " + count);
            if(str.charAt(i) == '1')
            {
                count++;
            }
            else if((str.charAt(i) == ' ' && count > 0))
            {
                total += count - 2*ans;
                if(count <= 1)
                {
                    total = 0;
                    break;
                }
                count = 0;
            }
            if(str.charAt(i) == '1' && i == str.length()-1)
            {
                total += count - 2*ans;
                if(count <= 1)
                {
                    total = 0;
                    break;
                }
                count = 0;
            }
        }

        System.out.println("" + total);
    }
}
