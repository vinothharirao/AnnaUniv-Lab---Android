package com.example.lab4primitives;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class DrawPrimitive extends View {
    
    private Paint paint;
    private String shape;
    private int width,height,radius;

    public DrawPrimitive(Context context,String shape) {
        super(context);

        // create the Paint and set its color
        this.shape = shape;
        paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(shape.equals("circle")) canvas.drawCircle(200, 200, 100, paint);
        else if(shape.equals("line")) canvas.drawLine(100, 100, 900, 900, paint);
        else if(shape.equals("ellipse")) canvas.drawOval(new RectF(200,200,500,1000), paint);
        else if(shape.equals("rectangle")) canvas.drawRect(100,100,500,700, paint);
    }

}