//Omar Abarca
public class Notation{

	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
	{
		NotationQueue<Character> workingQueue = new NotationQueue<>(infix.length());
		NotationStack<Character> workingStack = new NotationStack<>(infix.length());
		char[] character = infix.toCharArray();
		
		for(char workingChar : character)
		{
			if(workingChar == ' ')
				continue;
			
			else if(Character.isDigit(workingChar))
			{
				try {
					workingQueue.enqueue(workingChar);
					continue;
				} catch (QueueOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
			
			else if(workingChar == '(')
			{
				try {
					workingStack.push(workingChar);
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
			
			else if (workingChar == '*' || workingChar == '/' || workingChar == '+' || workingChar == '-') 
			{
				try {
				if (!workingQueue.isEmpty()) {
					char top = workingStack.top();
					if (top == '*' || top == '/' || workingChar == '-' && top == '-' || workingChar == '-' && top == '+'
							|| workingChar == '+' && top == '-' || workingChar == '+' && top == '+') {
						workingQueue.enqueue(workingStack.pop());

					}
				}
				workingStack.push(workingChar);
				continue;
				} catch(StackOverflowException | StackUnderflowException | QueueOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
			
			else if(workingChar == ')')
			{
				try {
				while (workingStack.top() != '(') {
					workingQueue.enqueue(workingStack.pop());
					if (workingStack.top() == null) {
						throw new InvalidNotationFormatException();
					}
				}
				workingStack.pop();
				} catch(StackUnderflowException | QueueOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
		}
		return workingQueue.toString();
	}
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException
	{
		NotationStack<String> workingStack = new NotationStack<>(postfix.length());
		
for (char workingChar : postfix.toCharArray()) {
            
            String nextChar = String.valueOf(workingChar);
            
            if(workingChar == ' ')
				continue;
            
            else if (Character.isDigit(workingChar)) 
            {
            	try {
					workingStack.push(nextChar);
					continue;
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
            } 
            
            else if (workingChar == '-' || workingChar == '+' || workingChar == '/' || workingChar == '*') 
            {
            	try {
                if (workingStack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }
                String first = workingStack.pop(), second = workingStack.pop();
                String result = '(' + second + workingChar + first + ')';
                workingStack.push(result);
            	} catch(StackUnderflowException | StackOverflowException e) {
            		throw new InvalidNotationFormatException();
            	}
            }
        }
        
        if (workingStack.size() > 2) {
            throw new InvalidNotationFormatException();
        }
        
        return workingStack.toString();
	}
	
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		NotationStack<Double> workingStack = new NotationStack<>(postfixExpr.length());
		char[] character = postfixExpr.toCharArray();

			for (char workingChar : character) {
				
				if (workingChar == ' ') 
					continue;
				
				else if (Character.isDigit(workingChar) || workingChar == '(') 
				{
					try {
						workingStack.push(Double.parseDouble(Character.toString(workingChar)));
						continue;
					} catch (StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}
				}
				
				else if (workingChar == '*' || workingChar == '/' || workingChar == '+' || workingChar == '-') 
				{
					try {
					if (workingStack.size() < 2) 
					{
						throw new InvalidNotationFormatException();
					}
					
					double right = workingStack.pop(), left = workingStack.pop();

					switch (workingChar) {
					case '*':
						workingStack.push(left * right);
						break;
					case '/':
						workingStack.push(left / right);
						break;
					case '+':
						workingStack.push(left + right);
						break;
					case '-':
						workingStack.push(left - right);
						break;
						}
					} catch(StackUnderflowException | StackOverflowException e) {
	            		throw new InvalidNotationFormatException();
	            	}
				}
			}
			
		if (workingStack.size() > 2) 
		{
			throw new InvalidNotationFormatException();
		}

		return Double.parseDouble(workingStack.toString());
	}
}
