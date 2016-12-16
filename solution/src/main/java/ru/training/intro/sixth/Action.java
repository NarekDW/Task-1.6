package ru.training.intro.sixth;

import ru.training.intro.sixth.linked.NoteEntry;

import java.util.Scanner;

/**
 * Класс работающий со списком/блокнотом и позволяющий
 * пользователю через консольный ввод определять какие
 * действия он хочет совершить со списком/блокнотом.
 *
 * @author Narek Karapetyan
 * @see ru.training.intro.sixth.linked.NoteEntry
 * @see ru.training.intro.sixth.linked.Notebook
 * @see java.util.LinkedList
 * @see java.util.List
 * @since 1.8
 */
class Action {
    private Scanner scan =new Scanner(System.in);
    private final NoteEntry note = new NoteEntry();

    /**
     * Метод позволяющий с помощью консольного ввода
     * выбрать операцию, которую пользователь хочет произвести.
     * После завершения операции, на консоль будет выведен результат
     * успешно совершенной операции, иначе не выведется ничего.
     * @return результат выбора, с помощью команды "exit"
     * пользователь может завершить работу приложения.
     * */
    boolean chooseAction(){
        print("Выберите действие:");
        String flag = scan.next();
        switch(flag){
            case "1":
               return lastAdd();
            case "2":
                return indexAdd();
            case "3":
                return deleteNote();
            case "4":
                return deleteByIndex();
            case "5":
                return updateNote();
            case "6":
                return updateByIndex();
            case "7":
                note.show();
                return true;
            case "exit":
                return false;
        }
        return true;
    }

    private boolean lastAdd(){
        print("Раздел добавить запись:");
        String message;
        while(!(message = scan.next()).equals("stop")){
            note.addLast(message);
        }
        print("Вы вышли из раздела!");
        return true;
    }

    private boolean indexAdd(){
        print("Раздел добавить запись по индексу:");
        print("Введите текст:");
        String message = scan.next();
        if(!message.equals("stop")){
            print("ведите индекс:");
            int index = scan.nextInt();
            if(note.addByIndex(index, message)){
                System.out.println("Запись добавлена!");
            }
        }
        print("Вы вышли из раздела!");
        return true;
    }

    private boolean deleteNote(){
        print("Раздел удалить запись:");
        print("Введите текст:");
        String message = scan.next();
       if(!message.equals("stop")){
           if(note.deleteByNote(message)){
               print("Запись удалена!");
           }
       }
        print("Вы вышли из раздела!");
        return true;
    }

    private boolean deleteByIndex(){
        print("Раздел удалить запись по индексу:");
        print("ведите индекс:");
        int index = scan.nextInt();
        if(note.deleteByIndex(index)){
                System.out.println("Запись удалена!");
            }
        print("Вы вышли из раздела!");
        return true;
    }

    private boolean updateNote(){
        print("Раздел обновить запись:");
        print("введите запись, которую нужно обновить:");
        String oldNote = scan.next();
        print("введите новую запись:");
        String message = scan.next();

        if(note.updateByNote(oldNote, message)){
            System.out.println("Запись обновлена!");
        }
        print("Вы вышли из раздела!");
        return true;
    }

    private boolean updateByIndex(){
        print("Раздел обновить запись:");
        print("введите индекс записи, которую нужно обновить:");
        int index  = scan.nextInt();
        print("введите новую запись:");
        String message = scan.next();
        if(note.updateByIndex(index, message)){
            System.out.println("Запись обновлена!");
        }
        print("Вы вышли из раздела!");
        return true;
    }

    private void print(String info){
        System.out.println(info);
    }
}
