public class Palindrome{
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            deque.addLast(ch);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> tested = wordToDeque(word);
        return isPalindromeHelper(tested, tested.size());
    }

    private boolean isPalindromeHelper(Deque<Character> word, int size) {

        if (size == 0 || size == 1) {
            return true;
        }
        Character first = word.removeFirst();
        Character last = word.removeLast();
        if (first == last) {
            return isPalindromeHelper(word, size - 2);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> tested = wordToDeque(word);
        if (tested.size() == 0 || tested.size() == 1) {
            return true;
        }
        OffByOne compare = (OffByOne) cc;
        for (int i = 0; i < tested.size()/2; i++) {
            Character first = tested.removeFirst();
            Character last = tested.removeLast();
            if (!compare.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }


}

