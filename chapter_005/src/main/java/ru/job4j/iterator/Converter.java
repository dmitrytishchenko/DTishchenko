package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать класс с методом Iterator<Integer> convert(Iterator<Iterator<Integer>> it).
 *
 * Что из себя представляет запись Iterator<Iterator<Integer>?.
 *
 * Каждый итератор это последовательность.
 *
 * Итератор 1 – 4 2 0 4 6 4 9
 *
 * Итератор 2 – 0 9 8 7 5
 *
 * Итератор 3 – 1 3 5 6 7 0 9 8 4
 *
 * Если мы говорим о записи Итератор Итераторов. Значит итератор содержит не конечные значения, а сложенные итераторы.
 *
 * Итератор - Итератор 1, Итератор 2, Итератор 3.
 *
 * Метод convert должен принимать объект итератор итератор и возвращать Итератор чисел.
 *
 * Iterator<Iterator<Integer> - ((4 2 0 4 6 4 9), (0 9 8 7 5), (1 3 5 6 7 0 9 8 4))
 *
 * Метод должен возвращать
 *
 * Iterator<Integer> - (4 2 0 4 6 4 9 0 9 8 7 5 1 3 5 6 7 0 9 8 4)
 *
 * Метод не должен копировать данные. Нужно реализовать итератор, который будет пробегать по вложенными итераторам без копирования данных.
 *
 * Шаблон класса
 *
 * Подробнее
 *
 * Перед отправкой решения - убедитесь, что программа успешно проходит тестовые методы из прилагаемого файла.
 * Пожелания:
 *
 * Подробнее
 * Так как вы реализуете итератор, то желательно чтобы его поведение соответствовало спецификации и было ожидаемым для программиста,
 * который будет его использовать. Перед реализацией ознакомьтесь пожалуйста с описанием интерфейса Iterator в спецификации API Java 8 - Iterator
 * метод next в случае отсутствия элементов к возврату генерирует NoSuchElementException.
 * метод next должен возвращать верные значения вне зависимости от того вызвал ли перед этим программист метод hasNext.
 * Аналогично для hasNext. Результат работы ваших методов не должен зависеть от последовательности в которой программист вызывает методы,
 * т.е. не полагайтесь на то, что программист будет вызывать методы именно в том порядке в котором вы ожидаете.
 * не допускайте дублирования кода. Если вы видите, что методы next и hasNext имеют одинаковый код, то выносите этот код в отдельный метод
 * и делайте уже его вызов.
 * не используйте эксепшены для управления логикой вашей программы. Они созданы для обработки критических ситуаций + очень дороги в создании
 * по сравнению с обычными объектами в Java.
 * не оставляйте пустых методов в коде. Обратите внимание, что метод remove объявлен как дефолтный - это значит, что нет необходимости
 * его реализовывать пустым, если вы не собираетесь переопределять его поведение. В коде не должно быть пустых методов, если ваша программа
 * не поддерживает какой-либо функционал задекларированный в интерфейсе - прокидывайте UnsupportedOperationException.
 */
public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> result;
            @Override
            public boolean hasNext() {
                while (result == null || !result.hasNext()) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    result = it.next();
                }
                return true;
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент массива отсутствует");
                }
                return result.next();
            }
        };
    }
}
