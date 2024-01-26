package com.javahongkong.bootcamp.exercise;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        this.ordersOfFurnitures = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        if(furnitureCount < 1){
            return;
        }
        if (this.ordersOfFurnitures.containsKey(type)) {
            int exisCount = ordersOfFurnitures.get(type);
            this.ordersOfFurnitures.put(type,exisCount+furnitureCount);
        }else{
            this.ordersOfFurnitures.put(type, furnitureCount);
        }
        System.out.println(this.ordersOfFurnitures.size());
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float cost = 0.0f;
        for(Map.Entry<Furniture, Integer> entry : this.ordersOfFurnitures.entrySet()){
            cost += entry.getKey().cost() * entry.getValue();
        }
        return cost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        if (!this.ordersOfFurnitures.containsKey(type)) {
            return 0;
        }
        return this.ordersOfFurnitures.get(type);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        if (!this.ordersOfFurnitures.containsKey(type)) {
            return 0.0f;
        }
        return this.ordersOfFurnitures.get(type) * type.cost();
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int sum = 0;
        for(Map.Entry<Furniture, Integer> entry : this.ordersOfFurnitures.entrySet()){
            sum += entry.getValue();
        }
        return sum;
    }
}