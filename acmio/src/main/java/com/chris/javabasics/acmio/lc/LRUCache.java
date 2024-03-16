package com.chris.javabasics.acmio.lc;

import java.util.HashMap;

public class LRUCache {
    private final HashMap<Integer, Node> map;
    private final DoubleLinkedList cache;
    private final int cap;

    public LRUCache(int cap) {
        this.map    = new HashMap<>();
        this.cache  = new DoubleLinkedList();
        this.cap    = cap;
    }

    public void put(int key, int val) {
        if(map.containsKey(key))
            delete(key);
        else if(cache.size() == cap)
            removeLeastRecently();
        addRecently(key, val);
    }

    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        map.remove(node.key);
    }

    private void delete(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        makeRecently(key);
        return map.get(key).val;
    }

    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }


    public static class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "[" + key + "," + val + "]";
        }
    }

    public static class DoubleLinkedList {
        Node head, tail;
        int size;

        public DoubleLinkedList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            this.size = 0;
        }

        public Node removeFirst() {
            Node first = head.next;
            remove(first);
            return first;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public void addLast(Node node) {
            node.next = tail;
            node.prev = tail.prev;

            tail.prev.next = node;
            tail.prev = node;

            size++;
        }

        public int size() {
            return size;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node p = head.next;
            sb.append("{");
            while(p != tail) {
                sb.append(p.toString());
                if(p.next != tail) sb.append(",");
                p = p.next;
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public DoubleLinkedList getCache() {
        return cache;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        System.out.println(lru.getCache());
        lru.put(2,2);
        System.out.println(lru.getCache());
        int key = lru.get(1);
        System.out.println(lru.getCache());
        lru.put(3, 3);
        System.out.println(lru.getCache());
        lru.put(4, 4);
        System.out.println(lru.getCache());
    }
}
