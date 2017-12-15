import java.util.*;
public class Hash<K, V> {
    private final int numBuckets = (int)(Math.pow(2,4));
    private ArrayList<ArrayList<HashElement<K, V>>> myHash;
    public Hash() {
        myHash = new ArrayList<>();
        for(int i = 0; i < numBuckets; i++)
            myHash.add(new ArrayList<HashElement<K, V>>());
    }
    
    public static void main() {
        Hash<Integer, Boolean> data = new Hash<Integer, Boolean>();
        HashSet<Integer> ex = new HashSet<Integer>();
    }
    
    public void put(K key, V value) {
        int bucket = key.hashCode() % numBuckets;
        HashElement toAdd = new HashElement(key, value);
        for(HashElement he : myHash.get(bucket))
            if(he.key().equals(key)) {
                he.setValue(value);
                System.out.println("Replaced.");
                return;
            }
        myHash.get(bucket).add(toAdd);
    }
    
    public V get(K key) {
        int bucket = key.hashCode() % numBuckets;
        for(HashElement<K,V> he : myHash.get(bucket))
            if(he.key().equals(key))
                return he.value();
        return null;
    }
    
    public boolean contains(K key) {
        return get(key) == null;
    }
    
    public class HashElement<K, V> {
        private K key;
        private V value;
        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K key(){return key;}
        public V value(){return value;}
        
        public void setValue(V nv){value = nv;}
        
        @Override
        public String toString() {
            return "key "+key+", value "+value;
        }
    }
}