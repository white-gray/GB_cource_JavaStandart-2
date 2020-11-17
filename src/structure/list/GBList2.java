package structure.list;

public interface GBList2 extends GBIterable2 {
    void add(String val);
    String remove(String val);
    String get(int index);
    int size();
}
