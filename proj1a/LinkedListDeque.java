public class LinkedListDeque<T>{

    public class node <T>{
        public T item;
        public node prev;
        public node next;

        public node(T i, node p, node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    public node sentinel;
    public int size;
    public node last;

    /** empty list*/
    public LinkedListDeque(){
        sentinel = new node(1000,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T i){
        sentinel =  new node(1000,null,null);
        sentinel.next = new node(i,sentinel,sentinel);
        sentinel.prev = sentinel.next;
        size += 1;
    }

    public int size(){
        return this.size;
    }

    public void addFrist(T item){
        sentinel.next = new node(item,sentinel,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item){
        sentinel.prev.next = new node(item,sentinel.prev,sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }else{
            T first = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return first;
        }
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }else{
            T lastv = sentinel.prev.item;
            sentinel.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return lastv;
        }
    }

    public T get(int index){
        int
        if (size < index+1){
            return null;
        }else{
        node p = sentinel;
        for (int j = 0;j <=index;j++){
            p = p.next;
        }
        T itemi = p.item;
        return itemi;
        }

    }

}
