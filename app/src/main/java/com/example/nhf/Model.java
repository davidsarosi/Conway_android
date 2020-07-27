package com.example.nhf;

import java.util.Random;

class Model {

    int mainsize = 51;
    int generations = 0;
    boolean[][] cells;
    int livecellcnt = 0;
    int sizey;
    int sizex;


    void setSize(){
        cells=new boolean[sizey][sizex];

    }

    private boolean ncount(int l, int k) {
        int nc = 0;

        for (int i = l - 1; i < l + 2; i++)
            for (int j = k - 1; j < k + 2; j++) {
                int x = (j % sizex + sizex) % sizex;
                int y = (i % sizey + sizey) % sizey;
                if (cells[y][x])
                    nc++;
            }


        return (cells[l][k] && ((nc - 1) == 2||(nc-1)==3)) || nc == 3;

    }

    void nextgen() {
        boolean[][] helpercells = new boolean[sizey][sizex];
        livecellcnt = 0;
        for (int i = 0; i < sizey; i++) {
            for (int j = 0; j < sizex; j++) {
                helpercells[i][j] = ncount(i, j);


            }
        }

        for (int i = 0; i < sizey; i++) {
            for (int j = 0; j < sizex; j++) {
                cells[i][j] = helpercells[i][j];
            }
        }
        generations++;

    }

    void random() {

        livecellcnt = 0;
        generations = 0;

        Random x = new Random();
        for (int i = 0; i < sizey; i++)
            for (int j = 0; j < sizex; j++) {
                cells[i][j] = x.nextBoolean();
                if (cells[i][j])
                    livecellcnt++;
            }

    }

    void cropSave(Cells Cells) {
        int minx = Cells.size;
        int maxx = 0;
        int miny = Cells.size;
        int maxy = 0;

        for (int i = 0; i < Cells.size; i++)
            for (int j = 0; j < Cells.size; j++) {
                if (Cells.cells[i][j]) {
                    minx = Math.min(j, minx);
                    miny = Math.min(i, miny);
                }
            }


        for (int i = 0; i < Cells.size; i++)
            for (int j = 0; j < Cells.size; j++) {
                if (Cells.cells[i][j]) {
                    maxx = Math.max(j, maxx);
                    maxy = Math.max(i, maxy);
                }
            }

        System.out.println("MAX X:" + maxx);
        System.out.println("MAX Y:" + maxy);
        System.out.println("MIN X:" + minx);
        System.out.println("MIN Y:" + miny);

        Pattern savedPattern = new Pattern();
        savedPattern.cells = new boolean[maxy - miny + 1][maxx - minx + 1];
        savedPattern.width = maxx - minx + 1;
        savedPattern.heigth = maxy - miny + 1;

        System.out.println(savedPattern.heigth);
        System.out.println(savedPattern.width);


        for (int y = miny; y < savedPattern.heigth + miny; y++)
            for (int x = minx; x < savedPattern.width + minx; x++)
                savedPattern.cells[y - miny][x - minx] = Cells.cells[y][x];

        savedPattern.savetable("Gliders\\Ligthweight Spaceship.ser");
    }


}
