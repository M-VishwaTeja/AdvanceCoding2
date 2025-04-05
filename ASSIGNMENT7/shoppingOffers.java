import java.util.*;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }
    
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<String, Integer> memo) {
        if (needs.stream().allMatch(count -> count == 0)) {
            return 0;
        }
        
        // Memoization key
        String key = needs.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // Option 1: Buy items at regular price
        int minCost = 0;
        for (int i = 0; i < price.size(); i++) {
            minCost += price.get(i) * needs.get(i);
        }
        // Option 2: Try all special offers
        for (List<Integer> offer : special) {
            List<Integer> newNeeds = new ArrayList<>();
            boolean validOffer = true;
            for (int i = 0; i < price.size(); i++) {
                if (offer.get(i) > needs.get(i)) {
                    validOffer = false;
                    break;
                }
                newNeeds.add(needs.get(i) - offer.get(i));
            }
            
            if (validOffer) {
                int offerCost = offer.get(price.size()); 
                int totalCost = offerCost + dfs(price, special, newNeeds, memo);
                minCost = Math.min(minCost, totalCost);
            }
        }
        memo.put(key, minCost);
        return minCost;
    }
}
