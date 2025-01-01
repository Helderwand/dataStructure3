import java.util.Stack;
public class MuseumSecuritySystem extends Accounts{
    /*
    * ı am checking they use only letter or something else
    * */
    public static boolean checkIfValidUsername(String usernames) {
        if (usernames.length() == 0) {
            return true;
        } else {
            char c = usernames.charAt(0);
            boolean isLetter = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
            return isLetter && checkIfValidUsername(usernames.substring(1));
        }
    }
    /*
     * ı am checking contains at least one letter between username and pass1
     * code iterates characters in pass1 and checks if it matches the top element in the stack
     * */

    public static boolean containsUserNameSpirit(String username, String password1) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < username.length(); i++) {
            char temp = username.charAt(i);
            if (password1.contains(String.valueOf(temp))) {
                stack.push(temp);
            }
        }
        for (int i = 0; i < password1.length(); i++) {
            char temp = password1.charAt(i);
            if (!stack.isEmpty() && temp == stack.peek()) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /*
     * I am checking pass1 is a balanced of parantheses and brackets
     * */
    public static boolean isBalancedPassword(String password1) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < password1.length(); i++) {
            char c = password1.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if ((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /*
     * ı am checking pallindrom possible at pass1 , ı am doing it cheking without brackets.
     * * we are excluding the first char . And we will check it in here for continue
     * */
    public static boolean isPalindromePossible(String password1) {
        if (password1.length() == 0) {
            return true;
        }

        char c = password1.charAt(0);
        if (c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
            return isPalindromePossible(password1.substring(1));
        } else {
            int lastIndex = password1.lastIndexOf(c);
            if (lastIndex == 0) {
                return isPalindromePossible(password1.substring(1));
            } else if (lastIndex == password1.length() - 1) {
                return isPalindromePossible(password1.substring(0, lastIndex));
            } else {
                return isPalindromePossible(password1.substring(1, lastIndex) + password1.substring(lastIndex + 1));
            }
        }
    }

    /*
     * we are changing the counter . And we will check it in here for countinue
     * */
    public boolean isExactDivision(int password2, int[] denominations,int counter) {
        if (password2 == 0) {
            return true;
        }
        if (counter == denominations.length) {
            return false;
        }

        // Recursive case
        if (denominations[counter] > password2) {
            return isExactDivision(password2, denominations, counter + 1);
        }
        return isExactDivision(password2 - denominations[counter], denominations, counter) || isExactDivision(password2, denominations, counter + 1);
    }

    public void IsItValid(Accounts user , MuseumSecuritySystem museum1){
        if (!museum1.checkIfValidUsername(user.username)) {
            System.out.println("Invalid username for "+user.username);
        } else if (!museum1.containsUserNameSpirit(user.username, user.password)) {
            System.out.println("Password does not contain username spirit for "+user.username);
        } else if (!museum1.isBalancedPassword(user.password)) {
            System.out.println("Invalid password(parantheses are not balanced) for "+user.username);
        } else if (!museum1.isPalindromePossible(user.password)) {
            System.out.println("Invalid password for "+user.username);
        } else if (!museum1.isExactDivision(user.password2, user.denominations,0)) {
            System.out.println("Invalid password for "+user.username);
        }
        else{
            System.out.println("The username and passwords are valid. The door is opening, please wait... :: FOR:"+user.username);
        }
    }

}
