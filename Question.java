public class Question{
    int qid;
    String qtext,a,b,c,d;
    char answer;
    public Question(){

    }
    public Question(int qid, String qtext, String a, String b, String c, String d, char answer) {
        this.qid = qid;
        this.qtext = qtext;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
    }
    

}