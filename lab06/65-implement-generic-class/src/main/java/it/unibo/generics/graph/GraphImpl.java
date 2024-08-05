package it.unibo.generics.graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private final Set<N> nodes;
    private final Map<N, Set<N>> edges;

    public GraphImpl(Set<N> nodes){
        this.nodes = nodes;
        this.edges = new HashMap<>();
    }

    public GraphImpl(){
        this(new HashSet<N>());
    }

    @Override
    public void addNode(N node) {
        if (node != null) {
            this.nodes.add(node);
        }  
    }

    @Override
    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            this.edges.putIfAbsent(source, new HashSet<>());
            this.edges.get(source).add(target);
            //this.edges.putIfAbsent(target, new HashSet<>());
            //this.edges.get(target).add(source);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return Set.copyOf(nodes);
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return Set.copyOf(edges.get(node));
    }

    @Override
    public List<N> getPath(N source, N target) {
        Stack<N> path = new Stack<>();
        path.add(source);
        buildPath(path, target);
        return path;
    }

    private void buildPath(Stack<N> path, N target) {
        

        for (N tmp : this.edges.get(path.peek())) {
            if (!path.contains(tmp)) {
                path.add(tmp);
                buildPath(path, target);
            } 
            if (path.peek() == target){
                return;
            }  
        }
        path.pop();
    }



   

   

    

    
    
}

