package org.example;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Sertting {
    public static ReplyKeyboardMarkup getKeb(){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Перший рядок кнопок
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(" "));
        row1.add(new KeyboardButton("top"));
        row1.add(new KeyboardButton(" "));

        // Другий рядок кнопок
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("left"));

        row2.add(new KeyboardButton("bottom"));

        KeyboardRow row3 = new KeyboardRow();

        row2.add(new KeyboardButton("right"));


        // Додавання рядків до клавіатури
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        // Призначення клавіатури до відповіді
        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(false); // Змінює розмір кнопок
        keyboardMarkup.setOneTimeKeyboard(true); // Клавіатура буде постійно показана
        return keyboardMarkup;
    }
}
