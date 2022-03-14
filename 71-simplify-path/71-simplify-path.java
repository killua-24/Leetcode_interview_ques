class Solution {
    public String simplifyPath(String path) {
   
        String[] fold = path.split("/");
        StringBuilder sb = new StringBuilder();
        List<String> al = new ArrayList<>();
        for(int i = 1 ; i < fold.length ; i++){
            if(fold[i].equals("..") ){
                if(al.size() >0) al.remove(al.size()-1);
            }else if(fold[i].equals(".")) continue;
            else{
                if(fold[i].length() != 0)
                al.add(fold[i]);
            }
        }

        for(String a : al){
            sb.append("/");
            sb.append(a);
            
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}