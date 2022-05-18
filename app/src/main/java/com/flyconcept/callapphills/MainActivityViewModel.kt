package com.flyconcept.callapphills

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: DataListRepository) :ViewModel(){

    val allList:LiveData<List<DataList>> = repository.allDataList.asLiveData()

    fun insert(list: DataList) = viewModelScope.launch {
        // Call the repository function and pass the details.
        repository.insertDataListDetails(list)
    }

    fun delete(list: DataList) = viewModelScope.launch {
        repository.removeList(list)
    }
}

class MainActivityViewModelFactory(private val repository: DataListRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}