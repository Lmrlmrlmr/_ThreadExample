public class YangYin
        extends Thread {
    private String word;             // what to say

    public YangYin(String whatToSay) {
        word = whatToSay;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(word + " ");
            yield();                 // to give another thread a chance
        }
    }

    public static void main(String[] args) {
        YangYin yin = new YangYin("\nYin");    // to create Yin thread
        YangYin yang = new YangYin("\nYang");  // to create Yang thread
        yin.start();                         // to start Yin thread
        yang.start();                        // to start Yang thread
        try {
            System.out.wait(10L, 0b1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}