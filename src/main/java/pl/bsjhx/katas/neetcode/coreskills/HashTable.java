package pl.bsjhx.katas.neetcode.coreskills;

class HashTable {

    private Entry[] array;

    private int count;

    public HashTable(int capacity) {
        this.array = new Entry[capacity];
        this.count = 0;
    }

    public void insert(int key, int value) {
        int pos = calculatePosition(key);
        if (array[pos] == null) {
            array[pos] = new Entry(key, value, null);
        } else {
            var curr = array[pos];

            while (curr.next != null) {
                if (updateIfSameKey(key, value, curr)) return;
                curr = curr.next;
            }
            if (updateIfSameKey(key, value, curr)) return;

            curr.next = new Entry(key, value, null);
        }
        count++;
        if (count >= array.length / 2) {
            resize();
        }
    }

    public int get(int key) {
        int pos = calculatePosition(key);
        if (array[pos] == null) {
            return -1;
        } else {
            var curr = array[pos];
            while (curr != null) {
                if (curr.key == key) {
                    return curr.value;
                }
                curr = curr.next;
            }
        }
        return -1;
    }

    public boolean remove(int key) {
        int pos = calculatePosition(key);

        if (array[pos] == null) {
            return false;
        }

        var curr = array[pos];
        if (curr.key == key) {
            array[pos] = curr.next;
            count--;
            return true;
        }

        Entry prev = null;

        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                count--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    public int getSize() {
        return count;
    }

    public int getCapacity() {
        return array.length;
    }

    private boolean updateIfSameKey(int key, int value, Entry curr) {
        if (curr.key == key) {
            curr.value = value;
            return true;
        }
        return false;
    }

    public void resize() {
        Entry[] temp = new Entry[array.length * 2];

        for (Entry oldEntry : array) {
            if (oldEntry == null) {
                continue;
            }
            insertToList(oldEntry, temp);
        }

        array = temp;
    }

    private void insertToList(Entry curr, Entry[] temp) {
        do {
            var newPos = curr.key % temp.length;
            if (temp[newPos] == null) {
                temp[newPos] = new Entry(curr.key, curr.value, null);
            } else {
                var currNew = temp[newPos];
                while (currNew.next != null) {
                    currNew = currNew.next;
                }
                currNew.next = new Entry(curr.key, curr.value, null);
            }
            curr = curr.next;
        } while (curr != null);
    }

    private int calculatePosition(int key) {
        return key % array.length;
    }

    private static class Entry {
        int key;
        int value;
        Entry next;

        public Entry(int key, int value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}