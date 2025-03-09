package element;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Input;

import java.awt.*;
import java.awt.event.InputEvent;

public class ElementController {
    public static void dnd(WebElement fromElement, WebElement toElement) throws AWTException {
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // get size from all elements
        Dimension fromElementSize = fromElement.getSize();
        Dimension toElementSize = toElement.getSize();

        // get the location for all elements
        Point fromElementLocation = fromElement.getLocation();
        Point toElementLocation = toElement.getLocation();

        // calculate the coordinate for the moves
        fromElementLocation.x += fromElementSize.getWidth() / 2;
        toElementLocation.x += toElementSize.getWidth() / 2;
        fromElementLocation.y += fromElementSize.getHeight() / 2;
        toElementLocation.y += toElementSize.getHeight() / 2;

//      Use the robot instance to make the moves
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(fromElementLocation.x, fromElementLocation.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

//         use the robot instance to make the moves
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(toElementLocation.x, toElementLocation.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);



    }
}
