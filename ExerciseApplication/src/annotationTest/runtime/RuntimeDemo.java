package annotationTest.runtime;

/**
 * @author zhangzhiquan
 * @date 2018/7/9
 */
public class RuntimeDemo {
    public Button button1;
    public Button button2;
    public RuntimeDemo(){
        button1 = new Button();
        button2 = new Button();
        ClickListenerInstaller.processAnnotations(this);
    }
    public static void main(String[] args) {
        RuntimeDemo demo = new RuntimeDemo();
        demo.button1.performClick();
        demo.button2.performClick();
    }

    @ClickListenerFor(source = "button1")
    public void handleClick1(){
        System.out.println("Handle Click 1");
    }

    @ClickListenerFor(source = "button2")
    public void handleClick2(){
        System.out.println("Handle Click 2");
    }

}
