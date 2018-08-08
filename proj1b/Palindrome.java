public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque deque = new LinkedListDeque<Character>();

        for(int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }

        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return checkPalindrome(deque);
    }

    public boolean checkPalindrome(Deque<Character> deque) {
        if(deque.size() < 2) return true;
        if(deque.removeFirst() == deque.removeLast()) {
            return checkPalindrome(deque);
        }
        return false;
    }
}