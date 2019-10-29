package EX3;
/*
 *
 * @author Danilo Sambugaro created on 28/10/2019 inside the package - EX3
 *
 */

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayListThreadSafe<T> implements List {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock read = readWriteLock.readLock();
    private Lock write = readWriteLock.writeLock();
    private ArrayList<T> array;

    ArrayListThreadSafe(){
        this.array = new ArrayList<T>();
    }

    ArrayListThreadSafe(int length){
        this.array = new ArrayList<T>(length);
    }


    @Override
    public int size() {
        read.lock();
        int size = this.array.size();
        read.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        read.lock();
        boolean empty = this.array.isEmpty();
        read.unlock();
        return empty;
    }

    @Override
    public boolean contains(Object o) {
        read.lock();
        boolean contains = array.contains(o);
        read.unlock();
        return contains;
    }

    @Override
    public Iterator iterator() {
        read.lock();
        Iterator<T> iterator = array.iterator();
        read.unlock();
        return iterator;
    }

    @Override
    public Object[] toArray() {
        read.lock();
        Object[] objects = array.toArray();
        read.unlock();
        return objects;
    }

    @Override
    public boolean add(Object o) {
        write.lock();
        boolean add = array.add((T) o);
        write.unlock();
        return add;
    }

    @Override
    public boolean remove(Object o) {
        write.lock();
        boolean remove = array.remove(o);
        write.unlock();
        return remove;
    }

    @Override
    public boolean addAll(Collection collection) {
        write.lock();
        boolean b = array.addAll(collection);
        write.unlock();
        return b;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        write.lock();
        boolean b = array.addAll(i, collection);
        write.unlock();
        return b;
    }

    @Override
    public void clear() {
        write.lock();
        array.clear();
        write.unlock();
    }

    @Override
    public Object get(int i) {
        read.lock();
        T t = array.get(i);
        read.unlock();
        return t;
    }

    @Override
    public Object set(int i, Object o) {
        write.lock();
        T set = array.set(i, (T) o);
        write.unlock();
        return set;
    }

    @Override
    public void add(int i, Object o) {
        write.lock();
        array.add(i, (T) o);
        write.unlock();
    }

    @Override
    public Object remove(int i) {
        write.lock();
        T remove = array.remove(i);
        write.unlock();
        return remove;
    }

    @Override
    public int indexOf(Object o) {
        read.lock();
        int i = array.indexOf(o);
        read.unlock();
        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        read.lock();
        int i = array.lastIndexOf(o);
        read.unlock();
        return i;
    }

    @Override
    public ListIterator listIterator() {
        read.lock();
        ListIterator<T> tListIterator = array.listIterator();
        read.unlock();
        return tListIterator;
    }

    @Override
    public ListIterator listIterator(int i) {
        read.lock();
        ListIterator<T> tListIterator = array.listIterator(i);
        read.unlock();
        return tListIterator;
    }

    @Override
    public List subList(int i, int i1) {
        read.lock();
        List<T> ts = array.subList(i, i1);
        read.unlock();
        return ts;
    }

    @Override
    public boolean retainAll(Collection collection) {
        write.lock();
        boolean b = array.retainAll(collection);
        write.unlock();
        return b;
    }

    @Override
    public boolean removeAll(Collection collection) {
        write.lock();
        boolean b = array.removeAll(collection);
        write.unlock();
        return b;
    }

    @Override
    public boolean containsAll(Collection collection) {
        read.lock();
        boolean b = array.containsAll(collection);
        read.unlock();
        return b;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        read.lock();
        Object[] objects1 = array.toArray(objects);
        read.unlock();
        return objects1;
    }
}
