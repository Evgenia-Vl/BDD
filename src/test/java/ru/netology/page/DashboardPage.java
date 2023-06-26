package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item div");
    private final String startBalance = "баланс: ";
    private final String finishBalance = " р.";

    public DashboardPage() {
        heading.shouldBe(visible);
    }

       public int getCardBalance(int index) {
        val text = cards.get(index).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(startBalance);
        val finish = text.indexOf(finishBalance);
        val value = text.substring(start + startBalance.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage selectCardToTransfer(DataHelper.CardInfo cardInfo) {
        cards.findBy(attribute("data-test-id", cardInfo.getTestId())).$("button").click();
        return new TransferPage();
    }

}

