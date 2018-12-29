package application;

import java.util.HashMap;

public class UsernamePW {
    public HashMap<String, String> hashmap = new HashMap<String, String>();
    public UsernamePW() {
	    // Adding Key and Value pairs to HashMap
	    hashmap.put("abc","Chaitanya");
	    hashmap.put("abcde","Pratap");
	    hashmap.put("robin1102","Singh");
	    hashmap.put("janice","Rajesh");
	    hashmap.put("soccerbballkate","Kate");	 
	    hashmap.put("21panr", "21djopsc");
	    hashmap.put("hi", "hola");
 }
    public void addUser(String user, String pw) {
    	hashmap.put(user, pw);
    }
    public boolean userExists(String user) {
        // Checking Key Existence
        boolean flag = hashmap.containsKey(user);
        return flag;
    }
    public boolean correctPW(String pw) {
    	boolean passw = hashmap.containsValue(pw);
    	return passw;
    }
    public HashMap<String,String> getHashMap(){
    	return hashmap;
    }
}