package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends TelegramLongPollingBot{



    public static void main(String[] args) {

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Main());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getBotUsername() {

        return "dathVaiderMybot"; // замініть на ім'я вашого бота
    }
//s
    @Override
    public String getBotToken() {
        return ""; // замініть на токен вашого бота
    }

    Long chattID;
    Integer lastMessageId;
     boolean isAlive;
     Move move;

    @Override
    public void onUpdateReceived(Update update) {
        if (!isAlive){
            move = new Move();
            move.start();
            isAlive = true;
        }

        if (update.hasMessage() && update.getMessage().hasText()) {

            Message message = update.getMessage();
            chattID = message.getChatId();
//            mesId = message.getMessageId();
            String text = message.getText();
            String data = "";
            if (text.equals("bottom") || text.equals("left") ){

                Snake.changeSide(text);

            }

        }
    }

    private void send(){
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(chattID));
        response.setText(Snake.parseSnake());
        response.setReplyMarkup(Sertting.getKeb());
        ;
        try {
            Message sentMessage = execute(response);
            lastMessageId = sentMessage.getMessageId();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
    private void delete(){
        if (lastMessageId==null)
            return;
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(String.valueOf(chattID));
        deleteMessage.setMessageId(lastMessageId);

        try {
            execute(deleteMessage); // Виконання запиту на видалення

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    class Move extends  Thread{
        @Override
        public void run() {
            while (true){
                Snake.move();
                delete();
                send();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}