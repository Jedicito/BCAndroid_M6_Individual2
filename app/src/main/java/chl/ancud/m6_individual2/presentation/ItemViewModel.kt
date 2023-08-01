package chl.ancud.m6_individual2.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import chl.ancud.m6_individual2.Repository
import chl.ancud.m6_individual2.data.local.Item
import chl.ancud.m6_individual2.data.local.ItemDatabase
import kotlinx.coroutines.launch

class ItemViewModel (application: Application): AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDatabase.getDatabase(application).getTaskDao()
        repository = Repository(dao)
    }

    fun getAllItems(): LiveData<List<Item>> = repository.getItemes()

    fun getTotal(): LiveData<Int> = repository.getTotal()


    fun insertItem(nombre: String, precio: Int, cantidad: Int) = viewModelScope.launch {
        val item = Item(nombre, precio, cantidad)
        repository.insertItem(item)
    }
}