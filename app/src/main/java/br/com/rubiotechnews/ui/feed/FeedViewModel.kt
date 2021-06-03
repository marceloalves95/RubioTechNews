package br.com.rubiotechnews.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rubiotechnews.data.remote.api.NewsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel@Inject constructor(private val newsApi: NewsApi) : ViewModel() {

    private val _feedState = MutableStateFlow<FeedState>(FeedState.Empty)
    val feedstate:StateFlow<FeedState> = _feedState


    fun getNews(){

        viewModelScope.launch {

            try {
                _feedState.value = FeedState.Loading(true)
                delay(1000)
                val response = newsApi.getNews()
                with(response){
                    if (isSuccessful){
                        _feedState.value = FeedState.Sucess(response.body())
                    }
                    else{
                        _feedState.value = FeedState.Error("Erro: ${code()}")
                    }
                }


            }
            catch (exception:Exception){
                _feedState.value = FeedState.Error("Sem internet")
            }

            _feedState.value = FeedState.Loading(false)
        }


    }

}