package climber_example.level_creator;

import Kartoha_Engine2D.geometry.Point2;
import Kartoha_Engine2D.ui.Scene;
import Kartoha_Engine2D.ui.SceneController;
import lombok.Getter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Getter
public class Controller {

    private final Container container;

    public Controller(Scene scene) {
        container = new Container(scene.getSpace());
        UI ui = new UI(container);
        ui.setUI();
    }

    public SceneController getSceneController(){
        return new SceneController(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (ReferencePoint point : container.getPoints()){
                    if (point.handleClick(e))
                        return;
                }
                container.addPoint(new Point2(e.getX(), e.getY()));
                container.addReferencePoint(new Point2(e.getX(), e.getY()));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }, null, null);
    }

}
