public class Test11 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        //    8、3、10、1、6、14、4、7、13
        bt.add(8);
        bt.add(3);
        bt.add(10);
        bt.add(1);
        bt.add(6);
        bt.add(14);
        bt.add(4);
        bt.add(7);
        bt.add(13);
        bt.print();

    }
}

class BinaryTree{
    private Node root;

    public void add(int data){
        if(root == null){
            root = new Node(data);
        }else{
            //往根节点添加孩子
            root.addNode(data);
        }
    }
    public void print(){
       root.print();
    }

    private class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
        }

        public void addNode(int data){
            //如果是添加左节点
            if(this.data >= data){
                if(this.left == null){
                    this.left = new Node(data);
                }else{
                    this.left.addNode(data);
                }
            }else{
                if(this.right == null){
                    this.right = new Node(data);
                }else{
                    this.right.addNode(data);
                }
            }

        }
        public void print(){
            if(this.left != null){
                this.left.print();
            }
            System.out.println(this.data);
            if(this.right != null){
                this.right.print();
            }

        }
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
