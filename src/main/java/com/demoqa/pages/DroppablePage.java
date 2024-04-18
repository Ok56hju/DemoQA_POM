package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage{
    public DroppablePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement droppHere;

    public DroppablePage actionDragMe() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe,droppHere).perform();

        String text = droppHere.getText();
        if (text.equals("Dropped!")){
            System.out.println("Pass!");
        }else {
            System.out.println("FAIL!");
        }
        return this;
    }

    public DroppablePage actionDragMeBy() {
        Actions actions = new Actions(driver);
        pause(500);
        //find x y for DragMe
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();

        int xOffset = droppHere.getLocation().getX();
        int yOffset = droppHere.getLocation().getY();

        System.out.println("xOffset1 --> " + xOffset + " yOffset1 " + yOffset);

        xOffset = (xOffset - xOffset1)+20;
        yOffset = (yOffset - yOffset1)+30;
        actions.dragAndDropBy(dragMe, xOffset,yOffset).perform();

        String text = droppHere.getText();
        if (text.equals("Dropped!")){
            System.out.println("Pass!");
        }else {
            System.out.println("FAIL!");
        }

        return this;
    }
}
