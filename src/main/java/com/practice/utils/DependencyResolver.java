import java.util.*;

public class DependencyResolver {

    // A map to store the dependencies (key -> dependent variables)
    private Map<String, List<String>> dependencyGraph;

    public DependencyResolver() {
        dependencyGraph = new HashMap<>();
    }

    // Add a dependency (e.g., A depends on B)
    public void addDependency(String from, String to) {
        dependencyGraph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

    // Find all downstream variables for a given variable using DFS with cycle detection
    public Set<String> findDownstreamVariables(String variable) {
        Set<String> downstream = new HashSet<>();
        Set<String> visited = new HashSet<>(); // To track already visited nodes in the DFS
        Set<String> inStack = new HashSet<>(); // To track nodes in the current DFS stack (for cycle detection)

        if (!dfs(variable, downstream, visited, inStack)) {
            throw new IllegalStateException("Cycle detected in the dependency graph.");
        }

        return downstream;
    }

    // Helper method to perform DFS with cycle detection
    private boolean dfs(String variable, Set<String> downstream, Set<String> visited, Set<String> inStack) {
        // If already visited, skip this variable
        if (visited.contains(variable)) {
            return true; // No cycle detected in this path
        }

        // If the variable is in the current DFS stack, we've found a cycle
        if (inStack.contains(variable)) {
            return false; // Cycle detected
        }

        // Mark the current variable as part of the DFS stack
        inStack.add(variable);

        // Mark the variable as visited
        visited.add(variable);

        // Explore all dependencies for the current variable
        if (dependencyGraph.containsKey(variable)) {
            for (String dependent : dependencyGraph.get(variable)) {
                if (!downstream.contains(dependent)) {
                    downstream.add(dependent);  // Add the dependent to downstream set
                }

                // Recursively find downstream dependencies
                if (!dfs(dependent, downstream, visited, inStack)) {
                    return false; // Cycle detected during DFS
                }
            }
        }

        // Remove the variable from the current DFS stack
        inStack.remove(variable);

        return true; // No cycle detected
    }

    public static void main(String[] args) {
        // Initialize the DependencyResolver
        DependencyResolver resolver = new DependencyResolver();

        // Define the dependencies
        resolver.addDependency("A", "B");
        resolver.addDependency("B", "C");
        resolver.addDependency("C", "A"); // This creates a cycle: A -> B -> C -> A

        try {
            // Find downstream variables for A
            Set<String> downstream = resolver.findDownstreamVariables("A");

            // Output the downstream variables
            System.out.println("Downstream variables for A: " + downstream);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Output: Cycle detected in the dependency graph.
        }
    }
}
