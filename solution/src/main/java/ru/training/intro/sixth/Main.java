package ru.training.intro.sixth;

/**
 * @author Narek Karapetyan
 * @see ru.training.intro.sixth.Action
 * @since 1.8
 */
public class Main {
    public static void main(String[] args){
       printCondition();
       Action action = new Action();
       while(action.chooseAction());
    }

    private static void printCondition(){
        System.out.println("Меню действий:");
        System.out.println("1 - Добавить запись в конец.\n" +
                        "2 - Добавить запись по индексу.\n" +
                        "3 - Удалить запись по содержанию.\n" +
                        "4 - Удалить запись по индексу.\n" +
                        "5 - Редактировать запись по содержанию.\n" +
                        "6 - Редактировать запись по индексу.\n" +
                        "7 - Посмотреть записи.\n" +
                        "stop - Прекратить действие добавить/удалить/редактировать.\n" +
                        "exit - Выйти из блокнота.\n");
    }
}
