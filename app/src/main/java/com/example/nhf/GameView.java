package com.example.nhf;


import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.*;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GameView extends LinearLayout {


    private Model table;
    public int DEFAULT_SIZE = 10;
    public int ac;
    public int dc;
    public int gc;
    private Thread thread;
    boolean isRunning = false;
    private Rect r = new Rect();
    private Paint p = new Paint();
    int rectsize = 70;
    private int time = 1;




    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        for (int i = 0; i < table.sizey; i++) {
            for (int j = 0; j < table.sizex; j++) {
                r.set(j * rectsize, i * rectsize, j * rectsize + rectsize, i * rectsize + rectsize);

                p.setColor(table.cells[i][j] ? Color.RED : Color.BLACK);
                canvas.drawRect(r, p);


            }
        }
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //ac= colorResolver(world.ac);
        // dc=colorResolver(world.dc);
        // gc=colorResolver(world.gc);
        table = new Model();
        initTable();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (isRunning) {
                    try {
                        Thread.sleep(1000 * time);
                        table.nextgen();
                        invalidate();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };


            }
        });

    }

    public void start() {

        isRunning = true;
        thread.start();
    }

    public void stop() {
        isRunning = false;

        while (true) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            break;
        }

    }

    private void initTable() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        assert wm != null;
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        table.sizex = point.x / rectsize;
        table.sizey = (int) (point.y / rectsize*0.8);
        table.setSize();
        table.random();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            int x = (int) (event.getX() / rectsize);
            int y = (int) (event.getY() / rectsize);
            if (x >= table.sizex || y >= table.sizey)
                return super.onTouchEvent(event);
            table.cells[y][x] = !table.cells[y][x];
            invalidate();


        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = resolveSize(rectsize * table.sizex, widthMeasureSpec);
        int h = resolveSize(rectsize * table.sizey, heightMeasureSpec);
        setMeasuredDimension(w, h);
    }

    int colorResolver(String color) {
        switch (color) {
            case "Black":
                return Color.BLACK;
            case "Blue":
                return Color.BLUE;
            case "Green":
                return Color.GREEN;
            case "Magenta":
                return Color.MAGENTA;
            case "Red":
                return Color.RED;
            case "White":
                return Color.WHITE;
            case "Yellow":
                return Color.YELLOW;
            default:
                return Color.GRAY;

        }
    }

}
