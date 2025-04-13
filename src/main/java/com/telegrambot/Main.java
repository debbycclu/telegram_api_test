package com.telegrambot;

import com.telegrambot.config.BotConfig;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Starting bot initialization...");
            System.out.println("Bot username: " + BotConfig.getBotUsername());
            System.out.println("Bot token length: " + BotConfig.getBotToken().length() + " characters");
            
            // Create the TelegramBotsApi object to register your bots
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            System.out.println("Created TelegramBotsApi instance");

            // Register your newly created bot using configuration
            botsApi.registerBot(new TelegramBot(BotConfig.getBotUsername(), BotConfig.getBotToken()));
            System.out.println("Bot registered successfully!");
            System.out.println("Bot is now running. Press Ctrl+C to stop.");
            
        } catch (TelegramApiException e) {
            System.err.println("Error initializing bot:");
            e.printStackTrace();
        }
    }
} 