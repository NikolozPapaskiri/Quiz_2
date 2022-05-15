import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.*;

public class Quiz2Test {
    @Test
    public void firstTest() {
        Configuration.headless = true;
        Configuration.timeout = 20000;

        open("https://demoqa.com/progress-bar");
        $("#startStopButton").click();
        $("#progressBar").$("div").shouldHave(Condition.exactText("100%"));
        System.out.println($("#progressBar").$("div").text());

        open("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        $("#dropdowm-menu-1").selectOptionByValue("python");
        $("#dropdowm-menu-1").shouldBe(Condition.selectedText("python"));
        
        for (int i = 0; i < 4; i++) {
            if ($("input[value = option-"+ (i + 1) +"]").is(checked)) {
                continue;
            } else {
                $("input[value = option-"+ (i + 1) +"]").click();
            }
        }
        $("input[value ^= purple]").click();
        $("#fruit-selects").$("option[value = orange]").shouldBe(Condition.disabled);

        open("http://the-internet.herokuapp.com/iframe");
        switchTo().frame("mce_0_ifr"); 
        int amountOfCharacters = $("#tinymce").$("p").getText().length();
        while (amountOfCharacters > 0) {
            $("#tinymce").$("p").sendKeys(Keys.BACK_SPACE);
            amountOfCharacters--;
        }
        $("#tinymce").$("p").sendKeys("Here Goes.");
        switchTo().parentFrame(); 
        $("button[title $= center]").click();
    }
}