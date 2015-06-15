/*
 * Reg Ex implementation 
 * Wild card *(0 or more char) and ?(1 char)
 */
package LeetCodeProblems;

/**
 *
 * @author Abhay Kawale
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        rem.testCases();
    }
    
    private void testCases(){
        System.out.println(isMatch("geeks","g*ks"));//YES
        System.out.println(isMatch("geeksforgeeks","ge.ks*"));//YES
        System.out.println(isMatch("gee","g*k"));//NO
        System.out.println(isMatch("pqrs","*pqrs"));//YES
        System.out.println(isMatch("abcdhghgbcd","abc*bcd"));//YES
        System.out.println(isMatch( "abcd","*.c*d"));//YES
        System.out.println(isMatch( "abcd","abc*c?d"));// NO
    }

    public boolean isMatch(String s,String p) {

        if (p == null) {
            return s == null;
        }

        if (p.length()==0){
            return s.length()==0;
        }
        
        
        if (s.length() == 0 && !p.equals("*")) {
            return false;
        }
        
        if (p.length() == 1) {

            if (s.length() < 1) {
                return false;
            }
            if (p.charAt(0) == '*') {
                return true;
            }
            if (p.charAt(0) == '.') {
                return s.length() == 1;
            } else {
                return s.length() == 1 && s.charAt(0) == p.charAt(0);
            }
        }

        if (p.charAt(0) != '*') {
            return ((p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                    && (isMatch(s.substring(1), p.substring(1))));
        } else if (p.charAt(0)=='*') {
            return (isMatch(s, p.substring(1))||(isMatch(s.substring(1), p)));
        } 
        return false;
    }
    
}
