package com.citi.karat;

// Recommend Delivery Partners
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DeliveryPartner {
    String partnerId;
    int startMinute;
    int endMinute;

    public DeliveryPartner(String partnerId, int startMinute, int endMinute) {
        this.partnerId = partnerId;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
    }
}
// OrderManager class
public class RecommendedDeliveryPartners {

    public static void main(String[] args) {
        RecommendedDeliveryPartners manager = new RecommendedDeliveryPartners();

        manager.addDeliveryPartner(new DeliveryPartner("P1", 10, 20));
        manager.addDeliveryPartner(new DeliveryPartner("P2", 15, 25));
        manager.addDeliveryPartner(new DeliveryPartner("P3", 18, 30));
        manager.addDeliveryPartner(new DeliveryPartner("P4", 40, 50));

        System.out.println("Recommended Partners: " + manager.getRecommendedPartners());
        // Output: [P1, P2, P3] (they overlap most often)
    }
    
    private List<DeliveryPartner> partners = new ArrayList<>();

    public void addDeliveryPartner(DeliveryPartner dp) {
        partners.add(dp);
    }

    public List<String> getRecommendedPartners() {
        Map<String, Integer> overlapCount = new HashMap<>();

        for (int i = 0; i < partners.size(); i++) {
            DeliveryPartner d1 = partners.get(i);

            for (int j = i+1; j < partners.size(); j++) {
                DeliveryPartner d2 = partners.get(j);

                if (d1.startMinute < d2.endMinute && d1.endMinute > d2.startMinute) {
                    overlapCount.put(d1.partnerId, overlapCount.getOrDefault(d1.partnerId, 0) + 1);
                    overlapCount.put(d2.partnerId, overlapCount.getOrDefault(d2.partnerId, 0) + 1);
                }
            }
        }

        int maxOverlap = overlapCount.values().stream().max(Integer::compare).orElse(0);

        List<String> result = overlapCount
                .entrySet().stream()
                .filter(e -> e.getValue() == maxOverlap)
                .map(Map.Entry<String, Integer>::getKey)
                .toList();

        return result;
    }
}
