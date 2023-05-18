package model;

//KOGPT Model 객체입니다. 이를 통해 api의 json file을 가져옵니다.
public class KogptModel {
    double template;
    String content;

    public String getContent() {
        return content;
    }

    public double getTemplate() {
        return template;
    }

    public void setGPT(double template, String content) {
        this.template = template;
        this.content = content;
    }
}
