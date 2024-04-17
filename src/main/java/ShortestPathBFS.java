import java.util.*;

public class ShortestPathBFS {
    // Modified bfs to store the parent of nodes along with
    // the distance from the source node
    static void bfs(List<List<Integer>> graph, int S, List<Integer> par, List<Integer> dist) {
        // Queue to store the nodes in the order they are
        // visited
        Queue<Integer> q = new LinkedList<>();
        // Mark the distance of the source node as 0
        dist.set(S, 0);
        // Push the source node to the queue
        q.add(S);

        // Iterate until the queue is not empty
        while (!q.isEmpty()) {
            // Pop the node at the front of the queue
            int node = q.poll();

            // Explore all the neighbors of the current node
            for (int neighbor : graph.get(node)) {
                // Check if the neighboring node is not
                // visited
                if (dist.get(neighbor)
                        == Integer.MAX_VALUE) {
                    // Mark the current node as the parent
                    // of the neighboring node
                    par.set(neighbor, node);
                    // Mark the distance of the neighboring
                    // node as the distance of the current
                    // node + 1
                    dist.set(neighbor, dist.get(node) + 1);
                    // Insert the neighboring node to the
                    // queue
                    q.add(neighbor);
                }
            }
        }
    }


    // Function to print the shortest distance between the
    // source vertex and destination vertex
    static List<Integer> shortestDistance(List<List<Integer>> graph, int S, int D, int V) {

        // par[] array stores the parent of nodes
        List<Integer> par
                = new ArrayList<>(Collections.nCopies(V, -1));

        // dist[] array stores the distance of nodes from S
        List<Integer> dist = new ArrayList<>(
                Collections.nCopies(V, Integer.MAX_VALUE));

        // Function call to find the distance of all nodes
        // and their parent nodes
        bfs(graph, S, par, dist);

        if (dist.get(D) == Integer.MAX_VALUE) {
            throw new RuntimeException(
                    "Source and Destination are not connected");
        }

        // List path stores the shortest path
        List<Integer> path = new ArrayList<>();
        int currentNode = D;
        path.add(D);
        while (par.get(currentNode) != -1) {
            path.add(par.get(currentNode));
            currentNode = par.get(currentNode);
        }


        // Printing path from source to destination
//        for (int i = path.size() - 1; i >= 0; i--) {
//            System.out.print(path.get(i) + " ");
//        }
        return path;
    }

    public static boolean areNodesConnectedThroughIntermediates (List<List<Integer>> graph, Integer start, Integer end, List<Integer> intermediates) {
        // Trova il percorso più breve dal nodo di partenza al nodo finale
        List<Integer> shortestPath = new ArrayList<>();
        for (Integer i : intermediates) {
            if (i.equals(end)) {
                shortestPath.add(i);
            }
            if (i.equals(start)){
                shortestPath.add(i);
            }
        }

        // Verifica se il percorso più breve esiste e se tutti i punti intermedi sono presenti nel percorso
        if (!shortestPath.isEmpty() && intermediates.stream().allMatch(shortestPath::contains)) {
            return true;
        }

        return false;
    }

    static boolean hasIntermediateNodes(List<List<Integer>> graph, int S, int D, List<Integer> intermediateNodes) {
        // Inizializza una struttura dati per tenere traccia dei nodi visitati
        boolean[] visited = new boolean[graph.size()];
        // Inizia la ricerca del percorso dalla radice
        return dfs(graph, S, D, intermediateNodes, visited);
    }

    // Metodo di ricerca in profondità (Depth-First Search)
    static boolean dfs(List<List<Integer>> graph, int current, int destination, List<Integer> intermediateNodes, boolean[] visited) {
        // Se il nodo corrente è uno dei nodi intermedi, restituisci true
        if (intermediateNodes.contains(current)) {
            return true;
        }
        // Marca il nodo corrente come visitato
        visited[current] = true;
        // Per ogni vicino del nodo corrente
        for (int neighbor : graph.get(current)) {
            // Se il vicino non è stato visitato
            if (!visited[neighbor]) {
                // Effettua una chiamata ricorsiva per il vicino
                if (dfs(graph, neighbor, destination, intermediateNodes, visited)) {
                    return true; // Se trovato un percorso, restituisci true
                }
            }
        }
        // Se non è stato trovato alcun percorso, restituisci false
        return false;
    }

}