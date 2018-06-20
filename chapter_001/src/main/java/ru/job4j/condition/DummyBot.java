package ru.job4j.condition;
/**
 * Это пятая моя программа
 * @version 1.05 3.12.2017
 * @author Dmitriy Tishchenko
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите меня другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока." .equals(question)) {
            rsl = "До скорой встречи.";
        } else if ("Сколько будет 2 + 2?" .equals(question)) {
            rsl = "Это ставит меня в тупик. Спросите меня другой вопрос.";
        }
        return rsl;
    }
}
