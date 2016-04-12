package com.example.jcate478.seat_suite.saddledome;

import com.example.jcate478.seat_suite.vendorInfo.*;

import java.util.*;
/**
 * Created by plazi478 on 3/30/2016.
 */
public class saddledomeGrid {

    ArrayList<int[]> grid = new ArrayList<>();


    //groups of sections
    int[] group0 = new int[] {215,111,214,112};//
    int[] group1 = new int[] {213,110,212,109};//
    int[] group2 = new int[] {212,109,211,108};//
    int[] group3 = new int[] {210,107,209,106};//
    int[] group4 = new int[] {105,104,103};
    int[] group5 = new int[] {201,102,228,101};
    int[] group6 = new int[] {122,227,121};
    int[] group7 = new int[] {226,120,225,119};
    int[] group8 = new int[] {224,118,223};
    int[] group9 = new int[] {117,116};
    int[] group10 = new int[] {115,114,113};


    public void populateGrid()
    {
        grid.add(group0);
        grid.add(group1);
        grid.add(group2);
        grid.add(group3);
        grid.add(group4);
        grid.add(group5);
        grid.add(group6);
        grid.add(group7);
        grid.add(group8);
        grid.add(group9);
        grid.add(group10);

    }

    public int searchGrid(int section)
    {
        for (int i = 0; i < grid.size(); i++)
        {
            int[] group = grid.get(i);
            for(int j = 0; j < group.length; j ++)
            {
                if (group[j] == section)
                    return i;
            }
        }
        return -1;
    }

    public int[] getGroup(int group)
    {
        return grid.get(group);
    }


}

