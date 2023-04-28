package starter.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ChooseProductPage extends PageObject {
    // =============================== Locator ===============================
    private By beliBtn() {
        return By.xpath("//span[text()='Beli']");
    }
    private By titleCart() {
        return By.xpath("//button[@type='button']");
    }

    private By cartBtn() {
        return By.xpath("//i[@aria-hidden='true']");
    }

    private By detailBtn() {
        return By.xpath("//span[text()='Detail']");
    }

    private By titleDetail() {
        return By.xpath("//button[@aria-label='Rating 4 of 5']");
    }
    private By bayarBtn() {
        return By.id("button-bayar");
    }

    private By historyTransactions() {
        return By.xpath("//div[@class='v-data-table__wrapper']");
    }

    //=============================================== Functional ===================================================


    public void mainPage() { open(); $(cartBtn()).shouldBeVisible();
    }

    public void clickBeli() { $(beliBtn()).click();
    }

    public void successAddToCart() { $(titleCart()).shouldBeVisible();
    }

    public void clickCart() { $(cartBtn()).click();
    }

    public void clickDetail() { $(detailBtn()).click();
    }

    public void seeDetail() { $(titleDetail()).click();
    }

    public void clickBayar() { $(bayarBtn()).click();
    }

    public void seeHistoryTransactions() { $(historyTransactions()).click();
    }
}
