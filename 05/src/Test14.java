public class Test14 {
    public static void main(String[] args) {
        NodeManager nm = new NodeManager();
        nm.add(5);
        nm.add(4);
        nm.add(3);
        nm.add(2);
        nm.add(1);
        nm.printAll();
        System.out.println("___________________");
        System.out.println(nm.find(3));
        System.out.println("___________________");
        nm.del(4);
        nm.printAll();
        System.out.println("___________________");
        nm.insert(4,888);
        nm.printAll();


    }
}

class NodeManager{
    private Node root;
    private int count;
    public void add(int data){
        //添加
        if(null == root){
            this.root = new Node(data);
        }else{
            this.root.addNode(data);
        }
    }
    public void insert(int index,int data){
        count = 0;
        //插入
        if(index == 0){
            Node nNode = new Node(data);
            nNode.next = this.root;
            this.root = nNode;
        }else{
            this.root.insertNode(index,data);
        }
    }
    public void update(int oldVal,int newVal){
        //修改
    }
    public void del(int data){
        //删除
        if(null != this.root){
            if(this.root.data == data){
                this.root = this.root.next;
            }else{
                this.root.delNode(data);
            }
        }

    }
    public Node find(int data) {
        if(this.root.data == data){
            return this.root;
        }else{
            return this.root.findNode(data);
        }
    }
    public void printAll(){
        if(this.root != null){
            System.out.print(this.root.data+"->");
            this.root.printAll();
            System.out.println();
        }
    }



    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }

        public void addNode(int data){
            //添加
            if(this.next == null){
                this.next = new Node(data);
            }else{
                this.next.addNode(data);
            }

        }
        public void insertNode(int index,int data){
            //插入
            count++;
            if(this.next != null) {
                if (index == count) {
                    Node n = new Node(data);
                    n.next = this.next;
                    this.next = n;
                } else {
                    this.next.insertNode(index, data);
                    System.out.println(count);
                }
            }else{
            this.next = new Node(data);
        }

        }
        public void updateNode(int oldVal,int newVal){
            //修改
        }
        public void delNode(int data){
            //删除
            if(this.next != null){
                if(this.next.data == data){
                    this.next = this.next.next;
                }else{
                    this.next.delNode(data);
                }
            }

        }
        public Node findNode(int data) {

            if(this.next != null){
                if(this.next.data == data){
                    return this.next;
                }else{
                    return this.next.findNode(data);
                }
            }

            return null;
        }
        public void printAll(){
            if(this.next != null){
                System.out.print(this.next.data+"->");
                this.next.printAll();
            }
        }


        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getN() {
            return next;
        }

        public void setN(Node next) {
            this.next = next;
        }

        public String toString(){
            return "data"+data;
        }
    }
}
