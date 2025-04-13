package com.telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    private final String botUsername;
    private final String botToken;

    public TelegramBot(String botUsername, String botToken) {
        this.botUsername = botUsername;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            // Handle different commands
            if (messageText.startsWith("/")) {
                handleCommand(messageText, chatId);
            } else {
                handleMessage(messageText, chatId);
            }
        }
    }

    private void handleCommand(String command, long chatId) {
        String response;
        switch (command) {
            case "/start":
                response = "Welcome to the bot! I'm here to help you.";
                break;
            case "/help":
                response = "Available commands:\n" +
                          "/start - Start the bot\n" +
                          "/help - Show this help message\n" +
                          "/echo [text] - Echo back the text";
                break;
            case "/echo":
                response = "Please provide text to echo. Usage: /echo [text]";
                break;
            default:
                if (command.startsWith("/echo ")) {
                    response = command.substring(6); // Remove "/echo " prefix
                } else {
                    response = "Unknown command. Type /help for available commands.";
                }
        }
        sendMessage(chatId, response);
    }

    private void handleMessage(String message, long chatId) {
        String response = "You said: " + message;
        sendMessage(chatId, response);
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
} 