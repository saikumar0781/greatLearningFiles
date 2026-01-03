//leetcode 3433
package leetcode121225;


import java.util.ArrayList;
import java.util.List;

public class CountMentionsPerUser {
    public static void main(String[] args) {
        int n = 2;
        List<List<String>> list = new ArrayList<>();
        String[][] arr = {{"MESSAGE","2","HERE"},{"OFFLINE","2","1"},{"OFFLINE","1","0"},{"MESSAGE","61","HERE"}};

        for(int i = 0;i<arr.length;i++)
        {
            List<String> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);
            temp.add(arr[i][2]);
            list.add(temp);
        }
        //System.out.println(list);
        int[] output = new CountMentionsPerUser().countMentions(2,list);

        for(int i = 0;i<output.length;i++)
            System.out.println(output[i]);

    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        User[] users = new User[numberOfUsers];
        for(int i = 0;i<users.length;i++)
        {
            users[i] = new User("ONLINE",0,0);
        }

        for(int i = 0;i<events.size();i++)
        {
            List<String> list = events.get(i);
            if(list.get(0) == "OFFLINE")
            {
                int id = Integer.parseInt(list.get(2));
                users[id].status = "OFFLINE";
                users[id].timestamp = Integer.parseInt(list.get(1));
            }
            else if (list.get(0) == "MESSAGE" && (!list.get(2).equals("HERE") && !list.get(2).equalsIgnoreCase("ALL"))){
                String[] arr = list.get(2).split(" ");

                for(int  j= 0;j<arr.length;j++) {
                    int id = Integer.parseInt(arr[j].substring(2));
                    if (!users[id].status.equals("OFFLINE")) {
                        users[id].count += 1;
                        users[id].timestamp = Integer.parseInt(list.get(1));
                        users[id].status = "ONLINE";
                    } else if (users[id].status.equals("OFFLINE") && users[id].timestamp != 0
                            && Integer.parseInt(list.get(1)) - users[id].timestamp >= 60) {
                        users[id].count += 1;
                        users[id].timestamp = Integer.parseInt(list.get(1));
                        users[id].status = "ONLINE";
                    }
                }
            }
            else if(list.get(2).equals("ALL"))
            {
                for(int k =0 ;k<users.length;k++)
                {
                    users[k].count += 1;
                }
            }
            else if(list.get(2).equals("HERE"))
            {
                for(int l =0 ;l<users.length;l++)
                {
                    if(users[l].status.equals("ONLINE") || (Integer.parseInt(list.get(1)) - users[l].timestamp >= 60))
                        users[l].count += 1;
                }
            }
        }
        int[] counts = new int[users.length];
        for(int i = 0;i<users.length;i++)
        {
            counts[i] = users[i].count;
        }
        return counts;
    }
    static class User
    {
        String status;
        int timestamp;
        int count;
        public User(String status, int timestamp,int count)
        {
            this.status = status;
            this.timestamp = timestamp;
            this.count = count;
        }
    }
}
