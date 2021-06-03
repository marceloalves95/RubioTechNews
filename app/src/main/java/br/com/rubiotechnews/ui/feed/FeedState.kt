package br.com.rubiotechnews.ui.feed

import br.com.rubiotechnews.data.remote.model.Artigo
import br.com.rubiotechnews.data.remote.model.NewsResponse

sealed class FeedState{
    class Sucess(val response: NewsResponse?): FeedState()
    class Loading(val isLoading:Boolean): FeedState()
    class Error(val message:String): FeedState()
    object Empty : FeedState()
}