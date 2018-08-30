
public class SLlist {
    /**
     * create note
     */

    public class Node {
        public int item;
        public Node next;

        public Node(int i, Node n) {
            item = i;
            next = n;
        }
    }

    public int size;
    public Node sentinel;
    public Node last;


    public  SLlist(){
        sentinel = new Node(100,null);
        last = sentinel;
        size = 0;
    }

    public SLlist(int i){
        sentinel = new Node(100,null);
        sentinel.next = new Node(i,null);
        last =  sentinel.next;
        size = 1;
    }

    public void addfirst(int i){
        sentinel.next = new Node(i,sentinel.next);;
        size += 1;

    }

    public int getfirst(){
        return sentinel.next.item;
    }


    public void addlast(int i){
        size += 1;
        last.next = new Node(i,null);
        last =  last.next;
    }





    public static void main(String[] args){
        SLlist a =  new SLlist(10);
        a.addfirst(10);
        a.addfirst(20);
        a.addfirst(30);
        a.addlast(20);
        System.out.print(a.getfirst());
    }



}
