package chl.ancud.m6_individual2.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItem(item: Item)

    @Query ("Select * from table_item")
    fun getItemes(): LiveData<List<Item>>

    @Query ("Select sum(precio * cantidad) from table_item")
    fun getTotal(): LiveData<Int>

}