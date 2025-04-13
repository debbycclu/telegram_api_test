# Telegram Bot

A Java-based Telegram bot project that demonstrates basic bot functionality.

## Project Structure

```
telegram-bot/
├── src/
│   ├── main/
│   │   ├── java/     # Java source files
│   │   └── resources/ # Configuration and resource files
│   └── test/         # Test files
├── pom.xml           # Maven project configuration
└── README.md         # This file
```

## Prerequisites

- Java JDK 8 or higher
- Maven 3.6 or higher
- Telegram Bot Token (obtain from @BotFather)

## Setup

1. Clone the repository:
```bash
git clone https://github.com/debbycclu/telegram_api_test.git
cd telegram_api_test
```

2. Configure your bot token in the appropriate configuration file

3. Build the project:
```bash
mvn clean install
```

4. Run the bot:
```bash
mvn exec:java
```

## Features

- Basic bot functionality
- Command handling
- Message processing

## Contributing

Feel free to submit issues and enhancement requests.

## License

This project is licensed under the MIT License - see the LICENSE file for details. 