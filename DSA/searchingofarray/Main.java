public class Main{
    public static void main(String[] args){
        char s = 'y';
        String str = "Tyson";
        int result = index(str,s);
        if(result != -1){
            System.out.println("Target element character is : "+result);
        }else{
            System.out.println("Target character cannot exist");
        }
    }
    public static int index(String str,char s){
        for(int i=0;i<str.length();i++){
            if(s == str.charAt(i))
            {
                return i;
            }
        }
        return -1;
    }
}

