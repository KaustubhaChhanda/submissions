class MyHashMap {
    int[] arr;

    public MyHashMap() {
        arr = new int[1000000];
        Arrays.fill(arr, -1);
    }
    
    public void put(int key, int value) {
        int index = Integer.hashCode(key) % arr.length;
        arr[index] = value;
}
    
    public int get(int key) {
        int index = Integer.hashCode(key) % arr.length;
        return arr[index];
    }
    
    public void remove(int key) {
        int index = Integer.hashCode(key) % arr.length;
        arr[index] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */