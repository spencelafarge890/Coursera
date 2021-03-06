import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
            	Bracket b = new Bracket(next, position+1);
            	opening_brackets_stack.push(b);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
            	Bracket top = opening_brackets_stack.pop();
            	if(!top.Match(next)) {
            		errorPosition = position + 1;
            		break;
            }
        }

            	// Printing answer, write your code here
            if(errorPosition ==0 && opening_brackets_stack.empty())
    			System.out.println("Success");
            
    		else {
    			if(errorPosition == 0) {
    				while(opening_brackets_stack.size()>1)
    					opening_brackets_stack.pop();
    				errorPosition = opening_brackets_stack.peek().position;
    			}
    			System.out.println(errorPosition);
    }
}
