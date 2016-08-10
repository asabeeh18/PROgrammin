class Palindrome {
    public static boolean isPalindrome(String str) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        char[] s=new char[str.length()];//str.replace(' ','\0').replace('.','\0').toCharArray();
        int top=0;
        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if(c=='.' || c==' ')
                continue;
            s[top]=c;
            top++;
        }
        int n=s.length;
        for(int i=0;i<top/2;i++) {
            //if(s[i]!=s[n-i-1])
            
            if(s[i]!=s[top-i-1]) {
				if(s[i]<'a' && s[top-i-1]<'a') {
                	    return false;
            	}	
                else if(s[i]>='a' && s[top-i-1]>='a')
                    return false;
            }
		}
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Noel ses Leon."));
    }
}