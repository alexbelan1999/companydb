package by.vsu;
import java.util.Vector;

import by.vsu.mf.ai.ssd.strings.*;
class LocalhostJob implements Job {
	@Override
	public void perform(StringBuilder s) {				
		 String sub1;
	        String sub2;
	        String sub3;
	        Vector<Integer> startarr = new Vector<Integer>();
	        Vector<Integer> endarr = new Vector<Integer>();
	        boolean flag1 = true;
	        boolean flag2 = false;
	        int count = 0;
	        for (int n = 0; n < s.length(); n++) {
	        	char startindex = s.charAt(n);
	        	char endindex = s.charAt(n);
	        	if (startindex =='(') {
	        		
	        		count++;
	        	}
	        	
	        	if ((startindex =='(') && flag1) {
	        		flag1 = false;
	        		flag2 = true;
	        		startarr.add(n);
	        	}
	        	if (startindex == ')' && flag2) {
	        		
	        		count--;
	        	}
	        	if ((endindex ==')') && flag2 && (count == 0)) {
	        		flag1 = true;
	        		flag2 = false;
	        		count = 0;
	        		endarr.add(n);
	        	}
	        }
	 
	        if (startarr.size()==0 || endarr.size()==0) {
	        	
	        }
	        else {
	        	 if (startarr.get(startarr.size()-1)>endarr.get(endarr.size()-1)) {
	 	        	startarr.remove(startarr.size()-1);
	 	        }
	        	StringBuilder str= new StringBuilder();
		        String resultstring = s.toString();
		        for (int i = 0; i < startarr.size(); i++)
		        {
		        	
		        	 if (startarr.size()==1) 
		        	 {
		        		 sub1 =resultstring.substring(0,startarr.get(i));
		        		 str.append(sub1).append("[").append(startarr.elementAt(i).toString()).append("]");
		        		 sub3 = resultstring.substring(endarr.elementAt(i)+1);
		        		 str.append(sub3);
		        	 }
		        	 else 
		        	 {
		        		 if (i == 0) {
		            		 sub1 = resultstring.substring(0, startarr.elementAt(i));
		            		 str.append(sub1).append("[").append(startarr.elementAt(i).toString()).append("]");
		            		 sub3 = resultstring.substring(endarr.elementAt(i)+1, startarr.elementAt(i+1));
		            		 str.append(sub3).append("[").append(startarr.elementAt(i+1).toString()).append("]");
		            	 }
		        		 else 
		        		 {
		            		 if (i == startarr.size()-1) 
		            		 {
		                		 sub2 = resultstring.substring(endarr.elementAt(i)+1);
		                		 str.append(sub2);
		                		 
		                	 }
		            		 else 
		            		 {
		                		 sub3 = resultstring.substring(endarr.elementAt(i)+1, startarr.elementAt(i+1));
		                		 str.append(sub3).append("[").append(startarr.elementAt(i+1).toString()).append("]");
		                	 }
		            	 }
		            	 
		            }
		        }
		        s.delete(0, s.length()-1).append(str);
	        }
	         
	        	 
	}
}

public class task3 {
	public static void main(String[] args) {
		Manager.createWindow(new LocalhostJob());
	}
}


