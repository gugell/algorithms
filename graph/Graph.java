import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Graph {

        static class Node {
                public final String name;
                public final HashSet<Edge> inEdges;
                public final HashSet<Edge> outEdges;

                public Node(String name) {
                        this.name = name;
                        inEdges = new HashSet<Edge>();
                        outEdges = new HashSet<Edge>();
                }

                public Node addEdge(Node node) {
                        Edge e = new Edge(this, node);
                        outEdges.add(e);
                        node.inEdges.add(e);
                        return this;
                }

                @Override
                public String toString() {
                        return name;
                }
        }

        static class Edge {
                public final Node from;
                public final Node to;
                public Edge(Node from, Node to) {
                        this.from = from;
                        this.to = to;
                }

                @Override
                public boolean equals(Object obj) {
                        Edge e = (Edge)obj;
                        return e.from == from && e.to == to;
                }
        }

        public static void main(String[] args) {
                Node seven = new Node("7");
                Node five = new Node("5");
                Node three = new Node("3");
                Node eleven = new Node("11");
                Node eight = new Node("8");
                Node two = new Node("2");
                Node nine = new Node("9");
                Node ten = new Node("10");
                seven.addEdge(eleven).addEdge(eight);
                five.addEdge(eleven);
                three.addEdge(eight).addEdge(ten);
                eleven.addEdge(two).addEdge(nine).addEdge(ten);
                eight.addEdge(nine).addEdge(ten);

                System.out.println("Running ...");

                for (Edge e : three.outEdges) {
                        System.out.println("Goes to: " + e.to.name);
                }
        }
}
