package UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class InvalideDateException extends Exception 
{
	InvalideDateException(String s) 
	   {
	      super(s);
	   }
	}
public class DateValidator {
 
	
	public static boolean isValidFormat(String format, String value) 
	{
        Date date = null;
        
        try 
        {
        	
            date = new SimpleDateFormat(format).parse(value);
            System.out.println("Date in fun :"+date);
        
        } 
        catch (ParseException ex) 
        {
            ex.printStackTrace();
        }
        
        return date != null;
    }
	
	
	
	
	public static void main(String args[])
	{
		try
		{
			System.out.println("Enter Date: ");
			String dt="1887-10-19";
			boolean val= new DateValidator().isValidFormat("dd-MM-yyyy",dt);
			System.out.println("Date :"+val);
			if(val==false)
			{
				throw new InvalideDateException("Invalid Date Formate..!!");
			}
			
		}
		catch (InvalideDateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}