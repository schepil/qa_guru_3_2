package pageobjects.toolsqa.fragments;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;

public class RowFragment {

    public static void checkRowValue(String key, String value) {
        $x(String.format("//td[text()=\"%s\"]", key)).sibling(0).shouldHave(exactText(value));
    }

}
