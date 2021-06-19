package beans;

import java.util.Date;

public class User {
    
    //属性
    private String userName = null;
    private String userMail = null;
    private String userPs = null;
    private String userAnswer = null;
    private Integer questionId = null;
    private Date  createdAt = null;
    private Date updatedAt = null;
    
    //引数を持たないコンストラクタ
    public User(){
    }
    
    //JspからServletに渡すときに使うコンストラクタ
    public User(String userName, String userMail, String userPs, Integer questionId, String userAnswer){
        this.userName = userName;
        this.userMail = userMail;
        this.userPs = userPs;
        this.questionId = questionId;
        this.userAnswer = userAnswer;
    }
    //Servlet内で作るインスタンス用のコンストラクタ
    public User(String userName, String userMail, String userPs,Integer questionId, String userAnswer, Date createdAt){
        this.userName = userName;
        this.userMail = userMail;
        this.userPs = userPs;
        this.questionId = questionId;
        this.userAnswer = userAnswer;
        this.createdAt = createdAt;
    }
    
    //setメソッド
    public void setUserName(String userName){this.userName = userName; }
    public void setUserMail(String userMailAddress){this.userMail = userMail; }
    public void setUserPs(String userPs){this.userPs = userPs; }
    public void setQuestionId(Integer questionId){this.questionId = questionId;}
    public void setUserAnswer(String userAnswer){this.userAnswer = userAnswer;}
    public void setCreatedAt(Date createdAt){this.createdAt = createdAt;}
    public void setUpdatedAt(Date updatedAt){this.updatedAt = updatedAt;}
    
    //getメソッド
    public String getUserName(){ return this.userName; }
    public String getUserMail(){ return this.userMail; }
    public String getUserPs(){ return this.userPs; }
    public Integer getQuestionId(){ return this.questionId; }
    public String getUserAnswer(){ return this.userAnswer; }
    public Date getCreatedAt(){ return  this.createdAt; }
    public Date getUpdatedAt(){ return this.updatedAt; }
    
}
