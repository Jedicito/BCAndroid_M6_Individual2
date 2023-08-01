package chl.ancud.m6_individual2

import androidx.lifecycle.LiveData
import chl.ancud.m6_individual2.data.local.Item
import chl.ancud.m6_individual2.data.local.ItemDao

class Repository(private val itemDao: ItemDao) {

    suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    fun getItemes(): LiveData<List<Item>> {
        return itemDao.getItemes()
    }

    fun getTotal(): LiveData<Int> {
        return itemDao.getTotal()
    }
}