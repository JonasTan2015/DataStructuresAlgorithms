public class Solution {
    public String countAndSay(int n) {
        if(n==1)return "1";
        StringBuilder cur=new StringBuilder("1");
        StringBuilder pre;
        for(int i=1;i<n;i++){
            pre=cur;
            cur.setLength(0);
            int count=1;
            
            char say=pre.charAt(0);
	 	        
	 	        for (int j=1,len=pre.length();j<len;j++){
	 	        	if (pre.charAt(j)!=say){
	 	        		cur.append(count).append(say);
	 	        		count=1;
	 	        		say=pre.charAt(j);
	 	        	}
	 	        	else count++;
	 	        }
	 	        cur.append(count).append(say);
			System.out.println(cur.toString());
        }
        return cur.toString();
        
        
    }
	
	public static void main(String[] args){
		Solution s=new Solution();
		s.countAndSay(3);
	}
}