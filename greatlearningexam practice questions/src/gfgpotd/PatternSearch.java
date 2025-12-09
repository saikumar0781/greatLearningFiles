package gfgpotd;
import java.util.*;
public class PatternSearch {
    public static void main(String[] args) {
        String txt = "gggg";
        String pat = "gg";
        System.out.println(search(pat,txt));
    }
    static ArrayList<Integer> search(String pat, String txt)
    {

        ArrayList<Integer> list = new ArrayList<>();

        int n = txt.length();
        int p = pat.length();

        int i=0;
        while(true)
        {
            String s = txt.substring(i,n);
            //System.out.println(s);
            int index = s.indexOf(pat);
            //System.out.println(index);
            if(index!=-1)
            {
                list.add(index+1+i);
                i += index+1;
            }
            else break;
        }
        if(list.size()==0) list.add(-1);
        return list;
    }
}
