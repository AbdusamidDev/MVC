package developer.abdusamid.mvc

import java.lang.IndexOutOfBoundsException
import java.util.*
import kotlin.collections.ArrayList

class MyModel : Observable() {
    //To save the data we can use API or etc.
    private val list: MutableList<Int>

    init {
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getValue(index: Int): Int {
        return list[index]
    }

    @Throws(IndexOutOfBoundsException::class)
    fun setValue(index: Int) {
        list[index] += 1
        setChanged() //to save changes
        notifyObservers() //to deliver changes
    }
}