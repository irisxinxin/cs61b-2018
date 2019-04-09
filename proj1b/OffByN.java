public class OffByN implements CharacterComparator{
    private int diff;

    public OffByN(int N) {
        diff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diffence = y - x;
        if(diffence == diff || diffence == -diff) {
            return true;
        }
        return false;
    }
}
