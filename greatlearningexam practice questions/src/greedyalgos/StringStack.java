package greedyalgos;

public class StringStack {
    public static void main(String[] args) {
        String pat = "dicxdcubad";
        String tar = "dia";

        boolean ans = stringStack(pat,tar);
        System.out.println(ans);
    }
    public static boolean stringStack(String pat, String tar) {
        // code here

        int i = pat.length()-1,j=tar.length() -1;
        StringBuilder s= new StringBuilder();
        int count = 0;

        while(i>=0 && j>=0)
        {
            if(pat.charAt(i) == tar.charAt(j) &&
                    (s.length() == 0 ||
                    (s.length() > 0
                            && s.charAt(0) == tar.charAt(j+1))))
            {
                s.insert(0,pat.charAt(i));
                i--;
                j--;
            }
            else
            {
                if(s.length() == 0)
                {
                    i--;
                    continue;
                }
                if(!s.toString().equals(tar.substring(j+1)))
                {
                    s.deleteCharAt(0);
                }
                else
                {
                    s.insert(0,pat.charAt(i));
                }
                i--;
            }
            //System.out.println(i+" "+s);
        }

        return s.toString().equals(tar);
    }
}
