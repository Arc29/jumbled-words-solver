import java.util.*;
import java.io.*;
class JumbleWdSolvr{
    
    ArrayList<String> order(String n){
        
        String a;char k;
        if(n.length()<=2){
            ArrayList<String> arr=new ArrayList<>();
            arr.add(n);
            arr.add(rev(n));
            return arr;
        }
        ArrayList<String> arr=new ArrayList<>();
        for(int i=0;i<n.length();i++){
            k=n.charAt(i);a="";
            for(int j=0;j<n.length();j++){
              if(i==j)
              continue;
              a=a+n.charAt(j);
            }
            arr.addAll(arr.size(),combine(k,order(a)));
        }
        return arr;
    }
    String rev(String n){
        String r="";
        for(int i=n.length()-1;i>=0;i--)
        r=r+n.charAt(i);
        return r;
    }
    ArrayList<String> combine(char n,ArrayList<String> arr){
        ListIterator<String> it=arr.listIterator();
        while(it.hasNext()){
        String x=it.next();
        it.set(n+x);
    }
    return arr;
}

public static void main(String args[])throws IOException{
    java.util.Set<String> dictionary = new HashSet<String>();
    BufferedReader br = null;
      try {
         br = new BufferedReader(new FileReader(new File("brit-a-z.txt")));
         String availalbe;
         while((availalbe = br.readLine()) != null) {
             dictionary.add(availalbe.toUpperCase());            
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (br != null) {
            try {
               br.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
    JumbleWdSolvr o=new JumbleWdSolvr();
    Scanner in=new Scanner(System.in);
    boolean flag=true;
    while(flag){
    System.out.println("Enter jumbled word");
    String s=in.next();
    s=s.toUpperCase().trim();
    ArrayList<String> arr=o.order(s);
    for(String str:arr)
    if(dictionary.contains(str)){
    System.out.println(str);break;}
    System.out.println("More words?(y/Y for affirmative)");
    char c=in.next().charAt(0);
    if(!(c=='y'||c=='Y'))
    flag=false;
}
}
}
        