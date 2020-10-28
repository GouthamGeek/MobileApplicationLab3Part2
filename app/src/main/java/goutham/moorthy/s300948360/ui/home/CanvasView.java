package goutham.moorthy.s300948360.ui.home;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {

    private static final float TOLERANCE = 5;
    public int width;
    public int height;
    Context context;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path cPath;
    private Paint cPaint;
    private float mX, mY;

    public void getSelectedOptions(String cColor, String cThick) {
        setColor(cColor);
        setThick(cThick);
    }

    // set color
    private void setColor(String color) {
        switch (color) {
            case "White" : cPaint.setColor(Color.WHITE);
                break;
            case "Green" : cPaint.setColor(Color.GREEN);
                break;
            case "Magenta" : cPaint.setColor(Color.MAGENTA);
                break;
            case "Blue" : cPaint.setColor(Color.BLUE);
                break;
            case "Yellow" : cPaint.setColor(Color.YELLOW);
                break;
            default:
                break;
        }
    }


    private void setThick(String thick) {
        switch (thick) {
            case "4 Size Font" : cPaint.setStrokeWidth(4f);
                break;
            case "8 Size Font" : cPaint.setStrokeWidth(8f);
                break;
            case "10 Size Font" : cPaint.setStrokeWidth(10f);
                break;
            case "15 Size Font" : cPaint.setStrokeWidth(15f);
                break;
            default:
                break;
        }
    }

    public CanvasView(Context c, AttributeSet attr) {
        super(c, attr);
        context = c;

        // we set a new Path
        cPath = new Path();

        // and we set a new Paint with the desired attributes
        cPaint = new Paint();
        cPaint.setAntiAlias(true);
        //mPaint.setColor(Color.BLACK);
        cPaint.setStyle(Paint.Style.STROKE);
        cPaint.setStrokeJoin(Paint.Join.ROUND);
        //mPaint.setStrokeWidth(4f);
    }

    // override onSizeChanged
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // your Canvas will draw onto the defined Bitmap
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    // override onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(cPath, cPaint);
    }

    public void clearPath() {
        cPath = new Path();
        invalidate();
    }

    // when ACTION_DOWN start touch according to the x,y values
    private void startTouch(float x, float y) {
        cPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    // when ACTION_MOVE move touch according to the x,y values
    private void moveTouch(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOLERANCE || dy >= TOLERANCE) {
            cPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }


    // when ACTION_UP stop touch
    private void upTouch() {
        cPath.lineTo(mX, mY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break;
        }
        return true;
    }
}