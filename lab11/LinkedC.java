package ua.lpnuai.oop.ryvak11;
//import FilmInfo;



import java.io.Serializable;

import java.util.Collection;

import java.util.Iterator;





public class LinkedC<Type extends FilmInfo> implements Serializable,Collection<Type> {

    private int mSize;// size of liked list

    private Node<Type> film;// 



    public LinkedC(){

        mSize = 0;

        film = null ;

    }



    public Node<Type> getNode(){

        return film;

    }



    public Node newInstance(){

        return new Node();

    }



    @Override

    public String toString() {

        StringBuilder builder = new StringBuilder();

        Node<Type> walker = film;

        builder.append("[");

        while (walker != null){

     

          builder.append((walker.item).getfdirector()).append(", ");

            builder.append((walker.item).getfdate()).append(", ");

            builder.append((walker.item).getfduration()).append(", ");

         

            builder.append("\n");

            walker = walker.next;

        }

        builder.delete(builder.length()-3,builder.length());

        builder.append("]");

        return builder.toString();

    }



    public Type get(int index) {

        if (index < 0 || index >= mSize)

            return null;

        Node<Type> walker = film;

        int counter = 0;

        while (counter != index){

            walker = walker.next;

            counter++;

        }

        return walker.item;

    }



    @Override

    public int size() {

        return mSize;

    }



    @Override

    public boolean isEmpty() {

        return (film == null);

    }



    @Override

    public boolean contains(Object o) {

        if (mSize == 0 || film == null || o == null)

            return false;

        Node walker = film;

        FilmInfo obj = (FilmInfo) o;

        while(walker != null){

            if(walker.equals(obj))

                return true;

            walker = walker.next;

        }

        return false;

    }



    @Override

    public Iterator<Type> iterator() {

        return new myIterable().iterator();

    }



    @Override

    public Object[] toArray() {

        Object[] array = new Object[mSize];

        Node walker = film;

        int mCounter1 = 0;

        while (walker != null){

            array[mCounter1] = walker.item;

            mCounter1++;

            walker = walker.next;

        }

        return array;

    }



    @Override

    public boolean add(Type element)  {

        if (element == null)

            return false;

        if (film == null){

        	film = new Node<>();

        	film.item = element;

            mSize++;

            return true;

        }

        Node<Type> walker = film;

        while(walker.hasNext()){

            walker = walker.next;

        }

        Node<Type> type = new Node<>();

        type.item = element;



        walker.next = type;



        mSize++;



        return true;

    }



    @Override

    public boolean remove(Object o) {

        return false;

    }



    public boolean removeByIndex(int index) {

            if (mSize == 0 || film == null || index < 0 || index > mSize)

                return false;



            Node<Type> walker = film;

            Node<Type> willRemoved;

            int mCounter = 0;

            mSize--;



            if (index == 0){

            	film = walker.next;

                return true;

            }



            while (walker != null){

                if (mCounter == index-1){

                    willRemoved = walker.next;

                    willRemoved.item = null;

                    walker.next = willRemoved.next;

                    return true;

                }

                walker = walker.next;

                mCounter++;

            }

        return true;

    }



    @Override

    public boolean containsAll(Collection<?> c) {

        if (mSize == 0 || film == null || c.size() != mSize || c == null)

            return false;



        Node<Type> walker = film;

        Iterator it = c.iterator();

        while(walker != null && it.hasNext()){

            if(!(walker.item).equals(it.next()))

                return false;

            walker = walker.next;

        }

        return true;

    }



    @Override

    public void clear() {

        Node<Type> walker = film;

        while(walker != null){

            walker.item = null;

            walker = walker.next;

        }

        film = null;

    }



    class myIterable implements Iterable<Type>{



        @Override

        public Iterator<Type> iterator() {

            return new mIterator();

        }



        class mIterator implements Iterator<Type>{

            Node<Type> walker;

            int counter = 0;



            public mIterator(){

                walker = film;

                counter = 0;

            }



            @Override

            public boolean hasNext() {

                if (counter == 0) {

                    if (walker != null)

                        return true;

                    return false;

                }

                if (walker.next != null)

                    return true;

                return false;

            }



            @Override

            public Type next() {

                if (counter == 0) {

                    counter++;

                    return walker.item;

                }

                counter++;

                walker = walker.next;

                return walker.item;

            }

        }

    }



    public class Node<Type extends FilmInfo> implements Serializable {

        Type item;

        Node<Type> next;



        Node() {

            item = null;

            next = null;

        }



        public Type getItem() {

            return item;

        }



        public void setItem(Type item) {

            this.item = item;

        }



        public Node<Type> getNext() {

            return next;

        }



        public void setNext(Node<Type> next) {

            this.next = next;

        }



        public boolean equals(FilmInfo filmInfo) {

            if (filmInfo == null)

                return false;

         //   else if (!(item.getfname()).equals(filmInfo.getfname()))

            //    return false;

          //  else if (!(item.getfgenre()).equals(filmInfo.getfgenre()))

          //      return false;

          //  else if (!(item.getfdirector()).equals(filmInfo.getfdirector()))

           //     return false;

            else if (item.getfdate() != item.getfdate())

                return false;

            else if (!(item.getfduration()).equals(filmInfo.getfduration()))

                return false;

      


            if ((item.getftext()).size() != (filmInfo.getftext()).size())

                return false;



            for (int i = 0; i < item.getftext().size(); i++){

                if(!(item.getftext().get(i)).equals(filmInfo.getftext().get(i)))

                    return false;

            }
/////////////

            if ((item.getfname()).size() != (filmInfo.getfname()).size())

                return false;



            for (int i = 0; i < item.getfname().size(); i++){

                if(!(item.getfname().get(i)).equals(filmInfo.getfname().get(i)))

                    return false;

            }
///////////
            if ((item.getfgenre()).size() != (filmInfo.getfgenre()).size())

                return false;



            for (int i = 0; i < item.getfgenre().size(); i++){

                if(!(item.getfgenre().get(i)).equals(filmInfo.getfgenre().get(i)))

                    return false;

            }
     //////////////////

            
            return true;

        }



        public boolean hasNext(){

            return (next != null);

        }



    }



    /*---------------------------------------------------------------------------------------------------------------*/

    /**

     * Don`t need to use

     * */

    @Override

    public <T> T[] toArray(T[] a) {

        return null;

    }



    

    @Override

    public boolean addAll(Collection<? extends Type> c) {

        return false;

    }



    

    @Override

    public boolean removeAll(Collection<?> c) {

        return false;

    }



    @Override

    public boolean retainAll(Collection<?> c) {

        return false;

    }

}