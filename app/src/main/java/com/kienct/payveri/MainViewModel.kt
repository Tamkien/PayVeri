package com.kienct.payveri

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kienct.payveri.db.Project
import com.kienct.payveri.db.ProjectRepository
import kotlinx.coroutines.launch

class MainViewModel (private val repository: ProjectRepository) : ViewModel() {
    val allProjects: LiveData<List<Project>> = repository.allProjects.asLiveData()

    fun insert(project: Project) = viewModelScope.launch{
        repository.insert(project)
    }

}

class MainViewModelFactory(private val repository: ProjectRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}