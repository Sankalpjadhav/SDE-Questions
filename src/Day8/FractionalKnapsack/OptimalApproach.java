package Day8.FractionalKnapsack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
Input:
Enter number of items:
3
Enter weight and associated values:
10 60
30 120
20 100
Enter the capacity of the knapsack:
50
Output:
Maximum value/profit possible: 240.0

Time complexity: O(nlogn) + O(n)
O(nlogn) : Sorting items based on value/weight ratio
O(n) : Traversing through number of items once

Space complexity: O(1) -  Not using any extra space
 */
public class OptimalApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of items: ");
        int numberOfItems = sc.nextInt();
        Item [] item = new Item[numberOfItems];
        System.out.println("Enter weight and associated values: ");
        for(int i=0;i<numberOfItems;i++){
            int weight = sc.nextInt();
            int value = sc.nextInt();
            item[i] = new Item(weight, value);
        }
        System.out.println("Enter the capacity of the knapsack: ");
        int W = sc.nextInt();

        System.out.println("Maximum value/profit possible: "+getMaximumValue(item, W, numberOfItems));
    }

    private static double getMaximumValue(Item [] item, int W, int numberOfItems){
        double maximumValue = 0;
        int currentWeight = 0;
        Arrays.sort(item, new ItemComparator());
        for(int i = 0;i<numberOfItems;i++){
            if(currentWeight + item[i].getWeight() <= W){
                currentWeight += item[i].getWeight();
                maximumValue += item[i].getValue();
            }
            else{
                int remainingWeight = W - currentWeight;
                maximumValue += ((double) item[i].getValue()/(double) item[i].getWeight()) * remainingWeight;
                break;
            }
        }
        return maximumValue;
    }
}

class Item{
    private int weight;
    private int value;

    public Item(int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class ItemComparator implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2) {
        double valueByWeight1 = (double)o1.getValue() / (double)o1.getWeight();
        double valueByWeight2 = (double)o2.getValue() / (double)o2.getWeight();

        return (int)(valueByWeight2 - valueByWeight1);
    }
}