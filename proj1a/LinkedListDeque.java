public class LinkedListDeque<T>{

    public class node {
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
        sentinel = new node (null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T i){
        sentinel =  new node(null,null,null);
        sentinel.next = new node(i,sentinel,sentinel);
        sentinel.prev = sentinel.next;
        size += 1;
    }

    public int size(){
        return this.size;
    }

    public void addFirst(T item){
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
            node first = sentinel.next;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return first.item;
        }
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }else{
            node lastv = sentinel.prev;
            sentinel.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return lastv.item;
        }
    }

    public T get(int index){
        if (size < index+1|size==0){
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
    public T getRecursiveHelp(node s,int index){
           if(index == 0){
               return s.next.item;
           }else{
               return getRecursiveHelp(s.next,index-1);
           }
    }

    public T getRecursive(int index){
        if(size<index+1|size==0){
            return null;
        }
        return getRecursiveHelp(sentinel,index);
    }

    public void printDeque(){
        node p = sentinel.next;
        for(int count =0;count<size;count++){
            System.out.print(p.item);
            System.out.print(' ');
            p = p.next;
        }
    }

}
