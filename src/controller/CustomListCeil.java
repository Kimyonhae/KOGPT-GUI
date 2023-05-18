package controller;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class CustomListCeil<T> extends ListCell<T> {
    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            setStyle("-fx-background-color: transparent;");
            Label textStyle = new Label(item.toString()); // label을 통해 글자 색을 바꾸기 위함입니다.
            textStyle.setStyle("-fx-text-fill: #dce2f0;"); // label style
            textStyle.setPadding(new Insets(10)); // padding
            HBox.setMargin(textStyle, new Insets(0, 0, 20, 0)); // margin
            textStyle.setPrefWidth(400); // 채팅의 너비를 제한합니다
            textStyle.setWrapText(true); // 너비를 넘으면 줄바꿈
            setGraphic(textStyle); // 따로 label style을 적용해줘야 합니다.
            textStyle.setBorder(
                    new Border(new BorderStroke(Color.valueOf("#dce2f0"), BorderStrokeStyle.SOLID, new CornerRadii(5),
                            BorderWidths.DEFAULT))); // ceil의 border를 담당합니다.
        } else {
            setStyle("-fx-background-color: transparent;");
            setGraphic(null);
        }
    }
}

/*
 * {
 * "id":"d16300f5-1bea-4583-8cba-f356cd21160c",
 * "generations":[
 * {
 * "text":" 히바리군의 인사드립니다. 추석연휴는 다들 잘 보내시고 계신가요?! 모두 맛있는 음식 많이 드시공, 보양하시면서 고향에서 돌아오세요! 저히도 무척 바빠서 이제야 찾아오게 되었습니다!! 제 크리스마스인사 ☞ 우이~~~~뿅!!! 우선 타임어바웃 11기를 하신 모든 클럽원분드으~~!!!! 미존클럽을 장장 10개월간 이끌어온 다듀의 수장..으로 FYB라는 또하나의 차세대 싱크탱트로 불리고 있죠(ᄆx;;;) 류소장님 써클장 이희정 보컬황사장 님 축하드리와요♥ HAPPINESS ["
 * ,"tokens":128}],
 * "usage":{"prompt_tokens":5,"generated_tokens":128,"total_tokens":133}}
 * 
 */
