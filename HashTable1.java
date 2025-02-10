public class HashTable1 {
    private final int size;
    private final Square[] table;
    public HashTable1(int size) {
        this.size = size;
        table = new Square[size];
    }
    private int hash(Square square) {
        int key = (int)square.P;
        return key % size;
    }
    public boolean insert(Square square) {
        int index = hash(square);
        if (table[index] == null) {
            table[index] = square;
            return true;
        }
        System.out.println("Collusion.");
        return false;
    }
    public void print() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println( i + " " + table[i].toString());
            }
        }
    }

}
