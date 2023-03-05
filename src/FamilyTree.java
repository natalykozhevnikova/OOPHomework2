public class FamilyTree {
    public static class Node
    {
        String name;
        Node nonnative, child;

        public Node(String name)
        {
            this.name = name;
            nonnative = child;
            child = null;
        }
    }

    static public Node addNonnative(Node node, String name)
    {
        if(node == null)
            return null;

        while(node.nonnative != null)
            node = node.nonnative;
        return(node.nonnative = new Node(name));
    }

    static public Node addChild(Node node,String name)
    {
        if(node == null)
            return null;

        if(node.child != null)
            return(addNonnative(node.child,name));
        else
            return(node.child = new Node(name));
    }

    static public void preorderTraversal(Node root)
    {
        if(root == null)
        {
            System.out.println("Корень отсутствует");
        }
        while(root != null)
        {
            System.out.print(root.name + " ");
            if(root.child != null)
                preorderTraversal(root.child);
            root = root.nonnative;
        }
    }

    public static void main(String args[])
    {
        System.out.println("Дерево с обходом: \n");

        Node root = new Node("Nina");
        Node node1 = addChild(root, "Ivan");
        Node node2 = addChild(root,"Marina");
        Node node3 = addNonnative(root,"Boris");

        preorderTraversal(root);

















