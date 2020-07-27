package com.example.nhf;

import java.io.*;


/**
 *Contains the array of cells and other attributes
 */
public class Cells implements Serializable {
    /**
     * Grid colour
     */
    String Gcolour = "White";
    /**
     * Cell colour
     */
    String Ccolour = "Black";
    /**
     * Bacground color
     */
    String Bcolour = "Red";
    /**
     * arra of cells
     */
    boolean[][] cells;
    /**
     * size of cells
     */
    int size = 45;
    /**
     * only used for cropsave
     */
    int width=1;
    /**
     * only used for cropsave
     */
    int heigth=3;
    /**
     * Living cell count
     */
    int livecellcnt = 0;
    /**
     * Generations number
     */
    int generation = 0;


    /**
     * Creates the cells
     */
    Cells() {

        cells = new boolean[size][size];


    }


    /**
     * @param path file path
     *             Loads the table
     */


    /**
     * @param path filepath
     *             saves the table
     */


}
