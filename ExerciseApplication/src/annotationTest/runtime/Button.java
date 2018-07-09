package annotationTest.runtime;

/**
 * @author zhangzhiquan
 * @date 2018/7/9
 */
public class Button {
    private OnClickListener mListener;
    public void setOnClickListener(OnClickListener listener){
        mListener = listener;
    }

    public void performClick(){
        if(mListener == null){
            return;
        }
        mListener.onClick(this);
    }
    public  interface OnClickListener{
        void onClick(Button button);
    }
}
