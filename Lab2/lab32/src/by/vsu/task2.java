package by.vsu;

import java.util.Vector;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class task2 {
	public static String Index(StringBuilder s){
        String sub1;
        String sub2;
        String sub3;
        Vector<Integer> startarr = new Vector<Integer>();
        Vector<Integer> endarr = new Vector<Integer>();
        Vector<String> stringarr = new Vector<String>();
        Vector<String> resultarr = new Vector<String>();
        boolean flag1 = true;
        boolean flag2 = false;
        int count = 0;
        for (int n = 0; n < s.length(); n++) {
        	char startindex = s.charAt(n);
        	char endindex = s.charAt(n);
        	if ((startindex =='(') ){
        		System.out.println("+1");

        		count++;
        	}
        	
        	if ((startindex =='(') && flag1) {
        		flag1 = false;
        		flag2 = true;
        		startarr.add(n);
        	}
        	if (startindex == ')' && flag2) {
        		System.out.println("-1");
        		count--;
        	}
        	if ((endindex ==')') && flag2 && (count == 0)) {
        		flag1 = true;
        		flag2 = false;
        		count = 0;
        		endarr.add(n);
        	}
        }
        
        
        System.out.println(startarr);
        System.out.println(endarr);
        if (startarr.size()==0 || endarr.size()==0) {
            return s.toString();
        }
        if (startarr.get(startarr.size()-1)>endarr.get(endarr.size()-1)) {
        	startarr.remove(startarr.size()-1);
        }
        System.out.println(stringarr); 
        StringBuilder str= new StringBuilder();
        String resultstring = s.toString();
        for (int i = 0; i < startarr.size(); i++)
        {
        	 System.out.println(i);
        	 if (startarr.size()==1) {
        		 sub1 =resultstring.substring(0,startarr.get(i));
        		 str.append(sub1).append("[").append(startarr.elementAt(i).toString()).append("]");
        		 sub3 = resultstring.substring(endarr.elementAt(i)+1);
        		 str.append(sub3);
        	 }else {
        		 if (i == 0) {
            		 sub1 = resultstring.substring(0, startarr.elementAt(i));
            		 str.append(sub1).append("[").append(startarr.elementAt(i).toString()).append("]");
            		 sub3 = resultstring.substring(endarr.elementAt(i)+1, startarr.elementAt(i+1));
            		 str.append(sub3).append("[").append(startarr.elementAt(i+1).toString()).append("]");
            	 }else {
            		 if (i == startarr.size()-1) {
                		 sub2 = resultstring.substring(endarr.elementAt(i)+1);
                		 str.append(sub2);
                		 
                	 }else {
                		 sub3 = resultstring.substring(endarr.elementAt(i)+1, startarr.elementAt(i+1));
                		 str.append(sub3).append("[").append(startarr.elementAt(i+1).toString()).append("]");
                	 }
            	 }
            	 
            	}
        	}
        	 
        System.out.println(str);
        System.out.println(resultarr);
        return str.toString();
    }
	public static void main(String[] args) {
        StringBuilder s= new StringBuilder();
        for (int i=0;i<args.length;i++){
            s.append(args[i]).append(" ");
        }
        System.out.println(Index(s));
    } 

}
