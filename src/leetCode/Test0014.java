package leetCode;

public class Test0014 {
    public String longestCommonPrefix(String[] strs) {
        if( strs == null && strs.length < 2){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for(int i = 1 ; i < strs.length; i++ ){
            if(strs[i].length()<strs[index].length()){
                index = i;
            }
        }
        int temp = strs[index].length();
        for(int i = 0 ; i < temp ; i ++){
            String str = strs[0].substring(i,i+1);
            for(int j = 1 ; j < strs.length ; j++){
                if(!str.equals(strs[j].substring(i,i+1))){
                    break;
                }
            }
            builder.append(str);
        }
        return builder.toString();
    }
}
