package ru.training.intro.sixth.linked;

/**
 * <p>
 *     Класс как инструмент, непосредственно работающий с
 * классом(двусвязным списком) {@link ru.training.intro.sixth.linked.Notebook}.
 * Поддерживающий оперции:</p>
 * <p>Добавления в конец/Добавления по индексу</p>
 * <p>Удаления по значению/Удаления по по индексу</p>
 * <p>Обновления по значению/Обновления по по индексу</p>
 * <p>Просмотр всех записей</p>
 *
 *
 * @author Narek Karapetyan
 * @see ru.training.intro.sixth.linked.Notebook
 * @see java.util.LinkedList
 * @see java.util.List
 * @since 1.8
 * */
public class NoteEntry {

    private Notebook header;
    private Notebook first;
    private Notebook last;
    private int index = 0;

    /**
     * Метод добавляющий строку в конец списка.
     * */
    public void addLast(String message){
        if(index == 0){
            header = new Notebook(null, message, null);
            Notebook.size++;
            index++;
            first = header;
        }else{
            last = new Notebook(first, message, null);
            first.next = last;
            Notebook.size++;
            first = last;
        }
    }

    /**
     * Метод добавляющий запись в список по номеру индекса/строки.
     * @return результат добавления, если указать несуществующий индекс,
     * то запись не добавится.
     * */
    public boolean addByIndex(int ind, String message){
        int j=Notebook.size;
        Notebook current = last;
        if(ind == Notebook.size || ind == 0 ){
            if(header!=null && ind == 0){
                Notebook newHeader = new Notebook(null, message, header);
                header.prev = newHeader;
                header = newHeader;
                Notebook.size++;
            } else
                addLast(message);
            return true;
        } else{
            while(j>0){
                if(j == ind){
                    Notebook post = current;
                    Notebook pre = current.next;
                    Notebook newNote = new Notebook(post, message, pre);
                    post.next = newNote;
                    pre.prev = newNote;
                    Notebook.size++;
                    return true;
                }
                current = current.prev;
                j--;
            }
            return false;
        }
    }

    /**
     * Удаление заданной строки.
     * @return результат удаления, если указать несуществующую строку,
     * то операция удаления не произойдет.
     * */
    public boolean deleteByNote(String message){
        Notebook current = last;
        int j = Notebook.size;
        while(j>0){
            if(message.equals(current.item)){
                 deleteRealise(current);
                 return true;
            }
            current = current.prev;
            j--;
        }
        return false;
    }

    /**
     * Метод удаляющий запись по указанному индексу/строке.
     * @return результат удаления, если указать несуществующий индекс,
     * то процесс удаления не произойдет.
     * */
    public  boolean deleteByIndex(int i){
        Notebook current = last;
        int j = Notebook.size;
        while(j>0){
            if(j == (i+1)){
                deleteRealise(current);
                return true;
            }
            current = current.prev;
            j--;
        }
        return false;
    }

    /**
     * Метод, позволяющий заменить существующую строку на новую.
     * @return результат обновления строки, если заданная строка
     * не существует в списке, то вернется значение {@code false}.
     * */
    public boolean updateByNote(String note, String message){
        Notebook current = last;
        int j = Notebook.size;
        while(j>0){
            if(note.equals(current.item)){
                updateRealise(current, message);
                return true;
            }
            current = current.prev;
            j--;
        }
        return false;
    }

    /**
     * Метод который удаляет запись по указанному индексу/строке.
     * @return результат обновления, если указать несуществубщий индекс,
     * процесс обновления не произойдет и метод вернет значение {@code false}.
     * */
    public boolean updateByIndex(int i, String message){
        Notebook current = last;
        int j = Notebook.size;
        while(j>0){
            if(j == (i+1)){
                updateRealise(current, message);
                return true;
            }
            current = current.prev;
            j--;
        }
        return false;
    }

    /**
     * Метод выводящий все записи на экран и нумерующий строки.
     * */
    public void show(){
        Notebook current = header;
        int j = 0;
        while(j!=Notebook.size){
            System.out.println(j+". "+current);
            j++;
            current = current.next;
        }
    }

    private void updateRealise(Notebook current, String message){
        current.item = message;
    }

    private void deleteRealise(Notebook current){
        Notebook pre;
        Notebook post;
        if(current.prev == null && current.next == null){
            current.item = null;
        }else if(current.prev == null){
            post = current.next;
            post.prev = null;
            header = post;
        } else if(current.next == null){
            pre = current.prev;
            pre.next = null;
            last = pre;
        } else {
            pre = current.prev;
            post = current.next;
            pre.next = post;
            post.prev = pre;
        }
        Notebook.size--;
    }
}
