package model;

//KOGPT Model 객체입니다. 이를 통해 api의 json file을 가져옵니다.
public class KogptModel {
    String id;
    double template;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemplate() {
        return template;
    }

    public void setTemplate(double template) {
        this.template = template;
    }
}
