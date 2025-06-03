import java.util.*;

class Solution {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(List.of("JFK", "SFO")); 
        tickets.add(List.of("JFK", "ATL")); 
        tickets.add(List.of("SFO", "JFK")); 
        tickets.add(List.of("ATL", "AAA")); 
        tickets.add(List.of("AAA", "ATL")); 
        tickets.add(List.of("ATL", "BBB")); 
        tickets.add(List.of("BBB", "ATL")); 
        tickets.add(List.of("ATL", "CCC")); 
        tickets.add(List.of("CCC" ,"ATL")); 
        tickets.add(List.of("ATL", "DDD")); 
        tickets.add(List.of("DDD", "ATL")); 
        tickets.add(List.of("ATL", "EEE")); 
        tickets.add(List.of("EEE", "ATL")); 
        tickets.add(List.of("ATL", "FFF")); 
        tickets.add(List.of("FFF", "ATL")); 
        tickets.add(List.of("ATL", "GGG")); 
        tickets.add(List.of("GGG", "ATL")); 
        tickets.add(List.of("ATL", "HHH")); 
        tickets.add(List.of("HHH", "ATL")); 
        tickets.add(List.of("ATL", "III")); 
        tickets.add(List.of("III", "ATL")); 
        tickets.add(List.of("ATL", "JJJ")); 
        tickets.add(List.of("JJJ", "ATL")); 
        tickets.add(List.of("ATL", "KKK")); 
        tickets.add(List.of("KKK", "ATL")); 
        tickets.add(List.of("ATL" ,"LLL")); 
        tickets.add(List.of("LLL", "ATL")); 
        tickets.add(List.of("ATL", "MMM")); 
        tickets.add(List.of("MMM", "ATL")); 
        tickets.add(List.of("ATL", "NNN")); 
        tickets.add(List.of("NNN" ,"ATL"));

        System.out.println("-------------------");
        System.out.println(findItinerary(tickets));
        
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets) {
            graph
                .computeIfAbsent(ticket.get(0), _ -> new PriorityQueue<>())
                .offer(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String current = stack.peek();
            PriorityQueue<String> neighbors = graph.get(current);

            if (neighbors != null && !neighbors.isEmpty()) {
                stack.push(neighbors.poll());
            } else {
                result.addFirst(stack.pop());
            }
        }

        return result;
    }
}