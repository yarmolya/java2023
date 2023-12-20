package JAVA_lab8.lab7;

import java.util.*;

public class FlowerList<E> implements List<E> {
    private List<E> internalList;

    public FlowerList() {
        this.internalList = new ArrayList<>();
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return internalList.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return internalList.iterator();
    }

    @Override
    public Object[] toArray() {
        return internalList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return internalList.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return internalList.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return internalList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return internalList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return internalList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return internalList.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return internalList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return internalList.retainAll(c);
    }

    @Override
    public void clear() {
        internalList.clear();
    }

    @Override
    public E get(int index) {
        return internalList.get(index);
    }

    @Override
    public E set(int index, E element) {
        return internalList.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        internalList.add(index, element);
    }

    @Override
    public E remove(int index) {
        return internalList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return internalList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return internalList.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return internalList.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return internalList.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return internalList.subList(fromIndex, toIndex);
    }


    public String toString() {
        return internalList.toString();
    }
}
