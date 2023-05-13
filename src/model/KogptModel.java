package model;

//KOGPT Model 객체입니다. 이를 통해 api의 json file을 가져옵니다.
public class KogptModel {
    String id;
    double template;
    String content;

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public double getTemplate() {
        return template;
    }

    public void setGPT(String id, double template, String content) {
        this.id = id;
        this.template = template;
        this.content = content;
    }
}
