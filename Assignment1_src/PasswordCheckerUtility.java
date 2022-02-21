import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CMSC 204
 * 
 * @Author Omar Abarca
 *
 */
public class PasswordCheckerUtility {
	public static boolean isValidPassword(String password) throws LengthException, NoDigitException, NoUpperAlphaException, 
	NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException
	{
		isValidLength(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasBetweenSixAndNineChars(password);
		hasDigit(password);
		hasSpecialChar(password);
		hasSameCharInSequence(password);
		return true;
	}
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		if(hasBetweenSixAndNineChars(password))
			return true;
		else if (password.length() > 9)
		return false;
		throw new WeakPasswordException();
	}
	
public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) throws UnmatchedException
	{
		if(password.equals(passwordConfirm))
			return true;
		else
			throw new UnmatchedException();
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) 
	{
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (int s = 0 ; s < passwords.size() ; s++) 
		{ 
			try {
				isValidPassword(passwords.get(s));
			} 
			catch (LengthException e) 
			{
				invalidPasswords.add(s + " " + e.getMessage());
			} 
			catch (NoUpperAlphaException e) 
			{
				invalidPasswords.add(s + " " + e.getMessage());
			} 
			catch (NoLowerAlphaException e) 
			{
				invalidPasswords.add(s + " " + e.getMessage());
			} 
			catch (NoDigitException e) 
			{
				invalidPasswords.add(s + " " + e.getMessage());
			} 
			catch (NoSpecialCharacterException e) 
			{
				invalidPasswords.add(s + " " + e.getMessage());
			} 
			catch (InvalidSequenceException e) 
			{
				invalidPasswords.add(s + " " + e.getMessage());
			}

		}

		return invalidPasswords;
	}
	
	public static boolean isValidLength(String password) throws LengthException
	{
		if(password.length() < 6)
			throw new LengthException();
		return true;
	}
	
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		if(password.length() >= 6 && password.length() <= 9)
			return true;
		return false;
	}
	
	public static boolean hasDigit(String password) throws NoDigitException
	{
		char[] passwordDigit = password.toCharArray();  
		for(int i = 0; i < passwordDigit.length; i++)
		{
			if(Character.isDigit(passwordDigit[i]))
				return true;
		}
		throw new NoDigitException();
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		char[] passwordUpper = password.toCharArray();  
		for(int i = 0; i < passwordUpper.length; i++)
		{
			if(Character.isUpperCase(passwordUpper[i]))
				return true;
		}
		throw new NoUpperAlphaException();
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		char[] passwordLower = password.toCharArray();  
		for(int i = 0; i < passwordLower.length; i++)
		{
			if(Character.isLowerCase(passwordLower[i]))
				return true;
		}
		throw new NoLowerAlphaException();
	}
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		boolean result = matcher.matches();
		if(result)
			throw new NoSpecialCharacterException();
		else
			return true;	
		}
	
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException
	{
		Pattern pattern = Pattern.compile(".*(.)\\1\\1.*");
		Matcher matcher = pattern.matcher(password);
		boolean result = matcher.matches();
		if(result)
			throw new InvalidSequenceException();
		else
			return true;
	}
}
