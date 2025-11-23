package pl.bsjhx.katas.neetcode.coreskills.sort;

class Pair {
    int key;
    String value;

    Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}