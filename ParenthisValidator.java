package ParenthesisValidation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthisValidator {

  public static void main(String args[]) {

    System.out.println(isValid("()()()()()"));

  }

  public static boolean isValid(String s) {

    Stack<Character> stack = new Stack<>();
    Map<Character, Character> mp = new HashMap<>();
    mp.put(')', '(');
    mp.put(']', '[');
    mp.put('}', '{');

    for (Character parens : s.toCharArray()) {

      // first check if current parens is a closing parenthesis
      if (mp.containsKey(parens)) {

        // if parens is closing parenthesis, confirm that our stack of opening
        // parenthesis is not empty AND that the top value
        // is the closing paren's opening parenthesis as set up in the hashmap
        if (!stack.isEmpty() && stack.peek() == mp.get(parens)) {

          // If the top of the stack is the opening parenthesis, remove that
          // from that stack because it is properly matched to its closing (which is
          // the current parens)

          System.out.println(stack.peek());
          stack.pop();

        } else {

          // If the top of the stack is not the opening parenthis, we can end the process
          // here because that would mean we have this -> ((} <-- parens in this example =
          // }
          // and the top of the stack = (. They don't match up so we're done
          return false;
        }
      } else {
        // parens is not a closing parenthesis so add it to the stack.
        // the stack will only ever contain opening parenthesis that will be
        // matched to the closing parenthis of the map whenever parens = a closing
        // parenthesis. As the values in the stack are matched to the values in the map
        // the stack is poped. When the stack is empty, we have also gone through the
        // entire
        // string so we can return true because everything matched
        stack.push(parens); // ((
      }
    }
    return stack.isEmpty();

  }

}
