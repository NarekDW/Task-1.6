package ru.training.intro.sixth.linked;

/**
 * <p>
 * Класс реализующий структуру данных  - двусвязный список.
 * Простейшее представление структуры {@link java.util.LinkedList}
 *</p>
 *
 * @author Narek Karapetyan
 * @see java.util.LinkedList
 * @see java.util.List
 * @since 1.8
 */
class Notebook {
    /**
     * <p>
     *     Класс представляет из себя совокупность ссылок на 3 объекта:
     * </p>
     * @parametr prev - ссылка на предыдущий объект
     * @parametr item - текущее значение объекта
     * @parametr next - ссылка на следующий объект
     * @parametr size - размер списка
     * */
    Notebook prev = null;
    String item = null;
    Notebook next = null;
    static int size = 0;

    protected Notebook(Notebook prev, String item, Notebook next){
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString(){
        return item;
    }
}
