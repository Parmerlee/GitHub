package com.demo.github;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        startAnimate(v);
        startAnimate2(v, v.getWidth(), 500);
    }


    //方法二 自行提供属性的set/get方法。
    private void startAnimate(View v) {
        ViewWapper wapper = new ViewWapper(v);
        ObjectAnimator.ofInt(wapper, "width", v.getWidth(), 500).setDuration(5000).start();
    }

    public class ViewWapper {
        private View target;

        public ViewWapper(View v) {
            this.target = v;
        }

        //提供get方法
        public int getWidth() {
            return target.getLayoutParams().width;
        }

        //提供width 方法
        public void setWdith(int wdith) {
            target.getLayoutParams().width = wdith; //赋值
            target.requestLayout();//刷新UI
        }
    }

    //方法三：根据动画过程，自己改变属性值
    private void startAnimate2(final View view, final int start, final int end) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private IntEvaluator mEvaluator = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float fraction = animation.getAnimatedFraction();
                view.getLayoutParams().width = mEvaluator.evaluate(fraction, start, end);
                view.requestLayout();
            }
        });
        valueAnimator.setDuration(5000).start();
    }
}
