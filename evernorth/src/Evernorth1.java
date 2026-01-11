import java.util.HashMap;
import java.util.Map;

public class Evernorth1 {
    public static void main(String[] args) {
        String str = "Chiluguraju Sai Kumar";
        str = str.replaceAll(" ","");
        Map<Character,Integer> map =new HashMap<>();

        for(int i = 0;i<str.length();i++)
        {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        System.out.println(map);
        char output = ' ';
        int val = -1;

        for(char c : map.keySet())
        {
            if(map.get(c) > val)
            {
                val = map.get(c);
                output = c;
            }
        }
        System.out.println("hightest repeated char is " + output);
    }
}
