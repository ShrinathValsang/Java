package com.barclays;

/*
Q1. In the city of Toyland, there are N houses. Noddy is looking for a piece of land in
the city to build his house. He wants to buy the land where he can build the
largest possible house. All the houses in the city lie in a straight line and all of
them are given a house number and position of the house from the entry point in
the city. Noddy wants to find the house numbers between which he can build the
largest house.
Write an algorithm to help Noddy to find the house numbers between which he can
build his house.
        Input: The input to the function/method consists of two arguments
          ● numOf House, an integer representing the number of houses.
        ● houseList, a list where each element of the list is a list of integers representing the house number and its position respectively.
        Constraints:
        2 < numOfHouse < 106
        1 <houseList[i][0] <numOfHouse
               0 < houseList[i][1] < 106
        0 < I < numOfHouse
Note: No two houses will have the same position. In case of multiple such answers, return the one with the least distance from the reference point Zero.
        Example:
Input:
numOfHouse = 5
houseList = [[3, 7],[1, 9],[2, 0],[5, 15],[4, 30]]
Output: [4, 5]
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class House {
    int houseNumber;
    int position;

    House(int houseNum, int pos) {
        this.houseNumber = houseNum;
        this.position = pos;
    }
}

public class ToyLandLargestPlot {

    public static void main(String[] args) {
        int numOfHouse = 5;
        int[][] houseList = {{3, 7},{1, 9},{2, 0},{5, 15}, {4, 30}};

        int[] largestPlot = findLargestPlot(numOfHouse, houseList);

    }

    private static int[] findLargestPlot(int numOfHouse, int[][] houseList) {
        List<House> houses = new ArrayList<>();
        House houseLeft = null, houseRight = null;

        for (int i = 0; i < numOfHouse; i++) {
            houses.add(new House(houseList[i][0], houseList[i][1]));
        }

        houses.sort(Comparator.comparingInt(h -> h.position));

        // Find max gap
        int gap = -1, maxGap = -1; int hl = -1, hr = -1;

        for (int j = 1; j < houses.size(); j++) {
            gap = houses.get(j).position - houses.get(j - 1).position;

            if (gap > maxGap) {
                maxGap = gap;
                houseLeft = houses.get(j);
                houseRight = houses.get(j - 1);
            } /*else if (gap == maxGap) {
                //houseLeft.position > houses.get(j).position
                //int currentDistFromStart = houses.get(j-1).position - houseLeft.position;
            }*/
            // don't need this else block as the list is already sorted and larger plot found later with same length
            // will always be farther from the reference i.e. 0!
        }

        return new int[]{houseLeft.position, houseRight.position};
    }

}
