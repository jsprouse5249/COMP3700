public class Message {

    public static final int FAIL = -1;
    public static final int SUCCESS = 0;

    public static final int LOAD_PRODUCT = 1;
    public static final int LOAD_PRODUCT_REPLY = 2;

    public static final int SAVE_PRODUCT = 3;

    public static final int LOAD_CUSTOMER = 4;
    public static final int LOAD_CUSTOMER_REPLY = 5;

    public static final int SAVE_CUSTOMER = 6;

    public static final int SAVE_ORDER = 8;

    public static final int LOAD_ORDER = 9;
    public static final int LOAD_ORDER_REPLY = 10;

    public static final int LOGIN = 11;
    public static final int FIND_PRODUCT = 12;
    public static final int FIND_PRODUCT_REPLY = 13;

    public static final int SAVE_NEW_USER = 14;



    private int id; // the type of the message
    private String content; // the content of the message

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
