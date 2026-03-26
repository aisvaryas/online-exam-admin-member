public interface Questiondao{
    void connect();

    void addq(Question q);

    void updateq(int id, String text);

    void viewq();

    void qspaper();


}