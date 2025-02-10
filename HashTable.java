public class HashTable {
    private final Node[] table;
    private final int size;
    public HashTable(int size) {
        this.size = size;
        this.table = new Node[size];
    }
    private int hashFunc(Square square) {
        int key = (int)square.P;
        return key % this.size;
    }
    public boolean insert(Square square) {
        int index = hashFunc(square);
        if (table[index] == null) {
            table[index] = new Node(square);
            return true;
        }
        else{
            Node cur = table[index];
            while (cur.next != null) {
                if (cur.data.equals(square)) {
                    return false;
                }
                cur = cur.next;
            }
            cur.next = new Node(square);
            return true;
        }
    }
    public void deleteArea(double area) {
        for (int i = 0; i < size; i++) {
            Node cur = table[i];
            Node prev = null;
            while (cur != null) {
                if (cur.data.getArea() < area) {
                    if (prev == null) {
                        table[i] = cur.next;
                    }
                    else {
                        prev.next = cur.next;
                    }
                }
                else {
                    prev = cur;
                }
                cur = cur.next;
            }
        }
    }
    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
               Node cur = table[i];
               while (cur != null) {
                   System.out.println(i + " " + cur.data.toString());
                   cur = cur.next;
               }
            }
        }
    }
}
