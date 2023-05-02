package view;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class AppRatio {
    public double deskTopWidth;
    public double deskTopHeight;

    // 크기를 구하는 method
    private double getWidth(Rectangle2D visibleBound) {
        deskTopWidth = visibleBound.getMaxX() - 500; // window or mac 의 창 너비 - 500
        // deskTopHeight = visibleBound.getMaxY() - 200; // window or mac 의 창 높이 - 200
        return deskTopWidth;
    }

    // 높이를 구하는 method
    private double getHeight(Rectangle2D visibleBound) {
        deskTopHeight = visibleBound.getMaxY() - 200; // window or mac 의 창 높이 - 200
        return deskTopHeight;
    }

    // 너비와 높이를 초기화 하는 함수입니다.
    public void setRatio() {
        Rectangle2D visibleBound = Screen.getPrimary().getVisualBounds();
        this.deskTopWidth = getWidth(visibleBound);
        this.deskTopHeight = getHeight(visibleBound);
    }
}